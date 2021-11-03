/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetosEmpresa;

import java.time.LocalDate;

/**
 *
 * @author brais.fernandezvazqu
 */
public class Empleado {

    private int empno;
    private String ename;
    private String job;
    private int mgr;
    private LocalDate hiredate;
    private float sal;
    private float comm;
    private int deptno;

    public Empleado() {
    }

    public Empleado(int empno, String ename, String job, int mgr, LocalDate hiredate, float sal, float comm, int deptno) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getMgr() {
        return mgr;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public LocalDate getHiredate() {
        return hiredate;
    }

    public void setHiredate(LocalDate hiredate) {
        this.hiredate = hiredate;
    }

    public float getSal() {
        return sal;
    }

    public void setSal(float sal) {
        this.sal = sal;
    }

    public float getComm() {
        return comm;
    }

    public void setComm(float comm) {
        this.comm = comm;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    @Override
    public String toString() {
        String output = " empno = " + getEmpno() + ",\tename = "
                + getEname() + ",\tjob = " + getJob()
                + "\t, mgr= " + getMgr() + ",\thiredate = "
                + getHiredate() + ",\tsal = " + getSal()
                + ",\tcomm = " + getComm() + ",\tdeptno = "
                + getDeptno() + " " + "\n";
        return output;
    }

}
