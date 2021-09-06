package br.com.diogomacedo.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.diogomacedo.dtos.UsuarioDTO;
import br.com.diogomacedo.entities.UsuarioEntity;
import br.com.diogomacedo.repositories.UsuarioRepository;
import br.com.diogomacedo.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public Page<UsuarioDTO> listar(int page, int size) {
		PageRequest pageRequest = PageRequest.of(0, 10);
		return this.repository.findAll(pageRequest).map(u -> u.toDTO());
	}

	public UsuarioDTO salvar(UsuarioDTO usuario) {
		UsuarioEntity usuarioEntity = usuario.toEntity();
		UsuarioEntity usuarioSalvo = this.repository.save(usuarioEntity);
		return usuarioSalvo.toDTO();
	}

	@Override
	public UsuarioDTO buscar(Long idUsuario) {
		Optional<UsuarioEntity> optUsuario = this.repository.findById(idUsuario);
		if (optUsuario.isPresent()) {
			return optUsuario.get().toDTO();
		}
		return null;
	}

}
