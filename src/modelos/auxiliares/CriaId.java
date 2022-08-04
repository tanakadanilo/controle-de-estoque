/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.auxiliares;

import excessoes.ExcecaoEstadoIlegal;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author tanak
 */
public class CriaId {

    public static int gerarId(String nomeDoArquivoID) {
        int id;
        try ( BufferedReader br = new BufferedReader(new FileReader(nomeDoArquivoID))) {
            id = Integer.parseInt(br.readLine());//   * salvando o ID
            id++;
            try ( FileWriter fw = new FileWriter(nomeDoArquivoID)) {
                fw.write("" + id);
            }
        } catch (NumberFormatException | IOException e) {//   * o arquivo não existe ou foi corrompido
            throw new ExcecaoEstadoIlegal("O arquivo: \"" + nomeDoArquivoID + "\", que contem o ID do banco foi perdido,"
                    + " por isso não é mais possivel incluir nada no banco de dados, contacte o suporte técnico para resolver o problema");
        }
        return id;
    }
}
