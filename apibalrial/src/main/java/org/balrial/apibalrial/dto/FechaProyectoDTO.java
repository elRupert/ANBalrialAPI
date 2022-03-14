package org.balrial.apibalrial.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity
@Table(name = "proyfechas")
public class FechaProyectoDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="idProyecto")
    private int idProyecto;

    @Column(name="fecha")
    private Timestamp fecha;


}
