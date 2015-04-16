package com.allstarcvs.tbone.elements;

import net.java.html.js.JavaScriptBody;

import org.teavm.dom.html.HTMLElement;

/**
 * Define common javascript calls used in semantic ui.
 *
 * @author albert
 */
public class SemanticUiScripts {

	@JavaScriptBody(args = { "e", "o" }, body = "$(e).dropdown(o)")
	public static native void dropdown(HTMLElement ele, DropdownSettings options);

	@JavaScriptBody(args = { "e" }, body = "$(e).checkbox()")
	public static native void checkbox(HTMLElement ele);

	@JavaScriptBody(args = { "e" }, body = "$(e).on('click', function() { $(this).closest('.message').fadeOut(); })")
	public static native void messageClose(HTMLElement ele);
}
