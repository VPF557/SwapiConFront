package org.vaadin.example;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and
 * use @Route annotation to announce it in a URL as a Spring managed
 * bean.
 * Use the @PWA annotation make the application installable on phones,
 * tablets and some desktop browsers.
 * <p>
 * A new instance of this class is created for every new user and every
 * browser tab/window.
 */
@Route
@PWA(name = "Vaadin Application",
        shortName = "Vaadin App",
        description = "This is an example Vaadin application.",
        enableInstallPrompt = false)
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends VerticalLayout {

    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     *
     * @param service The message service. Automatically injected Spring managed bean.
     */
    public MainView(@Autowired GreetService service)
    {

        // Use TextField for standard text input
        VistaAlta vistaA = new VistaAlta();
        VistaListado vistaL = new VistaListado();

        Tab altaTab = new Tab("Alta");
        Tab listadoTab = new Tab("Listado");
        Tabs menu = new Tabs(altaTab, listadoTab);

        vistaA.setVisible(true);
        vistaL.setVisible(false);
        menu.setSelectedTab(altaTab);
        vistaA.mostrar();

        menu.addSelectedChangeListener(event -> {
            if (event.getSelectedTab().equals(listadoTab)) {
                vistaL.setVisible(true);
                vistaL.mostrar();
                vistaA.setVisible(false);
            } else {
                vistaA.setVisible(true);
                vistaA.mostrar();
                vistaL.setVisible(false);
            }
        });
        add(menu, vistaA, vistaL);
        setAlignItems(Alignment.CENTER);
    }

}
