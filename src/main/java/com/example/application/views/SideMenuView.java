package com.example.application.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route("sideMenu")
@AnonymousAllowed
public class SideMenuView extends Div
        implements AfterNavigationObserver {
    Anchor blog = new Anchor("blog", "Blog");

    public SideMenuView() {
        add(blog);
        add(new Button());
        add(new Button());
        add(new Button());
    }
    @Override
    public void afterNavigation(
          AfterNavigationEvent event) {
        boolean active = event.getLocation()
                .getFirstSegment()
                .equals(blog.getHref());
        blog.getElement()
                .getClassList()
                .set("active", active);
    }
}