/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bancodedados;

import excessoes.ExcecaoEstadoIlegal;
import excessoes.ExcecaoRegraDoBanco;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.auxiliares.CriaId;
import modelos.estoque.ProdutoEstoque;
import org.json.JSONObject;

/**
 *
 * @author tanak
 * @param <T>
 */
public interface IBancoDeDados<T extends ProdutoEstoque> {

    String getNOME_ARQUIVO();

    T parse(JSONObject objeto);

    default int getId(T item) throws FileNotFoundException, IOException {
        try ( BufferedReader br = new BufferedReader(new FileReader(this.getNOME_ARQUIVO()))) {
            String linha;
            JSONObject otherItem;
            while ((linha = br.readLine()) != null) {
                otherItem = new JSONObject(linha);
                if (parse(otherItem).equals(item)) {
                    return otherItem.getInt(controlajson.ControlaJson.keysBancoDeDados[0]);
                }
            }
        }
        return 0;// * item não consta no banco
    }

    default String buscarBancoString() throws FileNotFoundException, IOException {
        StringBuilder bancoCompleto = new StringBuilder();
        try ( BufferedReader br = new BufferedReader(new FileReader(this.getNOME_ARQUIVO()))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                bancoCompleto.append(linha).append("\n");// * adicionando objeto na lista
            }
        }
        return bancoCompleto.toString();
    }

    default ArrayList<JSONObject> buscarBancoObjetos() throws FileNotFoundException, IOException {
        ArrayList<JSONObject> bancoCompleto = new ArrayList<>();
        try ( BufferedReader br = new BufferedReader(new FileReader(this.getNOME_ARQUIVO()))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                bancoCompleto.add(new JSONObject(linha));// * adicionando objeto na lista
            }
        }
        return bancoCompleto;
    }

    default void incluir(T produto) throws ExcecaoRegraDoBanco, IOException {
        ArrayList<T> estoqueCompleto = buscarTodos();
        if (estoqueCompleto != null) {
            for (var item : estoqueCompleto) {
                if (item.equals(produto)) {
                    throw new ExcecaoRegraDoBanco("O produto que está tentando cadastrar já está cadastrado no sistema");
                }
            }
        }
        try ( BufferedWriter br = new BufferedWriter(new FileWriter(this.getNOME_ARQUIVO(), true))) {
            JSONObject item = new JSONObject();
            item.put(controlajson.ControlaJson.keysBancoDeDados[0], CriaId.gerarId(this.getNOME_ARQUIVO()));//  * adicionando id
            item.put(controlajson.ControlaJson.keysProdutoEstoque[3], produto.toString());//    * adicionando os outros atributos do objeto
            br.write(item.toString());
        } catch (IOException ex) {
            throw new ExcecaoEstadoIlegal("Falha ao criar o arquivo: \"" + this.getNOME_ARQUIVO() + "\" ao tentar salvar um novo item no banco de dados");
        }
    }

    default void editar(int id, T novoProduto) throws ExcecaoRegraDoBanco, IOException {
        remover(id);
        incluir(novoProduto);
    }

    default void remover(int id) throws ExcecaoRegraDoBanco {
        boolean achou = false;
        StringBuilder BancoCompleto = new StringBuilder();
        try ( BufferedReader br = new BufferedReader(new FileReader(this.getNOME_ARQUIVO()))) {
            ArrayList listaCompleta = this.buscarBancoObjetos();
            if (listaCompleta == null) {
                throw new ExcecaoRegraDoBanco("Falha na exclusão porque o arquivo que estava sendo excluido não foi encontrado no banco");
            }
            for (var item : listaCompleta) {
                if (this.getId((T) item) == id) {
                    if (achou) {
                        throw new ExcecaoEstadoIlegal("Existem mais de um item com o mesmo ID no banco de dados, o ID repetido é:  + \"" + id + "\"");
                    } else {
                        achou = true;
                    }
                } else {
                    JSONObject objeto = new JSONObject(item.toString());
                    objeto.put(controlajson.ControlaJson.keysBancoDeDados[0], this.getId((T) item));
                    BancoCompleto.append(objeto.toString());
                }
            }
        } catch (IOException ex) {
            throw new ExcecaoEstadoIlegal("Falha ao criar o arquivo: \"" + this.getNOME_ARQUIVO());
        }
        try ( FileWriter fw = new FileWriter(this.getNOME_ARQUIVO())) {
            fw.write(BancoCompleto.toString());
        } catch (IOException ex) {
            throw new ExcecaoEstadoIlegal("Falha ao criar o arquivo: \"" + this.getNOME_ARQUIVO());
        }
    }

    default ArrayList<T> buscarTodos() throws FileNotFoundException, IOException {
        ArrayList<T> listaCompleta = new ArrayList<>();
        try ( BufferedReader br = new BufferedReader(new FileReader(this.getNOME_ARQUIVO()))) {
            String linha = br.readLine();
            while (linha != null) {
                JSONObject obj = new JSONObject(linha);
                T objeto = this.parse(obj);
                listaCompleta.add(objeto);
            }
        }
        if (listaCompleta.isEmpty()) {
            return null;
        }
        return listaCompleta;
    }
}
