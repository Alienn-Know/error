package com.example.application.views.list;

import com.example.application.data.Company;
import com.example.application.data.Contact;
import com.example.application.data.Status;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.crud.Crud;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.shared.Registration;

import java.util.List;

public class ContactForm extends FormLayout {
    Binder<Contact> binder = new BeanValidationBinder<>(Contact.class);

    TextField firstName = new TextField("First Name");
    TextField lastName = new TextField("Last Name");
    EmailField email = new EmailField("Email");
    ComboBox<Status> status = new ComboBox<>("Status");
    ComboBox<Company> company = new ComboBox<>("Company");

    Button save = new Button("Save");
    Button delete = new Button("Delete");
    Button cancel = new Button("Cancel");
    private Contact contact;

    public ContactForm(List<Company> companies, List<Status> statuses) {
        addClassName("contact-form");
        binder.bindInstanceFields(this);

        company.setItems(companies);
        company.setItemLabelGenerator(Company::getName);

        status.setItems(statuses);
        status.setItemLabelGenerator(Status::getName);

        add(
                firstName,
                lastName,
                email,
                company,
                status,
                createButtonLayout()
        );
    }

    public void setContact(Contact contact) {
        this.contact = contact;
        binder.setBean(contact);
    }

    private Component createButtonLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        delete.addClickShortcut(Key.DELETE);
        cancel.addClickShortcut(Key.ESCAPE);

        save.addClickListener(click -> validateAndSave());
        delete.addClickListener(click -> fireEvent(new DeleteEvent(this, contact)));
        cancel.addClickListener(click -> fireEvent(new CloseEvent(this)));

        binder.addStatusChangeListener(e -> save.setEnabled(binder.isValid()));
        return new HorizontalLayout(save, delete, cancel);
    }

    private void validateAndSave(){
        try{
            binder.writeBean(contact);
            fireEvent(new SaveEvent(this, contact));
        } catch(ValidationException e){
            e.printStackTrace();
        }
    }

    // Events
    public static abstract class ContactFormEvent extends ComponentEvent<ContactForm> {
        private Contact contact;

        protected ContactFormEvent(ContactForm source, Contact contact) {
            super(source, false);
            this.contact = contact;
        }

        public Contact getContact() {
            return contact;
        }
    }

    public static class SaveEvent extends ContactFormEvent {
        SaveEvent(ContactForm source, Contact contact) {
            super(source, contact);
        }
    }

    public static class DeleteEvent extends ContactFormEvent {
        DeleteEvent(ContactForm source, Contact contact) {
            super(source, contact);
        }

    }

    public static class CloseEvent extends ContactFormEvent {
        CloseEvent(ContactForm source) {
            super(source, null);
        }
    }

    public Registration addDeleteListener(ComponentEventListener<DeleteEvent> listener) {
        return addListener(DeleteEvent.class, listener);
    }

    public Registration addSaveListener(ComponentEventListener<SaveEvent> listener) {
        return addListener(SaveEvent.class, listener);
    }
    public Registration addCloseListener(ComponentEventListener<CloseEvent> listener) {
        return addListener(CloseEvent.class, listener);
    }
}
