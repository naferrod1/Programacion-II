class Doctor:
    def __init__(self, nombre, especialidad):
        self.nombre = nombre
        self.especialidad = especialidad


class Hospital:
    def __init__(self, nombre):
        self.nombre = nombre
        self.doctores = []

    def agregarDoctor(self, d):
        self.doctores.append(d)

    def mostrarDoctores(self):
        print(f"\nHospital {self.nombre}")
        for d in self.doctores:
            print(d.nombre, d.especialidad)

def main():
  
    doc1 = Doctor("Ana Pérez", "Cardiología")
    doc2 = Doctor("Luis Gómez", "Pediatría")
    doc3 = Doctor("Carla Rodríguez", "Neurología")
    doc4 = Doctor("Diego Fernández", "Oncología")

    hosp1 = Hospital("Hospital Central")
    hosp2 = Hospital("Hospital Norte")
    hosp3 = Hospital("Hospital Sur")


    hosp1.agregarDoctor(doc1)
    hosp1.agregarDoctor(doc2)
    
    hosp2.agregarDoctor(doc2)
    hosp2.agregarDoctor(doc3)
    
    hosp3.agregarDoctor(doc1)
    hosp3.agregarDoctor(doc4)

    hosp1.mostrarDoctores()
    hosp2.mostrarDoctores()
    hosp3.mostrarDoctores()


if __name__ == "__main__":
    main()

