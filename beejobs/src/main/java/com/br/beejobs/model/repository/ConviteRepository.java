package com.br.beejobs.model.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.br.beejobs.model.entities.Convite;


@Repository
public interface ConviteRepository extends JpaRepository<Convite, Long>{

	List<Convite> findBytituloVaga(String tituloVaga);
	
	@Query(value = ("SELECT taxa FROM convite WHERE taxa<>0"), nativeQuery = true)
    ArrayList<Integer> findAlltaxa();
     
	@Query(value= ("SELECT * FROM convite WHERE taxa = (SELECT max(taxa) FROM convite)"), nativeQuery =true)
	List<Convite> maiorDeTodos();
	

	
	
	
	

	
	
   

	

	



}