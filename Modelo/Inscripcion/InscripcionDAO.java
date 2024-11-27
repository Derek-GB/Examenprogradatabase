/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Inscripcion;

import Modelo.Dao.Dao;
import Modelo.Database.Database;
import Modelo.Participantes.ParticipanteDAO;
import Modelo.Taller.TallerDAO;
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
public class InscripcionDAO extends Dao<InscripcionDTO> {

    public InscripcionDAO(Connection connection) {
        super(connection);
    }

    @Override
    public boolean create(InscripcionDTO dto) throws SQLException {
        if (dto == null || !validateFkTaller(dto.getTaller()) || !validateFkParticipante(dto.getParticipante())) {
            return false;
        }
        String query = "Call InscripcionCreate(?,?,?,?)";
        try ( PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, dto.getTaller());
            stmt.setString(2, dto.getParticipante());
            stmt.setDate(3, dto.getFecha());
            stmt.setBoolean(4, dto.isAsistencia());
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public InscripcionDTO read(Object id) throws SQLException {
        if (id == null || (int) id == 0) {
            return null;
        }
        String query = "Call InscripcionRead(?)";
        try ( PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, (int) id);
            try ( ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new InscripcionDTO(
                            rs.getInt(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getDate(4),
                            rs.getBoolean(5)
                    );
                }
            }
        }
        return null;
    }

    @Override
    public List<InscripcionDTO> readAll() throws SQLException {
        String query = "Call PaymentReadAll()";
        List<InscripcionDTO> list = new ArrayList<>();
        try ( PreparedStatement stmt = connection.prepareStatement(query)) {
            try ( ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    list.add(new InscripcionDTO(
                            rs.getInt(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getDate(4),
                            rs.getBoolean(5))
                    );
                }
            }
        }
        return list;
    }

    @Override
    public boolean update(InscripcionDTO dto) throws SQLException {
        if (dto == null || !validateFkTaller(dto.getTaller()) || !validateFkParticipante(dto.getParticipante())) {
            return false;
        }
        String query = "Call InscripcionUpdate(?,?)";
        try ( PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, dto.getId());
            stmt.setBoolean(2, dto.isAsistencia());
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(Object id) throws SQLException {
        if (id == null || (int) id == 0) {
            return false;
        }
        String query = "Call InscripcionDelete(?)";
        try ( PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, (int) id);
            return stmt.executeUpdate() > 0;
        }
    }

    public static boolean validateFkTaller(Object id) throws SQLException {
        return new TallerDAO(Database.getConnection()).read(id) != null;
    }

    public static boolean validateFkParticipante(Object id) throws SQLException {
        return new ParticipanteDAO(Database.getConnection()).read(id) != null;
    }

}
