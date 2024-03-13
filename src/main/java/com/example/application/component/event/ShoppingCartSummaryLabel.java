package com.example.application.component.event;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.DetachEvent;
import com.vaadin.flow.component.Tag;

import java.util.EventObject;
import java.util.function.Consumer;

@Tag("div")
public class ShoppingCartSummaryLabel
        extends Component {

  private final Consumer<EventObject> eventHandler =
        this::onCartSummaryUpdate;

  @Override
  protected void onAttach(AttachEvent attachEvent) {
    ShopEventBus eventBus = attachEvent.getSession()
            .getAttribute(ShopEventBus.class);
    // registering to event bus for updates
    // from other components
    eventBus.register(eventHandler);
  }

  @Override
  protected void onDetach(DetachEvent detachEvent) {
    ShopEventBus eventBus = detachEvent.getSession()
    .getAttribute(ShopEventBus.class);
    // after detaching don't need any updates
    eventBus.unregister(eventHandler);
  }

  private void onCartSummaryUpdate(EventObject event) {
    // update cart summary ...
  }
}

interface ShopEventBus {
  void register(Consumer<EventObject> eventHandler);

  void unregister(Consumer<EventObject> eventHandler);
}