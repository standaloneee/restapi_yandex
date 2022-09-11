package ru.stand.contest.restapi_yandex.mapper;

import org.mapstruct.Context;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.stand.contest.restapi_yandex.dto.SystemItemImportDto;
import ru.stand.contest.restapi_yandex.entity.Item;

import java.sql.Date;

@Mapper(
        componentModel = "spring",
        injectionStrategy = InjectionStrategy.FIELD,
        imports = {Date.class}
)
public abstract class ItemMapper {

    public static final ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

    @Mapping(target = "date", expression = "java(date)")
    @Mapping(target = "url", expression = "java(systemItem.getUrl())")
    @Mapping(target = "size", expression = "java(systemItem.getSize())")
    public abstract Item toEntity(SystemItemImportDto systemItem, @Context Date date);


}
