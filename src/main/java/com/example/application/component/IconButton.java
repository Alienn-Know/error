package com.example.application.component;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.icon.VaadinIcon;

@Tag("vaadin-button")
@NpmPackage(value = "@vaadin/button", version = "24.4.0-alpha3")
@JsModule("@vaadin/button/vaadin-button.js")
public class IconButton extends Component {

    private VaadinIcon icon;

    public IconButton(VaadinIcon icon) {
        setIcon(icon);
    }

    public void setIcon(VaadinIcon icon) {
        this.icon = icon;

        Component iconComponent = icon.create();
        getElement().removeAllChildren();
        getElement().appendChild(iconComponent.getElement());
    }

    public void addClickListener(
            ComponentEventListener<ClickEvent<IconButton>> listener) {
        addListener(ClickEvent.class, (ComponentEventListener) listener);
    }

    public VaadinIcon getIcon() {
        return icon;
    }
}