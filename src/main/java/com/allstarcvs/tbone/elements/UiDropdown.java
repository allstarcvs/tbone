package com.allstarcvs.tbone.elements;

public class UiDropdown extends UiNode<UiDropdown> implements ValueContainer {

	private final UiNode<?> container;
	private final UiInput result;
	private final UiNode<?> placeholder;

	public UiDropdown(final UiNode<?> domNode, final UiNode<?> container, final UiNode<?> placeholder, final UiInput result) {
		super(domNode);
		this.container = container;
		this.result = result;
		this.placeholder = placeholder;
	}

	@Override
	public UiDropdown add(final UiNode<?>... items) {
		container.add(items);
		return this;
	}

	public UiDropdown options(final String... values) {
		for (final String value : values) {
			this.option(value);
		}
		return this;
	}

	public UiDropdown option(final String value) {
		return add(SemanticUi.dropdownOption(value, value));
	}

	public UiDropdown option(final String value, final String name) {
		return add(SemanticUi.dropdownOption(name, value));
	}

	@Override
	public UiDropdown text(final String value) {
		placeholder.text(value);
		return this;
	}

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

	public UiDropdown value(final String value) {
		result.value(value);
		return this;
	}

}
