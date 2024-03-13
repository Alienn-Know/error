package com.example.application.views;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route(value = "access-denied-error", layout = MainLayout.class)
@PageTitle("denied")
@AnonymousAllowed
public class AccessDeniedErrorView extends Div {

    public AccessDeniedErrorView() {
        add(new H1("Ошибка Доступ к странице запрешён"));
        //add(new Paragraph("Страница не найдена."));
    }
}
