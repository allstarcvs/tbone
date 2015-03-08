package com.allstarcvs.tbone.elements;

import static com.allstarcvs.tbone.TBone.*;

import org.teavm.dom.core.Node;
import org.teavm.dom.core.NodeList;
import org.teavm.dom.events.EventListener;
import org.teavm.dom.html.HTMLElement;

import com.allstarcvs.tbone.TBone;
import com.allstarcvs.tbone.View;

@SuppressWarnings("unchecked")
public class UiNode<T extends UiNode<?>> {

	protected final HTMLElement node;
	protected long scriptFlags = 0;

	protected UiNode(final HTMLElement node) {
		this.node = node;
		scriptFlags = 0;
	}

	protected UiNode(final UiNode<?> domNode) {
		node = domNode.node;
		scriptFlags = domNode.scriptFlags;
	}

	public Node node() {
		return node;
	}

	public static UiCommon body() {
		return new UiCommon(document.getBody());
	}

	public static UiCommon element(final String tagName) {
		return new UiCommon(document.createElement(tagName));
	}

	/**
	 * append child
	 */
	public T add(final UiNode<?>... children) {
		for (final UiNode<?> d : children) {
			node.appendChild(d.node);
			scriptFlags |= d.scriptFlags;
		}
		return (T) this;
	}

	/**
	 * render and append views to this node. This node must have been rendered already.
	 */
	public T add(final View... views) {
		for (final View view : views) {
			add(view.render());
			view.onShow();
		}
		return (T) this;
	}

	public T enable(final long scriptFlag) {
		scriptFlags |= scriptFlag;
		return (T) this;
	}

	// ====================================================================================================
	// Utilities
	// ====================================================================================================

	public static String join(final String... array) {
		if (array == null) return "";
		return " " + TBone.join(array, " ") + " ";
	}

	/**
	 * Remove all children
	 */
	public T clear() {
		final NodeList<Node> childNodes = node.getChildNodes();
		for (int i = 0; i < childNodes.getLength(); i++) {
			node.removeChild(childNodes.item(i));
		}
		return (T) this;
	}

	// ====================================================================================================
	// Attributes and Text
	// ====================================================================================================

	public T text(final String value) {
		if (value != null) node.appendChild(document.createTextNode(value));
		return (T) this;
	}

	public T text(final String format, final Object... arguments) {
		node.appendChild(document.createTextNode(TBone.sprintf(format, arguments)));
		return (T) this;
	}

	public T attr(final String attr, final String value) {
		node.setAttribute(attr, value);
		return (T) this;
	}

	public T style(final String value) {
		return attr("style", value);
	}

	/**
	 * Do not assign ID other than JQuery or styling needs.
	 */
	public T id(final String id) {
		return attr("id", id);
	}

	public T attr(final String attr, final boolean flag) {
		if (flag) attr(attr, "");
		return (T) this;
	}

	// ====================================================================================================
	// Actions
	// ====================================================================================================

	public T click(final EventListener listener) {
		node.addEventListener("click", listener);
		return (T) this;
	}

	public T change(final EventListener listener) {
		node.addEventListener("change", listener);
		return (T) this;
	}
}
