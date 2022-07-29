/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import org.json.JSONObject;

/**
 *
 * @author tanak
 */
public class Produto {

    /* * 
        * classe generica de tudo que será salvo no estoque
     */
    protected String nome;
    protected String codigo;
    protected String descricao;

    public Produto() {
    }

    public Produto(String nome, String codigo, String descricao) {
        this.nome = nome;
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        JSONObject obj = new JSONObject();
        obj.put("nome", nome);
        obj.put("codigo", codigo);
        obj.put("descricao", descricao);
        return obj.toString();
    }

}
