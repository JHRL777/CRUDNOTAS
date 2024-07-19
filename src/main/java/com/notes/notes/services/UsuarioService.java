package com.notes.notes.services;

import com.notes.notes.models.Usuario;
import com.notes.notes.repositorys.RepositoryUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private RepositoryUsuarios repositoryUsuarios;

    public List<Usuario> TodosUsuario(){
        return (List<Usuario>) repositoryUsuarios.findAll();
    }

    public Optional<Usuario> usuarioId(Integer id){
        return repositoryUsuarios.findById(id);

    }

}
