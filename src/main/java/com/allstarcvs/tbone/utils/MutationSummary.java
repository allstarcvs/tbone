package com.allstarcvs.tbone.utils;

import java.util.HashMap;
import java.util.Map;

import org.teavm.dom.core.Node;
import org.teavm.dom.core.NodeList;
import org.teavm.dom.html.HTMLElement;
import org.teavm.jso.JSArray;
import org.teavm.jso.JSConstructor;
import org.teavm.jso.JSFunctor;
import org.teavm.jso.JSObject;
import org.teavm.jso.JSProperty;

import com.allstarcvs.tbone.TBone;
import com.allstarcvs.tbone.elements.UiNode;

/**
 * Use MutationObserver to handle DOM change events. This implementation is only interested in nodes with the
 * "data-tbone-id" attributes.
 */
public class MutationSummary {

	private static final String DATA_TBONE_ID = "data-tbone-id";
	private static final Map<Integer, Runnable> handlers = new HashMap<>();
	private static int nextId = 0;

	/**
	 * Setup MO to detect any new nodes with the "data-tbone-id" and call the attached handler.
	 */
	public static void init() {

		final Instance mo = ((MyGlobal) TBone.globals).createMutationObserver(mutations -> {
			for (int i = 0; i < mutations.getLength(); i++) {
				final NodeList<Node> addedNodes = mutations.get(i).getAddedNodes();
				for (int j = 0; j < addedNodes.getLength(); j++) {
					TBone.jquery((HTMLElement) addedNodes.get(j))
							.find("[" + DATA_TBONE_ID + "]")
							.each((index, e) -> {
								final int myId = Integer.valueOf(e.getAttribute(DATA_TBONE_ID));
								if (handlers.containsKey(myId)) {
									handlers.get(myId).run();
									handlers.remove(myId); // housekeeping
								}
							});
				}
			}
		});
		final Settings options = (Settings) TBone.globals.newObject();
		options.setSubtree(true);
		options.setChildList(true);
		mo.observe(TBone.document.getBody(), options);
	}

	/**
	 * Attach an ID to the node as "data-tbone-id", and register the handler associated with this ID in Java.
	 */
	public static void observe(final UiNode<?> node, final Runnable handler) {
		final int myId = nextId++;
		node.attr(DATA_TBONE_ID, myId);
		handlers.put(myId, handler);
	}

	// ====================================================================================================
	// Javascript Object Mappings
	// ====================================================================================================

	static interface MyGlobal extends JSObject {
		@JSConstructor(value = "MutationObserver")
		public Instance createMutationObserver(Handler handler);
	}

	static interface Settings extends JSObject {

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

	@JSFunctor
	static interface Handler extends JSObject {

		public void handle(JSArray<MutationRecord> mutations);

	}

	static interface Instance extends JSObject {

		public void observe(Node node, Settings options);
	}

	static interface MutationRecord extends JSObject {

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
}
