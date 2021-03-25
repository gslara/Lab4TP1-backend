package com.lab4.tp1.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab4.tp1.main.entities.Noticia;

@Repository
public interface NoticiaRepository extends JpaRepository<Noticia, Long> {

}
