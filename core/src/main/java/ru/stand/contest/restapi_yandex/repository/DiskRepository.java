package ru.stand.contest.restapi_yandex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.stand.contest.restapi_yandex.dto.SystemItemImportDto;

import java.util.UUID;

//TODO Поменять на SystemItem
@Repository
public interface DiskRepository extends JpaRepository<SystemItemImportDto, UUID> {
}
