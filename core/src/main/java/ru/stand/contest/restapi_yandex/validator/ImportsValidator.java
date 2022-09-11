package ru.stand.contest.restapi_yandex.validator;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openapitools.jackson.nullable.JsonNullable;
import org.springframework.stereotype.Service;
import ru.stand.contest.restapi_yandex.dto.SystemItemImportDto;
import ru.stand.contest.restapi_yandex.dto.SystemItemImportRequest;
import ru.stand.contest.restapi_yandex.entity.Item;
import ru.stand.contest.restapi_yandex.interfaces.EnumNamePattern;
import ru.stand.contest.restapi_yandex.model.SystemItemType;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ImportsValidator {

    public static void validateItem(Item systemItem) {
        if (systemItem.getType().toString() != "FOLDER" && systemItem.getType().toString() != "FILE") {
//            log.debug(systemItem.getType().toString());
            throw new Error("unknown type");
        }
        log.debug("validation");
        if (systemItem.getId() == null) {
            throw new Error("id cannot be null");
        }
        if (systemItem.getType().toString() == "FOLDER") {
//            log.debug(systemItem.getType().toString());
//            log.debug(systemItem.getUrl());
            if (systemItem.getUrl() != null) {
                throw new Error("url is not null for folder");
            }
        }


    }

    public static void validateItems(List<Item> items) {
        for (var item :
                items) {
            if (item.getType().toString() == "FILE") {
                if (items.stream().anyMatch(o -> o.getType().toString().equals("FILE") && o.getId().equals(item.getParentId()))) {
                    throw new Error("parentId mismatch");
                }
            }
            if (item.getId() == null) {
                throw new Error("id is null");
            }
            if (items.stream().anyMatch(o -> o.getId().equals(item.getId()))) {
                if(item.getParentId() == null) break;
                throw new Error("not unique id");
            }
        }
    }

}
