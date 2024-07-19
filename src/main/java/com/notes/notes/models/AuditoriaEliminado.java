package com.notes.notes.models;


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
@Table(name="auditoria_eliminado")
public class AuditoriaEliminado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id ;
    @Column(name = "id_usuario")
    private int idUsuario;
    @Column(name = "descrioncion")
    private String descrioncion;
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;
    @Column(name = "fecha_eliminacion")
    private Date fechaEliminacion;
    @Column(name = "usuarii_elimino")
    private String usuariiElimino;


}
