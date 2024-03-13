package com.example.application.component;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;

@CssImport("./styles/numeric-field-styles.css")
public class ServerNumericField extends TextField {
//public class ServerNumericField extends NumberField {

    private Button substractBtn;
    private Button addBtn;

    private static final int DEFAULT_VALUE = 0;
    private static final int DEFAULT_INCREMENT = 1;

    private int numericValue;
    private int incrementValue;
    private int decrementValue;

    public ServerNumericField() {
        this(DEFAULT_VALUE, DEFAULT_INCREMENT,
                -DEFAULT_INCREMENT);
    }


    public ServerNumericField(int value, int incrementValue,
                              int decrementValue) {
        setNumericValue(value);
        this.incrementValue = incrementValue;
        this.decrementValue = decrementValue;


        setPattern("-?[0-9]*");
        // setPreventInvalidInput(true); не работает!!!

        //analog -> addChangeListener
        addValueChangeListener(event -> {
//            String text = event.getSource().getValue();
//            if (StringUtils.isNumeric(text)) {
//                setNumericValue(Integer.parseInt(text));
//            } else {
//                setNumericValue(DEFAULT_VALUE);
//            }
            Notification.show("сервер ответил");
            String text = event.getSource().getValue();
            try {
                // Пытаемся распарсить текст в число
                int numericValue = Integer.parseInt(text);
                setNumericValue(numericValue);
            } catch (NumberFormatException e) {
                // Если возникает ошибка парсинга, устанавливаем значение по умолчанию
                setNumericValue(DEFAULT_VALUE);
            }
        });

        substractBtn = new Button("-", event -> {
            setNumericValue(numericValue +
                    decrementValue);
        });

        addBtn = new Button("+", event -> {
            setNumericValue(numericValue +
                    incrementValue);
        });


        getElement().setAttribute("theme", "numeric");
        styleBtns();


        addToPrefix(substractBtn);
        addToSuffix(addBtn);



    }

    private void styleBtns() {
        // Note: The same as addThemeVariants
        substractBtn.getElement()
                .setAttribute("theme", "icon");
        addBtn.getElement()
                .setAttribute("theme", "icon");
    }

    public void setNumericValue(int value) {
        numericValue = value;
        setValue(value + "");
    }

    // getters and setters
}
