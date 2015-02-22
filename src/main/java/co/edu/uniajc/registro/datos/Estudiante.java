/*
 * Date    : 2015.02.19
 * Author  : alexhd
 * Class   : Estudiante.java
 * Project : Registro
 */
package co.edu.uniajc.registro.datos;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author estudiante101
 */
public class Estudiante implements Serializable{
    // Nombre del estudinate
    private String nombre;
    // Código de estudiante
    private int codigo;
    // Nombre de la universidad
    private String universidad;
    // Nombre del programa academico
    private String programa;

    /**
     * Constructor
     */
    public Estudiante() {
    }

    public Estudiante(String nombre, int codigo, String universidad, String programa) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.universidad = universidad;
        this.programa = programa;
    }

    public Estudiante(String datos) {
        String[] piezas = datos.split("\t");
        this.nombre = piezas[0];
        this.codigo = Integer.parseInt(piezas[1]);
        this.universidad = piezas[2];
        this.programa = piezas[3];
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the universidad
     */
    public String getUniversidad() {
        return universidad;
    }

    /**
     * @param universidad the universidad to set
     */
    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    /**
     * @return the programa
     */
    public String getPrograma() {
        return programa;
    }

    /**
     * @param programa the programa to set
     */
    public void setPrograma(String programa) {
        this.programa = programa;
    }

    @Override
    public String toString() {
        return String.format("%s\t%s\t%s\t%s", nombre, codigo, universidad, programa);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.nombre);
        hash = 47 * hash + this.codigo;
        hash = 47 * hash + Objects.hashCode(this.universidad);
        hash = 47 * hash + Objects.hashCode(this.programa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estudiante other = (Estudiante) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.universidad, other.universidad)) {
            return false;
        }
        if (!Objects.equals(this.programa, other.programa)) {
            return false;
        }
        return true;
    }
}
