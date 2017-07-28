package br.com.t4k.user.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {
	
	private static final BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
	
	public static String encode(String pass){
		return passEncoder.encode(pass);
	}
	
	public static boolean isMatch(String pass, String encodedPassword){
		return passEncoder.matches(pass, encodedPassword);
	}
}
