package com.example.application.views;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.*;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route(value = "not-found-error", layout = MainLayout.class)
@PageTitle("not-found")
@AnonymousAllowed
public class NotFoundErrorView extends Div {

    public NotFoundErrorView() {
        new H1("Ошибка: Страница не найдена");
    }
}