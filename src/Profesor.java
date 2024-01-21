class Profesor {
    private String nombre="";
    private String apellido="";
    private int edad=0;
    private String sexo="";
    private String titulo="";
    public String id="";
    
    public Profesor(){
        
    }
    public Profesor(String nombre,
            String apellido,
            int edad,
            String sexo,
            String titulo,
            String id){
        this.nombre=nombre;
        this.apellido=apellido;
        this.edad=edad;
        this.sexo=sexo;
        this.titulo=titulo;
        this.id=id;
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
    
    public void setTitulo(String titulo){
        this.titulo=titulo;
    }
    public void setId(String id){
        this.id=id;
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
    
    public String getTitulo(){
        return this.titulo;
    }
    
    public String getId(){
        return this.id;
    }
    @Override
    public String toString(){
        return ("Nombre: "+this.nombre+"\nApellido: "+
                this.apellido+"\nEdad: "+
                this.edad+"\nSexo: "+
                this.sexo+"\nTitulo: "+
                this.titulo);
    }
}
