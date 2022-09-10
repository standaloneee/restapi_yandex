package ru.stand.contest.restapi_yandex.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.stand.contest.restapi_yandex.dto.SystemItemImportDto;
import ru.stand.contest.restapi_yandex.service.ItemService;

import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-09T13:45:12.975114900+03:00[Europe/Moscow]")
@RestController
@RequestMapping("")
public class ImportsApiController implements ImportsApi {

    private ItemService itemService;
    public ImportsApiController(ItemService itemService) throws Error{
        this.itemService = itemService;
    }

    @PostMapping("/imports")
    public ResponseEntity<SystemItemImportDto> setItems(@RequestBody SystemItemImportDto systemItem) {
       return new ResponseEntity<>(itemService.setItems(systemItem), HttpStatus.CREATED) ;
    }



}
