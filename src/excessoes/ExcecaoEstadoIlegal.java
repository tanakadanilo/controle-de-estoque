/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excessoes;

/**
 *
 * @author tanak
 */
public class ExcecaoEstadoIlegal extends IllegalStateException {

    public ExcecaoEstadoIlegal() {
    }

    public ExcecaoEstadoIlegal(String s) {
        super(s);
    }

    public ExcecaoEstadoIlegal(String message, Throwable cause) {
        super(message, cause);
    }

    public ExcecaoEstadoIlegal(Throwable cause) {
        super(cause);
    }

}
