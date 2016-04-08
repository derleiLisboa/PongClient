/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pongclient;

/**
 *
 * @author Derlei
 */
public class Jogador {
    
    private String nome;
    private int pontos;
    private int vidas;

    public Jogador(String nome) {
        this.nome = nome;
        this.pontos = 0;
        this.vidas = 3;
    }

    public Jogador(String nome, int pontos) {
        this.nome = nome;
        this.pontos = pontos;
        this.vidas = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontos() {
        return pontos;
    }

    public int getVidas() {
        return vidas;
    }
    
    public void incrementarPontouacao(){
        this.pontos++;
    }
    
    public void decrementarVida(){
        this.vidas--;
    }
    
    
}
