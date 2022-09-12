/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.0.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package ru.stand.contest.restapi_yandex.controller;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import ru.stand.contest.restapi_yandex.model.Error;
import ru.stand.contest.restapi_yandex.model.SystemItemHistoryResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-09T13:45:12.975114900+03:00[Europe/Moscow]")
@Validated
@Tag(name = "node", description = "the node API")
public interface NodeApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /node/{id}/history
     * Получение истории обновлений по элементу за заданный полуинтервал [from, to). История по удаленным элементам недоступна.  - размер папки - это суммарный размер всех её элементов - можно получить статистику за всё время. 
     *
     * @param id id элемента для которого будет отображаться история (required)
     * @param dateStart Дата и время начала интервала, для которого считается история. Дата должна обрабатываться согласно ISO 8601 (такой придерживается OpenAPI). Если дата не удовлетворяет данному формату, необходимо отвечать 400. (optional)
     * @param dateEnd Дата и время конца интервала, для которого считается история. Дата должна обрабатываться согласно ISO 8601 (такой придерживается OpenAPI). Если дата не удовлетворяет данному формату, необходимо отвечать 400. (optional)
     * @return История по элементу. (status code 200)
     *         or Некорректный формат запроса или некорректные даты интервала. (status code 400)
     *         or Элемент не найден. (status code 404)
     */
    @Operation(
        operationId = "nodeIdHistoryGet",
        tags = { "Дополнительные задачи" },
        responses = {
            @ApiResponse(responseCode = "200", description = "История по элементу.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = SystemItemHistoryResponse.class))
            }),
            @ApiResponse(responseCode = "400", description = "Некорректный формат запроса или некорректные даты интервала.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            }),
            @ApiResponse(responseCode = "404", description = "Элемент не найден.", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/node/{id}/history",
        produces = { "application/json" }
    )
    default ResponseEntity<SystemItemHistoryResponse> nodeIdHistoryGet(
        @Parameter(name = "id", description = "id элемента для которого будет отображаться история", required = true) @PathVariable("id") String id,
        @Parameter(name = "dateStart", description = "Дата и время начала интервала, для которого считается история. Дата должна обрабатываться согласно ISO 8601 (такой придерживается OpenAPI). Если дата не удовлетворяет данному формату, необходимо отвечать 400.") @Valid @RequestParam(value = "dateStart", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date dateStart,
        @Parameter(name = "dateEnd", description = "Дата и время конца интервала, для которого считается история. Дата должна обрабатываться согласно ISO 8601 (такой придерживается OpenAPI). Если дата не удовлетворяет данному формату, необходимо отвечать 400.") @Valid @RequestParam(value = "dateEnd", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date dateEnd
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"items\" : [ { \"id\" : \"элемент_1_4\"," +
                            " \"url\" : \"/file/url1\"," +
                            " \"date\" : \"2022-05-28T21:12:01.000Z\"," +
                            " \"parentId\" : \"элемент_1_1\"," +
                            " \"size\" : 234, \"type\" : \"FILE\" }," +
                            " { \"id\" : \"элемент_1_4\", \"url\" : \"/file/url1\"," +
                            " \"date\" : \"2022-05-28T21:12:01.000Z\", " +
                            "\"parentId\" : \"элемент_1_1\", \"size\" : 234," +
                            " \"type\" : \"FILE\" } ] }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
