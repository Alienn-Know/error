package com.example.application.error;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.*;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import jakarta.servlet.http.HttpServletResponse;

// AccessDeniedView.java
@Tag("div")
@PageTitle("Access Denied")
@AnonymousAllowed
public class AccessDeniedView extends Div implements HasErrorParameter<AccessDeniedException> {
    @Override
    public int setErrorParameter(BeforeEnterEvent event, ErrorParameter<AccessDeniedException> parameter) {
        // Custom handling for "access denied" errors
        setText("Access Denied. You do not have permission to access this page.");
        return HttpServletResponse.SC_FORBIDDEN; // HTTP status code for "access denied"
    }
}