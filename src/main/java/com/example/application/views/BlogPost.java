package com.example.application.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.*;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route(value = "blog")
@AnonymousAllowed
class BlogPost extends Div
        implements HasDynamicTitle,
        HasUrlParameter<Long> {
    private String title = "";

    @Override
    public String getPageTitle() {
        return title;
    }

    @Override
    public void setParameter(BeforeEvent event,
                             @OptionalParameter Long parameter) {
        if (parameter != null) {
            title = "Blog Post #" + parameter;
        } else {
            title = "Blog Home";
        }
    }
}