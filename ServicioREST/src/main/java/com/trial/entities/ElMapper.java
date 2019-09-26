package com.trial.entities;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface ElMapper {
    //    Propietario cochePersona(Coche coche,Persona persona);
    @Mappings({
            @Mapping(target = "nombreMarca", source = "coche.marca"),
            @Mapping(target = "ncaballos", source = "coche.caballos"),
            @Mapping(target = "npuertas", source = "coche.puertas")
    })
    CocheDTO cocheToDTO(Coche coche);

    @Mappings({
            @Mapping(target = "marca", source = "dto.nombreMarca"),
            @Mapping(target = "caballos", source = "dto.ncaballos"),
            @Mapping(target = "puertas", source = "dto.npuertas")
    })
    Coche DTOtoCoche(CocheDTO dto);
}

