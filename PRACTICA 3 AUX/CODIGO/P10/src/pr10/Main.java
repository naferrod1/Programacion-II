/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pr10;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArchUsuarioSeguro arch = new ArchUsuarioSeguro();
        ArrayList<UsuarioSeguro> lista = arch.cargar();

        String user = "natalia";
        String pass = "12345";

        lista.add(new UsuarioSeguro(
                user,
                Cifrador.cifrar(pass)
        ));

        arch.guardar(lista);
        
        arch.mostrarTodo();

        arch.buscar("natalia");
    }
}
