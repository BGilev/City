package ru.gilev.city.mappers;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.gilev.city.dto.CitizenDto;
import ru.gilev.city.entity.Citizen;

@Mapper(componentModel = "spring"
)
public interface CitizenMapper {


    CitizenDto entityToDto(Citizen citizen);

    Citizen dtoToEntity(CitizenDto citizenDto);
}
