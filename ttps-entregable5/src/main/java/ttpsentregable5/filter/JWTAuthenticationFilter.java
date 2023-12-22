package ttpsentregable5.filter;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ttpsentregable5.service.TokenServices;

import java.security.Key;

@WebFilter(filterName = "jwt-auth-filter", urlPatterns = "*")
public class JWTAuthenticationFilter implements Filter {

	@Autowired
	private TokenServices tokenServices;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;

		// El login del usuarios es publico
		if ("/jwt/auth".equals(req.getRequestURI()) || HttpMethod.OPTIONS.matches(req.getMethod())) {
			chain.doFilter(request, response);
			return;
		}
		String token = req.getHeader(HttpHeaders.AUTHORIZATION);
		if (token == null || !TokenServices.validateToken(token)) {
			HttpServletResponse res = (HttpServletResponse) response;
			res.setStatus(HttpStatus.FORBIDDEN.value());
			
			Long userId = getUserIdFromToken(token);
	        req.setAttribute("usuarioId", userId);
			System.out.println("id de usuario: " + userId);
			return;
		}
		chain.doFilter(request, response);
	}

	
	 private Long getUserIdFromToken(String token) {
	        try {
	        	Key key = TokenServices.getKey();
	            Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
	            return Long.parseLong(claims.getSubject());
	        } catch (Exception e) {
	            // Manejar cualquier excepción que pueda ocurrir al parsear el token
	            return null; // o lanzar una excepción según tus necesidades
	        }
	    }
}