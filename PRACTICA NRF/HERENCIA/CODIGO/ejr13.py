class Empleado:
    def __init__(self, nombre, sueldoBase):
        self.nombre = nombre
        self.sueldoBase = sueldoBase

    def sueldo_total(self):
        return self.sueldoBase

    def mostrar(self):
        return f"{self.nombre} | SueldoBase: {self.sueldoBase}"


class Administrativo(Empleado):
    def __init__(self, nombre, sueldoBase, cargo):
        super().__init__(nombre, sueldoBase)
        self.cargo = cargo


class Chef(Empleado):
    def __init__(self, nombre, sueldoBase, horaExtra, tipo, sueldoHora):
        super().__init__(nombre, sueldoBase)
        self.horaExtra = horaExtra
        self.tipo = tipo
        self.sueldoHora = sueldoHora

    def sueldo_total(self):
        return self.sueldoBase + self.horaExtra * self.sueldoHora


class Mesero(Empleado):
    def __init__(self, nombre, sueldoBase, propina, horaExtra, sueldoHora):
        super().__init__(nombre, sueldoBase)
        self.propina = propina
        self.horaExtra = horaExtra
        self.sueldoHora = sueldoHora

    def sueldo_total(self):
        return self.sueldoBase + self.horaExtra * self.sueldoHora + self.propina


if __name__ == "__main__":
    chef = Chef("Gordon",3000.0,5,"Ejecutivo",20.0)
    mes1 = Mesero("Luis",1500.0,200.0,2,15.0)
    mes2 = Mesero("Ana",1500.0,150.0,3,15.0)
    adm1 = Administrativo("Bea",1800.0,"RRHH")
    adm2 = Administrativo("Omar",1700.0,"Contabilidad")

    empleados = [chef, mes1, mes2, adm1, adm2]

    # Mostrar empleados con sueldo base = X
    X = 1500.0
    print("Empleados con sueldoBase == X:")
    for e in empleados:
        if e.sueldoBase == X:
            print(e.mostrar())

    # Mostrar sueldo total empleados
    for e in empleados:
        print(f"{e.nombre} -> Sueldo total: {e.sueldo_total()}")
