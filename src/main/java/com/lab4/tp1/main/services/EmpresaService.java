package com.lab4.tp1.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab4.tp1.main.entities.Empresa;
import com.lab4.tp1.main.repositories.EmpresaRepository;
import com.lab4.tp1.main.repositories.NoticiaRepository;

@Service
public class EmpresaService implements BaseService<Empresa> {

	@Autowired
	private EmpresaRepository repository;
	
	@Autowired
	private NoticiaRepository noticiaRepository;
	
	
	@Override
	public List<Empresa> findAll() throws Exception {
		try {
			return repository.findAll();
		
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	

	@Override
	public Empresa findById(Long id) throws Exception {
		try {
			Optional<Empresa> empresaOptional = repository.findById(id);
			return empresaOptional.get();
		
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	

	@Override
	public Empresa save(Empresa empresa) throws Exception {
		try {
			return repository.save(empresa);
			
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}
	

	@Override
	public Empresa update(Long id, Empresa empresaEditada) throws Exception {
		try {
			Optional<Empresa> empresaOptional = repository.findById(id);
			Empresa empresa = empresaOptional.get();
			
			empresa.setId(id);
			empresa.setDenominacion(empresaEditada.getDenominacion());
			empresa.setTelefono(empresaEditada.getTelefono());
			empresa.setHorarioAtencion(empresaEditada.getHorarioAtencion());
			empresa.setQuienesSomos(empresaEditada.getQuienesSomos());
			empresa.setLatitud(empresaEditada.getLatitud());
			empresa.setLongitud(empresaEditada.getLongitud());
			empresa.setDomicilio(empresaEditada.getDomicilio());
			empresa.setEmail(empresaEditada.getEmail());

			
			return repository.save(empresa);
			
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	

	@Override
	public boolean delete(Long id) throws Exception {
		try {
			if(repository.existsById(id)) {
				noticiaRepository.findAll().forEach((n) -> {
					if(n.getEmpresa().getId() == id) {
						noticiaRepository.deleteById(n.getId());
					}
				});
				
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
