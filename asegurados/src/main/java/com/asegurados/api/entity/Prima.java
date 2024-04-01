package com.asegurados.api.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "prima")
public class Prima {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "edad_minima")
    private Integer edadMinima;

    @Column(name = "edad_maxima")
    private Integer edadMaxima;

    private Double porcentaje;

    @ManyToOne
    @JoinColumn(name = "id_amparo_pk", referencedColumnName = "id")
    private Amparo codigoAmparo;

}