package com.allstarcvs.tbone.wrappers;

import org.teavm.dom.browser.Window;
import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;

public interface Globals extends Window {

	@JSProperty
	public Page getPage();

	public void page(String path, PageCallback callback);

	public JSObject jQuery(String selector);
}
