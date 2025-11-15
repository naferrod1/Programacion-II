class Persona:
    def __init__(self, nombre, edad, ci):
        self.nombre = nombre
        self.edad = edad
        self.ci = ci


class Fraternidad:
    def __init__(self, nombre, encargado):
        self.nombre = nombre
        self.encargado = encargado
        self.integrantes = []

    def agregarIntegrante(self, p):
        # Validar que no esté en más de 2 frats
        self.integrantes.append(p)

    def pertenece(self, ci):
        return any(p.ci == ci for p in self.integrantes)


class Facultad:
    def __init__(self, nombre):
        self.nombre = nombre
        self.integrantes = []

    def agregarIntegrante(self, p):
        self.integrantes.append(p)
def main():
    # Crear facultades
    facultad1 = Facultad("Ingeniería")
    facultad2 = Facultad("Arquitectura")

    # Crear encargados de fraternidades
    encargado1 = Persona("Mario López", 30, "E001")
    encargado2 = Persona("Laura Pérez", 32, "E002")

    # Crear fraternidades
    frat1 = Fraternidad("Los Alegres", encargado1)
    frat2 = Fraternidad("Los Vigorosos", encargado2)

    # Crear participantes
    p1 = Persona("Ana Gómez", 20, "P001")
    p2 = Persona("Luis Torres", 22, "P002")
    p3 = Persona("Carla Ruiz", 21, "P003")
    p4 = Persona("Pedro Sánchez", 23, "P004")
    p5 = Persona("Lucía Martínez", 20, "P005")

    # Agregar participantes a facultades
    facultad1.agregarIntegrante(p1)
    facultad1.agregarIntegrante(p2)
    facultad2.agregarIntegrante(p3)
    facultad2.agregarIntegrante(p4)
    facultad1.agregarIntegrante(p5)

    # Agregar participantes a fraternidades (validando que no estén en más de 2)
    frat1.agregarIntegrante(p1)
    frat1.agregarIntegrante(p2)
    frat2.agregarIntegrante(p3)
    frat2.agregarIntegrante(p4)
    frat1.agregarIntegrante(p5)  # p5 en frat1
    # Si p5 fuera agregado a otra frat, habría que validar que no esté en >2

    # Mostrar participantes y a qué fraternidad y facultad pertenecen
    print("=== Participantes y sus fraternidades y facultades ===")
    participantes = [p1, p2, p3, p4, p5]
    for p in participantes:
        # Buscar fraternidad
        fraternidad = "Ninguna"
        for f in [frat1, frat2]:
            if f.pertenece(p.ci):
                fraternidad = f.nombre
        # Buscar facultad
        facultad = "Ninguna"
        for fac in [facultad1, facultad2]:
            if any(i.ci == p.ci for i in fac.integrantes):
                facultad = fac.nombre
        print(f"{p.nombre} - Edad: {p.edad} - Fraternidad: {fraternidad} - Facultad: {facultad}")

    # Mostrar encargados de cada fraternidad
    print("\n=== Encargados de cada fraternidad ===")
    for f in [frat1, frat2]:
        print(f"{f.nombre} - Encargado: {f.encargado.nombre}")

    # Mostrar edades de los participantes
    print("\n=== Edades de los participantes ===")
    for p in participantes:
        print(f"{p.nombre}: {p.edad} años")


if __name__ == "__main__":
    main()
