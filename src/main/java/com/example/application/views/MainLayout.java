package com.example.application.views;

import com.example.application.security.SecurityService;
import com.example.application.views.list.ListView;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.*;
import com.vaadin.flow.spring.security.AuthenticationContext;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

//public class MainLayout extends AppLayout {
//
//    private SecurityService securityService;
//    private AuthenticationContext authContext;
//
//    public MainLayout(@Autowired SecurityService securityService, AuthenticationContext authContext) {
//        this.securityService = securityService;
//        this.authContext = authContext;
//
//        createHeader();
//        createDrawer();
//    }
//
//    private void createHeader() {
//        H1 logo = new H1("Vaadin CRM");
//        logo.addClassNames("text-l", "m-m");
//
//
//        //Button logout = new Button("Logout", e -> securityService.logout());
//
//
//        HorizontalLayout header;
//
//        //показать кнопку Logout только при условии что пользователь авторизован
//        if (securityService.getAuthenticatedUser() != null) {
//            Button logout = new Button("Logout", click ->
//                    securityService.logout());
//            header = new HorizontalLayout(logo, logout);
//        } else {
//            header = new HorizontalLayout(logo);
//        }
//
//        //если пользователь админ -> кнопка иначе -> текст
//        authContext.getAuthenticatedUser(UserDetails.class).ifPresent(user -> {
//            boolean isAdmin = user.getAuthorities().stream()
//                    .anyMatch(grantedAuthority -> "ROLE_ADMIN".equals(grantedAuthority.getAuthority()));
//            if (isAdmin) {
//                header.add(new Button("Admin button"));
//            } else {
//                header.add(new H2("You are not an admin"));
//            }
//        });
//
//
//        //HorizontalLayout header = new HorizontalLayout(logo, logout);
//
//        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
//        header.expand(logo);
//        header.setWidthFull();
//        header.addClassNames("py-0", "px-m");
//
//        addToNavbar(header);
//    }
//
//    private void createDrawer() {
//        RouterLink listView = new RouterLink("List", ListView.class);
//        listView.setHighlightCondition(HighlightConditions.sameLocation());
//
//        addToDrawer(new VerticalLayout(
//                listView,
//                new RouterLink("Dashboard", DashboardView.class),
//                new RouterLink("TeSt", TestView.class),
//                new RouterLink("Admin", AdminView.class)
//        ));
//    }
//}

//@CssImport("./styles/views/main/main-view.css")
//@JsModule("./styles/shared-styles.js")
public class MainLayout extends AppLayout {
    private final Tabs menu;
    private H1 viewTitle;
    private SecurityService securityService;

    public MainLayout(@Autowired SecurityService securityService) {
        this.securityService = securityService;
        // Use the drawer for the menu
        setPrimarySection(Section.DRAWER);

        // Make the nav bar a header
        addToNavbar(true, createHeaderContent());

        // Put the menu in the drawer
        menu = createMenu();
        addToDrawer(createDrawerContent(menu));

        Button button = new Button("e2e");
        button.addClickListener(click -> {
            if (click.isCtrlKey()) {

                RouteConfiguration configuration =
                        RouteConfiguration.forApplicationScope();

                configuration.setRoute(
                        "main", //path
                        AdminView.class //navigation target
                );
                configuration.setRoute(
                        "info", //path
                        AdminView.class //navigation target
                );
                configuration.setRoute(
                        "version", //path
                        AdminView.class //navigation target
                );

                Notification.show("CTRL KEy");
            }
            else {
                RouteConfiguration configuration = RouteConfiguration
                        .forApplicationScope();
                // No view AdminView will be available
                configuration.removeRoute(AdminView.class);
                Notification.show("ELSE key");
            }

        });
        addToDrawer(button);
    }

    private Component createHeaderContent() {
        HorizontalLayout layout = new HorizontalLayout();
        //<theme-editor-local-classname>
        layout.addClassName("main-layout-horizontal-layout-1");

        // Configure styling for the header
        layout.setId("header");
        layout.getThemeList().set("dark", true);
        layout.setWidthFull();
        layout.setSpacing(false);
        layout.setAlignItems(FlexComponent.Alignment.CENTER);

        // Have the drawer toggle button on the left
        layout.add(new DrawerToggle());

        // Placeholder for the title of the current view.
        // The title will be set after navigation.
        viewTitle = new H1();
        layout.add(viewTitle);
        layout.setFlexGrow(1, viewTitle); // Занимаем всю доступную ширину

        // A user icon
        layout.add(new Icon("vaadin", "moon"));
        layout.add(new Image("images/avatar2.png", "Avatar"));

        return layout;
    }

    private Component createDrawerContent(Tabs menu) {
        VerticalLayout layout = new VerticalLayout();
        //<theme-editor-local-classname>
        layout.addClassName("main-layout-vertical-layout-1");

        // Configure styling for the drawer
        layout.setSizeFull();
        layout.setPadding(false);
        layout.setSpacing(false);
        layout.getThemeList().set("spacing-s", true);
        layout.setAlignItems(FlexComponent.Alignment.STRETCH);

        // Have a drawer header with an application logo
        HorizontalLayout logoLayout = new HorizontalLayout();
        logoLayout.setId("logo");
        logoLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        logoLayout.add(new Image("images/logo.png", "My Prkkoject logo"));
        logoLayout.add(new H1("My Project"));


        layout.add(logoLayout, menu);
        return layout;
    }

    private Tabs createMenu() {
        final Tabs tabs = new Tabs();
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        tabs.addThemeVariants(TabsVariant.LUMO_MINIMAL);
        tabs.setId("tabs");
        tabs.add(createMenuItems());
        //tabs.add(new Anchor("/hello", "Go to /hello route"));
        return tabs;
    }

    private Component[] createMenuItems() {
//        return new Tab[] { createTab("Hello World", HelloWorldView.class),
//                createTab("Card List", CardListView.class),
//                createTab("About", AboutView.class) };

        return new Tab[] {  createTab("list", ListView.class),
                            createTab("Hello World", DashboardView.class),
                            createTab("test", TestView.class),
                            createTab("admin", AdminView.class)};
    }

    private static Tab createTab(String text,
                                 Class<? extends Component> navigationTarget) {
        final Tab tab = new Tab();
        tab.add(new RouterLink(text, navigationTarget));
        ComponentUtil.setData(tab, Class.class, navigationTarget);
        return tab;
    }


    @Override
    protected void afterNavigation() {
        super.afterNavigation();

        // Select the tab corresponding to currently shown view
        //getTabForComponent(getContent()).ifPresent(menu::setSelectedTab);

        // Set the view title in the header
        String currentPageTitleName = getCurrentPageTitle();
        viewTitle.setText(currentPageTitleName != null ? currentPageTitleName : "null");
    }

    private Optional<Tab> getTabForComponent(Component component) {
        return menu.getChildren()
                .filter(tab -> ComponentUtil.getData(tab, Class.class)
                        .equals(component.getClass()))
                .findFirst().map(Tab.class::cast);
    }

    private String getCurrentPageTitle() {
        PageTitle pageTitleAnnotation = getContent().getClass().getAnnotation(PageTitle.class);
        if (pageTitleAnnotation != null) {
            return pageTitleAnnotation.value();
        } else {
            return "Default Title"; // Заголовок по умолчанию, если аннотация не найдена
        }
    }
}
