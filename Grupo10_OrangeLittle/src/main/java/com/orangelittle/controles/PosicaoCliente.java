package com.orangelittle.controles;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.orangelittle.dao.ClienteDAO;
import com.orangelittle.dao.MovimentoDAO;
import com.orangelittle.modelo.Cliente;
import com.orangelittle.modelo.Movimento;


@Controller
@RequestMapping("/posicao")
public class PosicaoCliente {
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	@Autowired
	private MovimentoDAO movimentoDAO;

	@RequestMapping(value = "/pesquisaPosicao", method = RequestMethod.GET)
	public String PesquisaPosicaoCliente()
	{
		
		return "pesquisa/pesquisaPosicaoCliente";
	}
	
	/*@RequestMapping(value = "/listaPosicao", method = RequestMethod.POST)
	public ModelAndView listaPosicaoCliente(Cliente cli)
	{
		ModelAndView view = new ModelAndView("pesquisa/listaPosicaoCliente");
		List<Movimento> m = (List<Movimento>) movimentoDAO.findAll();
		view.addObject("movimento",m);
		return view;
	}*/
}
