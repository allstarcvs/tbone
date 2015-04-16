package com.allstarcvs.tbone.mutations;

import org.teavm.jso.JSArray;
import org.teavm.jso.JSFunctor;
import org.teavm.jso.JSObject;

@JSFunctor
public interface MutationObserverHandler extends JSObject {

	public void handle(JSArray<MutationRecord> mutations);

}
