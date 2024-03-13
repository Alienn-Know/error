package com.example.application.views;

import com.example.application.views.list.ListView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.*;
import com.vaadin.flow.server.auth.AnonymousAllowed;

import java.util.Random;

@Route("page")
@AnonymousAllowed
public class ExampleView extends VerticalLayout implements BeforeLeaveObserver {

    public ExampleView() {
        this.setPadding(false);
        this.setMargin(false);

        Div mainBlock = new Div();
        Div middleBlock = new Div();
        Div topBlock = new Div();
        Div footerBlock = new Div();

        // Загружаем изображения
        Image mainImage = new Image("images/excalibur/main.jpg", "Main Image");
        Image middleImage = new Image("images/excalibur/middle.jpg", "Middle Image");
        Image topImage = new Image("images/excalibur/top.png", "Top Image");
        Image footerImage = new Image("images/excalibur/footer.png", "Footer Image");

        // Добавляем изображения в блоки Div
        // Добавляем изображения и ссылки в блоки Div

        RouterLink homeLink = new RouterLink("Главная", ListView.class);

        RouterLink aboutLink1 = new RouterLink("Форум", TestView.class);
        RouterLink aboutLink2 = new RouterLink("Донат", TestView.class);
        RouterLink aboutLink3 = new RouterLink("Города", TestView.class);
        RouterLink aboutLink4 = new RouterLink("Карта", TestView.class);
        RouterLink aboutLink5 = new RouterLink("Кабинет", TestView.class);
        RouterLink aboutLink6 = new RouterLink("Магазин", TestView.class);
        RouterLink aboutLink7 = new RouterLink("Помощь", TestView.class);
        RouterLink aboutLink8 = new RouterLink("Правила", TestView.class);
        //RouterLink aboutLink9 = new RouterLink("Greeting", GreetingView.class, "default_test");
        //RouterLink aboutLink9 = new RouterLink("Greeting", UserProfileEdit.class, new RouteParameters("userID", "123"));
        RouterLink aboutLink9 = new RouterLink(UserProfileEdit.class);
//        aboutLink9.add(new Icon(VaadinIcon.HOME));
//        aboutLink9.add(new Icon(VaadinIcon.ALIGN_JUSTIFY));
//        aboutLink9.add(new Icon(VaadinIcon.ARROW_LEFT));


        RouterLink вот_так = new RouterLink("Telegram", TestView.class);

        // Добавляем изображения и блоки с RouterLink в блоки Div
        mainBlock.add(createImageWithLinks(mainImage, homeLink, aboutLink1, aboutLink2, aboutLink3,
                aboutLink4, aboutLink5, aboutLink6, aboutLink7, aboutLink8, aboutLink9, вот_так, new RouterLink("SideMenu", SideMenuView.class)));

        Anchor anchor = new Anchor("/hello", "Go to /hello route");
        //anchor.getElement().setAttribute("target", "_blank"); //открытие страницы в новой вкладке
        anchor.getElement().setAttribute("router-ignore", "");//не перезагружать страницу
        mainBlock.add(anchor);

        middleBlock.add(middleImage);
        topBlock.add(topImage);
        footerBlock.add(footerImage);

        // Добавляем блоки Div на страницу
        add(mainBlock, middleBlock, topBlock, footerBlock);

        //add(createHeader());
        //add(createContent());
        //add(createFooter());
    }

    // Метод для создания блока Div с изображением и RouterLink
    private Div createImageWithLinks(Image image, RouterLink... links) {
        Div container = new Div(image);
        container.getStyle().set("position", "relative");

        // Создаем блок Div для RouterLink
        // Создаем блок Div для RouterLink
        Div linksContainer = new Div(links);
        linksContainer.getStyle()
                .set("position", "absolute")
                .set("top", "10px")  // Добавляем верхний отступ
                .set("left", "40%")
                .set("transform", "translateX(-50%)");

        // Добавляем небольшие отступы между RouterLink
        linksContainer.getChildren().forEach(link ->
                link.getElement().getStyle().set("margin", "0 20px"));


        // Добавляем блок с RouterLink в основной блок
        container.add(linksContainer);



        return container;
    }

    private Component createHeader() {
        // Создание шапки страницы
        //H1 logo = new H1("Логотип");
        RouterLink homeLink = new RouterLink("Главная", ListView.class);
        RouterLink aboutLink1 = new RouterLink("Форум", TestView.class);
        RouterLink aboutLink2 = new RouterLink("Донат", TestView.class);
        RouterLink aboutLink3 = new RouterLink("Города", TestView.class);
        RouterLink aboutLink4 = new RouterLink("Карта", TestView.class);
        RouterLink aboutLink5 = new RouterLink("Кабинет", TestView.class);
        RouterLink aboutLink6 = new RouterLink("Магазин", TestView.class);
        RouterLink aboutLink7 = new RouterLink("Помощь", TestView.class);
        RouterLink aboutLink8 = new RouterLink("Правила", TestView.class);
        RouterLink aboutLink9 = new RouterLink("Telegram", TestView.class);

        HorizontalLayout header = new HorizontalLayout(homeLink, aboutLink1, aboutLink2, aboutLink2, aboutLink3, aboutLink4, aboutLink5, aboutLink6, aboutLink7, aboutLink8, aboutLink9);
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        return header;
    }

    private Component createContent() {
        // Создание содержимого страницы
        // Пример содержимого страницы
        HorizontalLayout hl = new HorizontalLayout();
        TextField textField = new TextField("Введите текст");
        hl.add(textField, new Image("images/logo.png", "My Prkkoject logo"));
        Button button = new Button("Нажми меня");
        Checkbox checkbox = new Checkbox("Согласен с условиями");
        RadioButtonGroup<String> radioGroup = new RadioButtonGroup<>();
        radioGroup.setLabel("Выберите опцию");
        radioGroup.setItems("Опция 1", "Опция 2", "Опция 3");

        Paragraph text = new Paragraph("Когда сайт выполняет слишком много перенаправлений (переадресаций), это обычно означает, что есть циклическая зависимость в перенаправлениях или что-то неправильно сконфигурировано. В случае Vaadin, проблема может быть связана с маршрутизацией или с настройками безопасности.\n" +
                "\n" +
                "Вот несколько шагов, которые можно предпринять для выявления проблемы:\n" +
                "\n" +
                "Проверьте конфигурацию маршрутизации: Убедитесь, что маршруты в вашем приложении правильно настроены и не создают циклические зависимости. Проверьте все аннотации @Route в ваших классах представлений и убедитесь, что они указывают на правильные маршруты.\n" +
                "\n" +
                "Проверьте переадресации: Проверьте любые переадресации, которые вы настраиваете в вашем приложении. Убедитесь, что они настроены правильно и не вызывают циклические перенаправления.\n" +
                "\n" +
                "Проверьте настройки безопасности: Если вы используете механизм аутентификации или авторизации, убедитесь, что настройки безопасности правильно сконфигурированы. Проверьте любые фильтры безопасности или интерцепторы, которые могут быть причиной проблемы.\n" +
                "\n" +
                "Логирование: Включите подробное логирование для вашего приложения, чтобы увидеть, что происходит во время перенаправлений. Просмотрите журналы, чтобы найти любые сообщения об ошибках или предупреждения, которые могут указать на проблему.\n" +
                "\n" +
                "Отладка: Используйте отладчик, чтобы шаг за шагом проследить выполнение вашего приложения и увидеть, где возникают проблемы с перенаправлениями.\n" +
                "\n" +
                "Выявление причины проблемы может потребовать некоторого времени и терпения, но следуя этим шагам, вы сможете выявить и исправить проблему с переадресацией в вашем приложении Vaadin.");

        return new VerticalLayout(hl, button, checkbox, radioGroup, text);
    }

    private Component createFooter() {
        // Создание футера страницы
        H1 copyright = new H1("© 2024. Все права защищены.");

        VerticalLayout footer = new VerticalLayout(copyright);
        footer.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
        return footer;
    }

    @Override
    public void beforeLeave(BeforeLeaveEvent event) {
        if (hasChanges()) {
            BeforeLeaveEvent.ContinueNavigationAction action = event.postpone();
            ConfirmDialog confirmDialog = new ConfirmDialog();
            confirmDialog.setText("Вы переходите на сторонний сайт, мы не несём ответственность за него");
            confirmDialog.setCancelable(true);

            // Устанавливаем текст для кнопки подтверждения
            confirmDialog.setConfirmText("Ок");
            confirmDialog.addConfirmListener(__ -> action.proceed());

            // Устанавливаем текст для кнопки отмены на русском
            confirmDialog.setCancelText("Отмена");
            confirmDialog.addCancelListener(__ -> action.cancel());

            confirmDialog.open();
        }
    }

    private boolean hasChanges() {
        return true;
    }
}