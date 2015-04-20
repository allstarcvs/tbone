package com.allstarcvs.tbone.elements;

import static com.allstarcvs.tbone.TBone.*;

import org.teavm.dom.events.EventListener;
import org.teavm.dom.html.HTMLElement;

import com.allstarcvs.tbone.TBone;
import com.allstarcvs.tbone.View;
import com.allstarcvs.tbone.wrappers.JQuery;

@SuppressWarnings("unchecked")
public class UiNode<T extends UiNode<?>> {

	protected final HTMLElement node;

	protected UiNode(final HTMLElement node) {
		this.node = node;
	}

	protected UiNode(final UiNode<?> domNode) {
		node = domNode.node;
	}

	public HTMLElement node() {
		return node;
	}

	public JQuery jquery() {
		return TBone.jquery(node);
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
		}
		return (T) this;
	}

	/**
	 * render and append views to this node. This node must have been rendered already.
	 */
	public T add(final View... views) {
		for (final View view : views) {
			add(view.render());
		}
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
		while (node.hasChildNodes()) {
			node.removeChild(node.getLastChild());
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

	public T attr(final String attr, final int value) {
		return attr(attr, Integer.toString(value));
	}

	public T data(final String name, final String value) {
		node.setAttribute("data-" + name, value);
		return (T) this;
	}

	public T data(final String name, final int value) {
		return data(name, Integer.toString(value));
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

	public T observe(final Runnable script) {
		TBone.observe(this, script);
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
