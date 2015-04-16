package com.allstarcvs.tbone.elements;

import org.teavm.jso.JSFunctor;
import org.teavm.jso.JSObject;

@JSFunctor
public interface DropdownChangeEventHandler extends JSObject {

	public void handle(String value, String name);

}
