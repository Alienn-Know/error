package com.example.application.views;

import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

import javax.xml.transform.Templates;

@Route("login")
//@Route(value = "Login | Vaadin CRM", layout = MainLayout.class)
@PageTitle("Login | Vaadin CRM")
@AnonymousAllowed
public class LoginView extends VerticalLayout implements BeforeEnterObserver {

    private final LoginForm login = new LoginForm();

    public LoginView() {
        addClassName("login-view");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        login.setAction("login");
        login.setForgotPasswordButtonVisible(true);

        // Добавляем слушатель событий для кнопки "Забыли пароль"
        login.addForgotPasswordListener(event -> {
            // Здесь можно выполнить нужные действия, например, открыть диалоговое окно для восстановления пароля
            Notification.show("Ты забыл пароль!");
        });




        applyRussianLocalization();

        add(
                //new H1("Введи логин и пароль с которым ты регистрировался на сервере"),
                login
        );
    }

    // Метод для применения перевода текста на русский язык
    private void applyRussianLocalization() {
        LoginI18n i18n = LoginI18n.createDefault();

        LoginI18n.Form i18nForm = i18n.getForm();
        i18nForm.setTitle("Авторизация");
        i18nForm.setUsername("Логин");
        i18nForm.setPassword("Пароль");
        i18nForm.setSubmit("Войти");
        i18nForm.setForgotPassword("Забыли пароль?");
        i18n.setForm(i18nForm);

        //error message
        LoginI18n.ErrorMessage i18nErrorMessage = i18n.getErrorMessage();
        i18nErrorMessage.setTitle("Ошибка");
        i18nErrorMessage.setMessage("Неверный логин или пароль");

        i18nErrorMessage.setPassword("Введи пароль");
        i18nErrorMessage.setUsername("Введи логин");
        i18n.setErrorMessage(i18nErrorMessage);

        login.getElement().getAttributeNames();

        login.setI18n(i18n);
    }


    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if (beforeEnterEvent.getLocation().getQueryParameters().getParameters().containsKey("error")) {
            // Устанавливаем флаг ошибки в true, чтобы показать сообщение об ошибке
            login.setError(true);
        }
    }

    //TODO: -> не сбрасывать логин и пароль после нажатия "Войти" а оставлять заполненными
    //TODO: -> при переходе на не существующую страницу сообщение "Could not navigate to 'frfr'" либо на страницу к которой доступ запрещён             ++
    //TODO: -> при попытке открыть страницу для которой требудется авторизация, переходит на login страницу, а нужно написать "требуется авторизация"   ++
    //TODO: -> Routing & Navigation = Additional Guides = Route Templates
    //TODO: -> Creating UI = Enabled State (непонятно Overriding Default Disabled Behavior)
    //TODO: -> Creating UI = Keyboard Shortcuts  = Removing Shortcuts = (непонятна реализация действия как сделать)
    //TODO: -> Creating UI = Keyboard Shortcuts  = Shortcut Event Behavior on Client Side                    (непонятно)
    //TODO: -> Creating UI = Keyboard Shortcuts  = Submitting Change Events Before Shortcut Activation       (непонятно)
    //TODO: -> Creating UI = Creating Components = Single Element = Overriding Default Disabled Behavior    (не работает)
    //TODO: -> Creating UI = Creating Components = Extending Components = Client-side                       (хз как сделать что б работало js)
    //TODO: -> Creating UI = Element API         = Remote Procedure Calls
    //TODO: -> Creating UI = Templates           = Sub-Templates (НЕ РАБОТАЕТ)

}
