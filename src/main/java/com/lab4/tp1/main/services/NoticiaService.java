package com.lab4.tp1.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab4.tp1.main.entities.Noticia;
import com.lab4.tp1.main.repositories.NoticiaRepository;

@Service
public class NoticiaService implements BaseService<Noticia> {

	@Autowired
	private NoticiaRepository repository;
	
	
	
	@Override
	public List<Noticia> findAll() throws Exception {
		try {
			return repository.findAll();
		
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	

	@Override
	public Noticia findById(Long id) throws Exception {
		try {
			Optional<Noticia> noticiaOptional = repository.findById(id);
			return noticiaOptional.get();
		
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	

	@Override
	public Noticia save(Noticia noticia) throws Exception {
		try {
			return repository.save(noticia);
			
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	

	@Override
	public Noticia update(Long id, Noticia noticiaEditada) throws Exception {
		try {
			Optional<Noticia> noticiaOptional = repository.findById(id);
			Noticia noticia = noticiaOptional.get();
			
			noticia.setId(id);
			noticia.setTitulo(noticiaEditada.getTitulo());
			noticia.setResumen(noticiaEditada.getResumen());
			noticia.setImagen(noticiaEditada.getImagen());
			noticia.setContenidoHTML(noticiaEditada.getContenidoHTML());
			noticia.setPublicada(noticiaEditada.isPublicada());
			noticia.setFechaPublicacion(noticiaEditada.getFechaPublicacion());
			noticia.setEmpresa(noticiaEditada.getEmpresa());

			return repository.save(noticia);
			
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	

	@Override
	public boolean delete(Long id) throws Exception {
		try {
			if(repository.existsById(id)) {
				repository.deleteById(id);
				return true;
			
			} else {
				throw new Exception();
			}
			
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
}
