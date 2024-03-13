package com.example.application.component;

import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;

@Tag("sample-tooltip")
@JsModule("./src/sample-tooltip.ts")
public class Tooltip extends LitTemplate
        implements HasComponents, HasStyle {

}