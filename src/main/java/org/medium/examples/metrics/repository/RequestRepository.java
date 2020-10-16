package org.medium.examples.metrics.repository;

import org.medium.examples.metrics.entity.Request;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends CrudRepository<Request,Integer> {

    Request getRequestById(int id);


}
