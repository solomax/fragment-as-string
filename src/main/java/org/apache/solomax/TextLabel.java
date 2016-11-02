package org.apache.solomax;

import java.io.Serializable;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.basic.Label;

public class TextLabel extends Label {
	private static final long serialVersionUID = 1L;
	private static final String WICKET_VISIBLE = ":visible";

	public TextLabel(String id, Serializable val) {
		super(id, val);
		setRenderBodyOnly(true);
	}

	@Override
	public void onComponentTagBody(MarkupStream markupStream, ComponentTag openTag) {
		final String vis = openTag.getAttribute(markupStream.getWicketNamespace() + WICKET_VISIBLE);
		if (vis != null && Boolean.FALSE.equals(Boolean.valueOf(vis))) {
			//skip the body
			return;
		}
		super.onComponentTagBody(markupStream, openTag);
	}
}
