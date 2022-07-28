/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.estoque;

/**
 *
 * @author tanak
 */
public abstract class estoque {

    /* *
        * classe pai de tudo que será salvo no estoque
     */
    protected final String NOME_ARQUIVO;
    protected final String NOME_TIPO;
    protected int quantidadeNoEstoque = 0;
    protected int quantidadeMinima = 0;

    public estoque(String NOME_ARQUIVO, String NOME_TIPO) {
        this.NOME_ARQUIVO = NOME_ARQUIVO;
        this.NOME_TIPO = NOME_TIPO;
    }

    public estoque(String NOME_ARQUIVO, String NOME_TIPO, int quantidadeNoEstoque) {
        this.NOME_ARQUIVO = NOME_ARQUIVO;
        this.NOME_TIPO = NOME_TIPO;
        this.quantidadeNoEstoque = quantidadeNoEstoque;
    }

    public estoque(String NOME_ARQUIVO, String NOME_TIPO, int quantidadeNoEstoque, int quantidadeMinima) {
        this.NOME_ARQUIVO = NOME_ARQUIVO;
        this.NOME_TIPO = NOME_TIPO;
        this.quantidadeNoEstoque = quantidadeNoEstoque;
        this.quantidadeMinima = quantidadeMinima;
    }

    public String getNOME_ARQUIVO() {
        return NOME_ARQUIVO;
    }

    public String getNOME_TIPO() {
        return NOME_TIPO;
    }

    public int getQuantidadeNoEstoque() {
        return quantidadeNoEstoque;
    }

    public void setQuantidadeNoEstoque(int quantidadeNoEstoque) {
        this.quantidadeNoEstoque = quantidadeNoEstoque;
    }

    public int getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(int quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

}
