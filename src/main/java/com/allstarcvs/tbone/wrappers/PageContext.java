package com.allstarcvs.tbone.wrappers;

import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;

public interface PageContext extends JSObject {

	public void pushState();

	public void save();

	@JSProperty
	public JSObject getParams();

	@JSProperty
	public boolean isHandled();

	@JSProperty
	public String getCanonicalpath();

	@JSProperty
	public String getPath();

	@JSProperty
	public String getQuerystring();

	@JSProperty
	public String getPathname();

	@JSProperty
	public String getState();

	@JSProperty
	public String getTitle();
}
