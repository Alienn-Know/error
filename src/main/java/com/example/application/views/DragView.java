package com.example.application.views;

import com.example.application.component.CardComponent;
import com.example.application.component.Column;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dnd.DropEffect;
import com.vaadin.flow.component.dnd.DropTarget;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route("drag")
@AnonymousAllowed
public class DragView extends VerticalLayout {

    public DragView() {
        // continuing from the previous example, CardComponent implements DragSource
        CardComponent card1 = new CardComponent();

        //Column column = new Column();

        Div box = new Div();
        box.setWidth("300px");
        box.setHeight("300px");

        DropTarget<Div> dropTarget = DropTarget.create(box);

        dropTarget.setDropEffect(DropEffect.COPY);

        card1.setDragData("Queen of Hearts");
        //card2.setDragData(new Card(11, Land.Spade)); // the data can be any object

        add(card1,box);
        //add(card1, column, box);

        //когда начинается перетягивание
        // Continuing from the previous example with CardComponent
        card1.addDragStartListener(event -> {
            card1.addClassName("possible-drop-zone");
            Notification.show("когда начинается перетягивание");
        });

        //хз, когда заканчивается перетягивание
        card1.addDragEndListener(event -> {
            card1.removeClassName("possible-drop-zone");
            // NOTE: The following is always FALSE for Edge and Safari !!!
            Notification.show("когда закончилось перетягивание");
            if (event.isSuccessful()) {
                // Better to put logic for successful drop into DropEvent for the
                // DropTarget because of the above
                //column.add(event.getSource());
                Notification.show("перетягивание успешно выполнено");
            }
        });

        dropTarget.addDropListener(event -> {
            // move the dragged component to inside the drop target component
            if (event.getDropEffect() == DropEffect.COPY) {
                // the drag source is available only if the dragged component is from
                // the same UI as the drop target
                //event.getDragSourceComponent().ifPresent(box::add);
                Component component = card1.clone();
                //box.add(component);

                event.getDragData().ifPresent(data -> {
                    // the server side drag data is available if it has been set and the
                    // component was dragged from the same UI as the drop target
                });
            }
        });


    }

}
