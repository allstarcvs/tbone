package com.allstarcvs.tbone.elements;

import org.teavm.dom.html.HTMLInputElement;

/**
 * Wrap the dom node to provide common methods for HTMLInputElements.
 *
 * @author Albert Kwong
 */
public class UiInput extends UiNode<UiInput> implements ValueContainer {

	public UiInput(final UiNode<?> domNode) {
		super(domNode);
	}

	private HTMLInputElement inputNode() {
		return (HTMLInputElement) node();
	}

	@Override
	public String value() {
		return inputNode().getValue();
	}

	@Override
	public Double doubleValue() {
		return Double.valueOf(value());
	}

	@Override
	public Integer intValue() {
		return Integer.valueOf(value());
	}

	public UiInput value(final Object value) {
		if (value != null) inputNode().setValue(value.toString());
		return this;
	}
}
