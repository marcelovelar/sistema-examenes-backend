package com.sistema.examenes.service;

import com.sistema.examenes.entity.Usuario;
import com.sistema.examenes.entity.UsuarioRol;
import com.sistema.examenes.repository.RolRepository;
import com.sistema.examenes.repository.UsuarioRepository;
import com.sistema.examenes.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.Set;

// Por que implementa UsuarioService?
// Que hace la anotacion @Service
// Que es la inyeccion de dependencias
@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
        //Obtenemos el Username y guardamo en usuarioLocal
        Usuario usuarioLocal = usuarioRepository.findByUsername(usuario.getUsername());
        //Se pregunta si existe el Username para no registrar doble
        if(usuarioLocal != null){
            System.out.println("El usuario ya existe");
            throw new Exception("El usuario ya esta presente");
        }else {
            //Si no existe, se obtienen todos los roles para guardarlos
            for(UsuarioRol usuarioRol:usuarioRoles){
                rolRepository.save(usuarioRol.getRol());
            }
            usuario.getUsuarioRoles().addAll(usuarioRoles);
            usuarioLocal = usuarioRepository.save(usuario);
        }
        return usuarioLocal;
    }

    @Override
    public Usuario obtenerUsuario(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public void eliminarUsuario(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }
}
