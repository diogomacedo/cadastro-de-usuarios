package br.com.diogomacedo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.diogomacedo.entities.UsuarioEntity;
import br.com.diogomacedo.services.UsuarioService;

@RestController()
@RequestMapping("usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@ResponseBody
	@GetMapping
	public Page<UsuarioEntity> listar() {
		Page<UsuarioEntity> usuarios = this.service.listar(0, 0);
		return usuarios;
	}

}
