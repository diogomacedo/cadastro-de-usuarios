package br.com.diogomacedo.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_usuarios")
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
	private Date dataCadastro;

	@Column(name = "data_atualizacao")
	private Date dataAtualizacao;

	@OneToMany
	private List<SenhaEntity> senhas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public List<SenhaEntity> getSenhas() {
		if (this.senhas == null) {
			this.senhas = new ArrayList<SenhaEntity>();
		}
		return this.senhas;
	}

	public void setSenhas(List<SenhaEntity> senhas) {
		this.senhas = senhas;
	}

	@Override
	public String toString() {
		return "UsuarioEntity [id=" + id + ", nomeCompleto=" + nomeCompleto + ", nomeUsuario=" + nomeUsuario
				+ ", dataCadastro=" + dataCadastro + ", dataAtualizacao=" + dataAtualizacao + ", senhas=" + senhas
				+ "]";
	}

}
