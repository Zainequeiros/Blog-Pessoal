package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Postagem;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
	
	public List<Postagem> findAllByTituloContainingIgnoreCase (String tirulo);
	
	@Query(value = "select * from postagem where ano > 2011", nativeQuery = true)
	List<Postagem> findAllMaior();
	
	@Query(value = "select * from postagem where ano > 2011 order by ano desc", nativeQuery = true)
	List<Postagem> anoDesc();
	
	@Query(value = "select * from postagem where ano > 2011 order by ano asc", nativeQuery = true)
	List<Postagem> anoAsc();
	
	@Query(value = "select * from postagem where ano >= 2011 and ano <= 2013", nativeQuery = true)
	List<Postagem> anoIntervalo();
}
