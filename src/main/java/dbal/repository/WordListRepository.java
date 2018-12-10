package dbal.repository;

import models.WordList;

public class WordListRepository extends AbstractRepository<WordList, Integer> {
        @Override
        public Class<WordList> getDomainClass() {
            return WordList.class;
        }
}

