package com.example.application.component;

import com.example.application.component.event.TextField;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dnd.DragSource;
import com.vaadin.flow.component.html.Div;

//источник, откуда перетягивать компонент
@CssImport("./styles/v-dragged.css")
public class CardComponent extends Div implements DragSource<CardComponent>, HasStyle, Cloneable {
    public CardComponent() {
        // all cards are draggable by default
        Text text = new Text("CardComponent comp 1");
        TextField textField = new TextField();
        textField.setValue("поле для ввода comp 1");
        Button button = new Button("Кпопка comp1");
        add(text, textField, button);

        setDraggable(true);
    }

    @Override
    public CardComponent clone() {
        try {
            return (CardComponent) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
    // all DragSource methods have default implementations
}