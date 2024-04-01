package com.asegurados.api.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "asegurado")
public class Asegurado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "numero_identificacion", unique = true)
    private Integer numeroIdentificacion;

    private String nombre;

    private String apellido;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @ManyToOne
    @JoinColumn(name = "id_tipo_documento_pk")
    private TipoDocumento tipoDocumento;

    @ManyToOne
    @JoinColumn(name = "id_sexo_pk")
    private Sexo sexo;


}