package org.balrial.apibalrial.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class TestDTO {

    private String string;
    private Integer integer;
    private LocalDateTime dateTime;
    private LocalDate date;
    private LocalTime time;
    private BigDecimal latitud;
    private BigDecimal longitud;
    private Boolean bool;

}
