package com.example.application.component;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Synchronize;
import com.vaadin.flow.component.Tag;

@Tag(Tag.INPUT)
public class TextField2 extends Component {

    public TextField2(String value) {
        getElement().setProperty("value",value);
    }

    @Synchronize("change")
    public String getValue() {          return  getElement().getProperty("value");}
    public void setValue(String value) {        getElement().setProperty("value", value);}

}