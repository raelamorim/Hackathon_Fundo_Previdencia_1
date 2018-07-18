package com.orangelittle.controles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("cliente")
public class ClienteController {

	@RequestMapping(value = "/consultaPorSegemento", method = RequestMethod.GET)
	public String consultaPorSegmento()
	{
		return "pesquisa/consultaPorSegmento";
	}
}
