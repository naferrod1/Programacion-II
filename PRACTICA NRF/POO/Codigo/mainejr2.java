/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package producto;
public class main {
    public static void main(String[] args) {
        Producto producto1 = new Producto("celular", 3500.0, 10);

        producto1.vender(3);
        producto1.vender(15);
        producto1.reabastecer(20);
    }
}
