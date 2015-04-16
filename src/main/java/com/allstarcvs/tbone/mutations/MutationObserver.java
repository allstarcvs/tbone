package com.allstarcvs.tbone.mutations;

import org.teavm.dom.core.Node;
import org.teavm.jso.JSObject;

public interface MutationObserver extends JSObject {

	public void observe(Node node, MutationObserverOptions options);
}
