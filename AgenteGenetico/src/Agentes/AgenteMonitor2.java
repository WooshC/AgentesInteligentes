/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Agentes;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author USUARIO
 */
public class AgenteMonitor2 extends Agent {

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }

    @Override
    protected void takeDown() {
        System.out.print("Agente 2 muerto\n");
    }

    class Comportamiento extends CyclicBehaviour {

        private int x1 = 0;
        private int x2 = 0;

        @Override
        public void action() {
            ACLMessage msj = blockingReceive();
            if (msj != null) {
                String conversationId = msj.getConversationId();
                if (conversationId.equals("idAM1-AM2")) {
                    System.out.println("Mensaje recibido desde AgenteMonitor 1: " + msj.getContent());
                    Integer enteroAdjunto1 = extraerEnteroAdjunto(msj);
                    if (enteroAdjunto1 != null) {
                        x1 = enteroAdjunto1;

                    }
                } else if (conversationId.equals("idAM4-AM2")) {
                    System.out.println("Mensaje recibido desde AgenteMonitor 4: " + msj.getContent());
                    Integer enteroAdjunto = extraerEnteroAdjunto(msj);
                    if (enteroAdjunto != null) {
                        x2 = enteroAdjunto;

                    }
                } else {
                    System.out.println("Mensaje con conversationId desconocido: " + msj.getContent());
                }
            }
            if (x1 != 0 && x2 != 0) {
                if (x1 > x2) {
                    Mensajes.Mensaje.enviarMSJ(getAgent(), "AgenteMonitor3",
                            "idAM2-AM3", ACLMessage.INFORM, true, x1 + " X1 es mayor que  X2: " + x2, null);

                } else {
                    Mensajes.Mensaje.enviarMSJ(getAgent(), "AgenteMonitor3",
                            "idAM2-AM3", ACLMessage.INFORM, true, x2 + " X2 es mayor que X1: " + x1, null);
                }
            }
        }

    }

    private Integer extraerEnteroAdjunto(ACLMessage msj) {
        String[] parts = msj.getContent().split("\n");
        for (String part : parts) {
            if (part.startsWith("Entero Adjunto: ")) {
                try {
                    return Integer.parseInt(part.substring("Entero Adjunto: ".length()));
                } catch (NumberFormatException e) {
                    // Manejar la excepción si el formato del entero adjunto no es válido
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
