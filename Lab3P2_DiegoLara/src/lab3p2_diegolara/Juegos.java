/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3p2_diegolara;

/**
 *
 * @author diego
 */
public class Juegos extends Aplicaciones {

    private int edadR;

    public Juegos() {
    }

    public Juegos(String nombre, String desarrollador, double precio, int edadR) {
        super(nombre, desarrollador, precio);
        this.edadR = edadR;
    }

    public int getEdadR() {
        return edadR;
    }

    public void setEdadR(int edadR) {
        this.edadR = edadR;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(String desarrollador) {
        this.desarrollador = desarrollador;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getDescargas() {
        return descargas;
    }

    public void setDescargas(int descargas) {
        this.descargas = descargas;
    }

    @Override
    public String toString() {
        return super.toString() + "\nEdad: " + edadR + '}';
    }

}
