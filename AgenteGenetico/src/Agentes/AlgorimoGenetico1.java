/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Agentes;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;

/**
 *
 * @author LabP351
 */
public class AlgorimoGenetico1 {

    private int longitudCromosoma = 18;

    private Configuration configuracion(int tamanioPoblacion) {
        Configuration configuracion = new DefaultConfiguration();
        try {
            configuracion.setFitnessFunction(new FuncionAptitud1());
            Gene[] genes = new Gene[longitudCromosoma];
            for (int i = 0; i < longitudCromosoma; i++) {
                genes[i] = new IntegerGene(configuracion,
                        0, 1);
            }
            Chromosome cromosoma = null;
            cromosoma = new Chromosome(
                    configuracion,
                    genes);
            configuracion.setSampleChromosome(cromosoma);
            configuracion.setPopulationSize(tamanioPoblacion);

        } catch (InvalidConfigurationException ex) {
            Logger.getLogger(AlgorimoGenetico1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return configuracion;
    }

    private Genotype getPoblacion(Configuration configuracion) {
        Genotype poblacion = null;
        try {
            poblacion = Genotype.randomInitialGenotype(
                    configuracion);
        } catch (InvalidConfigurationException ex) {
            Logger.getLogger(AlgorimoGenetico1.class.getName()).log(Level.SEVERE, null, ex);
        }
        return poblacion;
    }

    public IChromosome iniciarAG(int tamanioPoblacion, int generaciones, int evoluciones) {
        Genotype poblacion = getPoblacion(configuracion(tamanioPoblacion));
        for (int i = 0; i < generaciones; i++) {
            //System.out.println("********* Generacion " + i + " ************");
            mostrarTodos(poblacion.getChromosomes());
            poblacion.evolve(evoluciones);
            //System.out.println("Mejor individuo: ");
            mostrarIndividuo(poblacion.getFittestChromosome());
        }
        System.out.println("*********Mejor individuo Agente monitor 4*********");
        IChromosome mejorIndividuo = poblacion.getFittestChromosome();
        mostrarIndividuo(mejorIndividuo);
        return mejorIndividuo;
    }

    private void mostrarTodos(IChromosome[] ic) {
        for (IChromosome iChromosome : ic) {
            //mostrarIndividuo(iChromosome);
        }
    }

    private void mostrarIndividuo(IChromosome ic) {
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
        System.out.println(valorX + " , " + valorY);
    }
}
