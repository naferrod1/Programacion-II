/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pr10;
public class Cifrador {
    public static String cifrar(String texto) {
        return new StringBuilder(texto).reverse().toString();
    }
    public static String descifrar(String texto) {
        return new StringBuilder(texto).reverse().toString();
    }
}