package br.com.caelum.cinema.core.domain.compra;

import java.util.Optional;

import br.com.caelum.cinema.core.domain.Filme;

public interface ImdbClient {

	<T> Optional<T> request(Filme filme, Class<T> tClass);

}