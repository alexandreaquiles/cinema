package br.com.caelum.cinema.core.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by nando on 03/03/17.
 */
//@Entity
public class Sala {

    //@Id
    //@GeneratedValue
    private Integer id;

    //@NotBlank
    private String nome;

    //@OneToMany(fetch = FetchType.EAGER)
    private List<Lugar> lugares = new ArrayList<>();
    
    private BigDecimal preco;

    /**
     * @deprecated hibernate only
     */
    public Sala() {

    }

    public Sala(String nome, BigDecimal preco) {
		this.nome = nome;
		this.preco = preco;
	}

    public Sala(Integer id) {
		this.id = id;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public void add(Lugar lugar) {
        this.lugares.add(lugar);
    }

    public List<Lugar> getLugares() {
        return lugares;
    }

    public void setLugares(List<Lugar> lugares) {
        this.lugares = lugares;
    }

    public Map<String, List<Lugar>> getMapaDeLugares() {
        if(!this.lugares.isEmpty()){
            return this.lugares.stream().collect(Collectors.groupingBy(Lugar::getFileira,Collectors.toList()));
        }
        return Collections.emptyMap();
    }

    public Integer lugar(String fileira, Integer posicao){
        Optional<Lugar> optional = this.lugares.stream().filter((x) -> fileira.equals(x.getFileira()) && posicao.equals(x.getPosicao())).findFirst();
        return optional.get().getId();
    }
}