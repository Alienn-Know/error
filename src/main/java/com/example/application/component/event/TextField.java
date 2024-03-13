package com.example.application.component.event;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.shared.Registration;


@Tag("input")
public class TextField extends Component {

    public Registration addChangeListener(
            ComponentEventListener<ChangeEvent> listener) {
        return addListener(ChangeEvent.class, listener);
    }

    public Registration addChangeListener2(
            ComponentEventListener<EnterPressEvent> listener) {
        return addListener(EnterPressEvent.class, listener);
    }

    public Registration addChangeListener3(
            ComponentEventListener<InputEvent> listener) {
        return addListener(InputEvent.class, listener);
    }

    public void setValue(String value) {
        getElement().setAttribute("value", value);
        fireEvent(new ChangeEvent(this, true));
        fireEvent(new EnterPressEvent(this, true));
    }

    // Other component methods omitted
}