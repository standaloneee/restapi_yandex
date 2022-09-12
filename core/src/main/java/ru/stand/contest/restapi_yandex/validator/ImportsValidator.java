package ru.stand.contest.restapi_yandex.validator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.expression.spel.ast.BooleanLiteral;
import org.springframework.stereotype.Service;
import ru.stand.contest.restapi_yandex.entity.Item;
import ru.stand.contest.restapi_yandex.handler.ValidationItemException;
import ru.stand.contest.restapi_yandex.model.SystemItemType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class ImportsValidator {
    Set<Item> itemSet = new HashSet<>();
    boolean firstElem = false;

    public void validateItem(Item systemItem) {

        if (SystemItemType.FOLDER.equals(systemItem.getType())) {
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
        if(!firstElem){
            itemSet.add(systemItem);
            firstElem = true;
        }
        else{
            for (var item:
                 itemSet) {
                if(item.getId().equals(systemItem.getId())){
                    throw new ValidationItemException("not unique id");
            }}
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
                if(item.getParentId() == null) break;
                throw new ValidationItemException("not u");
            }
        }
    }

}
