package com.allstarcvs.tbone.elements;

import org.teavm.jso.JSFunctor;

@JSFunctor
public interface DropdownChangeEventHandler {

	public void handle(String value, String name);

}
