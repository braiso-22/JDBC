/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import dao.DepartamentoDAO;
import java.sql.*;
import pool.BasicConnectionPool;
import dao.EmpleadoDAO;
import dao.FamiliarDAO;
import dao.ProyectoDAO;

/**
 *
 * @author Brais
 */
public class MySQLDAOFactory extends DAOFactory {

    final static String url = "jdbc:mysql:///empresa";
    final static String user = "admin";
    final static String password = "abc123.";
    static BasicConnectionPool bcp;

    public MySQLDAOFactory() {
        try {
            bcp = BasicConnectionPool.create(url, user, password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        return bcp.getConnection();
    }

    @Override
    public boolean releaseConnection(Connection connection) {
        return bcp.releaseConnection(connection);
    }

    @Override
    public int getSize() {
        return bcp.getSize();
    }
    //add getUser, getURL....

    @Override
    public void shutdown() throws SQLException {
        bcp.shutdown();
    }

    @Override
    public EmpleadoDAO getEmpleadoDAO() {
        // TODO Auto-generated method stub
        return new EmpleadoDAO();
    }

    @Override
    public DepartamentoDAO getDepartamentoDAO() {
        // TODO Auto-generated method stub
        return new DepartamentoDAO();
    }

    @Override
    public FamiliarDAO getFamiliarDAO() {
        return new FamiliarDAO();
    }

    @Override
    public ProyectoDAO getProyectoDAO() {
        return new ProyectoDAO();
    }
}
