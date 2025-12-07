package pr7;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class ArchNiño {

    private final String archivo = "ninos.json";
    private Gson gson = new Gson();

    public void guardar(ArrayList<Niño> lista) {
        try (FileWriter writer = new FileWriter(archivo)) {
            gson.toJson(lista, writer);
        } catch (Exception e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public ArrayList<Niño> cargar() {
        try (FileReader reader = new FileReader(archivo)) {
            return gson.fromJson(reader, new TypeToken<ArrayList<Niño>>(){}.getType());
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}