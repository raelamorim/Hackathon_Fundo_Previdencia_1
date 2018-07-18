package com.orangelittle.listener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.orangelittle.dao.MovimentoDAO;
import com.orangelittle.dominio.TipoMovimento;
import com.orangelittle.modelo.Ativo;
import com.orangelittle.modelo.Cliente;
import com.orangelittle.modelo.Movimento;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@Component
@RabbitListener(queues = {"g10-mov-az1", "g10-mov-az2", "g10-mov-az3" , "g10-mov-az4", "g10-mov-az5"})
public class QueueListener {
	
	@Autowired
	private MovimentoDAO movimentoDAO;

    @RabbitHandler 
    public void receive(String input) throws Exception {
        System.out.println(" [x] Received '" + input + "'");
        
        JSONObject jsonObject = (JSONObject) new JSONParser().parse(input);
        String nome = (String) jsonObject.get("nome");
        Long idMovimento = (Long) jsonObject.get("id");
        
        Long d = (Long)jsonObject.get("data");
        Calendar data = new GregorianCalendar();
        data.setTimeInMillis(d);
        
        Long quantidade = (Long) jsonObject.get("quantidade");
        BigDecimal valor = new BigDecimal((Double) jsonObject.get("valorOperacao"));
        
        TipoMovimento tipo;
        
        if (jsonObject.get("tipoMovimento").toString().equals("Compra")) {
        	tipo = TipoMovimento.COMPRA;
        } else if (jsonObject.get("tipoMovimento").toString().equals("Venda")){
        	tipo = TipoMovimento.VENDA;
        	valor.multiply(new BigDecimal("-1"));
        } else {
        	tipo = null;
        }
        
        JSONObject jsonCliente = (JSONObject) new JSONParser().parse(jsonObject.get("cliente").toString());
        Long idCliente = (Long) jsonCliente.get("id");
        Cliente cliente = new Cliente(idCliente);
        
        JSONObject jsonAtivo = (JSONObject) new JSONParser().parse(jsonObject.get("ativo").toString());
        Long idAtivo = (long) jsonAtivo.get("id");
        String codigoAtivo = (String) jsonAtivo.get("codigo");
        String nomeAtivo = (String) jsonAtivo.get("nome");
        JSONObject jsonPlataforma = (JSONObject) new JSONParser().parse(jsonAtivo.get("plataforma").toString());
        Long idPlataforma = (Long) jsonPlataforma.get("id");
        String nomePlataforma = (String) jsonPlataforma.get("nome");
        
        Movimento movimento = new Movimento(idMovimento, data, idCliente, tipo, idAtivo, quantidade, valor, idPlataforma, nomePlataforma);
      
        movimentoDAO.save(movimento);
    }
}
