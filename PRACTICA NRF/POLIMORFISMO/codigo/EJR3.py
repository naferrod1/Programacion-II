class Matriz:
    def __init__(self, datos=None, n=3):
        """
        Constructor:
        - Si no se envían datos, crea una matriz identidad (por defecto tamaño n x n).
        - Si se envían datos, crea la matriz con esos valores.
        """
        if datos is None:
            # matriz identidad
            self.matriz = [[1 if i == j else 0 for j in range(n)] for i in range(n)]
        else:
            self.matriz = datos

        self.n = len(self.matriz)  # tamaño

    def mostrar(self):
        for fila in self.matriz:
            print(fila)
        print()

    def sumar(self, otra):
        if self.n != otra.n:
            raise ValueError("Las matrices deben ser del mismo tamaño")
        nueva = [[self.matriz[i][j] + otra.matriz[i][j] for j in range(self.n)] for i in range(self.n)]
        return Matriz(nueva)

    def restar(self, otra):
        if self.n != otra.n:
            raise ValueError("Las matrices deben ser del mismo tamaño")
        nueva = [[self.matriz[i][j] - otra.matriz[i][j] for j in range(self.n)] for i in range(self.n)]
        return Matriz(nueva)

    def igual(self, otra):
        return self.matriz == otra.matriz


# mAin
m1 = Matriz()
print("Matriz identidad:")
m1.mostrar()

datos = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]
]
m2 = Matriz(datos)
print("Matriz m2:")
m2.mostrar()

print("Suma (m1 + m2):")
m3 = m1.sumar(m2)
m3.mostrar()

print("Resta (m2 - m1):")
m4 = m2.restar(m1)
m4.mostrar()

print("¿m1 es igual a m2?", m1.igual(m2))
print("¿m1 es igual a identidad?", m1.igual(Matriz()))
