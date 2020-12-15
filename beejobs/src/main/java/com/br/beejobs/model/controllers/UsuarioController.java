package com.br.beejobs.model.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.beejobs.model.entities.Convite;
import com.br.beejobs.model.entities.Usuario;
import com.br.beejobs.model.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	@PostMapping
	public Usuario salvarUsuario(Usuario user) {
	 
	return user = usuarioRepository.save(user);
	}
	
	@GetMapping
	public List<Usuario> getAllUsuario() {
	List<Usuario> user = usuarioRepository.findAll();
	
	return user;
	}
	
	@GetMapping("/{id}")
	public Usuario getById(@PathVariable("id")Long id){
		Usuario user = usuarioRepository.findById(id).orElse(null);
		
		return user;
	}
	
	@DeleteMapping("/{id}")
	public void deletarById(@PathVariable("id")Long id) {
		
		usuarioRepository.deleteById(id);
	}
     
	@PutMapping("/{id}")
	public Usuario alterar (@PathVariable("id")Long id, Usuario user ) {
		
     Usuario usuarioSalvo = usuarioRepository.findById(id).get();
		
		if(usuarioSalvo == null) {
			throw new NoSuchElementException();
		}
		
		BeanUtils.copyProperties(user, usuarioSalvo, "id");
		return usuarioRepository.save(usuarioSalvo);
	}
	
	@GetMapping("/{nome}")
	public List<Usuario> findByNome (@PathVariable("nome") String nome){
		
		List<Usuario> user = usuarioRepository.findByNome(nome);
		
		return user;
	}
}
