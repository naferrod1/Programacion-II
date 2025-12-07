package pr6;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.ArrayList;

public class ArchPrestamo {

    private final String archivo = "prestamos.json";
    private Gson gson = new Gson();

    public void guardar(ArrayList<Prestamo> lista) throws Exception {
        FileWriter fw = new FileWriter(archivo);
        fw.write(gson.toJson(lista));
        fw.close();
    }

    public ArrayList<Prestamo> cargar() throws Exception {
        File f = new File(archivo);
        if (!f.exists()) return new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(archivo));
        ArrayList<Prestamo> lista = gson.fromJson(br,
                new TypeToken<ArrayList<Prestamo>>(){}.getType());
        br.close();
        return lista;
    }
}
