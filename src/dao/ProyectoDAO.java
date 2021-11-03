/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import objetosEmpresa.Proyecto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author brais.fernandezvazqu
 */
public class ProyectoDAO implements Dao<Proyecto> {

    @Override
    public List<Proyecto> get(int query, String id, Connection conn) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Proyecto> getAll(Connection conn) {
        List<Proyecto> lista = null;
        try {
            Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = s.executeQuery("SELECT * FROM proyecto; ");
            int totalRows;
            rs.last();
            totalRows = rs.getRow();
            rs.beforeFirst();
            lista = new ArrayList<>(totalRows);
            while (rs.next()) {
                int deptno = rs.getInt(1);
                String nombreProyecto = rs.getString(2);
                int numero = rs.getInt(3);
                float presupuesto = rs.getFloat(4);
                String descripcion = rs.getString(5);

                lista.add(new Proyecto(deptno, nombreProyecto, numero, presupuesto, descripcion));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }
        // TODO Auto-generated method stub
        return lista;
    }
}
