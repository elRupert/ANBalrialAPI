package org.balrial.apibalrial.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GenerarPassword {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String passwordDec = "prueba";
        String passwordEnc = encoder.encode(passwordDec);
        System.out.println(passwordEnc);
    }
}
