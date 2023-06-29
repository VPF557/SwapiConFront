package org.vaadin.example;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.contextmenu.GridContextMenu;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.net.URISyntaxException;
import java.util.ArrayList;

public class VistaListado extends VerticalLayout {
    ArrayList<Param> listaParametro = new ArrayList<>();
    public VistaListado()
    {

    }
    public void mostrar()
    {
        removeAll();
        HorizontalLayout horizontal= new HorizontalLayout();
        ArrayList<Param> listaParams = new ArrayList<>();
        ArrayList<Planet> listaPlanet = new ArrayList<>();
        ArrayList<Param> listaAux = new ArrayList<>();

        Grid<Param> grid = new Grid<>(Param.class, false);
        grid.addColumn(Param::getParameter1).setHeader("Parametro 1");
        grid.addColumn(Param::getParameter2).setHeader("Parametro 2");


        GridContextMenu<Param> menu = grid.addContextMenu();
        menu.setOpenOnClick(true);
        menu.addItem("Delete", event ->
        {
            grid.setItems(DataService.eliminarParam(event.getItem().get(),listaAux));
        });
        grid.setAllRowsVisible(true);
        this.add(grid);
        add(horizontal);

       try {
           listaParams = DataService.getProductos(listaParams);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        grid.setItems(listaParams);


        Grid<Planet> grid2 = new Grid<>(Planet.class, false);
        grid2.addColumn(Planet::getName).setHeader("Name ");
        grid2.addColumn(Planet::getGravity).setHeader("Gravity ");
        grid2.addColumn(Planet::getPopulation).setHeader("Population");
        grid2.addColumn(Planet::getClimate).setHeader("Climate");

        GridContextMenu<Param> menu2 = grid.addContextMenu();
        try {
            listaPlanet = DataService.getPlanets(listaPlanet);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        grid2.setItems(listaPlanet);
        grid2.setAllRowsVisible(true);
        this.add(grid2);

        this.add(horizontal,grid,grid2);
    }

}