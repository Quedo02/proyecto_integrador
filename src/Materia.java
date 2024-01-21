class Materia {
    private String nombre="";
    public String clave="";
    private int credito=0;
    private Profesor profesor;

    public Materia(){
        
    }
    
    public Materia(String nombre,
            String clave,
            int credito){
        this.nombre=nombre;
        this.clave=clave;
        this.credito=credito;
    }
    
    //Setters
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public void setClave(String clave){
        this.clave=clave;
    }
    
    public void setCredito(int credito){
        this.credito=credito;
    }
    
    //Getters
    public String getNombre(){
        return this.nombre;
    }
    
    public String getClave(){
        return this.clave;
    }
    
    public int getCredito(){
        return this.credito;
    }

    // Setter para el profesor
    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    // Getter para el profesor
    public Profesor getProfesor() {
        return this.profesor;
    }
    
    @Override
    public String toString() { //Se agregó el nombre del profesor
        return ("Nombre: " + this.nombre + "\nClave: " + this.clave + "\nCredito: " + this.credito
                + "\nProfesor: " + (profesor != null ? profesor.getNombre() + " " + profesor.getApellido() : "No asignado"));
    }
}
