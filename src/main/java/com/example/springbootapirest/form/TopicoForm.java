package com.example.springbootapirest.form;

import com.example.springbootapirest.model.Curso;
import com.example.springbootapirest.model.Topico;
import com.example.springbootapirest.repository.CursoRepository;
import com.example.springbootapirest.repository.TopicoRepository;

public class TopicoForm {

    private String titulo;
    private String mensagem;
    private String nomeCurso;


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public Topico converter(CursoRepository cursorepository) {
        Curso curso = cursorepository.findBynome(nomeCurso);
        return new Topico(titulo,mensagem,curso);
    }
}
