package ru.stand.contest.restapi_yandex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.stand.contest.restapi_yandex.entity.Item;

import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {
Item getItemById(UUID id);

}
