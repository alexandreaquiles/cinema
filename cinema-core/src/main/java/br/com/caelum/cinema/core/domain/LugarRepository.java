package br.com.caelum.cinema.core.domain;

public interface LugarRepository {

	void save(Lugar lugar);

	Lugar findOne(Integer id);

}