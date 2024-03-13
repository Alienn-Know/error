package com.example.application.views;

import com.example.application.component.*;
import com.example.application.views.staticc.test_ui;
import com.vaadin.flow.component.*;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.DomEvent;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.dom.ElementFactory;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import elemental.json.JsonObject;
import jakarta.annotation.security.PermitAll;
import org.aspectj.weaver.ast.Not;
import org.springframework.security.access.prepost.PostAuthorize;

import java.util.stream.Collectors;

//@Route(value = "test", layout = MainLayout.class)
@CssImport("./styles/blue.css")
@Route("test")
@PageTitle("test | Vaadin CRM")
//@PermitAll
@AnonymousAllowed
public class TestView extends VerticalLayout {

    public TestView() {
//        Tooltip tooltip = new Tooltip();
//
//        tooltip.add(new H5("Tooltip"));
//        tooltip.add(new Paragraph("I am a paragraph"));


        MwcSlider slider = new MwcSlider();
        slider.setDiscrete(true);

        //обработкик нажатий на кнопку
        slider.addValueChangeListener(e -> {
            String message = "The value is now " + e.getValue();
            if (e.isFromClient()) {
                message += " (set by the user)";
            }
            Notification.show(message, 3000, Notification.Position.MIDDLE);
        });

        //обработчик кликов по слайдеру
        slider.addClickListener(e -> {
            Notification.show("Clicked at " + e.getX() + "," + e.getY(), 1000, Notification.Position.BOTTOM_START);
        });

        //я так понимаю регистратор функции кликов
        Button layoutJSButton = new Button("Layout component using JS", e -> {
            slider.layout(false);
        });
        add(layoutJSButton);


        add(slider);


        Button incrementButton = new Button("Increment using setValue", e -> {
            slider.setValue(slider.getValue() + 5);
        });

        add(incrementButton);

        IconButton iconButton = new IconButton(VaadinIcon.CHECK);
        iconButton.addClickListener(e -> {
            int next = (iconButton.getIcon().ordinal() + 1) % VaadinIcon.values().length;
            iconButton.setIcon(VaadinIcon.values()[next]);
        });



        add(iconButton);



        Element helloButton = ElementFactory.createButton("Say hello");

        helloButton.addEventListener("click", e -> {
            //при клике на кнопку создавать новый div "Hello!"
            Element response = ElementFactory.createDiv("Hello!");
            //добавить этот элемент на корень
            getElement().appendChild(response);
        });

        //добавить кнопку
        getElement().appendChild(helloButton);

        helloButton.addEventListener("click", this::handleClick)
                .addEventData("event.shiftKey")
                .addEventData("element.offsetWidth");

        checkConstructableStylesheets();

        ///Retrieving User Input
        Element textInput = ElementFactory.createInput();
        textInput.setAttribute("placeholder",
                "Enter your name");

        textInput.addPropertyChangeListener("value", "change", e -> {
            Notification.show(e.getValue() + "");
            Notification.show(e.getOldValue() + " | old");
            Notification.show(e.getPropertyName() + " | property");
            Notification.show(e.getSource() + " | property");
            Notification.show(e.isUserOriginated() + " | isUserOriginated");
        });

        getElement().appendChild(textInput);
        ///

        Element button = ElementFactory.createButton("button");

        button.addEventListener("click", e -> {
            String responseText = "Hello " +
                    textInput.getProperty("value");
            //добавляется div к элементу и идёт в низ
            Element response = ElementFactory
                    .createDiv(responseText);
            getElement().appendChild(response);
        });
        getElement().appendChild(button);

        ///// styles
        Element button2 = ElementFactory.createButton();

        button2.setText("Change to blue");

        //при потере фокуса с элемента снимать синий стиль кнопки
        button2.addEventListener("mouseout",
                //button2.addEventListener("click",
                e -> button2.getClassList().remove("blue"));

        //при появлении фокуса у элемента добавлять стиль кнопки
        button2.addEventListener("mouseover",
                //button2.addEventListener("click",
                e -> button2.getClassList().add("blue"));

        button2.getClassList().add("error");
        button2.getClassList().add("critical");
        button2.getClassList().remove("primary");

        // returns "error critical".
        Notification.show(button2.getProperty("classname"));

        getElement().appendChild(button2);

        /////////////////////////////////////
        Element input = ElementFactory.createInput();
        //этот метод записывает значение в Property value для совего объекта
        input.addPropertyChangeListener("value", "change", e -> {});
        getElement().appendChild(input);

        Element button12345 = ElementFactory.createButton();
        button12345.setText("Change to the entered value");
        button12345.addEventListener("click",
                e -> button12345.getStyle().set("background", input.getProperty("value")));
//                e -> button.getStyle().set("background", "red"));
        getElement().appendChild(button12345);

        button12345.getStyle().has("cursor");

        button12345.getStyle().set("color", "blue");
        //camelCase
        button12345.getStyle().set("fontWeight", "bold");

        MyLabel myLabel = new MyLabel();
        add(myLabel);

        HelloWorld hello = new HelloWorld();

        Div layout = new Div();
        layout.add(hello);
        add(layout);


    }

    private void handleClick(DomEvent event) {
        JsonObject eventData = event.getEventData();

        //true - нажат шыфт
        boolean shiftKey = eventData.getBoolean("event.shiftKey");
        //хз
        double width = eventData.getNumber("element.offsetWidth");


        String text = "Shift " + (shiftKey ? "down" : "up");
        text += " on button whose width is " + width + "px";

        Element response = ElementFactory.createDiv(text);
        getElement().appendChild(response);
    }

    public void setExpanded(Component otherComponent) {
        getElement().callJsFunction("expand",
                otherComponent.getElement());
    }

    public void checkConstructableStylesheets() {
        getElement().executeJs(
                        "return 'adoptedStyleSheets' in document")
                .then(Boolean.class, supported -> {
                    if (supported) {
                        System.out.println(
                                "Feature is supported");
                    } else {
                        System.out.println(
                                "Feature isn't supported");
                    }
                });
    }

}
