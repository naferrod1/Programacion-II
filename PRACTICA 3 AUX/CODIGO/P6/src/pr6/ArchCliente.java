package pr6;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.util.ArrayList;

public class ArchCliente {

    private final String archivo = "clientes.json";
    private Gson gson = new Gson();

    public void guardar(ArrayList<Cliente> lista) throws Exception {
        FileWriter fw = new FileWriter(archivo);
        fw.write(gson.toJson(lista));
        fw.close();
    }

    public ArrayList<Cliente> cargar() throws Exception {
        File f = new File(archivo);
        if (!f.exists()) return new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(archivo));
        ArrayList<Cliente> lista = gson.fromJson(br,
                new TypeToken<ArrayList<Cliente>>(){}.getType());
        br.close();
        return lista;
    }
}
