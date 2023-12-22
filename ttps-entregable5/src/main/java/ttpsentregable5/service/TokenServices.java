package ttpsentregable5.service;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import ttpsentregable5.model.Usuario;
import ttpsentregable5.repository.UsuarioRepository;

@Service
public class TokenServices {
	final static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public static Key getKey() {
        return key;
    }
	
	
	/**
	 * Genera el token de authorizacion para el usuario
	 *
	 * @param username Username que se guarda dentro del token
	 * @param segundos tiempo de validez del token
	 * @return token
	 */
	public String generateToken(String username, int segundos) {
		Date exp = getExpiration(new Date(), segundos);
		Usuario usu = usuarioRepository.recuperarPorNombreUsuario(username);
		return Jwts.builder().setSubject( String.valueOf(usu.getId()) ).signWith(key).setExpiration(exp).compact();
	}

	private Date getExpiration(Date date, int segundos) {
		return new Date(System.currentTimeMillis() + segundos * 1000L);
	}

	public static boolean validateToken(String token) {
		String prefix = "Bearer";
		try {
			if (token.startsWith(prefix)) {
				token = token.substring(prefix.length()).trim();
			}
			Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
			System.out.println("Subject: " + claims.getSubject());
			System.out.println("Expiration: " + claims.getExpiration());
			return true;
		} catch (ExpiredJwtException exp) {
			return false;
		} catch (JwtException e) {
			return false; // Algo salio mal en la verificacion
		}
	}

}
