package com.orangelittle.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.orangelittle.dao.ClienteDAO;
import com.orangelittle.dao.MovimentoDAO;
import com.orangelittle.modelo.Cliente;
import com.orangelittle.modelo.Movimento;

@RestController()
@RequestMapping("movimento")
public class ApiConsultaMovimento {

	@Autowired
	private ClienteDAO clienteDAO;
	
	@Autowired
	private MovimentoDAO movimentoDAO;
	
	@GetMapping(value = "/todosMovimentos", produces = "application/json")
	public @ResponseBody Iterable<Movimento> getTodosMoviemntos()
	{
		Iterable<Movimento> lista = movimentoDAO.findAll();
		return lista;
	}
}
