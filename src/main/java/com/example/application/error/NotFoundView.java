package com.example.application.error;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.*;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import jakarta.servlet.http.HttpServletResponse;

// NotFoundView.java
@Tag("div")
@PageTitle("Page Not Found")
@AnonymousAllowed
public class NotFoundView extends Div implements HasErrorParameter<NotFoundException> {
    @Override
    public int setErrorParameter(BeforeEnterEvent event, ErrorParameter<NotFoundException> parameter) {
        // Custom handling for "not found" errors
        setText("Sorry, the requested page was not found.");
        return HttpServletResponse.SC_NOT_FOUND; // HTTP status code for "not found"
    }
}