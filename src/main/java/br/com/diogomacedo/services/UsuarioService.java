package br.com.diogomacedo.services;

import org.springframework.data.domain.Page;

import br.com.diogomacedo.entities.UsuarioEntity;

public interface UsuarioService {

	Page<UsuarioEntity> listar(int page, int size);

	UsuarioEntity salvar(UsuarioEntity usuario);

	UsuarioEntity buscar(String email);

	UsuarioEntity buscar(String email, String senha);

}
