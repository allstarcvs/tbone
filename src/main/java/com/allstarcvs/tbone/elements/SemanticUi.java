package com.allstarcvs.tbone.elements;

import static com.allstarcvs.tbone.elements.UiNode.*;
import net.java.html.js.JavaScriptBody;

import org.teavm.dom.html.HTMLElement;

import com.allstarcvs.tbone.TBone;

public class SemanticUi {

	private static final String[] numbers = {
			"zero",
			"one", "two", "three", "four",
			"five", "six", "seven", "eight",
			"nine", "ten", "eleven", "twelve",
			"thirteen", "fourteen", "fifteen", "sixteen"
	};

	// ====================================================================================================
	// Basic Elements
	// ====================================================================================================

	public static UiCommon span(final String text) {
		return element("span").text(text);
	}

	public static UiCommon p(final String text) {
		return element("p").text(text);
	}

	public static UiCommon strong(final String text) {
		return element("strong").text(text);
	}

	public static UiCommon div(final String classes) {
		return element("div").attr("class", classes);
	}

	public static UiCommon br() {
		return element("br");
	}

	/**
	 * Content: text
	 */
	public static UiCommon iconLabel(final String icon, final String... variations) {
		return element("span").attr("class", join(variations) + icon).add(icon(icon));
	}

	public static UiCommon rating(final int rating, final String... variations) {
		return element("span").attr("class", "ui " + join(variations) + "rating").attr("data-rating", "" + rating);
	}

	public static UiCommon date(final String... variations) {
		return element("span").attr("class", join(variations) + "date");
	}

	public static UiCommon time(final String... variations) {
		return element("span").attr("class", join(variations) + "time");
	}

	// ====================================================================================================
	// Header
	// ====================================================================================================

	/**
	 * @param variations
	 *            <i>size</i>, icon, center/right/left/justified aligned, disabled, dividing, block,
	 *            top/bottom attached, right/left floated, <i>color</i>, inverted,
	 */
	public static UiCommon header(final String... variations) {
		return div(join(variations) + "header");
	}

	/**
	 * Append this to a header().content() element.
	 */
	public static UiCommon subHeader(final String... variations) {
		return div(join(variations) + "sub header");
	}

	public static UiCommon h1(final String text) {
		return element("h1")
				.attr("class", "ui header")
				.text(text);
	}

	public static UiCommon h2(final String text) {
		return element("h2")
				.attr("class", "ui header")
				.text(text);
	}

	public static UiCommon h3(final String text) {
		return element("h3")
				.attr("class", "ui header")
				.text(text);
	}

	public static UiCommon h4(final String text) {
		return element("h4")
				.attr("class", "ui header")
				.text(text);
	}

	public static UiCommon h5(final String text) {
		return element("h5")
				.attr("class", "ui header")
				.text(text);
	}

	public static UiCommon h6(final String text) {
		return element("h6")
				.attr("class", "ui header")
				.text(text);
	}

	// ====================================================================================================
	// Buttons
	// ====================================================================================================

	/**
	 * @param variations
	 *            basic, inverted, <i>color</i>, <i>size</i>, active, disabled, loading, compact, toggle, fluid,
	 *            circular, top/bottom/left/right attached, submit
	 */
	public static UiCommon button(final String... variations) {
		return div("ui " + join(variations) + "button");
	}

	/**
	 *
	 * @param visibleContent
	 *            content("visible")
	 * @param hiddenContent
	 *            content("hidden")
	 * @param variations
	 *            vertical, fade
	 * @return
	 */
	public static UiCommon animatedButton(final UiNode<?> visibleContent, final UiNode<?> hiddenContent, final String... variations) {
		return button(join(variations) + "animated").add(
				visibleContent, hiddenContent);

	}

	public static UiCommon iconButton(final String icon, final String... variations) {
		return button(join(variations) + "icon")
				.add(icon(icon));
	}

	public static UiCommon iconButtonWithLabel(final String icon, final String label, final String... variations) {
		return button(join(variations) + "icon")
				.add(icon(icon))
				.text(label);
	}

	/**
	 * Content: button, orDivider
	 *
	 * @param variations
	 *            vertical, <i>n</i> fluid, <i>color</i>, basic, <i>size</i>
	 */
	public static UiCommon buttons(final String... variations) {
		return div("ui " + join(variations) + "buttons");
	}

	/**
	 * Content: button, orDivider
	 *
	 * @param variations
	 *            vertical, <i>color</i>, basic, <i>size</i>
	 */
	public static UiCommon buttons(final int fluid, final String... variations) {
		return div("ui " + join(variations) + numbers[fluid] + " fluid buttons");
	}

	public static UiCommon orDivider() {
		return div("or");
	}

	// ====================================================================================================
	// Divider
	// ====================================================================================================

	/**
	 * May use text() header(), icon() to display text in the divider.
	 *
	 * @param variations
	 *            vertical, horizontal, inverted, fitted, hidden, section, clearing
	 */
	public static UiCommon divider(final String... variations) {
		return div("ui " + join(variations) + "divider");
	}

	// ====================================================================================================
	// Icons
	// ====================================================================================================

	/**
	 * @param country
	 *            two letter ISO code
	 */
	public static UiCommon flag(final String country, final String... variations) {
		return element("i")
				.attr("class", join(variations) + country + " flag");
	}

	/**
	 * @param variations
	 *            disabled, loading, <i>size</i>, link, horizontally/vertically flipped,
	 *            clockwise/counterclockwise rotated, circular, bordered, inverted, <i>color</i>
	 */
	public static UiCommon icon(final String name, final String... variations) {
		return element("i")
				.attr("class", "ui " + join(variations) + name + " icon");
	}

	// ====================================================================================================
	// Image
	// ====================================================================================================

	/**
	 * Content: image
	 */
	public static UiCommon images(final String variations) {
		return div("ui " + join(variations) + " images");
	}

	/**
	 *
	 * @param variations
	 *            <i>size</i>, disabled, avatar, bordered, rounded, circular, top/middle/bottom aligned, centered
	 *            left/right floated,
	 */
	public static UiCommon image(final String src, final String... variations) {
		return element("img")
				.attr("src", (src == null) ? "unknown.jpg" : src)
				.attr("class", "ui " + join(variations) + "image");
	}

	// ====================================================================================================
	// Input
	// ====================================================================================================

	/**
	 * Content: ui input
	 * <ul>
	 * <li>icon : include an additional icon as content</li>
	 * <li>labeled : include an additional label as content</li>
	 * <li>action : include an additional button as content</li>
	 * </ul>
	 *
	 * @param variations
	 *            focus, loading, error, [left] icon, corner/right labeled, action, transparent, inverted, fluid,
	 *            <i>size</i>
	 */
	public static UiInput input(final String... variations) {
		return new UiInput(div("ui " + join(variations) + "input"));
	}

	// ====================================================================================================
	// Label
	// ====================================================================================================

	/**
	 * Content: label
	 */
	public static UiCommon labels(final String... variations) {
		return div("ui " + join(variations) + "labels");
	}

	/**
	 * A label can contain: icon, detail, link, image.
	 *
	 * @param variations
	 *            image, pointing below/left/right, <i>color</i>, left/right corner, tag, left/right ribbon,
	 *            top/bottom left/right attached, horizontal, circular, floating
	 */
	public static UiCommon label(final String... variations) {
		return div("ui " + join(variations) + "label");
	}

	public static UiCommon detail(final String... variations) {
		return div("ui " + join(variations) + "detail");
	}

	// ====================================================================================================
	// Dimmer & Loader
	// ====================================================================================================

	/**
	 * The variations are for the loader
	 *
	 */
	public static UiCommon dimmerWithLoader(final String... variations) {
		return div("ui active dimmer")
				.add(loader(join(variations)));

	}

	/**
	 * @param variations
	 *            text, indeterminate, disabled, inline, <i>size</i>, inverted,
	 */
	public static UiCommon loader(final String... variations) {
		return div("ui " + join(variations) + "loader");

	}

	// ====================================================================================================
	// Rails
	// ====================================================================================================

	/**
	 * Content: segment
	 *
	 * @param variations
	 *            left/right, internal, dividing, attached, [very] close,
	 */
	public static UiCommon rail(final String... variations) {
		return div("ui " + join(variations) + "rail");
	}

	// ====================================================================================================
	// Reveal
	// ====================================================================================================

	/**
	 * Must specify the type of reveal.
	 *
	 * @param visibleContent
	 *            content("visible")
	 * @param hiddenContent
	 *            content("hidden")
	 * @param type
	 *            fade, right/up/down move, rotate [left]
	 * @param variations
	 *            circular, masked, instant, disabled
	 */
	public static UiCommon reveal(final UiNode<?> visibleContent, final UiNode<?> hiddenContent, final String type,
			final String... variations) {
		return div("ui " + join(variations) + type + " reveal").add(
				visibleContent,
				hiddenContent);
	}

	// ====================================================================================================
	// Segment
	// ====================================================================================================

	/**
	 * Content: segment
	 */
	public static UiCommon segments(final String... variations) {
		return div("ui " + join(variations) + "segments");
	}

	/**
	 * @param variations
	 *            vertical, horizontal, [tall] stacked, piled, disabled, loading, inverted, top/bottom attached,
	 *            compact, raised, <i>color</i>, primary/secondary/tertiary, circular, left/right floated,
	 *            left/right/center aligned, basic,
	 */
	public static UiCommon segment(final String... variations) {
		return div("ui " + join(variations) + "segment");
	}

	// ====================================================================================================
	// Step
	// ====================================================================================================

	/**
	 * Content: step
	 *
	 * @param variations
	 *            ordered, vertical,tablet stackable, fluid, <i>size</i>, <i>number</i>
	 */
	public static UiCommon steps(final String... variations) {
		return div("ui " + join(variations) + "steps");
	}

	/**
	 * Content: step
	 *
	 * @param variations
	 *            ordered, vertical,tablet stackable, fluid, <i>size</i>
	 */
	public static UiCommon steps(final int steps, final String... variations) {
		return div("ui " + join(variations) + numbers[steps] + " steps");
	}

	/**
	 * @param variations
	 *            active, disabled, completed, link
	 */
	public static UiCommon step(final String... variations) {
		return div("ui " + join(variations) + "step");
	}

	// ====================================================================================================
	// Breadcrumb
	// ====================================================================================================

	/**
	 * Content: bcSection, bcDivider
	 *
	 * @param variations
	 *            <i>size</i>
	 */
	public static UiCommon breadcrumb(final String... variations) {
		return div("ui " + join(variations) + "breadcrumb");
	}

	/**
	 * @param variations
	 *            active
	 */
	public static UiCommon bcSection(final String... variations) {
		return div(join(variations) + "section");
	}

	/**
	 * @param variations
	 *            active
	 */
	public static UiCommon bcDivider(final String... variations) {
		return div(join(variations) + "divider");
	}

	// ====================================================================================================
	// Form
	// ====================================================================================================

	/**
	 * Content: fields, field
	 *
	 * @param variations
	 *            loading, error, warning, fluid, small/large, inverted
	 */
	public static UiCommon form(final String... variations) {
		return div("ui " + join(variations) + "form");
	}

	/**
	 * @see form()
	 */
	public static UiCommon formWithSegment(final String... variations) {
		return div("ui " + join(variations) + "form segment");
	}

	/**
	 * @param variations
	 *            grouped, inline, <i>number</i>
	 */
	public static UiCommon fields(final String... variations) {
		return div(join(variations) + "fields");
	}

	/**
	 * @param variations
	 *            grouped, inline
	 */
	public static UiCommon fields(final int fields, final String... variations) {
		return div(join(variations) + numbers[fields] + " fields");
	}

	/**
	 * @param variations
	 *            inline, error, disabled, <i>n</i> wide, required,
	 */
	public static UiCommon field(final String... variations) {
		return div(join(variations) + "field");
	}

	/**
	 * @param variations
	 *            inline, error, disabled, required,
	 */
	public static UiCommon field(final int wide, final String... variations) {
		return div(join(variations) + numbers[wide] + " wide field");
	}

	/**
	 * Add optional 'for' attribute
	 */
	public static UiCommon fieldLabel() {
		return element("label");
	}

	/**
	 * Add optional 'readonly', 'disaabled', 'placeholder' attributes
	 */
	public static UiInput textField(final Object value, final InputEventHandler changeHandler) {
		final UiInput input = new UiInput(element("input").attr("type", "text")).value(value);
		if (changeHandler != null) input.change(e -> changeHandler.handle(input));
		return input;
	}

	public static UiInput textField(final Object value) {
		return textField(value, null);
	}

	public static UiInput textField() {
		return textField(null, null);
	}

	/**
	 * Add optional 'readonly', 'disaabled', 'placeholder' attributes
	 *
	 * @param format
	 *            sprintf style formatting
	 * @param value
	 *            should be double or integer
	 */
	public static UiInput numberField(final String format, final Number value, final InputEventHandler changeHandler) {
		final Object text = (format == null || value == null) ? value : TBone.sprintf(format, value);
		final UiInput input = new UiInput(element("input").attr("type", "number")).value(text);
		if (changeHandler != null) input.change(e -> changeHandler.handle(input));
		return input;
	}

	/**
	 * @param format
	 *            sprintf style formatting
	 * @param value
	 *            should be double or integer
	 */
	public static UiInput numberField(final String format, final Number value) {
		return numberField(format, value, null);
	}

	public static UiInput numberField(final Number value) {
		return numberField(null, value, null);
	}

	public static UiInput numberField() {
		return numberField(null, null, null);
	}

	public static UiInput textarea(final String value, final InputEventHandler changeHandler) {
		final UiInput input = new UiInput(element("textarea")).value(value);
		if (changeHandler != null) input.change(e -> changeHandler.handle(input));
		return input;
	}

	public static UiInput textarea(final String value) {
		return textarea(value, null);
	}

	public static UiInput textarea() {
		return textarea(null, null);
	}

	/**
	 * @param variations
	 *            fluid
	 */
	public static UiDropdown selectionDropdown(final Object value, final InputEventHandler changeHandler) {
		return UiDropdown.create(value, changeHandler);
	}

	public static UiDropdown selectionDropdown(final Object value) {
		return selectionDropdown(value, null);
	}

	public static UiDropdown selectionDropdown() {

		return selectionDropdown(null, null);
	}

	/**
	 * Content: options
	 *
	 * @param variations
	 *            search
	 * @return
	 */
	public static UiCommon select(final String... variations) {
		final UiCommon dropdown = element("select").attr("class", "ui " + join(variations) + "dropdown");
		return dropdown.observe(() -> initDropdown(dropdown.node));
	}

	public static UiCommon option(final String value) {
		return element("option").attr("value", value);
	}

	/**
	 * Content: append label.
	 *
	 * @param style
	 *            radio, toogle, slider
	 */
	public static UiCommon checkbox(final String name, final String style, final boolean checked) {
		final UiCommon checkbox = div("ui " + style + " checkbox" + (checked ? " checked" : "")).add(
				element("input")
						.attr("type", "radio")
						.attr("name", name)
						.attr("checked", checked)
				);
		return checkbox.observe(() -> initCheckbox(checkbox.node));
	}

	/**
	 * Content: append label.
	 * Simple checkbox.
	 */
	public static UiCommon checkbox(final String name, final boolean checked) {
		final UiCommon checkbox = div("ui checkbox" + (checked ? " checked" : "")).add(
				element("input")
						.attr("type", "checkbox")
						.attr("name", name)
						.attr("checked", checked)
				);
		return checkbox.observe(() -> initCheckbox(checkbox.node));
	}

	// ====================================================================================================
	// Grid
	// ====================================================================================================

	/**
	 * Content: row, column
	 *
	 * @param variations
	 *            centered, right/left/center aligned, right/left/center floated, mobile/computer/tablet only,
	 *            page, padded, <i>n</i> column, stackable
	 */
	public static UiCommon grid(final String... variations) {
		return div("ui " + join(variations) + "grid");
	}

	/**
	 * Content: row, column
	 *
	 * @param variations
	 *            centered, right/left/center aligned, right/left/center floated, mobile/computer/tablet only,
	 *            page, padded, stackable
	 */
	public static UiCommon grid(final int column, final String... variations) {
		return div("ui " + join(variations) + numbers[column] + " column grid");
	}

	/**
	 * Content: column
	 *
	 * @param variations
	 *            centered, right/left/center aligned, right/left/center floated, mobile/computer/tablet only,
	 *            <i>n</i> column, doubling, equal height
	 */
	public static UiCommon row(final String... variations) {
		return div(join(variations) + "row");
	}

	/**
	 * Content: column
	 *
	 * @param variations
	 *            centered, right/left/center aligned, right/left/center floated, mobile/computer/tablet only,
	 *            doubling, equal height
	 */
	public static UiCommon row(final int column, final String... variations) {
		return div(join(variations) + numbers[column] + " column row");
	}

	/**
	 * A grid has 16 columns by default. Suggest to add "segment" as content.
	 *
	 * @param variations
	 *            centered, right/left/center aligned, right/left/center floated, mobile/computer/tablet only,
	 *            <i>n</i> wide mobile/tablet/computer/large screen/widescreen,
	 */
	public static UiCommon column(final String... variations) {
		return div(join(variations) + "column");
	}

	/**
	 * A grid has 16 columns by default. Suggest to add "segment" as content.
	 *
	 * @param variations
	 *            centered, right/left/center aligned, right/left/center floated, mobile/computer/tablet only,
	 *            mobile/tablet/computer/large screen/widescreen,
	 */
	public static UiCommon column(final int wide, final String... variations) {
		return div(join(variations) + numbers[wide] + " wide column");
	}

	// ====================================================================================================
	// List, Menu, and Item
	// ====================================================================================================

	/**
	 * Content: item, nestedMenu
	 *
	 * @param variations
	 *            right, vertical, pagination, tabular, tiered, top/bottom attached, sub, secondary, pointing, text,
	 *            compact, inverted, <i>color</i>, [labeled] icon, fluid, <i>n</i> item, <i>size</i>, borderless
	 */
	public static UiCommon menu(final String... variations) {
		return div("ui " + join(variations) + "menu");
	}

	/**
	 * Content: item, nestedMenu
	 *
	 * @param variations
	 *            right, vertical, pagination, tabular, tiered, top/bottom attached, sub, secondary, pointing, text,
	 *            compact, inverted, <i>color</i>, [labeled] icon, fluid, <i>size</i>, borderless
	 */
	public static UiCommon menu(final int item, final String... variations) {
		return div("ui " + join(variations) + numbers[item] + " item menu");
	}

	/**
	 * @see menu()
	 */
	public static UiCommon nestedMenu(final String... variations) {
		return div(join(variations) + "menu");
	}

	/**
	 * Content: item
	 *
	 * @param variations
	 *            bulleted, ordered, link, divided, celled, horizontal, inverted, selection, animated, [very] relaxed,
	 *            <i>size</i>
	 */
	public static UiCommon list(final String... variations) {
		return div("ui " + join(variations) + "list");
	}

	/**
	 * Content: item
	 *
	 * @param variations
	 *            divided,
	 */
	public static UiCommon items(final String... variations) {
		return div("ui " + join(variations) + "items");
	}

	/**
	 * Contents: icon, image, content(header, meta, description), extra content
	 *
	 * @param variations
	 *            active, icon, disabled, dropdown, header, text, link, hover, down, <i>color</i>,
	 *            horizontally/vertically fitted
	 */
	public static UiCommon item(final String... variations) {
		return div("ui " + join(variations) + "item");
	}

	/**
	 * Content: header, meta, description, content
	 *
	 * @param variations
	 *            [top] aligned, visible, hidden
	 */
	public static UiCommon content(final String... variations) {
		return div(join(variations) + "content");
	}

	public static UiCommon title(final String... variations) {
		return div(join(variations) + "title");
	}

	public static UiCommon meta(final String... variations) {
		return div(join(variations) + "meta");
	}

	public static UiCommon description(final String... variations) {
		return div(join(variations) + "description");
	}

	public static UiCommon extra(final String... variations) {
		return div(join(variations) + "extra");
	}

	// ====================================================================================================
	// Message
	// ====================================================================================================
	/**
	 *
	 * @param variations
	 *            icon, hidden, visible, floating, compact, top/bottom attached, <i>color</i>, <i>size</i>
	 *            info / warning / error / success /positive / negative,
	 */
	public static UiCommon message(final String... variations) {
		final UiCommon msg = div("ui " + join(variations) + "message");
		return msg.observe(() -> initMessageClose(msg.node));
	}

	// ====================================================================================================
	// Table
	// ====================================================================================================

	/**
	 * @param variations
	 *            basic, celled, striped, definition, [very] compact, structured, unstackable, stackable, collapsing
	 *            <i>n</i> column, <i>color</i>, inverted, sortable, [very] padded, <i>size</i>
	 */
	public static UiCommon table(final String... variations) {
		return element("table").attr("class", "ui " + join(variations) + "table");
	}

	/**
	 * @param variations
	 *            basic, celled, striped, definition, [very] compact, structured, unstackable, stackable, collapsing
	 *            <i>color</i>, inverted, sortable, [very] padded, <i>size</i>
	 */
	public static UiCommon table(final int column, final String... variations) {
		return element("table").attr("class", "ui " + join(variations) + numbers[column] + " column table");
	}

	/**
	 * @param variations
	 *            full-width
	 */
	public static UiCommon thead(final String... variations) {
		return element("thead");
	}

	public static UiCommon tbody(final String... variations) {
		return element("tbody");
	}

	public static UiCommon tfoot(final String... variations) {
		return element("tfoot");
	}

	/**
	 * @param variations
	 *            positive, negative, error, warning, active, disabled, right/center/left aligned
	 */
	public static UiCommon tr(final String... variations) {
		return element("tr").attr("class", join(variations));
	}

	/**
	 * @param variations
	 *            positive, negative, error, warning, active, disabled, right/center/left aligned, collapsing,
	 *            <i>n</i> wide
	 */
	public static UiCommon td(final String... variations) {
		return element("td").attr("class", join(variations));
	}

	/**
	 * @param variations
	 *            positive, negative, error, warning, active, disabled, right/center/left aligned, collapsing,
	 */
	public static UiCommon td(final int wide, final String... variations) {
		return element("td").attr("class", join(variations) + numbers[wide] + " wide");
	}

	/**
	 * Sorting needs plugin.
	 *
	 * @param variations
	 *            positive, negative, error, warning, active, disabled, right/center/left aligned, collapsing,
	 *            <i>n</i> wide, ascending/descending
	 */
	public static UiCommon th(final String... variations) {
		return element("th").attr("class", join(variations));
	}

	/**
	 * Sorting needs plugin.
	 *
	 * @param variations
	 *            positive, negative, error, warning, active, disabled, right/center/left aligned, collapsing,
	 *            ascending/descending
	 */
	public static UiCommon th(final int wide, final String... variations) {
		return element("th").attr("class", join(variations) + numbers[wide] + " wide");
	}

	// ====================================================================================================
	// Advertisement
	// ====================================================================================================

	/**
	 * @param variations
	 *            small/medium/large/vertical rectangle, square/small button, [large] leaderboard, billboard,
	 *            vertical/top/half banner, half page, [wide] skyscraper, panorama, netboard,
	 *            centered, mobile, test
	 */
	public static UiCommon ad(final String... variations) {
		return div("ui " + join(variations) + "ad");
	}

	// ====================================================================================================
	// Cards
	// ====================================================================================================

	/**
	 * Content:card
	 *
	 * @param variations
	 *            <i>number</i>, doubling
	 */
	public static UiCommon cards(final String... variations) {
		return div("ui " + join(variations) + "cards");
	}

	/**
	 * Content:card
	 *
	 * @param variations
	 *            doubling
	 */
	public static UiCommon cards(final int n, final String... variations) {
		return div("ui " + join(variations) + numbers[n] + " cards");
	}

	/**
	 * Content: image, content (header, meta, description), extra content. @see item
	 *
	 * @param variations
	 *            link, fluid, <i>color</i>
	 */
	public static UiCommon card(final String... variations) {
		return div(join(variations) + "card");
	}

	// ====================================================================================================
	// Comment
	// ====================================================================================================

	/**
	 * Content: comment
	 *
	 * @param variations
	 *            collapsed, threaded, minimal
	 */
	public static UiCommon comments(final String... variations) {
		return div("ui " + join(variations) + "comments");
	}

	/**
	 * Content: avatar, content(author, metadata, text, actions, form). @see item
	 *
	 * @param variations
	 */
	public static UiCommon comment(final String... variations) {
		return div(join(variations) + "comment");
	}

	// ====================================================================================================
	// Feed
	// ====================================================================================================

	/**
	 * Content: event
	 *
	 * @param variations
	 *            <i>size</i>
	 */
	public static UiCommon feed(final String... variations) {
		return div("ui " + join(variations) + "feed");
	}

	/**
	 * Content: label, content(date, summary, extra text, extra images, meta). @see item
	 *
	 * @param variations
	 */
	public static UiCommon event(final String... variations) {
		return div(join(variations) + "event");
	}

	// ====================================================================================================
	// Feed
	// ====================================================================================================

	/**
	 * Content: statistic
	 *
	 * @param variations
	 */
	public static UiCommon statistics(final String... variations) {
		return div("ui " + join(variations) + "statistics");
	}

	/**
	 * Content: value, label
	 *
	 * @param variations
	 *            horizontal, <i>color</i>, inverted, right/left floated, <i>size</i>
	 */
	public static UiCommon statistic(final String... variations) {
		return div(join(variations) + "statistic");
	}

	// ====================================================================================================
	// modal
	// ====================================================================================================
	public static UiCommon modal(final String id, final String... variations) {
		return div("ui " + join(variations) + "modal").attr("id", id);
	}

	public static UiCommon actions(final String... variations) {
		return div(join(variations) + "actions");
	}

	// ====================================================================================================
	// scripts
	// ====================================================================================================

	@JavaScriptBody(args = { "e" }, body = "$(e).dropdown()")
	static native void initDropdown(HTMLElement ele);

	@JavaScriptBody(args = { "e" }, body = "$(e).checkbox()")
	static native void initCheckbox(HTMLElement ele);

	@JavaScriptBody(args = { "e" }, body = "$(e).on('click', function() { $(this).closest('.message').fadeOut(); })")
	static native void initMessageClose(HTMLElement ele);
}
