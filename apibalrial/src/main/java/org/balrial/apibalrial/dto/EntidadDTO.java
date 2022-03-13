package org.balrial.apibalrial.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class EntidadDTO implements Serializable {

    private Integer id;
    private String nombre;

}
