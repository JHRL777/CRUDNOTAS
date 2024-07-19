package com.notes.notes.controllers.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.notes.notes.models.Notascreada;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsuarioDto {
    private  int idUsuario;


    private String nombre;


    private List<Notascreada> notasLista = new ArrayList<>();

}
