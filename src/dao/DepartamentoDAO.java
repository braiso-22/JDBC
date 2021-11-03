/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import objetosEmpresa.Departamento;

/**
 *
 * @author brais.fernandezvazqu
 */
public class DepartamentoDAO implements Dao<Departamento> {

    @Override
    public List<Departamento> get(int query, String id, Connection conn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Departamento> getAll(Connection conn) {
        List<Departamento> lista = null;
        try {
            Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = s.executeQuery("SELECT * FROM departamento; ");
            int totalRows;
            rs.last();
            totalRows = rs.getRow();
            rs.beforeFirst();
            lista = new ArrayList<>(totalRows);
            while (rs.next()) {
                int deptno = rs.getInt(1);
                String dname = rs.getString(2);
                String loc = rs.getString(3);

                lista.add(new Departamento(deptno, dname, loc));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }
        // TODO Auto-generated method stub
        return lista;
    }
}
