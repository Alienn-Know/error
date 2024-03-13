package com.example.application.component.event;

import com.vaadin.flow.component.*;
import com.vaadin.flow.shared.Registration;

// My custom UI component
@Tag("button")
public class MyComponent extends Component {

    // Defines a custom click event:
    //@DomEvent("click")        клик мыши
    //@DomEvent("mouseover")    наведение мыши
    @DomEvent("keypress")    // нажатие на клавиатуре
    public static class CustomClickEvent extends ComponentEvent<MyComponent> {
        private int button;

        public CustomClickEvent(
          MyComponent source, boolean fromClient,
          @EventData("event.button") int button) {
            super(source, fromClient);
            this.button = button;
        }

        public int getButton() {
            return this.button;
        }
    }

    // Method for registering a listener to custom click events:
    public Registration addCustomClickListener(
        ComponentEventListener<CustomClickEvent> listener) {
            return addListener(CustomClickEvent.class, listener);
    }

}