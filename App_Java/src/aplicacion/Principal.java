/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion;

import java.io.IOException;

import modelo.Modelo;

/**
 *
 * @author mariano
 */
public class Principal{

    /**
     * @param args the command line arguments
     * @throws IOException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        Modelo modelo = new Modelo();
        modelo.aprenderModelo();
        Modelo.pedirDatosUsuario();
        System.out.println("El clasificador con Random Forest obtiene: " + modelo.aplicarModelo());
    }
}
