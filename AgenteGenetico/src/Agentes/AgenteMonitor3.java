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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class AgenteMonitor3 extends Agent {

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }

    @Override
    protected void takeDown() {
        System.out.print("Agente 3 muerto\n");
    }

    class Comportamiento extends CyclicBehaviour {

        @Override
        public void action() {
            // Verificar el tipo de mensaje
            ACLMessage msj = blockingReceive();
            String mensaje = msj.getContent();
            System.out.println("Mensaje recibido desde AgenteMonitor 2: " + mensaje);
            doDelete();
        }

    }

}
