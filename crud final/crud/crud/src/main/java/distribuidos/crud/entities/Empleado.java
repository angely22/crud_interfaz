package distribuidos.crud.entities;

import javax.persistence.*;

@Entity
@Table(name="empleado")
public class Empleado {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long documentoIdentidad;

    //atributos
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "correo")
    private String correo;

    @Column(name = "cargo")
    private String cargo;

    //constructor
    /*
    public Empleado(String nombre, String correo, String cargo) {
        this.nombre = nombre;
        this.correo = correo;
        this.cargo = cargo;
    }*/

    //constructor vacío para springboot
    public Empleado(){

    }

    //setters y getters


    public Long getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(Long documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /*
    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", cargo='" + cargo + '\'' +
                '}';
    }*/
}
