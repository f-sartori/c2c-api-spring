package com.generation.c2cspring.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVenda;
	private double valorTotal;
	
	@ManyToOne
	@JsonIgnoreProperties(value = {"compras","vendedor"})
	private Usuario usuario;
	
	@ManyToOne
	@JsonIgnoreProperties(value = {"telefone","senha","senhaConf","produtos","produtos","compras"})
	private Vendedor vendedor;
	
	@ManyToOne
	@JsonIgnoreProperties(value = {"compras","vendedor","categoria"})
	private Produto produto;

	public int getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProdutos(Produto produto) {
		this.produto = produto;
	}
	
	
	
	
}
