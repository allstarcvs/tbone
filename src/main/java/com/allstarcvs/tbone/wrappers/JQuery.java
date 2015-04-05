package com.allstarcvs.tbone.wrappers;

import org.teavm.jso.JSObject;

public interface JQuery extends JSObject {

	public JQuery addClass(String classes);

	public JQuery removeClass(String classes);

	public String data(String key);

	public JQuery data(final String key, String value);
}
