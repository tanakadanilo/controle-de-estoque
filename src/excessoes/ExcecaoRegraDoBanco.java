/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excessoes;

/**
 *
 * @author tanak
 */
public class ExcecaoRegraDoBanco extends Exception {

    public ExcecaoRegraDoBanco() {
    }

    public ExcecaoRegraDoBanco(String message) {
        super(message);
    }

    public ExcecaoRegraDoBanco(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcecaoRegraDoBanco(Throwable cause) {
        super(cause);
    }

    public ExcecaoRegraDoBanco(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
