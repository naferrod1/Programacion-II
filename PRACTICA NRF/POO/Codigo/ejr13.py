class Fruta:
    def __init__(self, nombre: str, tipo: str, vitaminas: list[str]):
        self.nombre = nombre
        self.tipo = tipo
        self.vitaminas = vitaminas
        self.nroVitaminas = len(vitaminas)

    def mostrar(self):
        print(f"Fruta: {self.nombre}, Tipo: {self.tipo}, Vitaminas: {', '.join(self.vitaminas)}")

    def get_vitaminas(self):
        return self.vitaminas


# a) Instanciar 3 frutas de 3 maneras diferentes
fruta1 = Fruta("Kiwi", "Subtropical", ["K", "C", "E"])
vitaminas_mango = ["A", "C", "E"]
fruta2 = Fruta("Mango", "Tropical", vitaminas_mango)
vitaminas_fresa = []
vitaminas_fresa.append("C")
vitaminas_fresa.append("B9")
fruta3 = Fruta("Fresa", "Cítrica", vitaminas_fresa)

frutas = [fruta1, fruta2, fruta3]

# b) fruta con más vitaminas
fruta_mas_vitaminas = max(frutas, key=lambda f: f.nroVitaminas)
print(f"La fruta con más vitaminas es {fruta_mas_vitaminas.nombre} con {fruta_mas_vitaminas.nroVitaminas} vitaminas.\n")

# c) Mostrar las vitaminas de la fruta X (ejemplo: Mango)
print(f"Vitaminas de {fruta2.nombre}: {', '.join(fruta2.get_vitaminas())}\n")

# d) Cuántas frutas tienen vitamina C (cítricas)
vitaminas_citricas = 0
for fruta in frutas:
    if "C" in fruta.get_vitaminas():
        vitaminas_citricas += 1
print(f"Hay {vitaminas_citricas} frutas que contienen vitamina C (cítricas).\n")

# e) Ordenar las frutas alfabéticamente según el nombre de sus vitaminas
for fruta in frutas:
    ordenadas = sorted(fruta.get_vitaminas())
    print(f"Vitaminas de {fruta.nombre} ordenadas: {', '.join(ordenadas)}")
