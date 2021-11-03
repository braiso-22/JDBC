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
public class Departamento {

    private int deptno;
    private String dname;
    private String loc;

    public Departamento() {

    }

    public Departamento(int deptno, String dname, String loc) {
        this.deptno = deptno;
        this.dname = dname;
        this.loc = loc;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        String output;
        String loc = ",\tloc = ";
        if (getDname().length() < 6) {
            loc = ",\t\tloc = ";
        }
        output = " deptno = " + getDeptno() + ",\tdname = "
                + getDname() + loc
                + getLoc() + "\n";

        return output;
    }

}
