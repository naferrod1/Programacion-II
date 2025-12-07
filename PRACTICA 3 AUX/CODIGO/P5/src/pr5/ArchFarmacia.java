package pr5;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.ArrayList;

public class ArchFarmacia {

    private final String archivo = "farmacias.json";
    private Gson gson = new Gson();

    public void guardar(ArrayList<Farmacia> lista) throws Exception {
        FileWriter fw = new FileWriter(archivo);
        fw.write(gson.toJson(lista));
        fw.close();
    }

    public ArrayList<Farmacia> cargar() throws Exception {
        File f = new File(archivo);
        if (!f.exists()) return new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(archivo));
        ArrayList<Farmacia> lista = gson.fromJson(
                br, new TypeToken<ArrayList<Farmacia>>(){}.getType()
        );
        br.close();
        return lista;
    }
}
