package br.com.caelum.cinema.core.domain.compra.descontos;

import java.math.BigDecimal;

public interface Desconto {

	BigDecimal aplicarDescontoSobre(BigDecimal precoOriginal);
	String getDescricao();
	
}
