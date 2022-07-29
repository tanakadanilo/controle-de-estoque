/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.estoque;

import modelos.Produto;
import org.json.JSONObject;

/**
 *
 * @author tanak
 */
public class ProdutoEstoque extends Produto implements estoque {

    protected final String NOME_ARQUIVO;
    protected final String TIPO_ARQUIVO;
    protected int quantidadeEstoque;
    protected int estoqueMinimo;
    protected boolean ativo = true;

    public ProdutoEstoque() {
        this.NOME_ARQUIVO = "null";
        this.TIPO_ARQUIVO = "null";
    }

    public ProdutoEstoque(int quantidadeEstoque, int estoqueMinimo, String nome, String codigo, String descricao) {
        super(nome, codigo, descricao);
        this.NOME_ARQUIVO = nome;
        this.TIPO_ARQUIVO = "txt";
        this.quantidadeEstoque = quantidadeEstoque;
        this.estoqueMinimo = estoqueMinimo;
    }

    @Override
    public String getNOME_ARQUIVO() {
        return this.NOME_ARQUIVO;
    }

    @Override
    public String getNOME_TIPO() {
        return this.TIPO_ARQUIVO;
    }

    @Override
    public int getQuantidadeNoEstoque() {
        return this.quantidadeEstoque;
    }

    @Override
    public void setQuantidadeNoEstoque(int quantidadeNoEstoque) {
        this.quantidadeEstoque = quantidadeNoEstoque;
    }

    @Override
    public int getQuantidadeMinima() {
        return this.estoqueMinimo;
    }

    @Override
    public void setQuantidadeMinima(int quantidadeMinima) {
        estoqueMinimo = quantidadeMinima;
    }

    @Override
    public boolean isAtivo() {
        return this.ativo;
    }

    @Override
    public void ativar() {
        this.ativo = true;
    }

    @Override
    public void desativar() {
        this.ativo = false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ProdutoEstoque{");
        sb.append("quantidadeEstoque=").append(quantidadeEstoque);
        sb.append(", estoqueMinimo=").append(estoqueMinimo);
        sb.append(", ativo=").append(ativo);
        sb.append(super.toString());
        sb.append('}');
        return sb.toString();
    }

}
