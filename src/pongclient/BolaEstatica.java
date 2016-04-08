/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pongclient;

import java.awt.Color;

/**
 *
 * @author Derlei
 */
public class BolaEstatica {
    
    private double posicaoVertical;
    private double posicaoHorizontal;
    private double raio;
    private Color cor;

    public BolaEstatica(double posicaoVertical, double posicaoHorizontal, double raio, Color cor) {
        this.posicaoVertical = posicaoVertical;
        this.posicaoHorizontal = posicaoHorizontal;
        this.raio = raio;
        this.cor = cor;
    }

    public double getPosicaoVertical() {
        return posicaoVertical;
    }

    public double getPosicaoHorizontal() {
        return posicaoHorizontal;
    }

    public double getRaio() {
        return raio;
    }

    public Color getCor() {
        return cor;
    }

    protected void setPosicaoVertical(double posicaoVertical) {
        this.posicaoVertical = posicaoVertical;
    }

    protected void setPosicaoHorizontal(double posicaoHorizontal) {
        this.posicaoHorizontal = posicaoHorizontal;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }
}