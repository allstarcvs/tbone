package com.allstarcvs.tbone.wrappers;

import org.teavm.dom.browser.Window;
import org.teavm.dom.html.HTMLElement;
import org.teavm.jso.JSConstructor;
import org.teavm.jso.JSProperty;

import com.allstarcvs.tbone.mutations.MutationObserver;
import com.allstarcvs.tbone.mutations.MutationObserverHandler;

public interface Globals extends Window {

	@JSProperty
	public Page getPage();

	public void page(String path, PageCallback callback);

	public JQuery jQuery(String selector);

	public JQuery jQuery(HTMLElement object);

	@JSConstructor(value = "MutationObserver")
	public MutationObserver createMutationObserver(MutationObserverHandler handler);
}
