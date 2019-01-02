package dbal.repository;

import models.Person;

public class PersonRepository extends AbstractRepository<Person, Integer> {
        @Override
        public Class<Person> getDomainClass() {
            return Person.class;
        }
}

