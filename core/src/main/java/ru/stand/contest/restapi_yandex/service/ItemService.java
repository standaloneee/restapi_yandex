package ru.stand.contest.restapi_yandex.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.stand.contest.restapi_yandex.dto.SystemItemImportDto;
import ru.stand.contest.restapi_yandex.dto.SystemItemImportRequest;
import ru.stand.contest.restapi_yandex.entity.Item;
import ru.stand.contest.restapi_yandex.mapper.ItemMapper;
import ru.stand.contest.restapi_yandex.model.SystemItem;
import ru.stand.contest.restapi_yandex.repository.ItemRepository;
import ru.stand.contest.restapi_yandex.validator.ImportsValidator;

import javax.transaction.Transactional;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemService {

    private final ItemRepository itemRepository;

    @SneakyThrows
    @Transactional()
    public SystemItemImportDto setItems(List<SystemItemImportRequest> systemItem) throws Error {
        ImportsValidator checkValidItem= new ImportsValidator();
        log.debug("123");
//        ImportsValidator.validateFile(systemItem);
        List<Item> itemsList = new ArrayList<>();
        for (SystemItemImportRequest request : systemItem) {
            itemsList.addAll(request.getItems().stream()
                    .map(item -> ItemMapper.INSTANCE.toEntity(item, new Date(request.getUpdateDate().getTime())))
                    .peek(item -> checkValidItem.validateItem(item))
                    .collect(Collectors.toList()));
        }

//        ImportsValidator.validateItems(itemsList);

        return null;
    }

    public ResponseEntity<SystemItem> getSystemItem(String id) {
        Optional<Item> optionalItem = itemRepository.findById(UUID.fromString(id));
        return optionalItem
                .map(item -> ResponseEntity.ok(ItemMapper.INSTANCE.toDto(item)))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
