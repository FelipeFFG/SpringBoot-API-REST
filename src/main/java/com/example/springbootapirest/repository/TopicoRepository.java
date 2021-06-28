package com.example.springbootapirest.repository;

import com.example.springbootapirest.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico,Long> {

}
