package br.com.caelum.cinema.core.domain.compra;

import java.time.YearMonth;

public class Cartao {

	private String numero;
	private Integer cvv;
	private YearMonth vencimento;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

	public YearMonth getVencimento() {
		return vencimento;
	}

	public void setVencimento(YearMonth vencimento) {
		this.vencimento = vencimento;
	}

	public boolean isValido() {
		return vencimento != null && vencimento.isAfter(YearMonth.now());
	}
}
