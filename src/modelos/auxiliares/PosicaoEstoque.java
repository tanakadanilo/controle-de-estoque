/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos.auxiliares;

import excessoes.ExcecaoFalhaDoBancoDeDados;
import excessoes.ExcecaoRegraDoBanco;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import org.json.JSONObject;

/**
 *
 * @author tanak
 */
public class PosicaoEstoque {

    /* 
        * classe de localização, informando a posição de algo dentro do estoque
        * o valor "0" será o padrão para caso algo não seja informado
     */
    private static String[] nomeValoresOrganizacao = {"Deposito",// * qual predio está
        "Andar",//  * em qual andar nesse prédio
        "Bloco",//   * em qual bloco desse andar
        "Estante",//    * em qual estante nesse bloco
        "Prateleira",// * em qual prateleira dessa estante
        "Caixa"};// * em qual caixa dessa prateleira

    private int deposito = 0;// * em qual dos predios da empresa está
    private int andar = 0;
    private String bloco = "A";
    private int estante = 0;
    private int prateleira = 0;//    * posição do objeto, na vertical
    private int caixa = 0;//    * posição do objeto, na horizontal

    public PosicaoEstoque() {
    }

    public PosicaoEstoque(int estante, int prateleira, int caixa) throws ExcecaoRegraDoBanco, IOException, FileNotFoundException, ExcecaoFalhaDoBancoDeDados {
        if (!validaValorEstoque(nomeValoresOrganizacao[5], caixa)) {
            throw new ExcecaoRegraDoBanco("A " + nomeValoresOrganizacao[5] + " " + caixa + " não consta no sistema");
        }
        if (!validaValorEstoque(nomeValoresOrganizacao[4], prateleira)) {
            throw new ExcecaoRegraDoBanco("A " + nomeValoresOrganizacao[4] + " " + prateleira + ", não consta no sistema");
        }
        if (!validaValorEstoque(nomeValoresOrganizacao[3], estante)) {
            throw new ExcecaoRegraDoBanco("A " + nomeValoresOrganizacao[3] + " " + estante + ", não consta no sistema");
        }
        this.estante = estante;
        this.prateleira = prateleira;
        this.caixa = caixa;
    }

    public PosicaoEstoque(String bloco, int estante, int prateleira, int caixa) throws IOException, FileNotFoundException, ExcecaoFalhaDoBancoDeDados, ExcecaoRegraDoBanco {
        if (!validaValorEstoque(nomeValoresOrganizacao[5], caixa)) {
            throw new ExcecaoRegraDoBanco("A " + nomeValoresOrganizacao[5] + " " + caixa + " não consta no sistema");
        }
        if (!validaValorEstoque(nomeValoresOrganizacao[4], prateleira)) {
            throw new ExcecaoRegraDoBanco("A " + nomeValoresOrganizacao[4] + " " + prateleira + ", não consta no sistema");
        }
        if (!validaValorEstoque(nomeValoresOrganizacao[3], estante)) {
            throw new ExcecaoRegraDoBanco("A " + nomeValoresOrganizacao[3] + " " + estante + ", não consta no sistema");
        }
        if (!validaValorEstoque(nomeValoresOrganizacao[2], bloco)) {
            throw new ExcecaoRegraDoBanco("A " + nomeValoresOrganizacao[2] + " " + bloco + ", não consta no sistema");
        }
        this.bloco = bloco;
        this.estante = estante;
        this.prateleira = prateleira;
        this.caixa = caixa;
    }

    public PosicaoEstoque(int andar, String bloco, int estante, int prateleira, int caixa) throws IOException, FileNotFoundException,
            ExcecaoFalhaDoBancoDeDados, ExcecaoRegraDoBanco {
        if (!validaValorEstoque(nomeValoresOrganizacao[5], caixa)) {
            throw new ExcecaoRegraDoBanco("A " + nomeValoresOrganizacao[5] + " " + caixa + " não consta no sistema");
        }
        if (!validaValorEstoque(nomeValoresOrganizacao[4], prateleira)) {
            throw new ExcecaoRegraDoBanco("A " + nomeValoresOrganizacao[4] + " " + prateleira + ", não consta no sistema");
        }
        if (!validaValorEstoque(nomeValoresOrganizacao[3], estante)) {
            throw new ExcecaoRegraDoBanco("A " + nomeValoresOrganizacao[3] + " " + estante + ", não consta no sistema");
        }
        if (!validaValorEstoque(nomeValoresOrganizacao[2], bloco)) {
            throw new ExcecaoRegraDoBanco("A " + nomeValoresOrganizacao[2] + " " + bloco + ", não consta no sistema");
        }
        if (!validaValorEstoque(nomeValoresOrganizacao[1], andar)) {
            throw new ExcecaoRegraDoBanco("A " + nomeValoresOrganizacao[1] + " " + andar + ", não consta no sistema");
        }
        this.andar = andar;
        this.bloco = bloco;
        this.estante = estante;
        this.prateleira = prateleira;
        this.caixa = caixa;
    }

    public PosicaoEstoque(int deposito, int andar, String bloco, int estante, int prateleira, int caixa) throws IOException, FileNotFoundException,
            ExcecaoFalhaDoBancoDeDados, ExcecaoRegraDoBanco {
        if (!validaValorEstoque(nomeValoresOrganizacao[5], caixa)) {
            throw new ExcecaoRegraDoBanco("A " + nomeValoresOrganizacao[5] + " " + caixa + " não consta no sistema");
        }
        if (!validaValorEstoque(nomeValoresOrganizacao[4], prateleira)) {
            throw new ExcecaoRegraDoBanco("A " + nomeValoresOrganizacao[4] + " " + prateleira + ", não consta no sistema");
        }
        if (!validaValorEstoque(nomeValoresOrganizacao[3], estante)) {
            throw new ExcecaoRegraDoBanco("A " + nomeValoresOrganizacao[3] + " " + estante + ", não consta no sistema");
        }
        if (!validaValorEstoque(nomeValoresOrganizacao[2], bloco)) {
            throw new ExcecaoRegraDoBanco("A " + nomeValoresOrganizacao[2] + " " + bloco + ", não consta no sistema");
        }
        if (!validaValorEstoque(nomeValoresOrganizacao[1], andar)) {
            throw new ExcecaoRegraDoBanco("A " + nomeValoresOrganizacao[1] + " " + andar + ", não consta no sistema");
        }
        if (!validaValorEstoque(nomeValoresOrganizacao[0], deposito)) {
            throw new ExcecaoRegraDoBanco("A " + nomeValoresOrganizacao[0] + " " + deposito + ", não consta no sistema");
        }
        this.deposito = deposito;
        this.andar = andar;
        this.bloco = bloco;
        this.estante = estante;
        this.prateleira = prateleira;
        this.caixa = caixa;
    }

    public int getDeposito() {
        return deposito;
    }

    public void setDeposito(int deposito) throws IOException, FileNotFoundException,
            ExcecaoFalhaDoBancoDeDados, ExcecaoRegraDoBanco {
        if (!validaValorEstoque(nomeValoresOrganizacao[0], deposito)) {
            throw new ExcecaoRegraDoBanco("A " + nomeValoresOrganizacao[0] + " informada não consta no sistema");
        }
        this.deposito = deposito;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) throws IOException, FileNotFoundException,
            ExcecaoFalhaDoBancoDeDados, ExcecaoRegraDoBanco {
        if (!validaValorEstoque(nomeValoresOrganizacao[1], andar)) {
            throw new ExcecaoRegraDoBanco("A " + nomeValoresOrganizacao[1] + " informada não consta no sistema");
        }
        this.andar = andar;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) throws IOException, FileNotFoundException,
            ExcecaoFalhaDoBancoDeDados, ExcecaoRegraDoBanco {
        if (!validaValorEstoque(nomeValoresOrganizacao[2], bloco)) {
            throw new ExcecaoRegraDoBanco("A " + nomeValoresOrganizacao[2] + " informada não consta no sistema");
        }
        this.bloco = bloco;
    }

    public int getEstante() {
        return estante;
    }

    public void setEstante(int estante) throws IOException, FileNotFoundException,
            ExcecaoFalhaDoBancoDeDados, ExcecaoRegraDoBanco {
        if (!validaValorEstoque(nomeValoresOrganizacao[3], estante)) {
            throw new ExcecaoRegraDoBanco("A " + nomeValoresOrganizacao[3] + " informada não consta no sistema");
        }
        this.estante = estante;
    }

    public int getPrateleira() {
        return prateleira;
    }

    public void setPrateleira(int prateleira) throws IOException, FileNotFoundException,
            ExcecaoFalhaDoBancoDeDados, ExcecaoRegraDoBanco {
        if (!validaValorEstoque(nomeValoresOrganizacao[4], prateleira)) {
            throw new ExcecaoRegraDoBanco("A " + nomeValoresOrganizacao[4] + " informada não consta no sistema");
        }
        this.prateleira = prateleira;
    }

    public int getCaixa() {
        return caixa;
    }

    public void setCaixa(int caixa) throws IOException, FileNotFoundException,
            ExcecaoFalhaDoBancoDeDados, ExcecaoRegraDoBanco {
        if (!validaValorEstoque(nomeValoresOrganizacao[5], caixa)) {
            throw new ExcecaoRegraDoBanco("A " + nomeValoresOrganizacao[5] + " informada não consta no sistema");
        }
        this.caixa = caixa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.deposito;
        hash = 37 * hash + this.andar;
        hash = 37 * hash + Objects.hashCode(this.bloco);
        hash = 37 * hash + this.estante;
        hash = 37 * hash + this.prateleira;
        hash = 37 * hash + this.caixa;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PosicaoEstoque other = (PosicaoEstoque) obj;
        if (this.deposito != other.deposito) {
            return false;
        }
        if (this.andar != other.andar) {
            return false;
        }
        if (this.estante != other.estante) {
            return false;
        }
        if (this.prateleira != other.prateleira) {
            return false;
        }
        if (this.caixa != other.caixa) {
            return false;
        }
        return Objects.equals(this.bloco, other.bloco);
    }

    private static boolean validaValorEstoque(String key, int valor) throws IOException, FileNotFoundException, ExcecaoFalhaDoBancoDeDados {
        JSONObject valores = EstoqueFisico.getValoresEstoque();
        int menorValor = valores.getInt("Menor " + key);
        int maiorValor = valores.getInt("Maior " + key);
        return valor >= menorValor && valor <= maiorValor;//   * não negativo nem zero e não estourou o int
    }

    private static boolean validaValorEstoque(String key, String valor) throws IOException, FileNotFoundException, ExcecaoFalhaDoBancoDeDados {
        JSONObject valores = EstoqueFisico.getValoresEstoque();
        String menorPrateleira = valores.getString("Menor " + key);
        String maiorPrateleira = valores.getString("Maior " + key);
        return valor.compareTo(menorPrateleira) >= 0
                && valor.compareTo(maiorPrateleira) <= 0;//   * Está dentro dos valores informados
    }

    @Override
    public String toString() {
        JSONObject obj = new JSONObject();
        obj.put(nomeValoresOrganizacao[0], deposito);
        obj.put(nomeValoresOrganizacao[1], andar);
        obj.put(nomeValoresOrganizacao[2], bloco);
        obj.put(nomeValoresOrganizacao[3], estante);
        obj.put(nomeValoresOrganizacao[4], prateleira);
        obj.put(nomeValoresOrganizacao[5], caixa);
        return obj.toString();
    }

}
