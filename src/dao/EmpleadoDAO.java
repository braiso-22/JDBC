/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import objetosEmpresa.Empleado;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Brais
 */
public class EmpleadoDAO implements Dao<Empleado> {

    private static final int ALL = 0;
    private static final int AUMENTAR_COMISION_JEFES = 6;
    public static final int EMPNO = 1;
    public static final int ENAME = 2;
    public static final int JOB = 3;
    public static final int COMPARA_FECHA = 4;
    public static final int BUSCA_POR_DEPARTAMENTO_Y_SALARIO = 5;
    

    public String prepararQuerys(int i) {
        querys.add("select * from empleado");
        querys.add("select * from empleado where empno = ? ;");
        querys.add("select * from empleado where ename= ?;");
        querys.add("select * from empleado where job = ?;");
        querys.add("select * from empleado where hiredate > ? ;");
        querys.add("select * from empleado where deptno = ? and sal > ?;");
        querys.add("select * from empleado where empno in (select mgr from empleado where comm is not null);");
        return querys.get(i);
    }

    @Override
    public List<Empleado> get(int queryInt, String id, Connection conn) {
        List<Empleado> lista = new ArrayList<>();
        try {
            String query;
            query = prepararQuerys(queryInt);
            PreparedStatement ps = conn.prepareStatement(query);
            switch (queryInt) {
                case COMPARA_FECHA:
                    Date cont = Date.valueOf(id);
                    ps.setDate(1, cont);
                    break;
                case EMPNO:
                case ENAME:
                case JOB:
                    ps.setString(1, id);
                    break;
                case BUSCA_POR_DEPARTAMENTO_Y_SALARIO:
                    String[] list = id.split(";");
                    ps.setInt(1, Integer.parseInt(list[0]));
                    ps.setInt(2, Integer.parseInt(list[1]));

                default:
                    break;
            }
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int empno = rs.getInt(1);
                String ename = rs.getString(2);
                String job = rs.getString(3);
                int mgr = rs.getInt(4);
                LocalDate hiredate = LocalDate.parse(rs.getDate(5).toString());
                float sal = rs.getFloat(6);
                float comm = rs.getFloat(7);
                int deptno = rs.getInt(8);
                lista.add(new Empleado(empno, ename, job, mgr, hiredate, sal, comm, deptno));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }

        return lista;
    }

    public void aumentarComisiones(Connection conn) {
        try {
            Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = s.executeQuery(prepararQuerys(AUMENTAR_COMISION_JEFES));
            while (rs.next()) {
                rs.updateFloat("comm", 500.5f);
                rs.updateRow();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void invertirMayusculas(Connection conn) {
        try {
            Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = s.executeQuery(prepararQuerys(ALL));
            while (rs.next()) {
                String ename = rs.getString(2);
                boolean mays = Character.isUpperCase(ename.charAt(0));
                if (mays) {
                    rs.updateString("ename", ename.toLowerCase());
                } else {
                    rs.updateString("ename", ename.toUpperCase());
                }
                rs.updateRow();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Empleado> getAll(Connection conn) {
        List<Empleado> lista = null;
        try {
            Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = s.executeQuery(prepararQuerys(ALL));
            int totalRows;
            rs.last();
            totalRows = rs.getRow();
            rs.beforeFirst();
            lista = new ArrayList<>(totalRows);
            while (rs.next()) {
                int empno = rs.getInt(1);
                String ename = rs.getString(2);
                String job = rs.getString(3);
                int mgr = rs.getInt(4);
                LocalDate hiredate = LocalDate.parse(rs.getDate(5).toString());
                float sal = rs.getFloat(6);
                float comm = rs.getFloat(7);
                int deptno = rs.getInt(8);
                lista.add(new Empleado(empno, ename, job, mgr, hiredate, sal, comm, deptno));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }
        // TODO Auto-generated method stub
        return lista;
    }
}
