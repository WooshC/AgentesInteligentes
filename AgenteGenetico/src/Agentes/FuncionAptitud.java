/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Agentes;

import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

/**
 *
 * @author LabP351
 */
public class FuncionAptitud extends FitnessFunction {

    @Override
    protected double evaluate(IChromosome ic) {
//        int signoX = (Integer) ic.getGene(0).getAllele();
//        int signoY = (Integer) ic.getGene(5).getAllele();

        int signoX = (Integer) ic.getGene(0).getAllele();
        int signoY = (Integer) ic.getGene(9).getAllele();

        int x0 = (Integer) ic.getGene(1).getAllele();
        int x1 = (Integer) ic.getGene(2).getAllele();
        int x2 = (Integer) ic.getGene(3).getAllele();
        int x3 = (Integer) ic.getGene(4).getAllele();
        int x4 = (Integer) ic.getGene(5).getAllele();
        int x5 = (Integer) ic.getGene(6).getAllele();
        int x6 = (Integer) ic.getGene(7).getAllele();
        int x7 = (Integer) ic.getGene(8).getAllele();

        int y0 = (Integer) ic.getGene(10).getAllele();
        int y1 = (Integer) ic.getGene(11).getAllele();
        int y2 = (Integer) ic.getGene(12).getAllele();
        int y3 = (Integer) ic.getGene(13).getAllele();
        int y4 = (Integer) ic.getGene(14).getAllele();
        int y5 = (Integer) ic.getGene(15).getAllele();
        int y6 = (Integer) ic.getGene(16).getAllele();
        int y7 = (Integer) ic.getGene(17).getAllele();

        int valorX = Integer.parseInt((x0 + "" + x1 + "" + x2 + "" + x3 + "" + x4 + "" + x5 + "" + x6 + "" + x7), 2);
        int valorY = Integer.parseInt((y0 + "" + y1 + "" + y2 + "" + y3 + "" + y4 + "" + y5 + "" + y6 + "" + y7), 2);

        if (signoX == 0) {
            valorX = -valorX;
        }
        if (signoY == 0) {
            valorY = -valorY;
        }
        //double score = 450 - (valorX*valorX + valorY*valorY);
        double score = valorX * valorX + valorY * valorY;
        //double score1 = 1.2695380493963884-Math.log10(Math.sqrt(score));
        double score1 = Math.log10(Math.sqrt(score));
        //System.out.println("Este es el score:" + score1);
        return score1;
    }

}
