package com.mmutawe.projects.school.library.be.repositories;

import com.mmutawe.projects.school.library.be.entities.CampusCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(
        readOnly = true,
        timeout = 10
)
public interface CampusCardRepository extends CrudRepository<CampusCard, Long> {
}
