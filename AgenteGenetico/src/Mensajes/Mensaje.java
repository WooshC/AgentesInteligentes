/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mensajes;

import jade.core.AID;
import jade.core.Agent;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author USUARIO
 */
public class Mensaje {
//
    public static void enviarMSJ(Agent emisor, String receptor,
             String idComunicacion, int tipoMSJ,boolean isContent,String contenido,Serializable contentObject) {
        ACLMessage acl=new ACLMessage(tipoMSJ);
        AID aid= new AID();
        aid.setLocalName(receptor);
        acl.addReceiver(aid);
        acl.setSender(emisor.getAID());
        if(isContent){
             acl.setContent(contenido);
        }else{
            try {
                acl.setContentObject(contentObject);
            } catch (IOException ex) {
                Logger.getLogger(Mensaje.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        acl.setLanguage(FIPANames.ContentLanguage.FIPA_SL);
        acl.setConversationId(idComunicacion);
        emisor.send(acl);
    }


    public static void enviarMSJ1(Agent emisor, String receptor,
            String idComunicacion, int tipoMSJ, boolean isContent, String contenido, Serializable contentObject, Integer enteroAdjunto) {
        ACLMessage acl = new ACLMessage(tipoMSJ);
        AID aid = new AID();
        aid.setLocalName(receptor);
        acl.addReceiver(aid);
        acl.setSender(emisor.getAID());
        
        if (isContent) {
            acl.setContent(contenido);
        } else {
            try {
                acl.setContentObject(contentObject);
            } catch (IOException ex) {
                Logger.getLogger(Mensaje.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (enteroAdjunto != null) {
            acl.setContent(acl.getContent() + "\nEntero Adjunto: " + enteroAdjunto);
        }

        acl.setLanguage(FIPANames.ContentLanguage.FIPA_SL);
        acl.setConversationId(idComunicacion);
        emisor.send(acl);
    }
}
