/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo.Dao;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Student
 */
public interface DaoCompleto<Dto> {

    public abstract boolean create(Dto dto) throws SQLException;

    public abstract Dto read(Object id) throws SQLException;

    public abstract List<Dto> readAll() throws SQLException;

    public abstract boolean update(Dto dto) throws SQLException;

    public abstract boolean delete(Object id) throws SQLException;

}
