package com.allstarcvs.tbone.elements;

import static com.allstarcvs.tbone.elements.SemanticUi.*;
import net.java.html.js.JavaScriptBody;

import org.teavm.dom.html.HTMLElement;
import org.teavm.jso.JSFunctor;
import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;

import com.allstarcvs.tbone.TBone;

/**
 * A HTML dropdown selection component based on SemanticUi menu.
 */
public class UiDropdown extends UiNode<UiDropdown> implements ValueContainer {

	private final UiNode<?> container;
	private final UiInput result;
	private final UiNode<?> placeholder;

	@Override
	public UiDropdown add(final UiNode<?>... items) {
		container.add(items);
		return this;
	}

	@Override
	public UiDropdown text(final String value) {
		placeholder.text(value);
		return this;
	}

	public UiDropdown value(final String value) {
		result.value(value);
		return this;
	}

	public UiDropdown options(final String... values) {
		for (final String value : values) {
			this.option(value);
		}
		return this;
	}

	public UiDropdown option(final String value) {
		return add(createOptionNode(value, value));
	}

	public UiDropdown option(final String value, final String name) {
		return add(createOptionNode(name, value));
	}

	// ====================================================================================================
	// ValueContainer
	// ====================================================================================================

	@Override
	public String value() {
		return result.value();
	}

	@Override
	public Integer intValue() {
		return result.intValue();
	}

	@Override
	public Double doubleValue() {
		return result.doubleValue();
	}

	// ====================================================================================================
	// Factory & constructor. Call from SemantiUi.java
	// ====================================================================================================

	UiDropdown(final UiNode<?> domNode, final UiNode<?> container, final UiNode<?> placeholder, final UiInput result) {
		super(domNode);
		this.container = container;
		this.result = result;
		this.placeholder = placeholder;
	}

	static UiDropdown create(final Object value, final InputEventHandler changeHandler) {

		final UiCommon container = div("menu");
		final UiCommon placeholder = div("default text");
		final UiInput result = new UiInput(element("input").attr("type", "hidden")).value(value);

		final UiCommon dropdown = div("ui fluid selection dropdown").add(
				result,
				placeholder,
				icon("dropdown"),
				container);

		final Settings settings = (Settings) TBone.globals.newObject();
		if (changeHandler != null) settings.setOnChange((v, n) -> changeHandler.handle(result));
		dropdown.observe(() -> initDropdown(dropdown.node, settings));

		return new UiDropdown(dropdown, container, placeholder, result);
	}

	private UiCommon createOptionNode(final Object value, final String text) {
		final UiCommon item = SemanticUi.div("ui item").text(text);
		if (value == null) return item;
		return item.attr("data-value", value.toString());
	}

	// ====================================================================================================
	// Internal structures
	// ====================================================================================================

	@JSFunctor
	static interface ChangeEventHandler extends JSObject {
		public void handle(String value, String name);
	}

	static interface Settings extends JSObject {
		@JSProperty
		public void setOnChange(ChangeEventHandler function);
	}

	@JavaScriptBody(args = { "e", "o" }, body = "$(e).dropdown(o)")
	private static native void initDropdown(HTMLElement ele, Settings options);

}
