package com.audora.security;

import java.io.IOException;
import java.security.SignatureException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Jwts;

public class TokenFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		String header = req.getHeader("Autorizacao");
		
		if(header ==null || !header.startsWith("Bearer")){
			
			throw new ServletException("Token inválido");
		}
		
		String token = header.substring(7);
		
		try{
			
			Jwts.parser().setSigningKey("TESTE").parseClaimsJws(token).getBody();
		}catch (Exception e) {
			throw new ServletException("Token inválido");
		}
		
		chain.doFilter(request, response);
			
	
	}
		
	}


