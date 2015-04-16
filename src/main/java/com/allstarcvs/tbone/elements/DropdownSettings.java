package com.allstarcvs.tbone.elements;

import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;

public interface DropdownSettings extends JSObject {

	@JSProperty
	public void setOnChange(DropdownChangeEventHandler function);
}
