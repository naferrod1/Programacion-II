class Empleado:
    def __init__(self, nombre, puesto, salario):
        self.nombre = nombre
        self.puesto = puesto
        self.salario = salario


class Empresa:
    def __init__(self, nombre):
        self.nombre = nombre
        self.empleados = []

    def agregarEmpleado(self, e):
        self.empleados.append(e)

    def mostrarEmpleados(self):
        for e in self.empleados:
            print(e.nombre, e.puesto, e.salario)

    def buscar(self, nombre):
        for e in self.empleados:
            if e.nombre == nombre:
                return e
        return None

    def promedioSalario(self):
        return sum(e.salario for e in self.empleados) / len(self.empleados)

    def listarSalarioMayor(self, x):
        for e in self.empleados:
            if e.salario > x:
                print(e.nombre, e.salario)

    def eliminarEmpleado(self, nombre):
        self.empleados = [e for e in self.empleados if e.nombre != nombre]

def main():
  
    empresa = Empresa("Tech Solutions")

    e1 = Empleado("Ana Pérez", "Desarrolladora", 2500)
    e2 = Empleado("Luis Gómez", "Analista", 2200)
    e3 = Empleado("Carla Rodríguez", "Gerente", 4000)
    e4 = Empleado("Pedro Martínez", "Soporte", 1800)

    empresa.agregarEmpleado(e1)
    empresa.agregarEmpleado(e2)
    empresa.agregarEmpleado(e3)
    empresa.agregarEmpleado(e4)


    print(f"=== Empleados de la empresa {empresa.nombre} ===")
    empresa.mostrarEmpleados()


    nombre_buscar = "Luis Gómez"
    empleado_encontrado = empresa.buscar(nombre_buscar)
    if empleado_encontrado:
        print(f"\nEmpleado encontrado: {empleado_encontrado.nombre}, "
              f"{empleado_encontrado.puesto}, Salario: {empleado_encontrado.salario}")
    else:
        print(f"\nEmpleado {nombre_buscar} no encontrado.")


    nombre_eliminar = "Pedro Martínez"
    empresa.eliminarEmpleado(nombre_eliminar)
    print(f"\n=== Empleados después de eliminar {nombre_eliminar} ===")
    empresa.mostrarEmpleados()


    promedio = empresa.promedioSalario()
    print(f"\nPromedio salarial: {promedio:.2f}")

    valor = 2300
    print(f"\nEmpleados con salario mayor a {valor}:")
    empresa.listarSalarioMayor(valor)


if __name__ == "__main__":
    main()
