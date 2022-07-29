/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bancodedados;

import excessoes.ExcecaoEstadoIlegal;
import excessoes.ExcecaoRegraDoBanco;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.estoque.ProdutoEstoque;

/**
 *
 * @author tanak
 * @param <T>
 */
public interface IBancoDeDados<T extends ProdutoEstoque> {

    String getNOME_ARQUIVO();

    String getNOME_TIPO();

    default void incluir(T produto) throws ExcecaoRegraDoBanco {
        ArrayList<T> estoqueCompleto = buscarTodos();
        if (estoqueCompleto != null) {
            for (var item : estoqueCompleto) {
                if (item.equals(produto)) {
                    throw new ExcecaoRegraDoBanco("O produto que está tentando cadastrar já está cadastrado no sistema");
                }
            }
            try ( BufferedWriter br = new BufferedWriter(new FileWriter(this.getNOME_ARQUIVO() + "." + this.getNOME_TIPO(), true))) {
                br.write(produto.toString());
            } catch (IOException ex) {
                throw new ExcecaoEstadoIlegal("Falha ao criar o arquivo: \"" + this.getNOME_ARQUIVO() + "." + this.getNOME_TIPO());
            }
        }
    }

    default void editar(int id, T novoProduto) throws ExcecaoRegraDoBanco {
        remover(id);
        incluir(novoProduto);
    }

    default void remover(int id) {
        boolean achou = false;
        try ( BufferedReader br = new BufferedReader(new FileReader(this.getNOME_ARQUIVO() + "." + this.getNOME_TIPO()))) {
            StringBuilder BancoCompleto;
        } catch (IOException ex) {
            throw new ExcecaoEstadoIlegal("Falha ao criar o arquivo: \"" + this.getNOME_ARQUIVO() + "." + this.getNOME_TIPO());
        }
    }

    ArrayList<T> buscarTodos();
}
