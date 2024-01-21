import java.util.ArrayList;

class Alumno {
    private String nombre="";
    private String apellido="";
    private int edad=0;
    private String sexo="";
    public String matricula="";
    private ArrayList<Materia> materiasInscritas;

    public Alumno(){
    }

    public Alumno(String nombre,
            String apellido,
            int edad,
            String sexo,
            String matricula){
        this.nombre=nombre;
        this.apellido=apellido;
        this.edad=edad;
        this.sexo=sexo;
        this.matricula=matricula;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public void setApellido(String apellido){
        this.apellido=apellido;
    }
    
    public void setEdad(int edad){
        this.edad=edad;
    }
    
    public void setSexo(String sexo){
        this.sexo=sexo;
    }
    
    public void setMatricula(String matricula){
        this.matricula=matricula;
    }
    //Getters
    public String getNombre(){
        return this.nombre;
    }
    
    public String getApellido(){
        return this.apellido;
    }
    
    public int getEdad(){
        return this.edad;
    }
    
    public String getSexo(){
        return this.sexo;
    }
    
    public String getMatricula(){
        return this.matricula;
    }

    public void setMateriasInscritas(ArrayList<Materia> materiasInscritas) {
        this.materiasInscritas = materiasInscritas;
    }

    public ArrayList<Materia> getMateriasInscritas() {
        return materiasInscritas;
    }

    @Override
    public String toString(){
        return ("Nombre: "+this.nombre+"\nApellido: "+this.apellido+"\nEdad: "+this.edad+"\nSexo: "+this.sexo);
    }
}
