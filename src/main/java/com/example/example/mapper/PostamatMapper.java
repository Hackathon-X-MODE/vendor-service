package com.example.example.mapper;

import com.example.example.config.MapperConfiguration;
import com.example.example.domain.PostamatEntity;
import com.example.example.model.PostamatDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(config = MapperConfiguration.class)
public interface PostamatMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "vendor", ignore = true)
    PostamatEntity toEntity(PostamatDto postamatDto);


    @Mapping(target = "vendorId", source = "vendor.id")
    PostamatDto toDto(PostamatEntity postamatEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "vendor", ignore = true)
    @Mapping(target = "externalId", source = "externalId", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "location", source = "location", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "size", source = "size", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "lastDateActivity", source = "lastDateActivity", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "videoLink", source = "videoLink", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "postamatInit", source = "postamatInit", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(@MappingTarget PostamatEntity postamatEntity, PostamatDto postamatDto);
}
