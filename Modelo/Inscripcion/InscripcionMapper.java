/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Inscripcion;

import Modelo.Database.Database;
import Modelo.Mapper.Mapper;
import Modelo.Participantes.ParticipanteDAO;
import Modelo.Participantes.ParticipanteMapper;
import Modelo.Taller.TallerDAO;
import Modelo.Taller.TallerMapper;
import Utils.UtilDate;
import java.sql.SQLException;

/**
 *
 * @author Student
 */
public class InscripcionMapper implements Mapper<Inscripcion, InscripcionDTO> {

    @Override
    public InscripcionDTO toDTO(Inscripcion ent) {
        return new InscripcionDTO(
                ent.getId(),
                ent.getTaller().getId(),
                ent.getParticipante().getCedula(),
                UtilDate.toSqlDate(ent.getFecha()),
                ent.isAsistencia()
        );
    }

    @Override
    public Inscripcion toEnt(InscripcionDTO dto) {
        try {
            return new Inscripcion(
                    dto.getId(),
                    new TallerMapper().toEnt(new TallerDAO(Database.getConnection()).read(dto.getTaller())),
                    new ParticipanteMapper().toEnt(new ParticipanteDAO(Database.getConnection()).read(dto.getParticipante())),
                    UtilDate.toLocalDate(dto.getFecha()),
                    dto.isAsistencia()
            );
        } catch (SQLException e) {
        }
        return null;
    }

}
