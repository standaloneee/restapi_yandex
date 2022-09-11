package ru.stand.contest.restapi_yandex.validator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.stand.contest.restapi_yandex.entity.Item;
import ru.stand.contest.restapi_yandex.handler.ValidationItemException;
import ru.stand.contest.restapi_yandex.model.SystemItemType;

import java.util.List;

@Service
@Slf4j
public class ImportsValidator {

    public static void validateItem(Item systemItem) {
        if (!SystemItemType.FOLDER.equals(systemItem.getType()) && !SystemItemType.FILE.equals(systemItem.getType())) {
            log.debug(systemItem.getType().toString());
            throw new ValidationItemException("Validation Failed");
        }
//        log.debug("validation");
        if (systemItem.getId() == null) {
            throw new ValidationItemException("Validation Failed");
        }
        if (SystemItemType.FOLDER.equals(systemItem.getType())) {
//            log.debug(systemItem.getType().toString());
//            log.debug(systemItem.getUrl());
            if (systemItem.getUrl() != null) {
                throw new ValidationItemException("Validation Failed");
            }
            if(systemItem.getSize() != null){
                throw new ValidationItemException("Validation Failed");
            }
        }
        else{
            if(systemItem.getUrl().length() > 255){
                throw new ValidationItemException("Validation Failed");
            }
            if(systemItem.getSize() <= 0 ){
                throw new ValidationItemException("Validation Failed");
            }
        }


    }

    public static void validateItems(List<Item> items) {
        for (var item :
                items) {
            if (!SystemItemType.FILE.equals(item.getType())) {
                if (items.stream().anyMatch(o -> o.getType().toString().equals("FILE") && o.getId().equals(item.getParentId()))) {
                    throw new ValidationItemException("Validation Failed");
                }
            }
            if (item.getId() == null) {
                throw new ValidationItemException("Validation Failed");
            }
            if (items.stream().anyMatch(o -> o.getId().equals(item.getId()))) {
//                if(item.getParentId() == null) break;
                throw new ValidationItemException("not u");
            }
        }
    }

}
