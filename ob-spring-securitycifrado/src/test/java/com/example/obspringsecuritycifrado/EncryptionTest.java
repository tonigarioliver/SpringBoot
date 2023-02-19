package com.example.obspringsecuritycifrado;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.*;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

public class EncryptionTest {
    @Test
    void bcryptest(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword =passwordEncoder.encode("admin");
        System.out.println(hashedPassword);
        boolean matches=passwordEncoder.matches("admin",hashedPassword);
        System.out.println(matches);
    }
    @Test
    void bycryptCheckMultiplePassword(){
        BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
        for(int i =0;i<30;i++){
            System.out.println(passwordEncoder.encode("main"));
        }
    }
    /*
    @Test
    void pbkdf2() {
        Pbkdf2PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder();
        for (int i = 0; i < 30; i++)
            System.out.println(passwordEncoder.encode("admin"));
    }

    @Test
    void argon() {
        Argon2PasswordEncoder passwordEncoder = new Argon2PasswordEncoder();
        for (int i = 0; i < 30; i++)
            System.out.println(passwordEncoder.encode("admin"));
    }

    @Test
    void scrypt() {
        SCryptPasswordEncoder passwordEncoder = new SCryptPasswordEncoder();
        for (int i = 0; i < 30; i++)
            System.out.println(passwordEncoder.encode("admin"));
    }*/


    @Test
    void springPasswordEncoders(){

        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put("bcrypt", new BCryptPasswordEncoder());
        /*encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
        encoders.put("argon2", new Argon2PasswordEncoder());
        encoders.put("scrypt", new SCryptPasswordEncoder());*/
        // no seguro:
        encoders.put("noop", NoOpPasswordEncoder.getInstance());
        encoders.put("sha256", new StandardPasswordEncoder());

        PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("bcrypt", encoders);

        String hashedPassword = passwordEncoder.encode("admin");
        System.out.println(hashedPassword);

    }
}
