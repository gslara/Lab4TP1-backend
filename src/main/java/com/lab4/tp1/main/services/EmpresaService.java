package com.lab4.tp1.main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lab4.tp1.main.entities.Empresa;
import com.lab4.tp1.main.repositories.EmpresaRepository;

@Service
public class EmpresaService implements BaseService<Empresa> {

	@Autowired
	private EmpresaRepository repository;
	
	
	
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
	public Empresa update(Long id, Empresa empresa) throws Exception {
		try {
			Optional<Empresa> empresaOptional = repository.findById(id);
			empresa = empresaOptional.get();
			empresa.setId(id);
			
			return repository.save(empresa);
			
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
