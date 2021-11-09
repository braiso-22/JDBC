/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import objetosEmpresa.Familiar;

/**
 *
 * @author brais.fernandezvazqu
 */
public class FamiliarDAO implements Dao<Familiar> {

    public static final int BUSCA_POR_EMPLEADO = 1;

    public String prepararQuerys(int i) {
        querys.add("select * from familiar f inner join empleado e on f.empleado = e.empno where e.ename = ? ;");
        return querys.get(i - 1);
    }

    @Override
    public List<Familiar> get(int queryInt, String id, Connection conn) {
        List<Familiar> lista = new ArrayList<>();
        try {
            String query;
            query = prepararQuerys(queryInt);
            PreparedStatement ps = conn.prepareStatement(query);
            switch (queryInt) {
                case BUSCA_POR_EMPLEADO:
                    String cont = id;
                    ps.setString(1, cont);
                    break;
                default:
                    break;
            }
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int numero = rs.getInt(1);
                String nombreFamiliar = rs.getString(2);
                int edad = rs.getInt(3);
                String parentesco = rs.getString(4);
                int empleado = rs.getInt(5);

                lista.add(new Familiar(numero, nombreFamiliar, edad, parentesco, empleado));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }
        return lista;
    }

    @Override
    public List<Familiar> getAll(Connection conn) {
        List<Familiar> lista = null;
        try {
            Statement s = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            ResultSet rs = s.executeQuery("SELECT * FROM Familiar; ");
            int totalRows;
            rs.last();
            totalRows = rs.getRow();
            rs.beforeFirst();
            lista = new ArrayList<>(totalRows);
            while (rs.next()) {
                int numero = rs.getInt(1);
                String nombreFamiliar = rs.getString(2);
                int edad = rs.getInt(3);
                String parentesco = rs.getString(4);
                int empleado = rs.getInt(5);

                lista.add(new Familiar(numero, nombreFamiliar, edad, parentesco, empleado));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println(e.getMessage());
        }
        // TODO Auto-generated method stub
        return lista;
    }

}
