package br.com.myapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


@Entity(name = "FUNCIONARIO")
public class Funcionario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_funcionario")
	@SequenceGenerator(name = "sq_funcionario", sequenceName = "sq_funcionario", allocationSize = 1)
	@Column(name = "ROW_ID")
	public Long id;
	
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "USUARIO")
	private String usuario;
	
	@Column(name = "SENHA")
	private String senha;
	
	@Column(name = "RG")
	private int rg;
	
	@Column(name = "CPF")
	private int cpf;
	
	@Column(name = "FONE")
	private String fone;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "DT_NASCIMENTO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtNascimento;
	
	@Column(name = "DATA_ADMISSAO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAdmissao;
	
	@Column(name = "LOGRADOURO")
	private String logradouro;
	
	@Column(name = "NUMERO")
	private int numero;
	
	@Column(name = "BAIRRO")
	private String bairro;
	
	@Column(name = "COMPLEMENTO")
	private String complemento;
		
	@Column(name = "CIDADE")
	private String cidade;
	
	@Column(name = "UF")
	private String uf;
	
	@Column(name = "CEP")
	private String cep;
	
	@ManyToOne
	@JoinColumn(name = "ID_SETOR")
	private Setor idSetor; 
	
	@Column(name = "ATIVO")
	private boolean ativo;
	
	@Transient
	private String imagemStatus="../resources/images/off.png"; //Variável para exibição da imagem do Status considerado "false".
		

	
	//------------------------------------------------

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + this.id 
				+ ", nome=" + this.nome 
				+ ", usuario=" + this.usuario 
				+ ", senha=" + this.senha 
				+ ", rg=" + this.rg
				+ ", cpf=" + this.cpf 
				+ ", fone=" + this.fone 
				+ ", email=" + this.email
				+ ", dtNascimento=" + this.dtNascimento 
				+ ", dataAdmissao=" + this.dataAdmissao 
				+ ", logradouro=" + this.logradouro 
				+ ", numero=" + this.numero
				+ ", bairro=" + this.bairro 
				+ ", complemento=" + this.complemento 
				+ ", cidade=" + this.cidade 
				+ ", uf=" + this.uf 
				+ ", cep=" + this.cep 
				+ ", idSetor=" + idSetor 
				+ ", ativo=" + ativo 
				+ "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getRg() {
		return rg;
	}

	public void setRg(int rg) {
		this.rg = rg;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public Date getDtInclusao() {
		return dataAdmissao;
	}

	public void setDtInclusao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Setor getIdSetor() {
		return idSetor;
	}

	public void setIdSetor(Setor idSetor) {
		this.idSetor = idSetor;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	
	//-------------------------------------------------------
	
	public String getImagemStatus() {
		if(this.ativo==true){
			this.imagemStatus="../resources/images/on.png";
		}
		return imagemStatus;
	}

	public void setImagemStatus(String imagemStatus) {
		this.imagemStatus = imagemStatus;
	}
	
	//------------------------------------------------------
	
	
	
}
