package dbal.repository;

import models.Result;

public class ResultRepository extends AbstractRepository<Result, Integer> {
        @Override
        public Class<Result> getDomainClass() {
            return Result.class;
        }
}

