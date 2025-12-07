package pr8;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class ArchRefri {
    String archivo = "refri.json";
    Gson gson = new Gson();

    public void guardar(ArrayList<Alimento> lista) {
        try (FileWriter w = new FileWriter(archivo)) {
            gson.toJson(lista, w);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Alimento> leer() {
        try (FileReader r = new FileReader(archivo)) {
            return gson.fromJson(r, new TypeToken<ArrayList<Alimento>>(){}.getType());
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}