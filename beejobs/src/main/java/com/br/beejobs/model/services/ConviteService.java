package com.br.beejobs.model.services;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.xml.bind.ValidationException;

import org.apache.catalina.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.br.beejobs.model.entities.Convite;
import com.br.beejobs.model.repository.ConviteRepository;

@Service
public class ConviteService {


	

	@Autowired
	 ConviteRepository conviteRepository;
	
	public Convite salvar(Convite convite) throws ValidationException {
		
		
	if(convite !=null) {
	     convite = conviteRepository.save(convite);
		 return convite;
}
    throw new ValidationException("Registro não encontrado") ;
}
	
	
	 public List<Convite> listar (){
			
	    	List<Convite> convite = conviteRepository.findAll();
			return convite;
	}
	
    public Convite listarPorId(@PathVariable Long id) throws ValidationException {
    	
    	if(!conviteRepository.existsById(id)) {
    		throw new ValidationException("Registro não encontrado") ;	
       }
    	Convite convite = conviteRepository.findById(id).orElse(null);
		return convite;	 
}
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
	    public void deletar(@PathVariable Long id) throws ValidationException {
    	   if(!conviteRepository.existsById(id)) {
    		          throw new ValidationException("Registro não encontrado") ;
    }
		conviteRepository.deleteById(id);
	}
    
        public Convite update (@PathVariable Long id, Convite convite) {
        	
		Convite conviteSalvo = conviteRepository.findById(id).get();
		
		if(conviteSalvo == null) {
			throw new NoSuchElementException();
		}
		
		BeanUtils.copyProperties(convite, conviteSalvo, "id");
		return conviteRepository.save(conviteSalvo);
		
	}
     public List<Convite> listarPorTitulo(@PathVariable String tituloVaga) {
    	 List<Convite> convite =  conviteRepository.findBytituloVaga(tituloVaga);
    	 
    	 return convite;
    	 
     }
     
 
 	public ArrayList<Integer> findAlltaxa() {
 		
 		return conviteRepository.findAlltaxa();
 		
 	 	
 	}
 	
 
 	public Integer somar() {
 		
     ArrayList<Integer> taxa = conviteRepository.findAlltaxa();
     int soma=0;
     
      for(int i=0;i<taxa.size();i++) {
 			
 	  soma = soma + taxa.get(i);
 	  
         }
 		
 	   return soma;
 	 
 	}
 	
 
 	public List<Convite> maior() {
 		return this.conviteRepository.maiorDeTodos();
 		 
 	
 	}


 	
    
     
     
    	
     
    	
}

