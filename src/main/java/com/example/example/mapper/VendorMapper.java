package com.example.example.mapper;

import com.example.example.config.MapperConfiguration;
import com.example.example.domain.VendorEntity;
import com.example.example.model.VendorDto;
import org.mapstruct.*;

@Mapper(config = MapperConfiguration.class)
public interface VendorMapper {


    VendorEntity toEntity(VendorDto dto);

    VendorDto toDto(VendorEntity entity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "code", source = "code", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "name", source = "name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "webhook", source = "webhook", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "legalEntity", source = "legalEntity", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(@MappingTarget VendorEntity entity, VendorDto dto);
}
