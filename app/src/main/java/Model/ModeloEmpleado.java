package Model;

public class ModeloEmpleado {

    public String nombre, apellido, posicion;
    public int id, password_ingreso;

    public ModeloEmpleado(String nombre, String apellido, String posicion, int id, int password_ingreso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.posicion = posicion;
        this.id = id;
        this.password_ingreso = password_ingreso;
    }


    //getters and setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPassword_ingreso() {
        return password_ingreso;
    }

    public void setPassword_ingreso(int password_ingreso) {
        this.password_ingreso = password_ingreso;
    }
}
