package com.example.application.views;

import com.example.application.data.Contact;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.*;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route("greet")

@AnonymousAllowed
public class UserProfileEdit extends Div implements HasUrlParameter<String> {

    @Override
    public void setParameter(BeforeEvent event,
                             @WildcardParameter String parameter) {
        if (parameter.isEmpty()) {
            setText("Welcome anonymous.");
        } else {
            setText(String.format("Handling parameter %s.", parameter));
        }
    }
}