/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Brais
 * @param <T>
 */
public interface Dao<T> {
    ArrayList<String> querys = new ArrayList<>();
    
    List<T> get(int query,String id, Connection conn);

    //METODOS NECESARIOS
    List<T> getAll(Connection conn);

}
