package br.com.caelum.cinema.core.domain.compra;

import java.math.BigDecimal;

import br.com.caelum.cinema.core.domain.Lugar;
import br.com.caelum.cinema.core.domain.Sessao;

//@Entity
public class Ingresso {
	
	//@Id
	//@GeneratedValue
	private Integer id;
	
	//@ManyToOne
	private Sessao sessao;
	
	//@ManyToOne
	private Lugar lugar;
	
	private BigDecimal preco;

	//@Enumerated(EnumType.STRING)
	private TipoDeIngresso tipoDeIngresso;
	
	/**
	* @deprecated hibernate only
	*/
	public Ingresso() {
	}
	
	public Ingresso(Sessao sessao, TipoDeIngresso tipoDeIngresso, Lugar lugar) {
		this.sessao = sessao;
		this.tipoDeIngresso = tipoDeIngresso;
		this.preco = tipoDeIngresso.aplicaDesconto(sessao.getPreco());
		this.lugar = lugar;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public BigDecimal getPreco() {
		return preco;
	}
	
	public Integer getId() {
		return id;
	}

	public Lugar getLugar() {
		return lugar;
	}

	public TipoDeIngresso getTipoDeIngresso() {
		return tipoDeIngresso;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTipoDeIngresso(TipoDeIngresso tipoDeIngresso) {
		this.tipoDeIngresso = tipoDeIngresso;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}


}
