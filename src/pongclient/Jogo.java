package pongclient;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.event.KeyEvent;

/**
 *
 * @author Derlei
 */
public class Jogo implements Runnable{

    
    private final String PATH_PROJETO = UtilPath.getPastaPrincipal();
    //"C:\\Users\\Derlei\\Documents\\NetBeansProjects\\PongClient\\src\\pongclient";
    private final String PATH_SOM_JOGO = PATH_PROJETO + "sounds\\mario.wav";
    private final String PATH_SOM_BOLA_PINGANDO = PATH_PROJETO + "sounds\\moeda.wav";
    private final String PATH_SOM_SUBIR_NIVEL = PATH_PROJETO + "sounds\\aumentaVeloc.wav";
    private final String PATH_SOM_FIM_JOGO = PATH_PROJETO + "sounds\\fim.wav";
    private final String PATH_IMAGEM_PLANO_DE_FUNDO = PATH_PROJETO + "img\\img.png";

    private final double INICIO_TELA = -1.0;
    private final double FIM_TELA = 1.0;

    private Jogador jogador;
    private Barra barra;
    private Bola bola;

    private BolaEstatica vidaUm;
    private BolaEstatica vidaDois;
    private BolaEstatica vidaTres;

    private int velocidade = 20;
    private int contadorPing = 1;
    private AudioClip audio;

    @Override
    public void run() {
        inicializarJogo();

        StdDraw.setXscale(INICIO_TELA, FIM_TELA);
        StdDraw.setYscale(INICIO_TELA, FIM_TELA);

        while (true) {
            if (Math.abs(bola.getPosicaoHorizontal() + bola.getVelocidadeHorizontal()) > FIM_TELA - bola.getRaio()) {
                bola.inverteVelocidadeHorizontal();
            }
            if (Math.abs(bola.getPosicaoVertical() + bola.getVelocidadeVertical()) > FIM_TELA - bola.getRaio()) {
                bola.inverteVelocidadeVertical();
            }

            //Se colidir com a barra
            if(estaColidindoComBarra()){
                bola.inverteVelocidadeVertical();
                jogador.incrementarPontouacao();
                contadorPing++;
                reproduzirSomContatoComBarra();
            }

            //Se passar pela barra
            if(passouPelaBarra()){
                jogador.decrementarVida();
                reinicializarBola();

                if(jogador.getVidas() == 0){

                    audio.stop();
                    reproduzirSomFimDeJogo();

                    StdDraw.setPenColor(Color.WHITE);
                    StdDraw.text(0.5, 0.9, "Fim do Jogo");
                    StdDraw.show(1);
                    break;
                }

                switch(jogador.getVidas()){
                    case 2:
                        vidaTres.setCor(Color.GRAY);
                        break;
                    case 1:
                        vidaDois.setCor(Color.GRAY);
                        break;
                }
            }

            if(contadorPing % 5 == 0){
                velocidade--;
                contadorPing++;
                reproduzirSomAumentarVelocidade();
            }

            bola.mover();

            imprimirPlanoDeFundo();
            imprimirBola();
            imprimirBarra();
            imprimirPontos();
            imprimirVidas();
            
            verificaTeclasPressionadas();
            
            StdDraw.show(velocidade);
            
        }
    }

    private void inicializarJogo(){
        obterJogador();
        iniciarSomDoJogo();
        inicializarBola();
        inicializarBarra();
        inicializarVida();
    }

    private void obterJogador() {
        jogador = new Jogador("Xico");
    }

    private void iniciarSomDoJogo() {
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                audio = StdAudio.loop(PATH_SOM_JOGO);
            }
        }).start();
    }

    private void inicializarBola() {
        bola = new Bola(0.480, 0.860, 0.023, 0.015, 0.05, Color.red);
    }

    private void reinicializarBola() {
        bola = new Bola(0.480, 0.860, bola.getVelocidadeVertical(), 0.023, 0.05, Color.red);
    }

    private void inicializarBarra() {
        barra = new Barra(-0.80, 0.01, 0.015, 0, 0.30, 0.05, Color.gray);
    }

    private void inicializarVida() {
        vidaUm = new BolaEstatica(0.95,-0.9,  0.03, Color.green);
        vidaDois = new BolaEstatica(0.95, -0.8, 0.03, Color.green);
        vidaTres = new BolaEstatica(0.95, -0.7, 0.03, Color.green);
    }

    private boolean estaColidindoComBarra() {

        boolean retorno = ((bola.getPosicaoVertical() + bola.getVelocidadeVertical() + bola.getRaio() < barra.getPosicaoVertical() + bola.getRaio())&&(bola.getPosicaoVertical()+bola.getVelocidadeVertical() < barra.getPosicaoVertical()));
        retorno = (retorno && ((bola.getPosicaoHorizontal() + bola.getVelocidadeHorizontal() > barra.getPosicaoHorizontal() - barra.getComprimento()) && (bola.getPosicaoHorizontal() + bola.getVelocidadeHorizontal() < barra.getPosicaoHorizontal() + barra.getComprimento())));

        return retorno;   
    }

    private boolean passouPelaBarra() {//((rx + vx > brx - (hw)) && (rx + vx < brx + (hw- 20))
        boolean retorno = (bola.getPosicaoVertical() + bola.getVelocidadeVertical() < barra.getPosicaoVertical() - 0.05);
        
        return retorno;
    }

    private void reproduzirSomContatoComBarra() {
        StdAudio.play(PATH_SOM_BOLA_PINGANDO);
    }

    private void reproduzirSomAumentarVelocidade() {
        StdAudio.play(PATH_SOM_SUBIR_NIVEL);
    }

    private void reproduzirSomFimDeJogo() {
        StdAudio.play(PATH_SOM_FIM_JOGO);
    }

    private void imprimirPlanoDeFundo() {
        StdDraw.clear(Color.white);

        StdDraw.picture(1, 0, PATH_IMAGEM_PLANO_DE_FUNDO);
    }

    private void imprimirBola() {
        StdDraw.setPenColor(bola.getCor());
        StdDraw.filledCircle(bola.getPosicaoHorizontal(), bola.getPosicaoVertical(), bola.getRaio());
    }

    private void imprimirBarra() {
        StdDraw.setPenColor(barra.getCor());
        StdDraw.filledRectangle(barra.getPosicaoHorizontal(), barra.getPosicaoVertical(), barra.getComprimento(), barra.getEspessura());
    }

    private void verificaTeclasPressionadas() {
        if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT)) {
                if (!(barra.getPosicaoHorizontal() <= INICIO_TELA + barra.getComprimento())) {
                    barra.moveEsquerda();
                }
            }

        //captura tecla direita
        if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT)) {
            if (!(barra.getPosicaoHorizontal() >= FIM_TELA - barra.getComprimento())) {
                barra.moveDireita();
            }
        }
    }

    private void imprimirPontos() {
        StdDraw.setPenColor(Color.WHITE);
        StdDraw.text(0.89, 0.95, String.valueOf(jogador.getPontos()));
    }

    private void imprimirVidas() {
        StdDraw.setPenColor(vidaUm.getCor());
        StdDraw.filledCircle(vidaUm.getPosicaoHorizontal(), vidaUm.getPosicaoVertical(), vidaUm.getRaio());
        StdDraw.setPenColor(vidaDois.getCor());
        StdDraw.filledCircle(vidaDois.getPosicaoHorizontal(), vidaDois.getPosicaoVertical(), vidaDois.getRaio());
        StdDraw.setPenColor(vidaTres.getCor());
        StdDraw.filledCircle(vidaTres.getPosicaoHorizontal(), vidaTres.getPosicaoVertical(), vidaTres.getRaio());
    }
}