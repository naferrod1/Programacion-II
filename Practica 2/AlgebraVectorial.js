public class AlgebraVectorial {
    private double x;
    private double y;
    private double z;

    public AlgebraVectorial(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public AlgebraVectorial sumar(AlgebraVectorial v) {
        return new AlgebraVectorial(this.x + v.x, this.y + v.y, this.z + v.z);
    }
    public AlgebraVectorial restar(AlgebraVectorial v) {
        return new AlgebraVectorial(this.x - v.x, this.y - v.y, this.z - v.z);
    }
    
    public AlgebraVectorial escalar(double r) {
        return new AlgebraVectorial(this.x * r, this.y * r, this.z * r);
    }

    public double longitud() {
        return Math.sqrt(x * x + y * y + z * z);
    }
    public AlgebraVectorial normalizar() {
        double l = longitud();
        if (l == 0) return new AlgebraVectorial(0, 0, 0);
        return new AlgebraVectorial(x / l, y / l, z / l);
    }
    public double productoEscalar(AlgebraVectorial v) {
        return this.x * v.x + this.y * v.y + this.z * v.z;
    }
    public AlgebraVectorial productoVectorial(AlgebraVectorial v) {
        return new AlgebraVectorial(
            this.y * v.z - this.z * v.y,
            this.z * v.x - this.x * v.z,
            this.x * v.y - this.y * v.x
        );
    }
    public boolean esPerpendicular(AlgebraVectorial v) {
        return this.productoEscalar(v) == 0;
    }
    public boolean esParalelo(AlgebraVectorial v) {
        AlgebraVectorial cross = this.productoVectorial(v);
        return cross.x == 0 && cross.y == 0 && cross.z == 0;
    }
    public AlgebraVectorial proyeccionSobre(AlgebraVectorial b) {
        double escalar = this.productoEscalar(b) / Math.pow(b.longitud(), 2);
        return b.escalar(escalar);
    }
    public double componenteEn(AlgebraVectorial b) {
        return this.productoEscalar(b) / b.longitud();
    }
    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
 }
