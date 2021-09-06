package br.com.diogomacedo.entities;

import java.time.Instant;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.diogomacedo.dtos.UsuarioDTO;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_usuarios")
@Getter
@Setter
public class UsuarioEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_usuario")
	private Long id;

	@Column(name = "nome_completo")
	private String nomeCompleto;

	@Column(name = "nome_usuario")
	private String nomeUsuario;

	@Column(name = "data_cadastro")
	private Instant dataCadastro;

	@Column(name = "data_atualizacao")
	private Instant dataAtualizacao;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	private List<SenhaEntity> senhas;

	@Override
	public String toString() {
		return "UsuarioEntity [id=" + id + ", nomeCompleto=" + nomeCompleto + ", nomeUsuario=" + nomeUsuario
				+ ", dataCadastro=" + dataCadastro + ", dataAtualizacao=" + dataAtualizacao + ", senhas=" + senhas
				+ "]";
	}

	public UsuarioDTO toDTO() {
		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setId(this.id);
		usuario.setNomeCompleto(this.nomeCompleto);
		usuario.setNomeUsuario(this.nomeUsuario);
		usuario.setDataCadastro(this.dataCadastro);
		usuario.setDataAtualizacao(this.dataAtualizacao);
		usuario.setSenha(this.getSenhas().get(0).getValor());
		return usuario;
	}
}
