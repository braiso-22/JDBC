/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosEmpresa;

/**
 *
 * @author brais.fernandezvazqu
 */
public class Familiar {

    private int numero;
    private String nombreFamiliar;
    private int edad;
    private String parentesco;
    private int empleado;

    public Familiar(int numero, String nombreFamiliar, int edad, String parentesco, int empleado) {
        this.numero = numero;
        this.nombreFamiliar = nombreFamiliar;
        this.edad = edad;
        this.parentesco = parentesco;
        this.empleado = empleado;
    }

    public Familiar() {

    }

    public String getNombreFamiliar() {
        return nombreFamiliar;
    }

    public void setNombreFamiliar(String nombreFamiliar) {
        this.nombreFamiliar = nombreFamiliar;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public int getEmpleado() {
        return empleado;
    }

    public void setEmpleado(int empleado) {
        this.empleado = empleado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        String output = "";
        String vEdad = ",\tedad = ";
        if (getNombreFamiliar().length() <= 5) {
            vEdad = ",\t\tedad = ";
        }
        output += "numero = " + getNumero()
                + "\tnombreFamiliar = " + getNombreFamiliar()
                + vEdad + getEdad()
                + ",\tparentesco = " + getParentesco()
                + ",\templeado = " + getEmpleado() + "\n";
        return output;
    }

}
