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
public class Proyecto {

    private String nombreProyecto;
    private float presupuesto;
    private String descripcion;
    private int deptno;
    private int numero;

    public Proyecto(int deptno, String nombreProyecto, int numero, float presupuesto, String descripcion) {
        this.nombreProyecto = nombreProyecto;
        this.presupuesto = presupuesto;
        this.descripcion = descripcion;
        this.deptno = deptno;
        this.numero = numero;
    }

    public Proyecto() {

    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public float getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(float presupuesto) {
        this.presupuesto = presupuesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    @Override
    public String toString() {
        String output = "";
        String dp = ",\tdeptno = ";
        String pre = ",\tpresupuesto = ";
        if (getDescripcion().length() <= 16) {
            dp = ",\t\tdeptno = ";
        }
        if (getNombreProyecto().length() <= 13) {
            pre = ",\t\tpresupuesto = ";
        }

        output += "nombreProyecto = " + getNombreProyecto()
                + pre + getPresupuesto()
                + ",\tdescripcion = " + getDescripcion()
                + dp + getDeptno()
                + ",\tnumero = " + getNumero()
                + "\n";
        return output;
    }

}
