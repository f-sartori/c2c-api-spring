package com.generation.c2cspring.model.security;

import javax.xml.bind.DatatypeConverter;

import com.generation.c2cspring.entities.Usuario;
import com.generation.c2cspring.entities.Vendedor;



public class Auth {
	private static final String PREFIXO="*C2C|";
	
	public static String generateToken(Usuario usuario) {
		String token = PREFIXO+usuario.toString();
		token = DatatypeConverter.printHexBinary(token.getBytes());
		return token;
	}
	public static String generateTokenVendedor(Vendedor vendedor) {
		String token = PREFIXO+vendedor.toString();
		token = DatatypeConverter.printHexBinary(token.getBytes());
		return token;
	}
	public static boolean isValid(String token) {
		byte[] vetor = DatatypeConverter.parseHexBinary(token);
		String credencial = new String(vetor);
		if(credencial.startsWith(PREFIXO)) {
			return true;
		}
		return false;
	}
	

}
