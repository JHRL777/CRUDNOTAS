package com.notes.notes.controllers;

import com.notes.notes.controllers.dto.UsuarioDto;
import com.notes.notes.models.Notascreada;
import com.notes.notes.models.Usuario;
import com.notes.notes.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class Usuarios {

    @Autowired
    private UsuarioService usuarioService;



    @GetMapping("/usuario")
    public ResponseEntity<?> usuarios(){
        List<Usuario> usuario =  usuarioService.TodosUsuario();
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE,"application/json")
                .body(usuario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> usuarioId(@PathVariable Integer id){

        Optional<Usuario> usuario = usuarioService.usuarioId(id);
        List<Notascreada> notasLista = usuario.get().getNotasLista();

        // Convert Usuario to UsuarioDTO
        UsuarioDto usuarioDTO = new UsuarioDto();
        // Convert Usuario to UsuarioDTO
        usuarioDTO.setIdUsuario(usuario.get().getIdUsuario());
        usuarioDTO.setNombre(usuario.get().getNombre());
        usuarioDTO.setNotasLista(notasLista); // Set notasLista in DTO

        return ResponseEntity.ok(usuarioDTO); // Return DTO for JSON serialization
         // Set notasLista in DTO


       /* if (validarid.isPresent()) {
            return ResponseEntity.ok(validarid.get());
        } else {
            return ResponseEntity.status(404).body("Usuario no existe");
        }

        */



    }
}
