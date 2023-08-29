package org.generation.ecommerce.controller;

import java.util.List;

import org.generation.ecommerce.model.ChangePassword;
import org.generation.ecommerce.model.Usuario;
import org.generation.ecommerce.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/usuarios/") // http://localhost:8080/api/usuarios/
public class UsuarioController {
private final UsuarioService usuarioService;
	
	@Autowired
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}//constructor

	@GetMapping
	public List<Usuario> getAllUsers(){
		return usuarioService.getAllUsuarios();
	}//getAllUsers
	
	@GetMapping(path="{userId}")
	public Usuario getUser(@PathVariable("userId") Long id){
		return usuarioService.getUsuario(id);
	}//getUser
	
	@DeleteMapping(path="{userId}")
	public Usuario deleteUsuario(@PathVariable("userId") Long id){
		return usuarioService.deleteUsuario(id);
	}//deleteUsuario
	
	@PostMapping
	public Usuario addUsuario(@RequestBody Usuario usuario ) {
		return usuarioService.addUsuario(usuario);
	}//addUsuario
	
	@PutMapping(path="{userId}")
	public Usuario updateUser(@PathVariable("userId") Long id, 
			@RequestBody ChangePassword changePassword) {
return usuarioService.updateUsuario(id, changePassword);
	}//updateUser

	
	
}//class UsuarioController
