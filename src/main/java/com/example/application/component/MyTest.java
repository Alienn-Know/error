package com.example.application.component;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

@Tag("my-test-element")
@JsModule("my-test-element/my-test-element.js")
public class MyTest extends Component {

    public MyTest(String msg) {
        getElement().setProperty("name", msg);
    }
}