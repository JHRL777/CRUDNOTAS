package com.notes.notes.repositorys;

import com.notes.notes.models.Notascreada;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotasCreadasRepository extends CrudRepository<Notascreada, Integer> {

}
