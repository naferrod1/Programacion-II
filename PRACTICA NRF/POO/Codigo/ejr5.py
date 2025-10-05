class Persona:
    def __init__(self, nombre: str, paterno: str, materno: str, edad: int, ci: int):
        self.nombre = nombre
        self.paterno = paterno
        self.materno = materno
        self.edad = edad
        self.ci = ci
    
    def mostrarDatos(self) -> None:
        print(f"Nombre: {self.nombre} {self.paterno} {self.materno}")
        print(f"Edad: {self.edad}")
        print(f"CI: {self.ci}")
    
    def mayorDeEdad(self) -> bool:
        return self.edad >= 18
    
    def modificarEdad(self, nuevo: int) -> None:
        self.edad = nuevo
        print(f"La edad de {self.nombre} ahora es {self.edad}")
    
    def compararApellido(self, otra) -> bool:
        return self.paterno == otra.paterno


# Instanciar dos personas
persona1 = Persona("Ana", "Gomez", "Lopez", 20, 123456)
persona2 = Persona("Luis", "Gomez", "Martinez", 17, 654321)

# Mostrar datos
persona1.mostrarDatos()
persona2.mostrarDatos()

# Verificar si son mayores de edad
print(f"{persona1.nombre} es mayor de edad? {persona1.mayorDeEdad()}")
print(f"{persona2.nombre} esmayor de edad? {persona2.mayorDeEdad()}")

# Modificar edad
persona2.modificarEdad(18)

# Comparar apellido paterno
if persona1.compararApellido(persona2):
    print("Tienen el mismo apellido paterno.")
else:
    print("No tienen el mismo apellido paterno.")
