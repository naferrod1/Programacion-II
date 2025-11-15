class Persona:
    def __init__(self, nombre, apellido, edad, ci):
        self.nombre = nombre
        self.apellido = apellido
        self.edad = edad
        self.ci = ci


class Participante(Persona):
    def __init__(self, nombre, apellido, edad, ci, nroTicket):
        super().__init__(nombre, apellido, edad, ci)
        self.nroTicket = nroTicket


class Speaker(Persona):
    def __init__(self, nombre, apellido, edad, ci, especialidad):
        super().__init__(nombre, apellido, edad, ci)
        self.especialidad = especialidad


class Charla:
    def __init__(self, lugar, nombreCharla, hora, speaker):
        self.lugar = lugar
        self.nombreCharla = nombreCharla
        self.hora = hora
        self.speaker = speaker
        self.participantes = []

    def agregarParticipante(self, p):
        self.participantes.append(p)


class Evento:
    def __init__(self, nombre):
        self.nombre = nombre
        self.charlas = []

    def promedioEdad(self):
        edades = []
        for charla in self.charlas:
            edades.extend([p.edad for p in charla.participantes])
        return sum(edades) / len(edades)

    def buscarPersona(self, nombre, apellido):
        for charla in self.charlas:
            for p in charla.participantes:
                if p.nombre == nombre and p.apellido == apellido:
                    return True
            if charla.speaker.nombre == nombre and charla.speaker.apellido == apellido:
                return True
        return False

    def eliminarCharlaPorSpeaker(self, ci):
        self.charlas = [c for c in self.charlas if c.speaker.ci != ci]

    def ordenarPorParticipantes(self):
        self.charlas.sort(key=lambda c: len(c.participantes))

def main():

    speaker1 = Speaker("Ana", "Pérez", 35, "12345", "Python")
    speaker2 = Speaker("Luis", "Gómez", 40, "67890", "Data Science")
    speaker3 = Speaker("Carla", "Rodríguez", 30, "54321", "Machine Learning")

  
    p1 = Participante("Juan", "Lopez", 25, "11111", 1)
    p2 = Participante("María", "Fernandez", 28, "22222", 2)
    p3 = Participante("Pedro", "García", 22, "33333", 3)
    p4 = Participante("Lucía", "Martínez", 30, "44444", 4)
    p5 = Participante("Diego", "Sánchez", 27, "55555", 5)

  
    charla1 = Charla("Auditorio A", "Introducción a Python", "10:00", speaker1)
    charla2 = Charla("Auditorio B", "Data Science 101", "12:00", speaker2)
    charla3 = Charla("Auditorio C", "Machine Learning Avanzado", "14:00", speaker3)

    charla1.agregarParticipante(p1)
    charla1.agregarParticipante(p2)

    charla2.agregarParticipante(p3)
    charla2.agregarParticipante(p4)
    charla2.agregarParticipante(p5)

    charla3.agregarParticipante(p1)
    charla3.agregarParticipante(p5)


    evento = Evento("Tech Conference 2025")
    evento.charlas.extend([charla1, charla2, charla3])


    promedio = evento.promedioEdad()
    print(f"Edad promedio de los participantes: {promedio:.2f} años")


    nombre_buscar = "Pedro"
    apellido_buscar = "García"
    existe = evento.buscarPersona(nombre_buscar, apellido_buscar)
    print(f"La persona {nombre_buscar} {apellido_buscar} está en el evento: {existe}")


    evento.eliminarCharlaPorSpeaker("67890")
    print("\nCharlas después de eliminar las de Luis Gómez:")
    for c in evento.charlas:
        print(f"{c.nombreCharla} - Speaker: {c.speaker.nombre} {c.speaker.apellido}")


    evento.ordenarPorParticipantes()
    print("\nCharlas ordenadas por número de participantes:")
    for c in evento.charlas:
        print(f"{c.nombreCharla} - Participantes: {len(c.participantes)}")


if __name__ == "__main__":
    main()