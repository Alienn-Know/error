package com.example.application.init;

import com.example.application.views.AdminView;
import com.vaadin.flow.router.RouteConfiguration;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;

public class ApplicationServiceInitListener
        implements VaadinServiceInitListener {

    @Override
    public void serviceInit(ServiceInitEvent event) {
        // add view only during development time
        if (!event.getSource()
                .getDeploymentConfiguration()
                .isProductionMode()) {
            RouteConfiguration configuration =
               RouteConfiguration.forApplicationScope();

            configuration.setRoute(
                "crud", //path
                AdminView.class //navigation target
            );
        }
    }
}