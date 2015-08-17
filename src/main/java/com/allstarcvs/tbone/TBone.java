package com.allstarcvs.tbone;

import net.java.html.js.JavaScriptBody;

import org.teavm.dom.ajax.XMLHttpRequest;
import org.teavm.dom.html.HTMLDocument;
import org.teavm.dom.html.HTMLElement;
import org.teavm.jso.JS;
import org.teavm.jso.JSObject;

import com.allstarcvs.tbone.elements.UiNode;
import com.allstarcvs.tbone.utils.MutationSummary;
import com.allstarcvs.tbone.wrappers.Globals;
import com.allstarcvs.tbone.wrappers.JQuery;
import com.allstarcvs.tbone.wrappers.Page;
import com.allstarcvs.tbone.wrappers.PageCallback;
import com.allstarcvs.tbone.wrappers.PageCallbackWithId;

public class TBone {

	public static final Globals globals = (Globals) JS.getGlobal();
	public static final HTMLDocument document = globals.getDocument();

	// ====================================================================================================
	// Page.js Helpers
	// ====================================================================================================

	/**
	 * Requires page.js
	 */
	public static void page(final String path, final PageCallback callback) {
		globals.page(path, callback);
	}

	/**
	 * Requires page.js
	 */
	public static void page(final String path, final Runnable callback) {
		globals.page(path, (ctx, next) -> callback.run());
	}

	/**
	 * Requires page.js
	 */
	public static void page(final String path, final PageCallbackWithId callback) {
		// TODO extract the parameter name from the path
		globals.page(path, (ctx, next) -> callback.run(asString(ctx.getParams(), "id")));
	}

	/**
	 * Requires page.js
	 */
	public static void show(final String path) {
		page().show(path);
	}

	/**
	 * Requires page.js
	 */
	@JavaScriptBody(args = {}, body = "page.start({hashbang:true})")
	public static native void pageStart();

	/**
	 * Requires page.js
	 */
	public static Page page() {
		return globals.getPage();
	}

	// ====================================================================================================
	// DOM Events - Mutation Observer
	// ====================================================================================================

	/**
	 * Start the mutation observer for UiNodes.
	 */
	public static void startObserver() {
		MutationSummary.init();
	}

	public static void observe(final UiNode<?> node, final Runnable handler) {
		MutationSummary.observe(node, handler);
	}

	// ====================================================================================================
	// Misc JS Functions
	// ====================================================================================================

	public static JSObject global(final String name) {
		return JS.get(globals, JS.wrap(name));
	}

	/**
	 * Requires jquery.js
	 */
	public static JQuery jquery(final String selector) {
		return globals.jQuery(selector);
	}

	/**
	 * Requires jquery.js
	 */
	public static JQuery jquery(final HTMLElement object) {
		return globals.jQuery(object);
	}

	public static JQuery jquery(final UiNode<?> node) {
		return jquery(node.node());
	}

	@JavaScriptBody(args = { "a", "s" }, body = "return a.join(s)")
	public static native String join(final String[] array, String separator);

	@JavaScriptBody(args = { "t", "s" }, body = "return t.split(s)")
	public static native String[] split(final String text, String separator);

	@JavaScriptBody(args = { "s1", "s2" }, body = "return s1.indexOf(s2) > -1")
	public static native boolean contains(final String str1, String str2);

	/**
	 * Requires sprintf.js
	 */
	@JavaScriptBody(args = { "f", "a" }, body = "return vsprintf(f, a)")
	public static native String sprintf(final String format, final Object... arguments);

	@JavaScriptBody(args = {}, body = "return Math.random()")
	public static native double random();

	public static int random(final int x) {
		return (int) Math.round(random() * x);
	}

	@JavaScriptBody(args = { "j" }, body = "return JSON.stringify(j)")
	public static native String stringify(JSObject json);

	@JavaScriptBody(args = { "j" }, body = "return JSON.parse(j)")
	public static native <T extends JSObject> T parseJson(String json);

	@JavaScriptBody(args = { "j" }, body = "return JSON.parse(j)")
	public static native <T extends JSObject> T[] parseJsonArray(String json);

	// ====================================================================================================
	// ajax
	// ====================================================================================================

	public static interface XhrResponseHandler {
		void handle(XMLHttpRequest xhr);
	}

	public static void ajaxGet(final String url, final XhrResponseHandler handler) {
		final XMLHttpRequest xhr = globals.createXMLHttpRequest();
		xhr.setOnReadyStateChange(() -> {
			if (xhr.getReadyState() == XMLHttpRequest.DONE) {
				handler.handle(xhr);
			}
		});
		xhr.open("GET", url);
		xhr.send();
	}

	/**
	 * POST data as json
	 */
	public static void ajaxPost(final String url, final JSObject data, final XhrResponseHandler handler) {
		final XMLHttpRequest xhr = globals.createXMLHttpRequest();
		xhr.setOnReadyStateChange(() -> {
			if (xhr.getReadyState() == XMLHttpRequest.DONE) {
				handler.handle(xhr);
			}
		});
		xhr.open("POST", url);
		xhr.setRequestHeader("Content-type", "application/json");
		xhr.send(stringify(data));
	}

	public static void ajax(final String method, final String url, final XhrResponseHandler handler) {
		final XMLHttpRequest xhr = globals.createXMLHttpRequest();
		xhr.setOnReadyStateChange(() -> {
			if (xhr.getReadyState() == XMLHttpRequest.DONE) {
				handler.handle(xhr);
			}
		});
		xhr.open(method, url);
		xhr.send();
	}

	// ====================================================================================================
	// html5 local storage
	// ====================================================================================================

	@JavaScriptBody(args = { "k", "o" }, body = "if(typeof(Storage) !== 'undefined') { localStorage.setItem(k,o);}")
	public static native void localPut(String key, String obj);

	@JavaScriptBody(args = { "k" }, body = "if(typeof(Storage) !== 'undefined') { return localStorage.getItem(k);}")
	public static native String localGet(String key);

	// ====================================================================================================
	// Utilities
	// ====================================================================================================

	@JavaScriptBody(args = { "o" }, body = "return Object.keys(o)")
	public static native String[] keys(JSObject obj);

	@JavaScriptBody(args = { "o" }, body = "return o === undefined")
	public static native boolean isUndefined(JSObject obj);

	@JavaScriptBody(args = { "o" }, body = "return o === undefined")
	public static native boolean isUndefined(JSObject[] obj);

	@JavaScriptBody(args = {}, body = "return undefined")
	public static native JSObject undefined();

	@JavaScriptBody(args = { "o" }, body = "console.log(o)")
	public static native void log(JSObject obj);

	@JavaScriptBody(args = { "o" }, body = "console.log(o)")
	public static native void log(JSObject[] obj);

	@JavaScriptBody(args = { "o" }, body = "console.log(o)")
	public static native void log(String msg);

	public static String asString(final JSObject object, final String field) {
		final JSObject obj = JS.get(object, JS.wrap(field));
		if (obj == null) return null;
		return JS.unwrapString(obj);
	}

	public static String asStringNotNull(final JSObject object, final String field) {
		final String text = asString(object, field);
		if (text == null) return "";
		return text;
	}

	public static Integer asInt(final JSObject object, final String field) {
		final JSObject obj = JS.get(object, JS.wrap(field));
		if (obj == null) return null;
		return JS.unwrapInt(obj);
	}

	public static Double asDouble(final JSObject object, final String field) {
		final JSObject obj = JS.get(object, JS.wrap(field));
		if (obj == null) return null;
		return JS.unwrapDouble(obj);
	}

}
