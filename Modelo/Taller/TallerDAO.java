/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Taller;

import Modelo.Dao.Dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DYLAN
 */
public class TallerDAO extends Dao<TallerDTO>{

    public TallerDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(TallerDTO dto) throws SQLException {
        if (dto == null) {
            return false;
        }
        String query = "Call TallerCreate(?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, dto.getNombre());
            stmt.setDate(2, (Date) dto.getFecha());
            stmt.setString(3, dto.getLugar());
            stmt.setInt(4, dto.getCapacidad());
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public TallerDTO read(Object id) throws SQLException {
        if (id == null || String.valueOf(id).trim().isEmpty()) {
            return null;
        }
        String query = "Call TallerRead(?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, String.valueOf(id));
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new TallerDTO(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getDate(3),
                            rs.getString(4),
                            rs.getInt(5));
                }
            }
        }
        return null;
    }

    @Override
    public List<TallerDTO> readAll() throws SQLException {
        String query = "Call TallerReadAll()";
        List<TallerDTO> list = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query)) {

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    list.add(new TallerDTO(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getDate(3),
                            rs.getString(4),
                            rs.getInt(5)));
                }
            }
            return list;
        }
    }

    @Override
    public boolean update(TallerDTO dto) throws SQLException {
        if (dto == null) {
            return false;
        }
        String query = "Call TallerUpdate(?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, dto.getId());
            stmt.setDate(2, (Date) dto.getFecha());
            stmt.setString(3, dto.getLugar());
            stmt.setInt(4, dto.getCapacidad());
            return stmt.executeUpdate() > 0;

        }
    }

    @Override
    public boolean delete(Object id) throws SQLException {
        if (id == null || String.valueOf(id).trim().isEmpty()) {
            return false;
        }
        String query = "Call TallerDelete(?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, String.valueOf(id));
            return stmt.executeUpdate() > 0;

        }
    }
    
}
