package com.example.application.component.event;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.DomEvent;

@DomEvent(value = "keypress",
          filter = "event.key == 'Enter'")
public class EnterPressEvent
        extends ComponentEvent<TextField> {
    public EnterPressEvent(TextField source,
                           boolean fromClient) {
        super(source, fromClient);
    }
}