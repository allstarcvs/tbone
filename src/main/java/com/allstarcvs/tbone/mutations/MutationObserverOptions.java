package com.allstarcvs.tbone.mutations;

import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;

public interface MutationObserverOptions extends JSObject {

	@JSProperty
	public void setChildList(boolean flag);

	@JSProperty
	public void setAttributes(boolean flag);

	@JSProperty
	public void setCharacterData(boolean flag);

	@JSProperty
	public void setSubtree(boolean flag);

	@JSProperty
	public void setAttributeOldValue(boolean flag);

	@JSProperty
	public void setCharacterDataOldValue(boolean flag);

	@JSProperty
	public void setAttributeFilter(String[] filter);
}
