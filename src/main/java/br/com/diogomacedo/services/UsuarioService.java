package br.com.diogomacedo.services;

import org.springframework.data.domain.Page;

import br.com.diogomacedo.dtos.UsuarioDTO;

public interface UsuarioService {

	Page<UsuarioDTO> listar(int page, int size);

	UsuarioDTO salvar(UsuarioDTO usuario);

	UsuarioDTO buscar(Long idUsuario);

}
