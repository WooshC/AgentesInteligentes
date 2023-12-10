/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Agentes;

import contentSerial.Cliente;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import org.jgap.IChromosome;


/**
 *
 * @author USUARIO
 */
public class AgenteMonitor4 extends Agent {

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }
    
    @Override
    protected void takeDown() {
        System.out.print("Agente 4 muerto\n");
    }

    class Comportamiento extends CyclicBehaviour {

        @Override
        public void action() {
            AlgorimoGenetico1 algoritmoGenetico1 = new AlgorimoGenetico1();
            IChromosome mejorIndividuo = algoritmoGenetico1.iniciarAG(6, 2, 2);
            int mensaje = construirMensaje(mejorIndividuo);
           Mensajes.Mensaje.enviarMSJ1(getAgent(), "AgenteMonitor2",
                    "idAM4-AM2", ACLMessage.INFORM, true, "Mensaje para el agente 2: "+ mensaje, null,mensaje);
           doDelete();
             
        }
         private int construirMensaje(IChromosome ic) {
            int signoX = (Integer) ic.getGene(0).getAllele();
            int x0 = (Integer) ic.getGene(1).getAllele();
            int x1 = (Integer) ic.getGene(2).getAllele();
            int x2 = (Integer) ic.getGene(3).getAllele();
            int x3 = (Integer) ic.getGene(4).getAllele();
            int x4 = (Integer) ic.getGene(5).getAllele();
            int x5 = (Integer) ic.getGene(6).getAllele();
            int x6 = (Integer) ic.getGene(7).getAllele();
            int x7 = (Integer) ic.getGene(8).getAllele();
            int valorX = Integer.parseInt((x0 + "" + x1 + "" + x2 + "" + x3 + "" + x4 + "" + x5 + "" + x6 + "" + x7), 2);
            if (signoX == 0) {
                valorX = -valorX;
            }
            return valorX; // Reemplaza esto con la lógica real
        }

    }

    }


