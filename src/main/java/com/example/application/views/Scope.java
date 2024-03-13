package com.example.application.views;

import com.example.application.component.ServerNumericField;
import com.example.application.component.TextField2;
import com.example.application.component.TextField3;
import com.example.application.component.Tooltip;
import com.example.application.component.event.MyComponent;
import com.example.application.component.event.TextField;
import com.example.application.views.list.ListView;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import org.aspectj.weaver.ast.Not;

//ЗДЕСЬ происходит очищение 2 форм ввода, при фокусе в них, и нажатии ESC
@Route("scope")
@AnonymousAllowed
@JsModule("./NumberField.js")
public class Scope extends Div {
    public Scope() {
        // Создаем шапку
        HorizontalLayout header = createHeader();

        // Создаем тело страницы
        Div content = createContent();

        // Создаем футер
        HorizontalLayout footer = createFooter();

        // Добавляем компоненты на страницу

        add(header, content, footer);
    }

    private HorizontalLayout createHeader() {
        Image logo = new Image("images/logo.png", "Логотип");
        logo.setHeight("50px"); // Устанавливаем высоту логотипа
        RouterLink homeLink = new RouterLink("Главная", ListView.class);
        RouterLink aboutLink = new RouterLink("О нас", TestView.class);

        return new HorizontalLayout(logo, homeLink, aboutLink);
    }

    private Div createContent() {
        // Создаем блоки с контентом
        Div block1 = new Div(new H1("Блок 1"));
        Div block2 = new Div(new H1("Блок 2"));
        Div block3 = new Div(new H1("Блок 3"));

        // Устанавливаем стили для блоков
        block1.addClassName("content-block");
        block2.addClassName("content-block");
        block3.addClassName("content-block");

        com.vaadin.flow.component.textfield.TextField textField = new com.vaadin.flow.component.textfield.TextField("123");
        TextField2 textField2 = new TextField2("rerr4");
        TextField3 textField3 = new TextField3();
        ServerNumericField numericField = new ServerNumericField();

        textField3.setLabel("label ");
        textField3.setValue("value");

        Notification.show(textField3.getLabel() + " " + textField3.getValue());

        TextField textField1 = new TextField();
        //textField1.addChangeListener(e -> Notification.show("ChangeEvent"));
        //textField1.addChangeListener2(e -> Notification.show("EnterPressEvent"));
        textField1.addChangeListener3(e -> Notification.show(e.getValue() + ""));

        MyComponent mc = new MyComponent();

        mc.addCustomClickListener(e->{
            Notification.show(e.getButton() + "");
        });

        Tooltip tooltip = new Tooltip();

        tooltip.add(new H5("Tooltip"));
        tooltip.add(new Paragraph("I am a paragraph"));



        return new Div(block1, block2, block3, textField, textField2, textField3, numericField, textField1, mc, tooltip);
    }

    private HorizontalLayout createFooter() {
        Button contactButton = new Button("Контакты");
        Button privacyButton = new Button("Политика конфиденциальности");

        // Добавляем обработчики событий для кнопок
        contactButton.addClickListener(event -> getUI().ifPresent(ui -> ui.navigate(AdminView.class)));
        privacyButton.addClickListener(event -> getUI().ifPresent(ui -> ui.navigate(AdminView.class)));

        return new HorizontalLayout(contactButton, privacyButton);
    }
}