package com.allstarcvs.tbone.wrappers;

import org.teavm.jso.JSObject;

public interface Page extends JSObject {

	public void show(String path);

	public void redirect(String fromPath, String toPath);

	public void redirect(String path);
}
