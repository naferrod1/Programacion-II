class Empleado:
    def __init__(self, nombre, cargo, sueldo):
        self.nombre = nombre
        self.cargo = cargo
        self.sueldo = sueldo

    def mostrar(self):
        print(f"Empleado: {self.nombre}, Cargo: {self.cargo}, Sueldo: {self.sueldo}")


class Departamento:
    def __init__(self, nombre, area):
        self.nombre = nombre
        self.area = area
        self.empleados = []

    def agregarEmpleado(self, emp):
        self.empleados.append(emp)

    def mostrarEmpleados(self):
        print(f"\nDepartamento: {self.nombre}")
        if not self.empleados:
            print("  Sin empleados.")
        else:
            for e in self.empleados:
                e.mostrar()

    def cambioSalario(self, porc):
        for e in self.empleados:
            e.sueldo += e.sueldo * (porc / 100)

    def contieneEmpleado(self, nombre):
        return any(e.nombre == nombre for e in self.empleados)

    def moverEmpleadosA(self, depto2):
        depto2.empleados.extend(self.empleados)
        self.empleados = []


e1 = Empleado("Jose", "Gerente", 5000)
e2 = Empleado("Carla", "Asistente", 3000)

d1 = Departamento("Administración", "Oficina Central")
d2 = Departamento("Ventas", "Sucursal Norte")

d1.agregarEmpleado(e1)
d1.agregarEmpleado(e2)

d1.mostrarEmpleados()

d1.cambioSalario(10)
print("\nDespués del aumento:")
d1.mostrarEmpleados()

d1.moverEmpleadosA(d2)

print("\nDespués de mover al otro departamento:")
d1.mostrarEmpleados()
d2.mostrarEmpleados()
