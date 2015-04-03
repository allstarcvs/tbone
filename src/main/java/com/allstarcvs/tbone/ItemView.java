package com.allstarcvs.tbone;

import com.allstarcvs.tbone.elements.UiNode;

/**
 * A very simple view that gives a DomNode view behaviors.
 *
 * @author Albert Kwong
 */
public class ItemView extends View {

	public ItemView(final UiNode<?> el) {
		this.el = el;
	}

	@Override
	public UiNode<?> onRender() {
		return el;
	}
}
