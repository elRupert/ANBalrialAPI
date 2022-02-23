package org.balrial.apibalrial.service;

import org.balrial.apibalrial.dto.TestDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TestService {

    public TestDTO mockTest() throws ParseException {

        TestDTO testDTO = new TestDTO();
        testDTO.setString("Cadena");
        testDTO.setInteger(1);
        testDTO.setLatitud(new BigDecimal(43.3797138).setScale(8, RoundingMode.CEILING));
        testDTO.setLongitud(new BigDecimal(-8.343728).setScale(8, RoundingMode.CEILING));
        testDTO.setBool(true);

        DateTimeFormatter fdt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime dt = LocalDateTime.parse("01/02/2022 14:30", fdt);
        testDTO.setDateTime(dt);
        testDTO.setTime(dt.toLocalTime());
        testDTO.setDate(dt.toLocalDate());

        return testDTO;
    }
}
