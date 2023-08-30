package com.sistema.examenes;

import com.sistema.examenes.entity.Rol;
import com.sistema.examenes.entity.Usuario;
import com.sistema.examenes.entity.UsuarioRol;
import com.sistema.examenes.repository.UsuarioRepository;
import com.sistema.examenes.service.UsuarioService;
import jakarta.servlet.ServletOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
//Se implementa CommandLineRunner para que se pueda ejecutar al iniciar
public class SistemaExamenesBackendApplication implements CommandLineRunner {

	@Autowired
	private UsuarioService usuarioService;

	public static void main(String[] args) {
		SpringApplication.run(SistemaExamenesBackendApplication.class, args);
	}

	//A traves de este guardamos un usuario en duro,creamos un rol y se lo asignamos al
	@Override
	public void run(String... args) throws Exception {
//		Usuario usuario = new Usuario();
//
//		usuario.setNombre("Marcel");
//		usuario.setApellido("Ovelar");
//		usuario.setUsername("fovelar");
//		usuario.setPassword("123");
//		usuario.setEmail("fovelar@gpol.una.py");
//		usuario.setTelefono("0992652352");
//		usuario.setPerfil("foto.png");
//
//		Rol rol = new Rol();
//		//El 1L indica que el numero es de tipo Long, forza.
//		rol.setRolId(1L);
//		rol.setNombre("ADMIN");
//
//		Set<UsuarioRol> usuarioRoles = new HashSet<>();
//		UsuarioRol usuarioRol = new UsuarioRol();
//		usuarioRol.setRol(rol);
//		usuarioRol.setUsuario(usuario);
//		usuarioRoles.add(usuarioRol);
//
//		Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario,usuarioRoles);
//		System.out.println(usuarioGuardado.getUsername());
	}
}
