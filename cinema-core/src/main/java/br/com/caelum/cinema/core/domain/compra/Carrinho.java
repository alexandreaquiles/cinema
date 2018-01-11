package br.com.caelum.cinema.core.domain.compra;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.cinema.core.domain.Lugar;
import br.com.caelum.cinema.core.domain.compra.Compra;
import br.com.caelum.cinema.core.domain.compra.Ingresso;

public class Carrinho {
	private List<Ingresso> ingressos = new ArrayList<>();

	public void add(Ingresso ingresso) {
		ingressos.add(ingresso);
	}

	public boolean isSelecionado(Lugar lugar) {
		return ingressos.stream().map(Ingresso::getLugar).anyMatch(l -> l.equals(lugar));
	}

	public BigDecimal getTotal() {
		return ingressos.stream().map(Ingresso::getPreco).reduce(BigDecimal::add).orElse(BigDecimal.ZERO);
	}

	public List<Ingresso> getIngressos() {
		return ingressos;
	}
	
	public void setIngressos(List<Ingresso> ingressos) {
		this.ingressos = ingressos;
	}

	public Compra toCompra() {
		return new Compra(ingressos);
	}

	public void limpa() {
		ingressos.clear();
	}
}
