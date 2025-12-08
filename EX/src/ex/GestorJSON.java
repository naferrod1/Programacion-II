
package ex;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.ArrayList;

public class GestorJSON {

    private static final String ARCHIVO_MED = "medicos.json";
    private static final String ARCHIVO_CONS = "consultas.json";

    private static Gson gson = new Gson();

    public static void guardarMedicos(ArrayList<Medico> lista) {
        try (Writer w = new FileWriter(ARCHIVO_MED)) {
            gson.toJson(lista, w);
        } catch (Exception e) { e.printStackTrace(); }
    }

    public static void guardarConsultas(ArrayList<Consulta> lista) {
        try (Writer w = new FileWriter(ARCHIVO_CONS)) {
            gson.toJson(lista, w);
        } catch (Exception e) { e.printStackTrace(); }
    }

    public static ArrayList<Medico> leerMedicos() {
        try (Reader r = new FileReader(ARCHIVO_MED)) {
            return gson.fromJson(r, new TypeToken<ArrayList<Medico>>(){}.getType());
        } catch (Exception e) { return new ArrayList<>(); }
    }

    public static ArrayList<Consulta> leerConsultas() {
        try (Reader r = new FileReader(ARCHIVO_CONS)) {
            return gson.fromJson(r, new TypeToken<ArrayList<Consulta>>(){}.getType());
        } catch (Exception e) { return new ArrayList<>(); }
    }
}
