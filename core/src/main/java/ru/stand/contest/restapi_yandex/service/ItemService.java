package ru.stand.contest.restapi_yandex.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.stand.contest.restapi_yandex.dto.SystemItemImportDto;
import ru.stand.contest.restapi_yandex.dto.SystemItemImportRequest;
import ru.stand.contest.restapi_yandex.entity.Item;
import ru.stand.contest.restapi_yandex.model.SystemItem;
import ru.stand.contest.restapi_yandex.repository.ItemRepository;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemService {
    
    private final ItemRepository itemRepository;

    @SneakyThrows
    public SystemItemImportDto setItems(SystemItemImportRequest systemItem){
        log.debug("{}", systemItem.getUpdateDate());
        Item item = new Item();
        SystemItemImportDto systemItemImportDto = systemItem.getItems().get(0);
        item.setId(systemItemImportDto.getId());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        java.util.Date date = df.parse(systemItem.getUpdateDate());
        item.setDate(new Date(date.getTime()));
        item.setSize(systemItemImportDto.getSize().get());
        item.setType(systemItemImportDto.getType());
        item.setParentId(systemItemImportDto.getParentId());
        itemRepository.save(item);

        return null;
    }

    public SystemItem getSystemItem(String id) {
        return null;
    }
}
