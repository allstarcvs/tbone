package com.allstarcvs.tbone;

import org.teavm.dom.ajax.XMLHttpRequest;

public interface XhrResponseHandler {

	void handle(XMLHttpRequest xhr);
}
