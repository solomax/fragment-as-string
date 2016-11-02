/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License") +  you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.solomax;

import java.util.Date;

import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Fragment;

public class CreatedAppointmentTemplate extends AbstractAppointmentTemplate {
	private static final long serialVersionUID = 1L;

	public CreatedAppointmentTemplate() {
		super();

		add(new Label("titleLbl", "Title Label"));
		add(new Label("title", "Title"));
		add(new WebMarkupContainer("descContainer")
			.add(new Label("descLbl", "Description Label"))
			.add(new Label("desc", "Description"))
			);
	}

	@Override
	public String getSubject() {
		Fragment f = new Fragment(COMP_ID, "subject", this);
		f.add(new Label("prefix", "Prefix").setRenderBodyOnly(true)
				, new TextLabel("title", "Title")
				, new TextLabel("start", new Date().toString())
				, new DashTextLabel("dash")
				, new TextLabel("end", new Date().toString())
				);
		return ComponentRenderer.renderComponent(f).toString();
	}
}
