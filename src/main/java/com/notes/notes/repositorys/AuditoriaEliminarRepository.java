package com.notes.notes.repositorys;

import com.notes.notes.models.AuditoriaEliminado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriaEliminarRepository extends CrudRepository<AuditoriaEliminado, Integer> {
}
