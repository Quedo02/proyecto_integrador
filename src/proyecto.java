import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class proyecto {
    public static void main(String[] args) throws Exception {
        boolean exit=false;
        Uvm uvm=new Uvm();
        do{
            try{
                int task=mainMenu ();
                switch(task){
                    case 0: exit=true; break;
                    case 1: menuAlumnos(uvm);break;
                    case 2: menuProfesores(uvm); break;
                    case 3: menuMaterias(uvm);break;
                    case 4: uvm.showGeneralInfo();break;
                }
                System.out.println();
            }
            catch(IOException ex){
                Logger.getLogger(Uvm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        while(!exit);
    }

    //Metodo que crea el menu principal
    private static int mainMenu() throws IOException{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Opciones: \n"
                +"1. Opciones Alumno \n"
                +"2. Opciones Profersor \n"
                +"3. Opciones Materia \n"
                +"4. Informacion general \n"
                +"0. Salir \n");
        System.out.print("Introducir numero de opcion deseada: \n");
        return Integer.parseInt(input.readLine());
    }

    //Metodo que crea el submenu para alumnos
    private static void menuAlumnos(Uvm uvm) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        boolean back = false;
    
        do {
            System.out.println("-----------------------------");
            System.out.println("Opciones Alumno: \n"
                    + "1. Agregar alumno \n"
                    + "2. Ver alumnos \n"
                    + "3. Eliminar alumno \n"
                    + "0. Regresar al menú anterior \n");
    
            System.out.print("Introducir numero de opcion deseada: \n");
            int option = Integer.parseInt(input.readLine());
    
            switch (option) {
                case 1:
                    uvm.addAlumno();
                    break;
                case 2:
                    uvm.getAlumnos();
                    break;
                case 3:
                    uvm.deleteAlumnos();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción correcta.");
                    System.out.println("-----------------------------");
                    break;
            }
        } while (!back);
    }

    //Metodo que crea el submenu para profesores
    private static void menuProfesores(Uvm uvm) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        boolean back = false;
    
        do {
            System.out.println("-----------------------------");
            System.out.println("Opciones Alumno: \n"
                    + "1. Agregar profesores \n"
                    + "2. Ver profesores \n"
                    + "3. Eliminar profesores \n"
                    + "0. Regresar al menú anterior \n");
    
            System.out.print("Introducir numero de opcion deseada: \n");
            int option = Integer.parseInt(input.readLine());
    
            switch (option) {
                case 1:
                    uvm.addProfesor();
                    break;
                case 2:
                    uvm.getProfesores();
                    break;
                case 3:
                    uvm.deleteProfesores();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción correcta.");
                    System.out.println("-----------------------------");
                    break;
            }
        } while (!back);
    }

    //Metodo que crea el submenu para materias
    private static void menuMaterias(Uvm uvm) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        boolean back = false;
    
        do {
            System.out.println("-----------------------------");
            System.out.println("Opciones Alumno: \n"
                    + "1. Agregar materia \n"
                    + "2. Ver materias \n"
                    + "3. Eliminar materias \n"
                    + "0. Regresar al menú anterior \n");
    
            System.out.print("Introducir numero de opcion deseada: \n");
            int option = Integer.parseInt(input.readLine());
    
            switch (option) {
                case 1:
                    uvm.addMateria();
                    break;
                case 2:
                    uvm.getMaterias();
                    break;
                case 3:
                    uvm.deleteMaterias();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción correcta.");
                    System.out.println("-----------------------------");
                    break;
            }
        } while (!back);
    }
    
}