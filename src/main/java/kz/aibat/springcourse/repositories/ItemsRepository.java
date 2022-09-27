package kz.aibat.springcourse.repositories;

import kz.aibat.springcourse.models.Item;
import kz.aibat.springcourse.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemsRepository extends JpaRepository<Item, Integer> {
    List<Item> findByOwner(Person owner);

    List<Item> findByItemName(String itemName);
}
