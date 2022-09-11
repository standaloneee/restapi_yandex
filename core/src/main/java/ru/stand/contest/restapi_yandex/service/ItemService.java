package ru.stand.contest.restapi_yandex.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.stand.contest.restapi_yandex.dto.SystemItemImportDto;
import ru.stand.contest.restapi_yandex.dto.SystemItemImportRequest;
import ru.stand.contest.restapi_yandex.entity.Item;
import ru.stand.contest.restapi_yandex.mapper.ItemMapper;
import ru.stand.contest.restapi_yandex.model.SystemItem;
import ru.stand.contest.restapi_yandex.repository.ItemRepository;
import ru.stand.contest.restapi_yandex.validator.ImportsValidator;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemService {

    private final ItemRepository itemRepository;

    @SneakyThrows
    @Transactional()
    public SystemItemImportDto setItems(List<SystemItemImportRequest> systemItem) throws Error {
        log.debug("123");
//        ImportsValidator.validateFile(systemItem);
        List<Item> itemsList = new ArrayList<>();
        for (SystemItemImportRequest request : systemItem) {
            itemsList.addAll(request.getItems().stream()
                    .map(item -> ItemMapper.INSTANCE.toEntity(item, new Date(request.getUpdateDate().getTime())))
                    .peek(item -> ImportsValidator.validateItem(item))
                    .collect(Collectors.toList()));
        }
        ImportsValidator.validateItems(itemsList);
//        ImportsValidator.validateFile(systemItem.stream()
//                .flatMap(o->o.getItems()
//                        .stream().map(o1-> new SystemItemImportDto(o1.getId(), o1.getUrl(), o1.getParentId(), o1.getType(), o1.getSize()))).collect(Collectors.toList()));
//        log.debug("{}", systemItem.getUpdateDate());
//        Item item = new Item();
//        SystemItemImportDto systemItemImportDto = systemItem.getItems().get(0);
//        item.setId(systemItemImportDto.getId());
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
//        java.util.Date date = df.parse(systemItem.getUpdateDate());
//        item.setDate(new Date(date.getTime()));
//        item.setSize(systemItemImportDto.getSize().get());
//        item.setType(systemItemImportDto.getType());
//        item.setParentId(systemItemImportDto.getParentId());
//        itemRepository.save(item);

        return null;
    }

    public SystemItem getSystemItem(String id) {
        return null;
    }
}
