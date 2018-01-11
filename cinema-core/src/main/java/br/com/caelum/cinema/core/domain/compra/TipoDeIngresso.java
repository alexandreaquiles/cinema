package br.com.caelum.cinema.core.domain.compra;

import java.math.BigDecimal;

import br.com.caelum.cinema.core.domain.compra.descontos.Desconto;
import br.com.caelum.cinema.core.domain.compra.descontos.DescontoDeTrintaPorCentoParaBancos;
import br.com.caelum.cinema.core.domain.compra.descontos.DescontoEstudante;
import br.com.caelum.cinema.core.domain.compra.descontos.SemDesconto;

public enum TipoDeIngresso {

	INTEIRO(new SemDesconto()),
	ESTUDANTE(new DescontoEstudante()),
	BANCO(new DescontoDeTrintaPorCentoParaBancos());
	
	private final Desconto desconto;
	
	private TipoDeIngresso(Desconto desconto) {
		this.desconto = desconto;
	}

	public BigDecimal aplicaDesconto(BigDecimal valor) {
		return desconto.aplicarDescontoSobre(valor);
	}

	public String getDescricao() {
		return desconto.getDescricao();
	}
	
}
