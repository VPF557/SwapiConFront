package SwapiConFront.example.SwapiConFront;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EscribirJson {
    static void escribirJsonPlanet(ArrayList<Planet> listaPlanets)
    {

        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter("Planets.json")) {
            gson.toJson(listaPlanets, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void escribirJsonPeticiones(ArrayList<Param> listaParams)
    {
        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter("Petitions.json")) {
            gson.toJson(listaParams, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void escribirJsonStarship(ArrayList<Starship> listaStarship)
    {

        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter("Starships.json")) {
            gson.toJson(listaStarship, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
