/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.juniordev.gerfina.models;

import br.com.juniordev.gerfina.enums.StatusLancamento;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author junior
 */
@Entity
public class Lancamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descricao;
    @NotNull(message = "Valor original é um campo obrigatório")
    @Temporal(TemporalType.DATE)
    private Date dataVencimento;
    @Temporal(TemporalType.DATE)
    private Date dataPgtoRcto;
    @NotNull(message = "Valor original é um campo obrigatório")
    @DecimalMin(value = "0.01", message = "Valor original não deve ser inferior a 0,01")
    @Column(precision = 10, scale = 2)
    private BigDecimal valorOriginal;
    @Column(precision = 10, scale = 2)
    @DecimalMin(value = "0.01", message = "Valor do pagamento/recebimento não deve ser inferior a 0,01")
    private BigDecimal valorPagoRecebido;
    @Column(precision = 10, scale = 2)
    @DecimalMin(value = "0.01", message = "Valor do juros não deve ser inferior a 0,01")
    private BigDecimal valorJuros;
    @Column(precision = 10, scale = 2)
    @DecimalMin(value = "0.01", message = "Valor do desconto não deve ser inferior a 0,01")
    private BigDecimal valorDesconto;
    @Column(precision = 10, scale = 2)
    @DecimalMin(value = "0.01", message = "Valor do acréscimo não deve ser inferior a 0,01")
    private BigDecimal valorAcrescimo;
    @Enumerated(EnumType.ORDINAL)
    private StatusLancamento status;
    
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Conta conta;
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
    @ManyToOne
    @JoinColumn(name = "cartao_credito_id")
    private CartaoCredito cartaoCredito;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public BigDecimal getValorOriginal() {
        return valorOriginal;
    }

    public void setValorOriginal(BigDecimal valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    public BigDecimal getValorPagoRecebido() {
        return valorPagoRecebido;
    }

    public void setValorPagoRecebido(BigDecimal valorPagoRecebido) {
        this.valorPagoRecebido = valorPagoRecebido;
    }

    public Date getDataPgtoRcto() {
        return dataPgtoRcto;
    }

    public void setDataPgtoRcto(Date dataPgtoRcto) {
        this.dataPgtoRcto = dataPgtoRcto;
    }

    public BigDecimal getValorJuros() {
        return valorJuros;
    }

    public void setValorJuros(BigDecimal valorJuros) {
        this.valorJuros = valorJuros;
    }

    public BigDecimal getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(BigDecimal valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public StatusLancamento getStatus() {
        return status;
    }

    public void setStatus(StatusLancamento status) {
        this.status = status;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public CartaoCredito getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(CartaoCredito cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    public BigDecimal getValorAcrescimo() {
        return valorAcrescimo;
    }

    public void setValorAcrescimo(BigDecimal valorAcrescimo) {
        this.valorAcrescimo = valorAcrescimo;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lancamento)) {
            return false;
        }
        Lancamento other = (Lancamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.gerfina.models.Lancamento[ id=" + id + " ]";
    }
    
}
