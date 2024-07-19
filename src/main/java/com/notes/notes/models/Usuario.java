    package com.notes.notes.models;


    import com.fasterxml.jackson.annotation.JsonIgnore;
    import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;

    import java.util.ArrayList;
    import java.util.List;

    @Entity
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Table(name="usuarios")

    public class Usuario {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_usuario")
        private  int idUsuario;

        @Column(name="nombre")
        private String nombre;

        @OneToMany(mappedBy = "idUsuario")
        @JsonIgnore
        private List<Notascreada> notasLista = new ArrayList<>();


    }
