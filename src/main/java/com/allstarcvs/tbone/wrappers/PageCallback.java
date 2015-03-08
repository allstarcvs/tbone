package com.allstarcvs.tbone.wrappers;

import org.teavm.jso.JSFunctor;
import org.teavm.jso.JSObject;

@JSFunctor
public interface PageCallback extends JSObject {

	public void run(PageContext ctx, PageCallback next);
}
