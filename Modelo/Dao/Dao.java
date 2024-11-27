/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Dao;

import java.sql.Connection;

/**
 *
 * @author Student
 * @param <Dto>
 */
public abstract class Dao<Dto> implements DaoCompleto<Dto> {
    protected Connection connection;

    public Dao(Connection connection) {
        this.connection = connection;
    }
}
