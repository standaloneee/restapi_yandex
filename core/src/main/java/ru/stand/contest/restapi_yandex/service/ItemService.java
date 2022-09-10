package ru.stand.contest.restapi_yandex.service;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stand.contest.restapi_yandex.dto.SystemItemImportDto;
import ru.stand.contest.restapi_yandex.repository.DiskRepository;

@Service
@NoArgsConstructor
public class ItemService {
    private DiskRepository diskRepository;


    public ItemService(DiskRepository diskRepository){
        this.diskRepository = diskRepository;
    }

    //TODO Поменять возвращаемый тип на SystemItem

    public SystemItemImportDto setItems(SystemItemImportDto systemItem){
        return diskRepository.save(systemItem);
    }
}
