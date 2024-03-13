package com.example.application.component;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.dom.ShadowRoot;


@Tag("my-label")
public class MyLabel extends Component {

    public MyLabel() {
        ShadowRoot shadowRoot = getElement()
                .attachShadow();
        Label textLabel = new Label("In the shadow");
        Button button = new Button("КнОпКа");
        shadowRoot.appendChild(textLabel.getElement());
        shadowRoot.appendChild(button.getElement());
    }
}