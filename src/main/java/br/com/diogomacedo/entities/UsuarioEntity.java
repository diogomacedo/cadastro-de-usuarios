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
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.domain.Persistable;

import br.com.diogomacedo.dtos.UsuarioDTO;
import lombok.Getter;
import lombok.Setter;

@Entity
//@Table(name = "tb_usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "nome_usuario", name = "nome_usuario_uk"))
@Table(name = "tb_usuarios")
@Getter
@Setter
public class UsuarioEntity implements Persistable<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_usuario")
	private Long id;

	@Column(name = "nome_completo")
	private String nomeCompleto;

	@Column(name = "nome_usuario", unique = true)
	private String nomeUsuario;

	@Column(name = "data_cadastro")
	private Instant dataCadastro;

	@Column(name = "data_atualizacao")
	private Instant dataAtualizacao;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	private List<SenhaEntity> senhas;

	@Transient
	private boolean entidadeNova = true;

	@Override
	public boolean isNew() {
		return this.entidadeNova;
	}

	@PrePersist
	@PostLoad
	void markNotNew() {
		this.entidadeNova = false;
	}

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
