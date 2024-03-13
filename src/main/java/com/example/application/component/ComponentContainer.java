package com.example.application.component;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.dom.ElementFactory;

@Tag("component-container")
@JsModule("./src/component-container.ts")
public class ComponentContainer extends LitTemplate {

    public ComponentContainer() {
        Element label = ElementFactory.createLabel("Main layout header");
        Element button = ElementFactory.createButton("Click me");

        getElement().appendChild(label, button);
    }
}