package com.example.springbootapirest.controller;

import com.example.springbootapirest.dto.TopicoDto;
import com.example.springbootapirest.model.Curso;
import com.example.springbootapirest.model.Topico;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

                                                     //Por padrao ele assume que todos os metodos tem o @ReponseBody.
@RestController                            //ResponseBody - indica que o retorno do metodo deve ser serializado e devolvido no corpo da resposnta.
public class TopicosController {

    @RequestMapping("/topicos")
    public List<TopicoDto> lista(){
        Topico topico = new Topico("Dúvida","Dúvida com Spring",new Curso("Spring","Programação"));
        return TopicoDto.converter(Arrays.asList(topico,topico,topico));
    }

}
