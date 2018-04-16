package bo.edu.umss.programming.examen1;

import java.util.Date;

/**
 * @author ariel.alcocer
 */
abstract public class Producto {
    private String nombre;
    private double precio;
    private Date fechaVenc;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFechaVenc() {
        return fechaVenc;
    }

    public void setFechaVenc(Date fechaVenc) {
        this.fechaVenc = fechaVenc;
    }

    abstract public void mostrar();

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", fechaVenc=" + fechaVenc +
                '}';
    }
}
