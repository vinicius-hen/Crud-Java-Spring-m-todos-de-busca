package com.br.beejobs.model.controllers;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.br.beejobs.model.entities.Convite;
import com.br.beejobs.model.repository.ConviteRepository;
import com.br.beejobs.model.services.ConviteService;







@RestController
@RequestMapping("/convite")
public class ConviteController {
	
	
	@Autowired
	ConviteRepository conviteRepository;
	@Autowired
	ConviteService conviteService;
	
	public Integer soma = 0;
	
	
	@SuppressWarnings("unchecked")
	@PostMapping
	public ResponseEntity salvar(Convite convite, HttpServletRequest req) throws ValidationException {
		try{
		return new ResponseEntity(this.conviteService.salvar(convite),HttpStatus.OK);
		}catch (ValidationException e) {
			return new ResponseEntity (e.getMessage(), HttpStatus.CONFLICT);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	
	@SuppressWarnings("unchecked")
	@GetMapping
	public ResponseEntity listar( HttpServletRequest req) throws ValidationException {
		return new ResponseEntity(this.conviteService.listar(),HttpStatus.OK);
	}
	
	
	@SuppressWarnings("unchecked")
	@GetMapping("/{id}")
	
	public ResponseEntity listarId(@PathVariable("id") Long id, HttpServletRequest req) throws ValidationException {
		try {
		return new ResponseEntity(this.conviteService.listarPorId(id),HttpStatus.OK);
	}catch (ValidationException e) {
		return new ResponseEntity (e.getMessage(), HttpStatus.CONFLICT);
	} catch (Exception e) {
		return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
		
	}
	
	
	@SuppressWarnings("unchecked")
	@DeleteMapping ("/{id}")
	public ResponseEntity deletar(@PathVariable("id") Long id, HttpServletRequest req) throws ValidationException {
		this.conviteService.deletar(id);
		return new ResponseEntity (null, HttpStatus.NO_CONTENT);
		}
	
	
	
	@SuppressWarnings("unchecked")
	@PutMapping ("/{id}")
	public ResponseEntity listarId(@PathVariable("id") Long id, Convite convite, HttpServletRequest req) throws ValidationException {
		return new ResponseEntity(this.conviteService.update(id, convite),HttpStatus.OK);
		
	}
	@SuppressWarnings("unchecked")
	@GetMapping ("/p/{tituloVaga}")
	public ResponseEntity listarTitulo(@PathVariable("tituloVaga")String tituloVaga, HttpServletRequest req) throws ValidationException {
		return new ResponseEntity(this.conviteService.listarPorTitulo(tituloVaga),HttpStatus.OK);
	}
	
	@GetMapping("/tx")
	public ArrayList<Integer> findAlltaxa() {
		
		return conviteRepository.findAlltaxa();
		
	 	
	}
	
	@GetMapping("/som")
	public Integer somar() {
		
    ArrayList<Integer> taxa = conviteRepository.findAlltaxa();
    
    
     for(int i=0;i<taxa.size();i++) {
			
	  soma = soma + taxa.get(i);
	  
        }
		
	   return soma;
	 
	}
	
	@GetMapping("/maior")
	public List<Convite> maior() {
		return this.conviteRepository.maiorDeTodos();
		 
	
	}
	
	@GetMapping("/sub")
	public Integer sub() {
		
    ArrayList<Integer> taxa = conviteRepository.findAlltaxa();
    
    
     for(int i=0;i<taxa.size();i++) {
			
	  soma = soma - taxa.get(i);
	  
        }
		
	   return soma;
	 
	}
	
			
}

	

