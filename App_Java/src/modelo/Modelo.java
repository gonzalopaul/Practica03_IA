/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import weka.classifiers.Classifier;
import weka.classifiers.trees.RandomForest;
import weka.core.Instances;

import aplicacion.Principal;

/**
 *
 * @author mariano
 */
public class Modelo {

    private Instances leerInstancias(String ficheroArff){
        try{
            Instances inst = new Instances(new BufferedReader(new FileReader(ficheroArff)));
            inst.setClassIndex(inst.numAttributes() - 1);

            return inst;
        }catch (IOException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void aprenderModelo()
    {
        try {
            // Creamos el Random Forest
            
		    RandomForest cls = new RandomForest();
            // train
            Instances inst = leerInstancias("App_Java/training_data/practica_3.arff");
            cls.buildClassifier(inst);

            // serialize model
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("App_Java/models/objetoRFufc.model"));
            oos.writeObject(cls);
            oos.flush();
            oos.close();
        } catch (Exception ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String aplicarModelo() {
        try{
            Instances data = leerInstancias("App_Java/test_data/test.arff");
            String[] valoresAtributos = {"Blue", "Red"};
            Classifier clasificador  = (Classifier) weka.core.SerializationHelper.read("App_Java/models/objetoRFufc.model");
            return valoresAtributos[(int)clasificador.classifyInstance(data.instance(0))];
        }catch (Exception ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
            return "Error al intentar leer el modelo";
        }
    }
    public static void pedirDatosUsuario() throws IOException, InterruptedException{
        System.out.println("Introduzca datos, separados por comas:");
        Thread.sleep(4);
        System.out.println("Victorias Red, Postura Red, Alcance Red, Victorias Blue, Postura Blue, Alcance Blue,?");
        Thread.sleep(4);
        System.out.println("No olvide poner (?) en el campo que desea consultar");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String datosUsuario = reader.readLine();
        System.out.println("Los datos se han introducido correctamente");

        FileWriter fw = new FileWriter("App_Java/test_data/test.arff", true);
        fw.write(datosUsuario);
        fw.close();

    }

}
