package com.allstarcvs.tbone;

import net.java.html.js.JavaScriptBody;

import org.teavm.dom.ajax.ReadyStateChangeHandler;
import org.teavm.dom.ajax.XMLHttpRequest;
import org.teavm.dom.html.HTMLDocument;
import org.teavm.dom.html.HTMLElement;
import org.teavm.jso.JS;
import org.teavm.jso.JSObject;

import com.allstarcvs.tbone.wrappers.Globals;
import com.allstarcvs.tbone.wrappers.JQuery;
import com.allstarcvs.tbone.wrappers.Page;
import com.allstarcvs.tbone.wrappers.PageCallback;
import com.allstarcvs.tbone.wrappers.PageCallbackWithId;
import com.allstarcvs.tbone.wrappers.PageContext;

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
		globals.page(path, new PageCallback() {
			@Override
			public void run(final PageContext ctx, final PageCallback next) {
				callback.run();
			}
		});
	}

	/**
	 * Requires page.js
	 */
	public static void page(final String path, final PageCallbackWithId callback) {
		// TODO extract the parameter name from the path
		globals.page(path, new PageCallback() {
			@Override
			public void run(final PageContext ctx, final PageCallback next) {
				callback.run(asString(ctx.getParams(), "id"));
			}
		});
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

	@JavaScriptBody(args = { "a", "s" }, body = "return a.join(s)")
	public static native String join(final String[] array, String separator);

	@JavaScriptBody(args = { "t", "s" }, body = "return t.split(s)")
	public static native String[] split(final String text, String separator);

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
		xhr.setOnReadyStateChange(new ReadyStateChangeHandler() {
			@Override
			public void stateChanged() {
				if (xhr.getReadyState() == XMLHttpRequest.DONE) {
					handler.handle(xhr);
				}
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
		xhr.setOnReadyStateChange(new ReadyStateChangeHandler() {
			@Override
			public void stateChanged() {
				if (xhr.getReadyState() == XMLHttpRequest.DONE) {
					handler.handle(xhr);
				}
			}
		});
		xhr.open("POST", url);
		xhr.setRequestHeader("Content-type", "application/json");
		xhr.send(stringify(data));
	}

	public static void ajax(final String method, final String url, final XhrResponseHandler handler) {
		final XMLHttpRequest xhr = globals.createXMLHttpRequest();
		xhr.setOnReadyStateChange(new ReadyStateChangeHandler() {
			@Override
			public void stateChanged() {
				if (xhr.getReadyState() == XMLHttpRequest.DONE) {
					handler.handle(xhr);
				}
			}
		});
		xhr.open(method, url);
		xhr.send();
	}

	// ====================================================================================================
	// Utilities
	// ====================================================================================================

	/**
	 * return Object.keys(obj)
	 */
	@JavaScriptBody(args = { "o" }, body = "return Object.keys(o);")
	public static native String[] keys(JSObject obj);

	public static String asString(final JSObject object, final String field) {
		return JS.unwrapString(JS.get(object, JS.wrap(field)));
	}

	public static int asInt(final JSObject object, final String field) {
		return JS.unwrapInt(JS.get(object, JS.wrap(field)));
	}

	public static double asDouble(final JSObject object, final String field) {
		return JS.unwrapDouble(JS.get(object, JS.wrap(field)));
	}

}
