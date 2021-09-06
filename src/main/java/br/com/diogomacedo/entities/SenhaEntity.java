package br.com.diogomacedo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_senhas")
@Getter
@Setter
public class SenhaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_senha")
	private Long id;

	@Column(name = "valor")
	private String valor;

	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private UsuarioEntity usuario;

	@Override
	public String toString() {
		return "SenhaEntity [id=" + id + ", valor=" + valor + "]";
	}

}
