package com.example.application.component;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;

@Tag("parent-template")
@JsModule("./src/parent-template.ts")
public class ParentTemplate extends LitTemplate {

    public ParentTemplate() {

    }

    @Id("childTemplate")
    private ChildTemplate child;
}