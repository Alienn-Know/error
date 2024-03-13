package com.example.application.views;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route("login2")
@AnonymousAllowed
public class LoginView2 extends Div {
    private TextField login;
    private PasswordField password;

    public LoginView2() {
        login = new TextField("Login");
        password = new PasswordField("Password");

        Button submit = new Button("Submit",
                this::handleLogin);

        add(login, password, submit);
    }

    private void handleLogin(
            ClickEvent<Button> buttonClickEvent) {
    }
}
