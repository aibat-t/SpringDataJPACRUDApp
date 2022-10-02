package kz.aibat.springcourse.dao;

import kz.aibat.springcourse.models.Person;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class PersonDAO {

    private final EntityManager entityManager;

    public PersonDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional(readOnly = true)
    public void testNplus1() {
        Session session = entityManager.unwrap(Session.class);

//        //N + 1 проблема
//        //1 Запрос
//        List<Person> people = session.createQuery("select p from Person p", Person.class).getResultList();
//
//        //N запросы к БД
//        for(Person person: people)
//            System.out.println(person.getItemList());

        //Solution
        //SQL: A LEFT JOIN B -> результирующая объединенная таблица
        //Hashset что бы убрать дупликаты
        Set<Person> people = new HashSet<>( session.createQuery("select p from Person p left join fetch p.itemList", Person.class).getResultList());

        for(Person person: people)
            System.out.println(person.getItemList());
    }
}
