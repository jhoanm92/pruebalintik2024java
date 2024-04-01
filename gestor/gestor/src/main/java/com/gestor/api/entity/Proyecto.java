package com.gestor.api.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "proyecto")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String descripcion;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tarea_proyecto",
            joinColumns = @JoinColumn(name = "id_proyecto_fk", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_tarea_fk", referencedColumnName = "id"))
    private List<Tarea> tarea;

}