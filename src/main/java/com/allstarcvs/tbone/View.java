package com.allstarcvs.tbone;

import com.allstarcvs.tbone.elements.UiNode;

public abstract class View {

	UiNode<?> el;

	public final UiNode<?> render() {
		return el = onRender();
	}

	protected abstract UiNode<?> onRender();

	/**
	 * @see TBone.observe()
	 */
	@Deprecated
	protected final void onShow() {
		// do not override
	}

	public final void show(final View view) {
		if (el == null) return;
		el.clear().add(view);
	}
}
