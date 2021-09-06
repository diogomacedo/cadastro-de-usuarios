package br.com.diogomacedo.repositories;

import java.time.Instant;
import java.util.ArrayList;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.diogomacedo.entities.SenhaEntity;
import br.com.diogomacedo.entities.UsuarioEntity;

@DataJpaTest
@DisplayName("Testando o UsuarioRepository")
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository repository;

	@Test
	void testSalvar() {
		// Criar usuário
		UsuarioEntity usuario = this.initUsuario();
		UsuarioEntity usuarioSalvo = this.repository.save(usuario);
		// Validações
		Assertions.assertThat(usuarioSalvo).isNotNull();
		Assertions.assertThat(usuarioSalvo.getId()).isNotNull();
		Assertions.assertThat(usuarioSalvo.getNomeCompleto()).isEqualTo(usuario.getNomeCompleto());
		Assertions.assertThat(usuarioSalvo.getNomeUsuario()).isEqualTo(usuario.getNomeUsuario());
		Assertions.assertThat(usuarioSalvo.getSenhas()).isEqualTo(usuario.getSenhas());
	}

	private UsuarioEntity initUsuario() {
		UsuarioEntity usuario = new UsuarioEntity();
		// Informações
		usuario.setNomeCompleto("Diogo Rodrigo Rosa Macedo");
		usuario.setNomeUsuario("diogomacedo");
		// Datas
		Instant horaAtual = Instant.now();
		usuario.setDataCadastro(horaAtual);
		usuario.setDataAtualizacao(horaAtual);
		// Senha
		SenhaEntity senha = new SenhaEntity();
		senha.setValor("12345678");
		senha.setUsuario(usuario);
		usuario.setSenhas(new ArrayList<SenhaEntity>());
		usuario.getSenhas().add(senha);
		//
		return usuario;
	}

}
