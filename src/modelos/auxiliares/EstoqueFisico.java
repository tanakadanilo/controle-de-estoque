/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.auxiliares;

import excessoes.ExcecaoEstadoIlegal;
import excessoes.ExcecaoFalhaDoBancoDeDados;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;

/**
 *
 * @author tanak
 */
public class EstoqueFisico {

    private static String nomeArquivo = "ValoresEstoque.txt";
    private static int quantidadeItens = 12;

    public static void setValores(JSONObject valores) throws IOException, ExcecaoFalhaDoBancoDeDados {
        if (valores.keySet().size() != quantidadeItens) {
            throw new ExcecaoFalhaDoBancoDeDados("A quantidade de dados que devem ser salvas no banco é de: " + quantidadeItens
                    + ", e a quantidade informada foi de:  " + valores.keySet().size());
        }
        try ( BufferedWriter bw = new BufferedWriter(new FileWriter(nomeArquivo))) {
            bw.write(valores.toString());
        }
    }

    public static JSONObject getValoresEstoque() throws FileNotFoundException, IOException, ExcecaoFalhaDoBancoDeDados {
        JSONObject valores = null;
        try ( BufferedReader br = new BufferedReader(new FileReader(EstoqueFisico.getNomeArquivo()))) {
            valores = new JSONObject(br.readLine());
        }
        if (valores.keySet().size() != quantidadeItens) {
            throw new ExcecaoFalhaDoBancoDeDados("A quantidade de dados salva no banco era de: " + valores.keySet().size()
                    + ", e a quantidade esperada era de: " + quantidadeItens);
        }
        return valores;
    }

    public static String getNomeArquivo() {
        return nomeArquivo;
    }

    public static void setNomeArquivo(String nomeArquivo) {
        EstoqueFisico.nomeArquivo = nomeArquivo;
    }

    public static int getQuantidadeItens() {
        return quantidadeItens;
    }

    public static void setQuantidadeItens(int quantidadeItens) {
        EstoqueFisico.quantidadeItens = quantidadeItens;
    }

}
