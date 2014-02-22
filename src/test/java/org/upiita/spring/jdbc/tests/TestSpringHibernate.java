package org.upiita.spring.jdbc.tests;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.upiita.spring.jdbc.daos.UsuarioDAO;
import org.upiita.spring.jdbc.entidades.Usuario;

public class TestSpringHibernate {

	public static void main(String[] args) {
		//creamos el contexto de Spring
		ApplicationContext contexto = new ClassPathXmlApplicationContext("/contexto.xml");
		//nos traemos el bean HibernateUsuarioDAO
		UsuarioDAO usuarioDAO = (UsuarioDAO)contexto.getBean("usuarioDAO");
		Usuario usuario = new Usuario();
		usuario.setUsuarioId(3);
		usuario.setNombre("Zayra Rosquero Perez");
		usuario.setEmail("cazrp24@gmail.com");
		usuario.setPassword("123");
		usuarioDAO.creaUsuario(usuario);
		
		usuario.setPassword("1234");
		usuarioDAO.creaUsuario(usuario);
		
		System.out.println("datos guardados");
		Usuario usuarioBD = usuarioDAO.buscaUsuarioPorId(3);
		System.out.println("El usuario encontrado es: "+usuarioBD); 
		
		//Probando el usuario criterior
		Usuario usuarioCriterio = usuarioDAO.buscaPoremailYPassword("cazrp24@gmail.com","123");
		System.out.println("El usuario por email y password es: "+usuarioCriterio); 
		
		//Prueba del criterio like
	    List<Usuario> lstUsuarios=usuarioDAO.buscaPorNombre("Perez");
		System.out.println("Lista de resultados: "+lstUsuarios);
		
	}

}
