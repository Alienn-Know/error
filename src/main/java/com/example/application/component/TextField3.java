package com.example.application.component;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.dom.Element;

@Tag("div")
public class TextField3 extends Component {

    Element labelElement = new Element("label");
    Element inputElement = new Element("input");

    public TextField3() {
        inputElement
            .addPropertyChangeListener("value", "change", e -> {});
        getElement()
            .appendChild(labelElement, inputElement);
    }

    public String getLabel() {
        return labelElement.getText();
    }

    public String getValue() {
        return inputElement.getProperty("value");
    }

    public void setLabel(String label) {
        labelElement.setText(label);
    }

    public void setValue(String value) {
        inputElement.setProperty("value", value);
    }

}