package ru.stand.contest.restapi_yandex.validator;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import ru.stand.contest.restapi_yandex.dto.SystemItemImportDto;
import ru.stand.contest.restapi_yandex.dto.SystemItemImportRequest;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImportsValidator {
    @JsonProperty("items")
    public static void validateFile(SystemItemImportRequest systemItem) {

    }

    public void validateFoler(SystemItemImportRequest systemItem) {

    }
}
