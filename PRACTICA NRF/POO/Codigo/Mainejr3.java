/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bus;
public class Main {
    public static void main(String[] args) {
        Bus miBus = new Bus(40);

        miBus.subirPasajeros(25);
        miBus.asientosDisponibles();
        miBus.cobrarPasajes();

        miBus.subirPasajeros(20);
        miBus.asientosDisponibles();
    }
}
