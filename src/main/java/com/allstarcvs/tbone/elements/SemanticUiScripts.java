package com.allstarcvs.tbone.elements;

import net.java.html.js.JavaScriptBody;

/**
 * Define common javascript calls used in semantic ui.
 *
 * @author albert
 */
public class SemanticUiScripts {

	// @formatter:off
	public static final long DROPDOWN 			= 0x00000001;
	public static final long CHECKBOX     		= 0x00000002;
	public static final long MESSAGE_CLOSE 		= 0x00000004;
	// @formatter:on

	/**
	 * Test each flag to execute the corresponding script.
	 */
	private static void execute(final long flags) {
		if ((flags & DROPDOWN) != 0) dropdown();
		if ((flags & CHECKBOX) != 0) checkbox();
		if ((flags & MESSAGE_CLOSE) != 0) messageClose();
	}

	public static void execute(final UiNode<?> node) {
		execute(node.scriptFlags);
	}

	@JavaScriptBody(args = {}, body = "$('.dropdown').dropdown()")
	private static native void dropdown();

	@JavaScriptBody(args = {}, body = "$('.ui.checkbox').checkbox()")
	private static native void checkbox();

	@JavaScriptBody(args = {}, body = "$('.message .close').on('click', function() { $(this).closest('.message').fadeOut(); })")
	private static native void messageClose();
}
