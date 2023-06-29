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


        this.add(horizontal,grid);
    }

}