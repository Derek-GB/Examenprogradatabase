/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Database.Database;
import Modelo.Inscripcion.Inscripcion;
import Modelo.Inscripcion.InscripcionDAO;
import Modelo.Inscripcion.InscripcionDTO;
import Modelo.Participantes.ParticipanteDAO;
import Modelo.Taller.TallerDAO;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.swing.text.View;
import Vista.vista;



/**
 *
 * @author DYLAN
 */
public class InscripcionControlador {
    private InscripcionDAO dao;
    private final vista view;
    private final InscricionMapper mapper;
    
    public InscripcionControlador(vista view) {
        this.view = view;
        mapper=new InscripcionMapper();
        try {
            dao=new InscripcionDAO(Database.getConnection());
        } catch (SQLException ex) {
            view.showError("Error al conectar con la Base de Datos");
        }
    }
    
    public void create(Inscripcion inscripcion){
        if(inscripcion==null || !validateRequired(inscripcion)) {
            view.showError("Faltan datos requeridos");
            return;
        }
        try {
            if (!validatePK(inscripcion.getId())){
                view.showError("La cedula ingresada ya se encuentra registrada");
                return;
            }
            dao.create(mapper.toDTO(inscripcion));
            view.showMessage("Datos guardados correctamente");
        } catch (SQLException ex) {
            view.showError("Ocurrio un error al guardar los datos: "+ ex.getMessage());
        }
    }
    
    public void read(){
        
    }
    
    public void readAll(){
        try {
            List<InscripcionDTO> dtoList = dao.readAll();
            List<Inscripcion> inscripcionList = dtoList.stream()
                    .map(mapper::toEnt)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            view.showAll(inscripcionList);
        } catch (SQLException ex) {
            view.showError("Error al cargar los datos: "+ ex.getMessage());
        }
    }
    
    public void update(Inscripcion inscripcion){
        if(inscripcion==null || !validateRequired(inscripcion)) {
            view.showError("Faltan datos requeridos");
            return;
        }
        try {
            if (validatePK(inscripcion.getId())){
                view.showError("La cedula ingresada no se encuentra registrada");
                return;
            }
            dao.update(mapper.toDTO(inscripcion));
        } catch (SQLException ex) {
            view.showError("Ocurrio un error al actualizar los datos: "+ ex.getMessage());
        }
    }
    
    public void delete(Inscripcion inscripcion){
        if(inscripcion==null || !validateRequired(inscripcion)) {
            view.showError("No hay ningun cliente cargado actualmente");
            return;
        }
        try {
            if (validatePK(inscripcion.getId())){
                view.showError("La cedula ingresada no ya se encuentra registrada");
                return;
            }
            dao.delete(inscripcion.getId());
        } catch (SQLException ex) {
            view.showError("Ocurrio un error al eliminar los datos: "+ ex.getMessage());
        }
    }
    

    
    public static boolean validateFkTaller(Object id) throws SQLException {
        return new TallerDAO(Database.getConnection()).read(id) != null;
    }

    public static boolean validateFkParticipante(Object id) throws SQLException {
        return new ParticipanteDAO(Database.getConnection()).read(id) != null;
    }
    
    
    
    
    
    public boolean validateRequired(Inscripcion inscripcion) {
        return false;
    }

    public boolean validatePK(String id) {
        return false;
    }
}
