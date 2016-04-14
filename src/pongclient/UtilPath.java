/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pongclient;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Guilherme
 */
public class UtilPath {

    public static String getPastaPrincipal() {
        String linha = "";
        try {
            BufferedReader leitor = new BufferedReader(new FileReader("path.txt"));

            linha = leitor.readLine();
            leitor.close();

        } catch (IOException ex) {
        }
        return linha;
    }
}
