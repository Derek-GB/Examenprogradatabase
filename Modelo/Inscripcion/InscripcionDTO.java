/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Inscripcion;

import java.time.LocalDate;
import java.sql.Date;

/**
 *
 * @author Student
 */
public class InscripcionDTO {
    private final int id;
    private final int taller;
    private final String participante;
    private final Date fecha;
    private final boolean asistencia;

    public int getId() {
        return id;
    }

    public int getTaller() {
        return taller;
    }

    public String getParticipante() {
        return participante;
    }

    public Date getFecha() {
        return fecha;
    }

    public boolean isAsistencia() {
        return asistencia;
    }

    public InscripcionDTO(int id, int taller, String participante, Date fecha, boolean asistencia) {
        this.id = id;
        this.taller = taller;
        this.participante = participante;
        this.fecha = fecha;
        this.asistencia = asistencia;
    }

    @Override
    public String toString() {
        return "InscripcionDTO{" + "id=" + id + ", taller=" + taller + ", participante=" + participante + ", fecha=" + fecha + ", asistencia=" + asistencia + '}';
    }
    
    
}
