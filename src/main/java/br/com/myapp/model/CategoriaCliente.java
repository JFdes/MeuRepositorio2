package br.com.myapp.model;

public class CategoriaCliente {

	//repercutirá na classe Cliente.
		private String CategoriaCliente;
		private boolean ativo;
		
		//Getters e Setters:
		
		public String getCategoriaCliente() {
			return CategoriaCliente;
		}
		public void setCategoriaCliente(String categoriaCliente) {
			CategoriaCliente = categoriaCliente;
		}
		public boolean isAtivo() {
			return ativo;
		}
		public void setAtivo(boolean ativo) {
			this.ativo = ativo;
		}
}
