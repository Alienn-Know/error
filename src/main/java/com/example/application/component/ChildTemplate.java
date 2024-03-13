package com.example.application.component;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;

@Tag("child-template")
@JsModule("./src/child-template.ts")
public class ChildTemplate extends LitTemplate {

    public ChildTemplate() {

    }
}