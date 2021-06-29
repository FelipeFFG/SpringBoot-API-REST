package com.example.springbootapirest.controller;

import com.example.springbootapirest.dto.TopicoDto;
import com.example.springbootapirest.model.Topico;
import com.example.springbootapirest.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

                                                     //Por padrao ele assume que todos os metodos tem o @ReponseBody.
@RestController                            //ResponseBody - indica que o retorno do metodo deve ser serializado e devolvido no corpo da resposnta.
public class TopicosController {


    @Autowired
    private TopicoRepository topicoRepository;

    @RequestMapping("/topicos")
    public List<TopicoDto> lista(String nomeCurso){
        if (nomeCurso==null){
            List<Topico> topicos = topicoRepository.findAll();
            return TopicoDto.converter(topicos);
        }else{
            List<Topico> topicos = topicoRepository.findByCurso_Nome(nomeCurso);  //filtra os topicos que tiverem o nome do curso igual o passado na url.
            return TopicoDto.converter(topicos);
        }
    }

}
