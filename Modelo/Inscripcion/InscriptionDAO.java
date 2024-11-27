/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Inscripcion;

import Modelo.Dao.Dao;
import Modelo.Database.Database;
import Utils.UtilDate;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Student
 */
public class InscriptionDAO extends Dao<InscripcionDTO> {

    @Override
    public boolean create(InscripcionDTO dto) throws SQLException {
        if (dto == null || !validateFkTaller(dto.getTaller()) || !validateFkParticipante(dto.getParticipante())) {
            return false;
        }
        String query = "Call InscripcionCreate(?,?,?,?,?)";
        try ( PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, dto.getId());
            stmt.setInt(2, dto.getTaller());
            stmt.setString(3, dto.getParticipante());
            stmt.setDate(4, UtilDate.toSqlDate(dto.getFecha()));
            return stmt.executeUpdate() > 0;
        }
    }

    @Override
    public InscripcionDTO read(Object id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<InscripcionDTO> readAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean update(InscripcionDTO dto) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(Object id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static boolean validateFkTaller(Object id) throws SQLException {
        return new TallerDAO(Database.getConnection()).read(id) != null;
    }

    public static boolean validateFkParticipante(Object id) throws SQLException {
        return new ParticipanteDAO(Database.getConnection()).read(id) != null;
    }

}
