package com.example.application.component.event;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.DebounceSettings;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;
import com.vaadin.flow.dom.DebouncePhase;

@DomEvent(value = "input",
          debounce = @DebounceSettings(
              timeout = 1000,
//              phases = DebouncePhase.INTERMEDIATE))
              phases = { DebouncePhase.LEADING,
                         DebouncePhase.INTERMEDIATE }))
public class InputEvent extends ComponentEvent<TextField> {
    private String value;

    public InputEvent(TextField source, ///3e3
            boolean fromClient,//11
            @EventData("element.value") String value) {///233
        super(source, fromClient);////2333
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}