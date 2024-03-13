package com.example.application.views;

import com.example.application.views.staticc.test_ui;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.NotFoundException;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AccessDeniedErrorRouter;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import jakarta.annotation.security.RolesAllowed;

@Route(value = "admin", layout = MainLayout.class)
@PageTitle("admin")
@RolesAllowed("ADMIN")
//@AnonymousAllowed
//@AccessDeniedErrorRouter(rerouteToError = NotFoundException.class)
public class AdminView extends VerticalLayout {

    public AdminView() {
        add(new H1("Это для тестов сделал 1"));
        add(new H1("Это для тестов сделал 2"));
        add(new H1("Это для тестов сделал 3"));
    }


    // ...
}
