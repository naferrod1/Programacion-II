class Persona:
    def __init__(self, nombre, paterno, materno, edad):
        self.nombre = nombre
        self.paterno = paterno
        self.materno = materno
        self.edad = edad

    def mostrar(self):
        return f"{self.nombre} {self.paterno} {self.materno}, Edad: {self.edad}"

class Docente(Persona):
    def __init__(self, nombre, paterno, materno, edad, sueldo, regProfesional):
        super().__init__(nombre, paterno, materno, edad)
        self.sueldo = sueldo
        self.regProfesional = regProfesional

    def mostrar(self):
        return f"Docente: {super().mostrar()} | Sueldo: {self.sueldo} | Reg: {self.regProfesional}"


class Estudiante(Persona):
    def __init__(self, nombre, paterno, materno, edad, ru, matricula):
        super().__init__(nombre, paterno, materno, edad)
        self.ru = ru
        self.matricula = matricula

    def mostrar(self):
        return f"Estudiante: {super().mostrar()} | RU: {self.ru} | Mat: {self.matricula}"

    def modificarEdad(self, nueva):
        self.edad = nueva


def promedio_edades(estudiantes):
    if not estudiantes:
        return 0
    return sum(e.edad for e in estudiantes) / len(estudiantes)


def mismo_edad(estudiante, docente):
    return estudiante.edad == docente.edad

if __name__ == "main":
    e1 = Estudiante("Juan","Diaz","Lopez",20,"RU001","M001")
    e2 = Estudiante("Maria","Perez","Soto",22,"RU002","M002")
    d = Docente("Carlos","Quispe","Ortega",45,3500.0,"RP-123")

    print(e1.mostrar())
    print(e2.mostrar())
    print(d.mostrar())
    print("Promedio edad estudiantes:", promedio_edades([e1,e2]))
    e1.modificarEdad(21)
    print("e1 nueva edad:", e1.edad)
    print("¿e1 tiene misma edad que docente?", mismo_edad(e1,d))
