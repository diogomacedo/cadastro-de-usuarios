package br.com.diogomacedo.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.diogomacedo.entities.UsuarioEntity;
import br.com.diogomacedo.repositories.UsuarioRepository;
import br.com.diogomacedo.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public Page<UsuarioEntity> listar(int page, int size) {
		PageRequest pageRequest = PageRequest.of(0, 10);
		return this.repository.findAll(pageRequest);
	}

	public UsuarioEntity salvar(UsuarioEntity usuario) {
		return null;
	}

	public UsuarioEntity buscar(String email) {
		return null;
	}

	public UsuarioEntity buscar(String email, String senha) {
		return null;
	}

}
