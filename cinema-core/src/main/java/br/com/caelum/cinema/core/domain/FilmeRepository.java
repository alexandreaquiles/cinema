package br.com.caelum.cinema.core.domain;

import java.util.List;

public interface FilmeRepository {

	Filme findOne(Integer id);

	void save(Filme filme);

	List<Filme> findAll();

	void delete(Integer id);

}