package com.notes.notes.repositorys;

import com.notes.notes.models.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUsuarios extends CrudRepository<Usuario,Integer> {
}
