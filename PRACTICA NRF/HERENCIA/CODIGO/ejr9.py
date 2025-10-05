class Politico:
    def __init__(self, profesion, añosExp):
        self.profesion = profesion
        self.añosExp = añosExp


class Partido:
    def __init__(self, nombreP, rol):
        self.nombreP = nombreP
        self.rol = rol


class Presidente(Politico, Partido):
    def __init__(self, nombre, apellido, profesion, añosExp, nombreP, rol):
        Politico.__init__(self, profesion, añosExp)
        Partido.__init__(self, nombreP, rol)
        self.nombre = nombre
        self.apellido = apellido

    def mostrar(self):
        return f"{self.nombre} {self.apellido} | Partido: {self.nombreP} | Profesión: {self.profesion} | AñosExp: {self.añosExp}"


if __name__ == "main":
    p1 = Presidente("Ana","Gomez","Abogada",20,"Partido A","Lider")

    p2 = Presidente("Luis","Perez","Economista",15,"Partido B","Fundador")

    p3 = Presidente("Rosa","Diaz","Ingeniera",10,"Partido C","Miembro")

    lista = [p1, p2, p3]

    for p in lista:
        print(p.mostrar())

    #buscar por nombre
    nombre_buscado = "Luis"
    encontrados = [p for p in lista if p.nombre.lower() == nombre_buscado.lower()]
    for e in encontrados:
        print("Encontrado:", e.mostrar())
