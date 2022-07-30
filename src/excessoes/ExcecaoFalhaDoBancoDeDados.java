/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excessoes;

/**
 *
 * @author tanak
 */
public class ExcecaoFalhaDoBancoDeDados extends Exception {

    public ExcecaoFalhaDoBancoDeDados() {
    }

    public ExcecaoFalhaDoBancoDeDados(String message) {
        super(message);
    }

    public ExcecaoFalhaDoBancoDeDados(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcecaoFalhaDoBancoDeDados(Throwable cause) {
        super(cause);
    }

    public ExcecaoFalhaDoBancoDeDados(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
