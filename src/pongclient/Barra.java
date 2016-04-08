package pongclient;

import java.awt.Color;

/**
 *
 * @author Derlei
 */
public class Barra {
    private double posicaoVertical;
    private double posicaoHorizontal;
    private double velocidadeVertical;
    private double velocidadeHorizontal;
    // 1/2 do comprimeto da barra.
    private double comprimento;
    private double espessura;
    private Color cor;

    public Barra(double posicaoVertical, double posicaoHorizontal, double velocidadeVertical, double velocidadeHorizontal, double comprimento, double espessura, Color cor) {
        this.posicaoVertical = posicaoVertical;
        this.posicaoHorizontal = posicaoHorizontal;
        this.velocidadeVertical = velocidadeVertical;
        this.velocidadeHorizontal = velocidadeHorizontal;
        this.comprimento = comprimento;
        this.espessura = espessura;
        this.cor = cor;
    }
    
    public void moveEsquerda(){
        posicaoHorizontal -= 0.04;
    }

    public void moveDireita(){
        posicaoHorizontal += 0.04;
    }

    public double getInicioBarra(){
        return posicaoHorizontal - comprimento;
    }

    public double getFimBarra(){
        return posicaoHorizontal + comprimento;
    }

    public double getPosicaoVertical() {
        return posicaoVertical;
    }

    public double getPosicaoHorizontal() {
        return posicaoHorizontal;
    }

    public double getVelocidadeVertical() {
        return velocidadeVertical;
    }

    public double getVelocidadeHorizontal() {
        return velocidadeHorizontal;
    }

    public double getComprimento() {
        return comprimento;
    }

    public double getEspessura() {
        return espessura;
    }

    public Color getCor() {
        return cor;
    }

    
    
}
