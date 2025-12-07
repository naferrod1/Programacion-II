/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pr10;
public class UsuarioSeguro {
    private String username;
    private String passwordCifrada;

    public UsuarioSeguro() {}

    public UsuarioSeguro(String username, String passwordCifrada) {
        this.username = username;
        this.passwordCifrada = passwordCifrada;
    }

    public String getUsername() { return username; }
    public String getPasswordCifrada() { return passwordCifrada; }

    public void mostrar() {
        System.out.println("Usuario: " + username + " | Password: " + passwordCifrada);
    }
}