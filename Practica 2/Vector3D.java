public class Vector3D {
    private double x;
    private double y;
    private double z;
    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Vector3D sumar(Vector3D v) {
        return new Vector3D(this.x + v.x, this.y + v.y, this.z + v.z);
    }
    public Vector3D multiplicarEscalar(double r) {
        return new Vector3D(this.x * r, this.y * r, this.z * r);
    }
    public double longitud() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public Vector3D normalizar() {
        double l = longitud();
        if (l == 0) return new Vector3D(0, 0, 0);
        return new Vector3D(x / l, y / l, z / l);
    }
    public double productoEscalar(Vector3D v) {
        return this.x * v.x + this.y * v.y + this.z * v.z;
    }
    public Vector3D productoVectorial(Vector3D v) {
        return new Vector3D(
            this.y * v.z - this.z * v.y,
            this.z * v.x - this.x * v.z,
            this.x * v.y - this.y * v.x
        );
    }
    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
 }

 
