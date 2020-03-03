package com.toulan.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @Author LOL_toulan
 * @Time 2020/3/1 19:46
 * @Message
 */
public class BCryptPasswordEncoderUtils {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();




    public static String encodeString(String password) {
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String saltPassword = encodeString("ssmoa");

        //$2a$10$3xBtVCIQQlDtdOJJcQP6q.G/g9O8nhwTv1miZn7he21quN1fEsM1u 123
        //$2a$10$OdPLKiNrl2GBctDRwSKhcu9EqHyF/VKjqLbaL1YkJANt2zsDhDVCq admin
        //$2a$10$Znydv8aolFQl0FtlqKMU1OTajva2AqoPw.uj5Kn2TNfe6/ESsZe2u user
        System.out.println(saltPassword);



    }

}
