package ru.stand.contest.restapi_yandex.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stand.contest.restapi_yandex.dto.SystemItemImportDto;
import ru.stand.contest.restapi_yandex.repository.ItemRepository;

@Service
@RequiredArgsConstructor
public class ItemService {
    
    private final ItemRepository itemRepository;

    public SystemItemImportDto setItems(SystemItemImportDto systemItem){
        return null;
    }
}
