package com.allstarcvs.tbone;

import com.allstarcvs.tbone.elements.SemanticUiScripts;
import com.allstarcvs.tbone.elements.UiNode;

public abstract class View {

	protected UiNode<?> el;

	public abstract UiNode<?> render();

	/**
	 * Override this method to execute scripts after showing this view. Be sure to call super.onShow() to execute the
	 * default semantic-ui scripts.
	 */
	public void onShow() {
		SemanticUiScripts.execute(el);
	}

	public final void show(final View view) {
		if (el == null) return;

		el.clear().add(view);
	}

	/**
	 * Install a lambda function to be executed after this.onShow()
	 */
	public View onShow(final Runnable lambda) {
		this.onShow();
		lambda.run();
		return this;
	}
}
