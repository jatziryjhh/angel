package utez.edu.mx.unidad3.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

    public static String encondePassword(String rawPassword){
        return new BCryptPasswordEncoder().encode(rawPassword);
    }


    public static boolean verifyPassword(String rawPassword, String encodedPassword) {
        return new BCryptPasswordEncoder().matches(rawPassword, encodedPassword);
    }
}
