package Beans;

public class ListaReproduccion{
    private int idlistaReproduccion;
    private String nombre;

    public ListaReproduccion(int idlistaReproduccion, String nombre) {
        this.idlistaReproduccion = idlistaReproduccion;
        this.nombre = nombre;
    }

    public int getIdlistaReproduccion() {
        return idlistaReproduccion;
    }

    public void setIdlistaReproduccion(int idlistaReproduccion) {
        this.idlistaReproduccion = idlistaReproduccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
