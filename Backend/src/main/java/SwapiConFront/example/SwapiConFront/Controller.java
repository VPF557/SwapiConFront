package SwapiConFront.example.SwapiConFront;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Controller {

    LeerJson reader = new LeerJson();
    DataHanding data = new DataHanding();
    EscribirJson writter = new EscribirJson();

    @GetMapping("/registro")
    public ArrayList<Parametro> listaObjeto1()
    {
        //Leemos el reason e introducimos los elementos en un arraylist
        ArrayList<Parametro> listaPeticiones = reader.LeerFicheroPeticiones("Peticiones.json");
        //Mostramos los elementos leidos
        return listaPeticiones;
    }

    @PostMapping("/peticion")
    public void mandarElemento(@RequestBody Parametro objeto1)
    {
        //Hecho
        ArrayList<Personaje> listaPersonaje = reader.LeerFicheroPersonajes("Personajes.json");
        ArrayList<Parametro> listaPeticiones = reader.LeerFicheroPeticiones("Peticiones.json");
        ArrayList<Fusion> listaFusion = reader.LeerFicheroFusion("Fusiones.json");

        if(objeto1.getParameter1().equals("fusion"))
        {
            Fusion fusion = new Fusion();
            fusion = data.obtenerFusion(objeto1);
            listaFusion.add(fusion);
            writter.escribirJsonFusion(listaFusion);

        }
        else
        {
            Personaje personaje = new Personaje();
            personaje = data.obtenerPersonaje(objeto1);
            listaPersonaje.add(personaje);
            writter.escribirJsonPersonaje(listaPersonaje);

        }

        listaPeticiones.add(objeto1);
        writter.escribirJsonPeticiones(listaPeticiones);
    }

    @DeleteMapping("/Borrar{parameter2}")
    public ArrayList<Parametro> borrarParam(@RequestParam String parameter2)
    {
        ArrayList<Parametro>  lista = data.buscarObjeto(parameter2,"Peticiones.json");
        EscribirJson escribirJSON = new EscribirJson();
        writter.escribirJsonPeticiones(lista);

        return lista;

    }
}
