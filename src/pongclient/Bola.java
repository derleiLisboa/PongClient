
package pongclient;

import java.awt.Color;

/**
 *
 * @author Honras à casa de Stark
 */
public class Bola extends BolaEstatica{
    
    private double velocidadeVertical;
    private double velocidadeHorizontal;

    public Bola(double posicaoVertical, double posicaoHorizontal, double velocidadeVertical, double velocidadeHorizontal, double raio, Color cor) {
        super(posicaoVertical, posicaoHorizontal, raio, cor);
        this.velocidadeVertical = velocidadeVertical;
        this.velocidadeHorizontal = velocidadeHorizontal;
    }

    public void mover(){
        setPosicaoHorizontal(velocidadeHorizontal + getPosicaoHorizontal());
        setPosicaoVertical(velocidadeVertical + getPosicaoVertical());
    }

    public void inverteVelocidadeVertical(){
        velocidadeVertical *= -1;
    }

    public void inverteVelocidadeHorizontal(){
        velocidadeHorizontal *= -1;
    }

    public double getVelocidadeVertical() {
        return velocidadeVertical;
    }

    public double getVelocidadeHorizontal() {
        return velocidadeHorizontal;
    }
}
