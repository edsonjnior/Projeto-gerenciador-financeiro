/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.juniordev.gerfina.controllers;

import br.com.juniordev.gerfina.enums.PeriodosRepetir;
import br.com.juniordev.gerfina.jpa.CategoriaDao;
import br.com.juniordev.gerfina.jpa.ContaDao;
import br.com.juniordev.gerfina.jpa.PessoaDao;
import br.com.juniordev.gerfina.models.Categoria;
import br.com.juniordev.gerfina.models.Conta;
import br.com.juniordev.gerfina.models.Lancamento;
import br.com.juniordev.gerfina.models.Pessoa;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import org.primefaces.PrimeFaces;

/**
 *
 * @author junior
 */
@Named(value = "lancamentoBean")
@ViewScoped
public class LancamentoBean implements Serializable {

    private static final long serialVersionUID = 8273257043275693971L;
    private static final Logger LOG = Logger.getLogger(LancamentoBean.class.getName());

    @Inject
    private PessoaDao pessoaDao;
    @Inject
    private ContaDao contaDao;
    @Inject
    private CategoriaDao categoriaDao;
    @Inject
    private ContaBean contaBean;
    @Inject
    private PessoaBean pessoaBean;
    @Inject
    private CategoriaBean categoriaBean;
    
    private Lancamento lancamento;
    private Conta conta;
    private Pessoa pessoa;
    private Categoria categoria;
    private Integer repetirPeriodo;
    private List<Pessoa> pessoas;
    private List<Conta> contas;
    private List<Categoria> categorias;
    private boolean repetirLancamento;
    private boolean usarCartao;
    private Long idPessoa;
    private Long idConta;

    private String textoTeste;

    public LancamentoBean() {
        novoLancamento();
        novaConta();
        novaPessoa();
        novaCategoria();
    }

    private void novoLancamento() {
        lancamento = new Lancamento();
        repetirLancamento = false;
        usarCartao = false;
    }
    
    public void novaConta(){
       conta = new Conta();
    }
    
    public void novaCategoria(){
        categoria = new Categoria();
    }
    
    public void novaPessoa(){
        pessoa = new Pessoa();
    }

    public void salvarConta(){
        Conta c = contaBean.salvarComRetorno();
        contas.add(c);
        conta = c;
        contaBean.novaConta();
        
        PrimeFaces primeFaces = PrimeFaces.current();
        primeFaces.executeScript("modal('modalCadastroSimplesConta', 'hide')");
    }
    
    public void salvarPessoa(){
        Pessoa p = pessoaBean.salvarComRetorno();
        pessoas.add(p);
        pessoa = p;
        pessoaBean.novaPessoa();
        
        PrimeFaces primeFaces = PrimeFaces.current();
        primeFaces.executeScript("modal('modalCadastroSimplesPessoa', 'hide')");
    }
    
    public void salvarCategoria(){
        Categoria c = categoriaBean.salvarComRetorno();
        categorias.add(c);
        categoria = c;
        categoriaBean.novaCategoria();
        
        PrimeFaces primeFaces = PrimeFaces.current();
        primeFaces.executeScript("modal('modalCadastroSimplesCategoria', 'hide')");
    }
    
    public Integer getRepetirPeriodo() {
        return repetirPeriodo;
    }

    public void setRepetirPeriodo(Integer repetirPeriodo) {
        this.repetirPeriodo = repetirPeriodo;
    }

    public Lancamento getLancamento() {
        return lancamento;
    }

    public void setLancamento(Lancamento lancamento) {
        this.lancamento = lancamento;
    }

    public boolean isRepetirLancamento() {
        return repetirLancamento;
    }

    public void setRepetirLancamento(boolean repetirLancamento) {
        this.repetirLancamento = repetirLancamento;
    }

    public boolean isUsarCartao() {
        return usarCartao;
    }

    public void setUsarCartao(boolean usarCartao) {
        this.usarCartao = usarCartao;
    }

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Long getIdConta() {
        return idConta;
    }

    public void setIdConta(Long idConta) {
        this.idConta = idConta;
    }
    

    public List<Pessoa> getPessoas() {
        if(pessoas == null){
            pessoas = pessoaDao.listarPessoasOrderAsc();
        }
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }

    
    public PeriodosRepetir[] periodosRepetir(){
        return PeriodosRepetir.values();
    }

    public List<Conta> getContas() {
        if(contas == null){
            contas = contaDao.listarContasOrderAsc();
        }
        return contas;
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

    public List<Categoria> getCategorias() {
        if(categorias == null){
            categorias = categoriaDao.listarCategoriasOrderAsc();
        }
        return categorias;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    
    //    TESTES
    public void metodoTeste() {
        if (idPessoa != null) {
            Pessoa p = pessoaDao.find(idPessoa);
            System.out.println(p);
        }else{
            System.out.println("Nenhuma pessoa");
        }
    }
}
