package com.orangelittle.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.orangelittle.dao.ClienteDAO;
import com.orangelittle.modelo.Cliente;

@RestController()
@RequestMapping("segmento")
public class ApiConsultaSegmento {
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	@GetMapping(value = "/consultaSegmento", produces = "application/json")
	public @ResponseBody Iterable<Cliente> getSegmento(@RequestParam(name="sgm") String segmento)
	{
		Iterable<Cliente> lista = clienteDAO.findBySegmentoStartingWith("%" +segmento);
		return lista;
	}
}
