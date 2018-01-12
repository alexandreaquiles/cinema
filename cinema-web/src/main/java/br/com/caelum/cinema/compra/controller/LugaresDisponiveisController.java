package br.com.caelum.cinema.compra.controller;

import br.com.caelum.cinema.core.domain.Sessao;
import br.com.caelum.cinema.core.domain.SessaoRepository;
import br.com.caelum.cinema.core.domain.compra.Carrinho;
import br.com.caelum.cinema.core.domain.compra.ImagemCapa;
import br.com.caelum.cinema.core.domain.compra.ImdbClient;
import br.com.caelum.cinema.core.domain.compra.TipoDeIngresso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;


import java.util.Optional;

@Controller
public class LugaresDisponiveisController {

	@Autowired
	private SessaoRepository sessoes;

	@Autowired
	private ImdbClient client;

	@Autowired
	private Carrinho carrinho;

	@GetMapping("/sessao/{id}/lugares")
	public ModelAndView lugaresNaSessao(@PathVariable("id") Integer sessaoId) {
		ModelAndView modelAndView = new ModelAndView("sessao/lugares");
		Sessao sessao = sessoes.buscaSessaoComIngressos(sessaoId);
		Optional<ImagemCapa> imagemCapa = client.request(sessao.getFilme(), ImagemCapa.class);
		modelAndView.addObject("sessao", sessao);
		modelAndView.addObject("carrinho", carrinho);
		modelAndView.addObject("imagemCapa", imagemCapa.orElse(new ImagemCapa()));
		modelAndView.addObject("tiposDeIngressos", TipoDeIngresso.values());

		return modelAndView;
	}

}
