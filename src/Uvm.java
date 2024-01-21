import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Uvm {
    //Creacion de los array para cada clase
    private ArrayList<Alumno> listAlumno;
    private ArrayList<Materia> listMateria;
    private ArrayList<Profesor> listProfesor;

    public Uvm(){
        this.listAlumno=new ArrayList();
        this.listMateria=new ArrayList();
        this.listProfesor=new ArrayList();
    }

    //Ingreso de alumnos en "listAlumno"
    // public void addAlumno() throws IOException{
    //     BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
    //     Alumno newAlumno=new Alumno();
    //     System.out.println("Matricula: ");
    //     newAlumno.setMatricula(input.readLine());
    //     System.out.print("Nombre: ");
    //     newAlumno.setNombre(input.readLine());
    //     System.out.print("Apellido: ");
    //     newAlumno.setApellido(input.readLine());
    //     System.out.print("Edad: ");
    //     newAlumno.setEdad(Integer.parseInt(input.readLine()));
    //     System.out.print("Sexo: ");
    //     newAlumno.setSexo(input.readLine());
    //     listAlumno.add(newAlumno);
    // }

    // Ingreso de alumnos en "listAlumno" con selección de materias
    public void addAlumno() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Alumno newAlumno = new Alumno();

        System.out.println("Matricula: ");
        newAlumno.setMatricula(input.readLine());
        System.out.print("Nombre: ");
        newAlumno.setNombre(input.readLine());
        System.out.print("Apellido: ");
        newAlumno.setApellido(input.readLine());
        System.out.print("Edad: ");
        newAlumno.setEdad(Integer.parseInt(input.readLine()));
        System.out.print("Sexo: ");
        newAlumno.setSexo(input.readLine());

        // Seleccionar las materias en las que está inscrito el alumno
        ArrayList<Materia> materiasInscritas = selectMaterias();
        newAlumno.setMateriasInscritas(materiasInscritas);

        listAlumno.add(newAlumno);
        System.out.println("Alumno agregado exitosamente.");
    }

    //Ingreso de alumnos en "listMateria"
    // public void addMateria() throws IOException{
    //     BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    //     Materia newMateria=new Materia();
    //     System.out.print("Nombre de la materia: ");
    //     newMateria.setNombre(input.readLine());
    //     System.out.print("Clave: ");
    //     newMateria.setClave(input.readLine());
    //     System.out.print("Creditos: ");
    //     newMateria.setCredito(Integer.parseInt(input.readLine()));
    //     listMateria.add(newMateria);
    // }
    
    //Ingreso de materias en "listMateria"
    public void addMateria() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Materia newMateria = new Materia();

        // Solicitar nombre de la materia
        System.out.print("Nombre de la materia: ");
        newMateria.setNombre(input.readLine());

        // Solicitar clave de la materia
        System.out.print("Clave: ");
        newMateria.setClave(input.readLine());

        // Solicitar créditos de la materia
        System.out.print("Créditos: ");
        newMateria.setCredito(Integer.parseInt(input.readLine()));

        // Bucle para solicitar nombre del profesor hasta que se ingrese un dato válido
        do {
            // Solicitar nombre completo del profesor
            System.out.print("Nombre del profesor que impartirá la materia: ");
            String nombreCompletoProfesor = input.readLine();
        
            // Buscar el profesor en la lista de profesores
            Profesor profesorAsignado = findProfesor(nombreCompletoProfesor);
            if (profesorAsignado != null) {
                newMateria.setProfesor(profesorAsignado);
                listMateria.add(newMateria);
                System.out.println("Materia agregada exitosamente.");
                break; // Salir del bucle si se ingresó un profesor válido
            } else {
                System.out.println("No se encontró al profesor. Inténtelo nuevamente.");
            }
        } while (true); // Bucle infinito hasta que se ingrese un profesor válido
    }

    //Ingreso de alumnos en "listProfesor"
    public void addProfesor() throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Profesor newProfesor=new Profesor();
        System.out.print("Nombre: ");
        newProfesor.setNombre(input.readLine());
        System.out.print("Apellido: ");
        newProfesor.setApellido(input.readLine());
        System.out.print("Edad: ");
        newProfesor.setEdad(Integer.parseInt(input.readLine()));
        System.out.print("Sexo: ");
        newProfesor.setSexo(input.readLine());
        System.out.print("Titulo: ");
        newProfesor.setTitulo(input.readLine());
        listProfesor.add(newProfesor);
    }

    // Impresion de los valores en el array "listAlumno" con materias asociadas
    public void getAlumnos() {
        for (int i = 0; i < listAlumno.size(); i++) {
            System.out.println("-----Alumno #" + (i + 1) + "-----");
            Alumno alumno = listAlumno.get(i);
            System.out.println(alumno);

            // Mostrar las materias en las que está inscrito el alumno
            ArrayList<Materia> materiasInscritas = alumno.getMateriasInscritas();
            if (materiasInscritas != null && !materiasInscritas.isEmpty()) {
                System.out.println("Materias inscritas:");
                for (Materia materia : materiasInscritas) {
                    System.out.println("- " + materia.getNombre());
                }
            } else {
                System.out.println("Este alumno no está inscrito en ninguna materia.");
            }
        }
    }

    //Impresion de los valores en el array "listMateria"
    public void getMaterias() {
        for (int i = 0; i < listMateria.size(); i++) {
            System.out.println("-----Materia #" + (i + 1) + "-----");
            System.out.println(listMateria.get(i));
        }
    }
  
    //Impresion de los valores en el array "listProfesor"
    // public void getProfesores() {
    //     for (int i = 0; i < listProfesor.size(); i++) {
    //         System.out.println("-----Profesor #" + (i + 1) + "-----");
    //         System.out.println(listProfesor.get(i));
    //     }
    // }

    // Impresion de los valores en el array "listProfesor" con materias asociadas
    public void getProfesores() {
        for (int i = 0; i < listProfesor.size(); i++) {
            System.out.println("-----Profesor #" + (i + 1) + "-----");
            Profesor profesor = listProfesor.get(i);
            System.out.println(profesor);

            // Mostrar las materias que imparte el profesor
            ArrayList<Materia> materiasImpartidas = getMateriasByProfesor(profesor);
            if (!materiasImpartidas.isEmpty()) {
                System.out.println("Materias que imparte:");
                for (Materia materia : materiasImpartidas) {
                    System.out.println("- " + materia.getNombre());
                }
            } else {
                System.out.println("Este profesor no imparte ninguna materia.");
            }
        }
    }

    //Eliminacion de algun valor dentro del array "listAlumno"
    public void deleteAlumnos() throws IOException{
        BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Ingrese la matricula del alumno que desea eliminar: ");
        String matricula= input.readLine();

        Iterator<Alumno> iterator = listAlumno.iterator();
        while(iterator.hasNext()){
            Alumno alumno =iterator.next();
            if(alumno.getMatricula().equals(matricula)){
                iterator.remove();
                System.out.println("Alumno eliminiado exitosamente");
                return;
            }else{
                System.out.println("No se encontro ningun alumno con esa matricula");
            }
        }
    }

    //Eliminacion de algun valor dentro del array "listMateria"
    public void deleteMaterias() throws IOException{
        BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Ingrese la clave de la materia que desea eliminar: ");
        String clave= input.readLine();
      
        Iterator<Materia> iterator = listMateria.iterator();
        while(iterator.hasNext()){
            Materia materia =iterator.next();
            if(materia.getClave().equals(clave)){
                iterator.remove();
                System.out.println("Materia eliminiada exitosamente");
                return;
            }else{
                System.out.println("No se encontro ninguna materia con esa clave");
            }
        }
    }

    //Eliminacion de algun valor dentro del array "listProfesor"
    public void deleteProfesores() throws IOException{
        BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Ingrese el id del profesor que desea eliminar: ");
        String id= input.readLine();

        Iterator<Profesor> iterator = listProfesor.iterator();
        while(iterator.hasNext()){
            Profesor profesor =iterator.next();
            if(profesor.getId().equals(id)){
                iterator.remove();
                System.out.println("Profesor eliminiado exitosamente");
                return;
            }else{
                System.out.println("No se encontro ningun profesor con ese ID");
            }
        }
    }

    // Método auxiliar para buscar un profesor por nombre completo en la lista de profesores
    private Profesor findProfesor(String nombreCompleto) {
        for (Profesor profesor : listProfesor) {
            String nombreProfesorCompleto = profesor.getNombre() + " " + profesor.getApellido();
            if (nombreProfesorCompleto.equalsIgnoreCase(nombreCompleto)) {
                return profesor;
            }
        }
        return null; // Retorna null si no se encuentra al profesor
    }

    // Método auxiliar para obtener las materias impartidas por un profesor
    private ArrayList<Materia> getMateriasByProfesor(Profesor profesor) {
        ArrayList<Materia> materiasImpartidas = new ArrayList<>();
        for (Materia materia : listMateria) {
            // Verificar si el profesor está asignado a la materia
            if (materia.getProfesor() != null && materia.getProfesor().equals(profesor)) {
                materiasImpartidas.add(materia);
            }
        }
        return materiasImpartidas;
    }

    // Método para seleccionar las materias en las que un alumno está inscrito
    private ArrayList<Materia> selectMaterias() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Materia> materiasSeleccionadas = new ArrayList<>();

        System.out.println("Materias disponibles:");
        getMaterias(); // Mostrar todas las materias para que el alumno pueda seleccionar

        int maxMaterias = 6; // Máximo de materias que puede seleccionar el alumno

        for (int i = 0; i < maxMaterias; i++) {
            System.out.print("Ingrese el nombre de la materia (o '0' para dejar de agregar materias): ");
            String materiaNombre = input.readLine();

            if (materiaNombre.equals("0")) {
                break; // El usuario ingresó '0', salir del bucle
            }

            // Buscar la materia en la lista
            Materia materia = findMateriaByName(materiaNombre);
            if (materia != null) {
                materiasSeleccionadas.add(materia);
                System.out.println("Materia agregada: " + materia.getNombre());
            } else {
                System.out.println("Materia no encontrada. Inténtelo nuevamente.");
                i--; // Decrementar el índice para que el usuario pueda intentar nuevamente
            }
        }

        return materiasSeleccionadas;
    }

    // Método auxiliar para buscar una materia por nombre en la lista de materias
    private Materia findMateriaByName(String nombreMateria) {
        for (Materia materia : listMateria) {
            if (materia.getNombre().equalsIgnoreCase(nombreMateria)) {
                return materia;
            }
        }
        return null; // Retorna null si no se encuentra la materia
    }

    // Método para mostrar información general de materias, profesores y alumnos
    public void showGeneralInfo() {
        System.out.println("----- Información General -----");
        System.out.println("Materias:");

        // Crear un mapa para almacenar la lista de alumnos inscritos por materia
        HashMap<Materia, ArrayList<Alumno>> alumnosPorMateria = new HashMap<>();

        // Mostrar información de cada materia
        for (Materia materia : listMateria) {
            System.out.println("Clave: " + materia.getClave());
            System.out.println("Nombre: " + materia.getNombre());

            // Modificación aquí: Mostrar nombre completo del profesor
            Profesor profesor = materia.getProfesor();
            if (profesor != null) {
                System.out.println("Profesor: " + profesor.getNombre() + " " + profesor.getApellido());
            } else {
                System.out.println("Profesor: No asignado");
            }

            System.out.println("Alumnos inscritos:");

            // Obtener la lista de alumnos inscritos en la materia
            ArrayList<Alumno> alumnosInscritos = getAlumnosByMateria(materia);

            // Mostrar la lista de alumnos inscritos
            for (Alumno alumno : alumnosInscritos) {
                System.out.println("- " + alumno.getNombre() + " " + alumno.getApellido());
            }

            // Guardar la lista de alumnos inscritos en el mapa
            alumnosPorMateria.put(materia, alumnosInscritos);

            System.out.println("-----------------------------");
        }
    }


    // Método auxiliar para obtener la lista de alumnos inscritos en una materia
    private ArrayList<Alumno> getAlumnosByMateria(Materia materia) {
        ArrayList<Alumno> alumnosInscritos = new ArrayList<>();
        for (Alumno alumno : listAlumno) {
            if (alumno.getMateriasInscritas().contains(materia)) {
                alumnosInscritos.add(alumno);
            }
        }
        return alumnosInscritos;
    }
}