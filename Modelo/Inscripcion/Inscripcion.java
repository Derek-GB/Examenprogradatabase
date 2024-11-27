/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Inscripcion;

import java.time.LocalDate;

/**
 *
 * @author Student
 */
public class Inscripcion {

    private int id;
    private Taller taller;
    private Participante participante;
    private LocalDate fecha;
    private boolean asistencia;

    public int getId() {
        return id;
    }

    public Taller getTaller() {
        return taller;
    }

    public Participante getParticipante() {
        return participante;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public boolean isAsistencia() {
        return asistencia;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }

    public Inscripcion(int id, Taller taller, Participante participante, LocalDate fecha, boolean asistencia) {
        this.id = id;
        this.taller = taller;
        this.participante = participante;
        this.fecha = fecha;
        this.asistencia = asistencia;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "id=" + id + ", taller=" + taller + ", participante=" + participante + ", fecha=" + fecha + ", asistencia=" + asistencia + '}';
    }
}
