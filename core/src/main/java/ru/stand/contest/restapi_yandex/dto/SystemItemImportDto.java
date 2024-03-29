package ru.stand.contest.restapi_yandex.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.UUID;

import org.openapitools.jackson.nullable.JsonNullable;
import ru.stand.contest.restapi_yandex.model.SystemItemType;

import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import javax.annotation.Generated;

/**
 * SystemItemImport
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-09-09T13:45:12.975114900+03:00[Europe/Moscow]")
public class SystemItemImportDto {

  @JsonProperty("id")
  private UUID id;

  @JsonProperty("url")
  private JsonNullable<String> url = JsonNullable.undefined();

  @JsonProperty("parentId")
  private UUID parentId;

  @JsonProperty("type")
  private SystemItemType type;

  @JsonProperty("size")
  private Long size;

//  public SystemItemImportDto id(String id) {
//    this.id = id;
//    return this;
//  }
//
//  /**
//   * Уникальный идентфикатор
//   * @return id
//  */
//  @NotNull
//  @Schema(name = "id", example = "элемент_1_1", description = "Уникальный идентфикатор", required = true)
//  public String getId() {
//    return id;
//  }
//
//  public void setId(String id) {
//    this.id = id;
//  }
//
//  public SystemItemImportDto url(String url) {
//    this.url = JsonNullable.of(url);
//    return this;
//  }
//
//  /**
//   * Ссылка на файл. Для папок поле равнно null.
//   * @return url
//  */
//
//  @Schema(name = "url", description = "Ссылка на файл. Для папок поле равнно null.", required = false)
//  public JsonNullable<String> getUrl() {
//    return url;
//  }
//
//  public void setUrl(JsonNullable<String> url) {
//    this.url = url;
//  }
//
//  public SystemItemImportDto parentId(String parentId) {
//    this.parentId = JsonNullable.of(parentId);
//    return this;
//  }
//
//  /**
//   * id родительской папки
//   * @return parentId
//  */
//
//  @Schema(name = "parentId", example = "элемент_1_1", description = "id родительской папки", required = false)
//  public JsonNullable<String> getParentId() {
//    return parentId;
//  }
//
//  public void setParentId(JsonNullable<String> parentId) {
//    this.parentId = parentId;
//  }
//
//  public SystemItemImportDto type(SystemItemType type) {
//    this.type = type;
//    return this;
//  }
//
//  /**
//   * Get type
//   * @return type
//  */
//  @NotNull @Valid
//  @Schema(name = "type", required = true)
//  public SystemItemType getType() {
//    return type;
//  }
//
//  public void setType(SystemItemType type) {
//    this.type = type;
//  }
//
//  public SystemItemImportDto size(Long size) {
//    this.size = JsonNullable.of(size);
//    return this;
//  }
//
//  /**
//   * Целое число, для папок поле должно содержать null.
//   * @return size
//  */
//
//  @Schema(name = "size", description = "Целое число, для папок поле должно содержать null.", required = false)
//  public JsonNullable<Long> getSize() {
//    return size;
//  }
//
//  public void setSize(JsonNullable<Long> size) {
//    this.size = size;
//  }
//
//  @Override
//  public boolean equals(Object o) {
//    if (this == o) {
//      return true;
//    }
//    if (o == null || getClass() != o.getClass()) {
//      return false;
//    }
//    SystemItemImportDto systemItemImportDto = (SystemItemImportDto) o;
//    return Objects.equals(this.id, systemItemImportDto.id) &&
//        Objects.equals(this.url, systemItemImportDto.url) &&
//        Objects.equals(this.parentId, systemItemImportDto.parentId) &&
//        Objects.equals(this.type, systemItemImportDto.type) &&
//        Objects.equals(this.size, systemItemImportDto.size);
//  }
//
//  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
//    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
//  }
//
//  @Override
//  public int hashCode() {
//    return Objects.hash(id, url, parentId, type, size);
//  }
//
//  private static <T> int hashCodeNullable(JsonNullable<T> a) {
//    if (a == null) {
//      return 1;
//    }
//    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
//  }
//
//  @Override
//  public String toString() {
//    StringBuilder sb = new StringBuilder();
//    sb.append("class SystemItemImport {\n");
//    sb.append("    id: ").append(toIndentedString(id)).append("\n");
//    sb.append("    url: ").append(toIndentedString(url)).append("\n");
//    sb.append("    parentId: ").append(toIndentedString(parentId)).append("\n");
//    sb.append("    type: ").append(toIndentedString(type)).append("\n");
//    sb.append("    size: ").append(toIndentedString(size)).append("\n");
//    sb.append("}");
//    return sb.toString();
//  }
//
//  /**
//   * Convert the given object to string with each line indented by 4 spaces
//   * (except the first line).
//   */
//  private String toIndentedString(Object o) {
//    if (o == null) {
//      return "null";
//    }
//    return o.toString().replace("\n", "\n    ");
//  }
}

