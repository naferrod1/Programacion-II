class EcuacionLineal:
    def __init__(self, a, b, c, d, e, f):
        self.a = a
        self.b = b
        self.c = c
        self.d = d
        self.e = e
        self.f = f
    def tiene_solucion(self):
        return (self.a * self.d - self.b * self.c) != 0
    def getX(self):
        return (self.e * self.d - self.b * self.f) / (self.a * self.d - self.b * self.c)
    def getY(self):
        return (self.a * self.f - self.e * self.c) / (self.a * self.d - self.b * self.c)
a, b, c, d, e, f = map(float, input("Ingrese a, b, c, d, e, f: ").split())
eq = EcuacionLineal(a, b, c, d, e, f)

if eq.tiene_solucion():
    print(f"x = {eq.getX()}, y = {eq.getY()}")
else:
    print("La ecuación no tiene solución")
