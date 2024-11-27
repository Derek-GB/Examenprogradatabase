/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Taller;

import Modelo.Mapper.Mapper;
import Utils.UtilDate;

/**
 *
 * @author DYLAN
 */
public class TallerMapper implements Mapper<Taller,TallerDTO>{

    @Override
    public TallerDTO toDTO(Taller ent) {
        return new TallerDTO(
                ent.getId(),
                ent.getNombre(),
                UtilDate.toSqlDate(ent.getFecha()),
                ent.getLugar(),
                ent.getCapacidad()
        );
    }

    @Override
    public Taller toEnt(TallerDTO dto) {
        return new Taller(
                dto.getId(),
                dto.getNombre(),
                UtilDate.toLocalDate(dto.getFecha()),
                dto.getLugar(),
                dto.getCapacidad()
        );
    }
    
}
