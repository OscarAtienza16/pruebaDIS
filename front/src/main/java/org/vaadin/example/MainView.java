package org.vaadin.example;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.data.renderer.NativeButtonRenderer;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and use @Route
 * annotation to announce it in a URL as a Spring managed bean.
 * <p>
 * A new instance of this class is created for every new user and every browser
 * tab/window.
 * <p>
 * The main view contains a text field for getting the user name and a button
 * that shows a greeting message in a notification.
 */
@Route
public class MainView extends VerticalLayout {

    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     *
     * @param service
     *            The message service. Automatically injected Spring managed
     *            bean.
     */
    public MainView(@Autowired GreetService service) throws URISyntaxException, IOException, InterruptedException {

        Grid<Ship> grid = new Grid<>(Ship.class, false);
        grid.addColumn(Ship::getName).setHeader("Ship name");
        grid.addColumn(Ship::getModel).setHeader("Ship model");
        grid.addColumn(Ship::getCost_in_credits).setHeader("Cost in credits");
        grid.addColumn(Ship::getCrew).setHeader("Crew");
        grid.addColumn(Ship::getCargo_capacity).setHeader("Cargo capacity");
        grid.addColumn(Ship::getConsumables).setHeader("Consumables");
        grid.addColumn(Ship::getHyperdrive_rating).setHeader("Hyperdrive rating");
        grid.addColumn(Ship::getStarship_class).setHeader("Starship class");
        grid.addColumn(Ship::getPilotsView).setHeader("Pilots");
        grid.addColumn(Ship::getFilmsView).setHeader("Films");
        grid.addColumn(new NativeButtonRenderer<>("Generar", clickedItem -> {
                    try {
                        service.sendPDFShip(clickedItem.getName());
                    } catch (URISyntaxException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                })
        ).setHeader("Generar PDF");

        List<Ship> ship = service.getShipsList();
        grid.setItems(ship);
        grid.setWidth("100%");
        grid.setWidthFull();
        addClassName("centered-content");

        add(grid);
    }

}
