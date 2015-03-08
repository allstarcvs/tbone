package com.allstarcvs.tbone.elements;

import org.teavm.dom.html.HTMLElement;

/**
 * Wrap the dom node to provide common methods for HTMLInputElements.
 *
 * @author Albert Kwong
 */
public class UiCommon extends UiNode<UiCommon> {

	public UiCommon(final HTMLElement node) {
		super(node);
	}
}
