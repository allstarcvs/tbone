package com.allstarcvs.tbone.mutations;

import org.teavm.dom.core.Node;
import org.teavm.dom.core.NodeList;
import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;

public interface MutationRecord extends JSObject {

	@JSProperty
	public String getType();

	@JSProperty
	public Node getTarget();

	@JSProperty
	public NodeList<Node> getAddedNodes();

	@JSProperty
	public NodeList<Node> getRemovedNodes();

	@JSProperty
	public Node getPreviousSibling();

	@JSProperty
	public Node getNextSibling();

	@JSProperty
	public String getAttributeName();

	@JSProperty
	public String getAttributeNamespace();

	@JSProperty
	public String getOldValue();
}
