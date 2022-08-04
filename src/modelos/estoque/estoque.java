/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.estoque;

/**
 *
 * @author tanak
 */
public interface estoque {

    /* *
        * classe pai de tudo que será salvo no estoque
     */
    String getNOME_ARQUIVO();

    int getQuantidadeNoEstoque();

    void setQuantidadeNoEstoque(int quantidadeNoEstoque);

    int getQuantidadeMinima();

    void setQuantidadeMinima(int quantidadeMinima);

    boolean isAtivo();

    void ativar();

    void desativar();
}
