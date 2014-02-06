package br.com.jomow.model.ajrc;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pedido {
	//CODIGO
	private Long codigo;
	//A1
	private String nomeCliente;
	//A3
	private Date dataPedido;
	//A4
	private String telefone;
	//A9
	private String endereco;
	//A11
	private String bairro;
	//A12
	private String cidade;
	//A14
	private String cliente;
	//A18
	private String userSystem;
	//A25
	private String referenciaEndereco;
	//A22
	private String status;
	//A15
	private String condicaoDePagamento;		
	//A39
	private Double troco;
	//A41
	private Double txEntrega;
	//A42
	private Double total;
	//A45
	private Double valorCompra;
	//P1
	private Integer qtde;
	//P2
	private String codigoProduto;
	//P3
	private String descricaoProduto;
	//P7
	private Double valorProduto;
	//K2
	private String horarioPedido;
	
	private String md5;
	
	public Pedido(ResultSet results) throws SQLException {
		
			setCodigo(results.getLong("CODIGO"));
			setBairro(results.getString("A11"));
			setCidade(results.getString("A12"));
			setCliente(results.getString("A14"));
			setCodigoProduto(results.getString("P2"));
			setCondicaoDePagamento(results.getString("A15"));
			setDataPedido(results.getDate("A3"));
			setDescricaoProduto(results.getString("P3"));
			setEndereco(results.getString("A9"));
			setHorarioPedido(results.getString("K2"));
			setNomeCliente(results.getString("A1"));
			setQtde(results.getInt("P1"));
			setReferenciaEndereco(results.getString("A25"));
			setStatus(results.getString("A22"));
			setTelefone(results.getString("A4"));
			setTotal(results.getDouble("A42"));
			setTroco(results.getDouble("A39"));
			setTxEntrega(results.getDouble("A41"));
			setUserSystem(results.getString("A18"));
			setValorCompra(results.getDouble("A45"));
			setValorProduto(results.getDouble("P7"));			
		
	}	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public Date getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getUserSystem() {
		return userSystem;
	}
	public void setUserSystem(String userSystem) {
		this.userSystem = userSystem;
	}
	public String getReferenciaEndereco() {
		return referenciaEndereco;
	}
	public void setReferenciaEndereco(String referenciaEndereco) {
		this.referenciaEndereco = referenciaEndereco;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCondicaoDePagamento() {
		return condicaoDePagamento;
	}
	public void setCondicaoDePagamento(String condicaoDePagamento) {
		this.condicaoDePagamento = condicaoDePagamento;
	}
	public Double getTroco() {
		return troco;
	}
	public void setTroco(Double troco) {
		this.troco = troco;
	}
	public Double getTxEntrega() {
		return txEntrega;
	}
	public void setTxEntrega(Double txEntrega) {
		this.txEntrega = txEntrega;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Double getValorCompra() {
		return valorCompra;
	}
	public void setValorCompra(Double valorCompra) {
		this.valorCompra = valorCompra;
	}
	public Integer getQtde() {
		return qtde;
	}
	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}
	public String getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(String codigoProduto) {
		this.codigoProduto = codigoProduto;
	}
	public String getDescricaoProduto() {
		return descricaoProduto;
	}
	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}
	public Double getValorProduto() {
		return valorProduto;
	}
	public void setValorProduto(Double valorProduto) {
		this.valorProduto = valorProduto;
	}
	public String getHorarioPedido() {
		return horarioPedido;
	}
	public void setHorarioPedido(String horarioPedido) {
		this.horarioPedido = horarioPedido;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}
	

}
