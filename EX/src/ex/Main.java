package ex;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {


        ArrayList<Medico> medicos = GestorJSON.leerMedicos();
        if (medicos == null) medicos = new ArrayList<>();

        ArrayList<Consulta> consultas = GestorJSON.leerConsultas();
        if (consultas == null) consultas = new ArrayList<>();


        if (medicos.isEmpty()) {

            medicos.add(new Medico(1, "Carlos", "Lopez", 5));
            medicos.add(new Medico(2, "Maria", "Perez", 7));
            medicos.add(new Medico(3, "Jose", "Ramos", 10));

            int idConsulta = 1;

            for (int idMed = 1; idMed <= 3; idMed++) {
                for (int i = 0; i < 3; i++) {

                    int tempId = idConsulta;

                    consultas.add(new Consulta(
                            idConsulta++,
                            "Paciente" + tempId,
                            "Apellido" + tempId,
                            20, 12, 2025,  // día, mes, año
                            idMed
                    ));
                }
            }
        }

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el nombre del médico a eliminar: ");
        String nombreX = sc.nextLine();

        System.out.print("Ingrese el apellido del médico a eliminar: ");
        String apellidoY = sc.nextLine();

        int idMedBorrar = -1;

        Iterator<Medico> itM = medicos.iterator();
        while (itM.hasNext()) {
            Medico m = itM.next();
            if (m.getNombreMed().equalsIgnoreCase(nombreX) &&
                m.getApellidoMed().equalsIgnoreCase(apellidoY)) {

                idMedBorrar = m.getIdMed();
                itM.remove();
            }
        }


        if (idMedBorrar != -1) {
            Iterator<Consulta> itC = consultas.iterator();
            while (itC.hasNext()) {
                Consulta c = itC.next();
                if (c.getIdMed() == idMedBorrar) {
                    itC.remove();
                }
            }
        }


        for (Consulta c : consultas) {

            if (c.getDia() == 25 && c.getMes() == 12) {
                c.setDia(26);
                c.setMes(12);
            }

            if (c.getDia() == 1 && c.getMes() == 1) {
                c.setDia(2);
                c.setMes(1);
            }
        }


        GestorJSON.guardarMedicos(medicos);
        GestorJSON.guardarConsultas(consultas);

        sc.close();

        System.out.println("Proceso terminado con \u00E9xito.");
    }
}

