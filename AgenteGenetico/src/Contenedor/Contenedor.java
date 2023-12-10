/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Contenedor;

import Agentes.AgenteMonitor;
import Agentes.AgenteMonitor2;
import Agentes.AgenteMonitor3;
import Agentes.AgenteMonitor4;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USUARIO
 */
public class Contenedor {

    AgentContainer agenteContenedor;

    public void crearContenedor() {
        jade.core.Runtime runtime = jade.core.Runtime.instance();
        Profile p = new ProfileImpl(null, 1099, null);
        agenteContenedor = runtime.createMainContainer(p);
        agregarAgnetes();
    }

    private void agregarAgnetes() {
        try {
            agenteContenedor.createNewAgent("AgenteMonitor",
                    AgenteMonitor.class.getName(), null).start();
            agenteContenedor.createNewAgent("AgenteMonitor2",
                    AgenteMonitor2.class.getName(), null).start();
            agenteContenedor.createNewAgent("AgenteMonitor3",
                    AgenteMonitor3.class.getName(), null).start();
            agenteContenedor.createNewAgent("AgenteMonitor4",
                    AgenteMonitor4.class.getName(), null).start();
        } catch (StaleProxyException ex) {
            Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
