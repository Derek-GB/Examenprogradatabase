/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Participantes;

import Modelo.Dao.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Student
 */
public class ParticipanteDAO extends Dao<ParticipanteDTO> {

     public ParticipanteDAO(Connection connection) {
        super(connection);
    }
    
    @Override
    public boolean create(ParticipanteDTO dto) throws SQLException {
       if (dto == null ) {
            return false;
        }
        String query = "Call ParticipanteCreate(?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, dto.getCedula());
            stmt.setString(2, dto.getNombre());
            stmt.setString(3, dto.getTelefono());
            stmt.setString(4, dto.getCorreo());
            return stmt.executeUpdate() > 0;
        }  
        
    }

    @Override
    public ParticipanteDTO read(Object id) throws SQLException {
      if (id == null || String.valueOf(id).trim().isEmpty()) {
            return null;
        }
        String query = "Call ParticipanteRead(?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, String.valueOf(id));
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new ParticipanteDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                            
                }
            }
        }
        return null;
    }

    @Override
    public List<ParticipanteDTO> readAll() throws SQLException {
      String query = "Call ParticipanteReadAll()";
        List<ParticipanteDTO> list = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(query)) {

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    list.add(new ParticipanteDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
                }
            }
        }
        return list;
    }

    @Override
    public boolean update(ParticipanteDTO dto) throws SQLException {
if (dto == null) {
            return false;
        }
        String query = "Call ParticipanteUpdate(?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, dto.getCedula());
            stmt.setString(2, dto.getTelefono());
            stmt.setString(3, dto.getCorreo());
            return stmt.executeUpdate() > 0;

        }
    }

    @Override
    public boolean delete(Object id) throws SQLException {
      if (id == null || String.valueOf(id).trim().isEmpty()) {
            return false;
        }
        String query = "Call ParticipanteDelete(?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, String.valueOf(id));
            return stmt.executeUpdate() > 0;

        }
    }
    
}
