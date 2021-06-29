package com.example.springbootapirest.controller;

import com.example.springbootapirest.dto.TopicoDto;
import com.example.springbootapirest.form.TopicoForm;
import com.example.springbootapirest.model.Topico;
import com.example.springbootapirest.repository.CursoRepository;
import com.example.springbootapirest.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

                                                     //Por padrao ele assume que todos os metodos tem o @ReponseBody.
@RestController                            //ResponseBody - indica que o retorno do metodo deve ser serializado e devolvido no corpo da resposnta.
@RequestMapping("/topicos")
public class TopicosController {


    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public List<TopicoDto> lista(String nomeCurso){
        if (nomeCurso==null){
            List<Topico> topicos = topicoRepository.findAll();
            return TopicoDto.converter(topicos);
        }else{
            List<Topico> topicos = topicoRepository.findByCurso_Nome(nomeCurso);  //filtra os topicos que tiverem o nome do curso igual o passado na url.
            return TopicoDto.converter(topicos);
        }
    }


    @PostMapping
    public ResponseEntity<TopicoDto> cadastrar(@RequestBody TopicoForm form, UriComponentsBuilder uriBuilder){  //sinaliza pra pegar no corpo da requisição
        Topico topico =form.converter(cursoRepository);    //chama o repositorio do curso, pra buscar o curso com aquele nome, e converte os dados em um objeto TOPICO
        topicoRepository.save(topico);                     //salvamos o TOPICO no banco de dados.

        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri(); //cria e converte o id em uri
        return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }

}
