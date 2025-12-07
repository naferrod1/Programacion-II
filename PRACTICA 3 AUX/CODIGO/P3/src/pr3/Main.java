package pr3;
public class Main {
    public static void main(String[] args) {
        ArchivoProducto archivo = new ArchivoProducto("productos.dat");
        archivo.crearArchivo();

        Producto p1 = new Producto(101, "Teclado", 150.0f);
        Producto p2 = new Producto(102, "Mouse", 80.0f);
        Producto p3 = new Producto(103, "Monitor", 950.0f);

        archivo.guardaProducto(p1);
        archivo.guardaProducto(p2);
        archivo.guardaProducto(p3);

        System.out.println("\nBuscar producto con código 102:");
        Producto buscado = archivo.buscaProducto(102);
        System.out.println(buscado != null ? buscado : "No encontrado");

        System.out.println("\nPromedio de precios:");
        System.out.println(archivo.promedioPrecios());

        System.out.println("\nProducto más caro:");
        System.out.println(archivo.productoMasCaro());
    }
}