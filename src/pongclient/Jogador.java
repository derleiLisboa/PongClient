/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pongclient;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Derlei
 */
public class Jogador {
    
    private String nome;
    private int pontos;

    public Jogador(String nome) {
        this.nome = nome;
        this.pontos = 0;
    }

    public Jogador(String nome, int pontos) {
        this.nome = nome;
        this.pontos = pontos;
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
}