class Mp4:
    def __init__(self, marca: str, capacidadGb: float):
        self.marca = marca
        self.capacidadGb = capacidadGb
        self.nroCanciones = 0
        self.canciones = []  
        self.nroVideos = 0
        self.videos = []    

    def mostrar(self):
        print(f"MP4 Marca: {self.marca}, Capacidad total: {self.capacidadGb}GB")
        print("Canciones:")
        for c in self.canciones:
            print(f"  Nombre: {c[0]}, Artista: {c[1]}, Peso: {c[2]}Kb")
        print("Videos:")
        for v in self.videos:
            print(f"  Nombre: {v[0]}, Artista: {v[1]}, Peso: {v[2]}Mb")
        print(f"Capacidad disponible: {self.capacidadDisponible():.2f} GB")
        print()

    def borrar(self, nombre=None, artista=None, peso=None):
        if nombre and artista and peso:
            self.canciones = [c for c in self.canciones if not (c[0]==nombre and int(c[2])==peso)]
        elif nombre:
       
            self.canciones = [c for c in self.canciones if c[0] != nombre]
        elif artista:
      
            self.canciones = [c for c in self.canciones if c[1] != artista]

        self.nroCanciones = len(self.canciones)

    def __add__(self, cancion: list):
        pesoGb = cancion[2] / (1024*1024)
        if self.capacidadDisponible() >= pesoGb:
            if not any(c[0]==cancion[0] and c[1]==cancion[1] for c in self.canciones):
                self.canciones.append(cancion)
                self.nroCanciones += 1
            else:
                print(f"La canción {cancion[0]} ya existe.")
        else:
            print("No hay suficiente espacio para agregar la canción.")
        return self

    def __sub__(self, video: list):
        pesoGb = video[2] / 1024
        if self.capacidadDisponible() >= pesoGb:
            if not any(v[0]==video[0] and v[1]==video[1] for v in self.videos):
                self.videos.append(video)
                self.nroVideos += 1
            else:
                print(f"El video {video[0]} ya existe.")
        else:
            print("No hay suficiente espacio para agregar el video.")
        return self

    def capacidadDisponible(self):
        pesoCancionesGb = sum(c[2]/(1024*1024) for c in self.canciones)  
        pesoVideosGb = sum(v[2]/1024 for v in self.videos)                
        return self.capacidadGb - (pesoCancionesGb + pesoVideosGb)



mp4 = Mp4("Sony", 2.0)  # 2 GB

#Agregar canciones
mp4 + ["Back To Black", "Amy Winehouse", 100]
mp4 + ["Lost On You", "LP", 150]
mp4 + ["Back To Black", "Amy Winehouse", 100]  # ya existe

#Agregar videos
mp4 - ["Heathens", "twenty one pilots", 50]
mp4 - ["Without Me", "Halsey", 30]

mp4.mostrar()

#Borrar canciones
mp4.borrar(nombre="Lost On You")
mp4.mostrar()
