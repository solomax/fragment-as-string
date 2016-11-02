package org.apache.solomax;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;

public class HomePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public HomePage(final PageParameters parameters) {
		super(parameters);

		add(new Label("version", getApplication().getFrameworkSettings().getVersion()));

		CreatedAppointmentTemplate temp = new CreatedAppointmentTemplate();
		add(new Label("body", temp.getEmail()).setEscapeModelStrings(false));
		add(new Label("subject", temp.getSubject()).setEscapeModelStrings(false));
	}
}
