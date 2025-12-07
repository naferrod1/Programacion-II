/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pr1;
public class Charango {
    private String material;
    private int nroCuerdas;
    private boolean[] cuerdas;

    public Charango(String material, int nroCuerdas, boolean[] cuerdas) {
        this.material = material;
        this.nroCuerdas = nroCuerdas;
        this.cuerdas = cuerdas;
    }

    public String getMaterial() { return material; }
    public int getNroCuerdas() { return nroCuerdas; }
    public boolean[] getCuerdas() { return cuerdas; }

    public int contarCuerdasRotas() {
        int c = 0;
        for (boolean b : cuerdas)
            if (!b) c++;
        return c;
    }

    @Override
    public String toString() {
        return material + " - cuerdas: " + nroCuerdas;
    }
}
