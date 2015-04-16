package com.allstarcvs.tbone.wrappers;

import org.teavm.dom.core.Element;
import org.teavm.jso.JSFunctor;
import org.teavm.jso.JSObject;

@JSFunctor
public interface JQueryFindCallback extends JSObject {

	public void run(int i, Element ele);
}
