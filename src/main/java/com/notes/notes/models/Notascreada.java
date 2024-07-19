package com.notes.notes.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="notascreadas")
public class Notascreada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_notas")
    private  int IdNotas;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario idUsuario;


    @Column(name = "descrioncion")
    private  String descrioncion;
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "completado")
    private boolean completado;

    @Column(name = "fecha_actualizacion")
    private Date fechaActualizacion;



}
