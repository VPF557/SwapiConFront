package SwapiConFront.example.SwapiConFront;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Controller {

    LeerJson reader = new LeerJson();
    DataHanding data = new DataHanding();
    EscribirJson writter = new EscribirJson();

    @GetMapping("/registro")
    public ArrayList<Param> listaObjeto1()
    {
        //Leemos el reason e introducimos los elementos en un arraylist
        ArrayList<Param> listaPeticiones = reader.LeerFicheroPeticiones("Petitions.json");
        //Mostramos los elementos leidos
        return listaPeticiones;
    }

    @PostMapping("/peticion")
    public void mandarElemento(@RequestBody Param objeto1)
    {
        //Hecho
        ArrayList<Planet> listaPlanets = reader.LeerFicheroPlanets("Planets.json");
        ArrayList<Param> listaPeticiones = reader.LeerFicheroPeticiones("Petitions.json");
        ArrayList<Starship> listaStarships = reader.LeerFicheroStarships("Starships.json");

        if(objeto1.getParameter1().equals("starships"))
        {
            Starship starship = new Starship();
            starship = data.obtenerStarships(objeto1);
            listaStarships.add(starship);
            writter.escribirJsonStarship(listaStarships);

        }
        else
        {
            Planet planeta = new Planet();
            planeta = data.obtenerPlanets(objeto1);
            listaPlanets.add(planeta);
            writter.escribirJsonPlanet(listaPlanets);

        }

        listaPeticiones.add(objeto1);
        writter.escribirJsonPeticiones(listaPeticiones);
    }

    @DeleteMapping("/Borrar{parameter1}{parameter2}")
    public ArrayList<Param> borrarParam(@RequestParam String parameter1,@RequestParam int parameter2 )
    {
        ArrayList<Param>  lista = data.buscarObjeto(parameter1,parameter2,"Petitions.json");
        EscribirJson escribirJSON = new EscribirJson();
        writter.escribirJsonPeticiones(lista);

        return lista;

    }
}
