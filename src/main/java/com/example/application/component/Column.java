package com.example.application.component;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dnd.DropTarget;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

//цель, куда перетягивать компонент
@CssImport("./styles/v-dragged-target.css")
public class Column extends VerticalLayout implements DropTarget<VerticalLayout> {

    public Column() {
        // Allow drops by default
        Text text = new Text("Column text");
        add(text);
        setActive(true);
    }

    // All drop target methods have default implementations
}