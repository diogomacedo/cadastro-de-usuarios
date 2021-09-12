package br.com.diogomacedo.repositories;

import java.time.Instant;
import java.util.ArrayList;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import br.com.diogomacedo.entities.SenhaEntity;
import br.com.diogomacedo.entities.UsuarioEntity;

@DataJpaTest
@DisplayName("Testando o UsuarioRepository")
public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository repository;

	@BeforeEach
	void init() {
		// Criar usuário
		UsuarioEntity usuario = this.initUsuario();
		// Salvar
		this.repository.saveAndFlush(usuario);
	}

	@Test
	@DisplayName("Criar/Salvar um novo usuário")
	void testSalvarUsuario() {
		// Criar usuário
		UsuarioEntity usuario = this.initUsuario("diogo.macedo");
		// Salvar
		this.repository.saveAndFlush(usuario);
		// Validações
		Assertions.assertThat(usuario).isNotNull();
		Assertions.assertThat(usuario.getId()).isNotNull();
		Assertions.assertThat(usuario.getNomeUsuario()).isNotNull();
		Assertions.assertThat(usuario.getSenhas()).isNotNull();
		Assertions.assertThat(usuario.getSenhas().size()).isGreaterThanOrEqualTo(1);
	}

	@Test
	@DisplayName("Criar/Salvar um usuário existente (duplicado)")
	void testSalvarUsuarioDuplicado() {
		// Criar usuário
		UsuarioEntity usuario = this.initUsuario();
		// Validações
		Assertions.assertThatThrownBy(() -> {
			// Salvar
			this.repository.saveAndFlush(usuario);
		}).isInstanceOf(DataIntegrityViolationException.class);
	}

	@Test()
	@DisplayName("Buscar um usuário existente utilizando o \"nomeUsuario\" ")
	void testBuscarUsuarioExistente() {
		// Salvar
		UsuarioEntity usuario = this.repository.findByNomeUsuario("diogomacedo");
		// Validações
		Assertions.assertThat(usuario).isNotNull();
		Assertions.assertThat(usuario.getId()).isNotNull();
		Assertions.assertThat(usuario.getNomeUsuario()).isNotNull();
		Assertions.assertThat(usuario.getSenhas()).isNotNull();
		Assertions.assertThat(usuario.getSenhas().size()).isGreaterThanOrEqualTo(1);
	}

	@Test()
	@DisplayName("Buscar um usuário inexistente utilizando o \"nomeUsuario\" ")
	void testBuscarUsuarioInexistente() {
		// Salvar
		UsuarioEntity usuario = this.repository.findByNomeUsuario("diogomacedo1");
		// Validações
		Assertions.assertThat(usuario).isNull();
	}

	@Test
	@DisplayName("Listar usuários cadastrados")
	void TestListarUsuariosCadastrados() {
		// Listar
		Iterable<UsuarioEntity> itUsuarios = this.repository.findAll();
		ArrayList<UsuarioEntity> usuarios = Lists.newArrayList(itUsuarios);
		// Validações
		Assertions.assertThat(usuarios).isNotNull();
		Assertions.assertThat(usuarios.size()).isGreaterThanOrEqualTo(1);
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

	private UsuarioEntity initUsuario(String nomeUsuario) {
		UsuarioEntity usuario = this.initUsuario();
		usuario.setNomeUsuario(nomeUsuario);
		return usuario;
	}

}
