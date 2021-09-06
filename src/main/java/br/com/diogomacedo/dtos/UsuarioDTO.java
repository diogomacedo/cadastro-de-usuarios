package br.com.diogomacedo.dtos;

import java.time.Instant;
import java.util.ArrayList;

import br.com.diogomacedo.entities.SenhaEntity;
import br.com.diogomacedo.entities.UsuarioEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {

	private Long id;
	private String nomeCompleto;
	private String nomeUsuario;
	private Instant dataCadastro;
	private Instant dataAtualizacao;
	private String senha;

	@Override
	public String toString() {
		return "UsuarioDTO [id=" + id + ", nomeCompleto=" + nomeCompleto + ", nomeUsuario=" + nomeUsuario
				+ ", dataCadastro=" + dataCadastro + ", dataAtualizacao=" + dataAtualizacao + ", senha=" + senha + "]";
	}

	public UsuarioEntity toEntity() {
		UsuarioEntity usuario = new UsuarioEntity();
		usuario.setNomeCompleto(this.nomeCompleto);
		usuario.setNomeUsuario(this.nomeUsuario);
		usuario.setDataCadastro(Instant.now());
		usuario.setDataAtualizacao(Instant.now());
		if (usuario.getSenhas() == null) {
			usuario.setSenhas(new ArrayList<SenhaEntity>());
		}
		SenhaEntity senha = new SenhaEntity();
		senha.setValor(this.senha);
		senha.setUsuario(usuario);
		usuario.getSenhas().add(senha);
		return usuario;
	}

}
