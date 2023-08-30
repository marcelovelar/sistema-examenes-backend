package com.sistema.examenes.controller;

import com.sistema.examenes.entity.Rol;
import com.sistema.examenes.entity.Usuario;
import com.sistema.examenes.entity.UsuarioRol;
import com.sistema.examenes.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

//Que son estas anotaciones?
//Que es una API REST?
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/")
                                //Esta notacion nos va a servir para poder mandar este objeto
    public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception{
        Set<UsuarioRol> roles = new HashSet<>();

        Rol rol = new Rol();
        rol.setRolId(2L);
        rol.setNombre("NORMAL");

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);

        return usuarioService.guardarUsuario(usuario,roles);
    }

    @GetMapping("/{username}")
    public Usuario obtenerUsuario(@PathVariable("username")String username){
        return usuarioService.obtenerUsuario(username);
    }

    @DeleteMapping("/{usuarioId}")
    public void eliminarUsuario(@PathVariable("usuarioId")Long usuarioId){
        usuarioService.eliminarUsuario(usuarioId);
    }
}
