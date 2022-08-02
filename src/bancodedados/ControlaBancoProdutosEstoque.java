/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bancodedados;

import controlajson.ControlaJson;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Produto;
import modelos.estoque.ProdutoEstoque;
import org.json.JSONObject;

/**
 *
 * @author tanak
 */
public class ControlaBancoProdutosEstoque implements IBancoDeDados<ProdutoEstoque> {

    ProdutoEstoque produtoEstoque = new ProdutoEstoque();

    public ControlaBancoProdutosEstoque() {
    }

    @Override
    public ProdutoEstoque parse(JSONObject objeto) {
        int quantidadeEstoque = objeto.getInt(ControlaJson.keysProdutoEstoque[0]);
        int estoqueMinimo = objeto.getInt(ControlaJson.keysProdutoEstoque[1]);
        boolean ativo = objeto.getBoolean(ControlaJson.keysProdutoEstoque[2]);
        String nome = objeto.getString(ControlaJson.keysProduto[0]);
        String codigo = objeto.getString(ControlaJson.keysProduto[1]);
        String descricao = objeto.getString(ControlaJson.keysProduto[2]);
        return new ProdutoEstoque(quantidadeEstoque, estoqueMinimo, nome, codigo, descricao);

    }

    @Override
    public String getNOME_ARQUIVO() {
        return new ProdutoEstoque().getNOME_ARQUIVO();
    }

    @Override
    public String getNOME_TIPO() {
        return new ProdutoEstoque().getNOME_TIPO();
    }

    @Override
    public ArrayList<ProdutoEstoque> buscarTodos() throws IOException {
        ArrayList<ProdutoEstoque> listaCompleta = new ArrayList<>();
        try ( BufferedReader br = new BufferedReader(new FileReader(this.getNOME_ARQUIVO() + "." + this.getNOME_TIPO()))) {

            String linha = br.readLine();
            while (linha != null) {

                ProdutoEstoque p = parse(new JSONObject(linha));
                if (p.isAtivo()) {
                    listaCompleta.add(p);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(this.getNOME_ARQUIVO() + "." + this.getNOME_TIPO());
            Logger.getLogger(ControlaBancoProdutosEstoque.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (listaCompleta.isEmpty()) {
                return null;
            }
            return listaCompleta;
        }
    }

}
