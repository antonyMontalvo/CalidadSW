package unmsm.edu.pe.calidadsw;

import java.util.Date;
import java.util.List;

import unmsm.edu.pe.calidadsw.dao.AssistantDAO;
import unmsm.edu.pe.calidadsw.dao.EventDAO;
import unmsm.edu.pe.calidadsw.dao.Event_has_assistantDAO;
import unmsm.edu.pe.calidadsw.models.Assistant;
import unmsm.edu.pe.calidadsw.models.Event;
import unmsm.edu.pe.calidadsw.models.Event_has_assistant;

public class Prueba {
    public static void main (String [ ] args) {
        
        //Prueba de listar los participantes de un evento determinado por el id del evento.
        //---------------------------------------------------------------------------------
        // Event_has_assistantDAO control = new Event_has_assistantDAO();
        // List<Assistant> array = control.consultaTodosParticipantesEvento(1);
        // for(int i=0;i<array.size();i++){
        //     System.out.println(array.get(i).getName());
        // }
        //---------------------------------------------------------------------------------
        
        //Prueba de inscribir a un participante a un evento. (idevento,dni)
        //---------------------------------------------------------------------------------
        /*Event_has_assistant event_has_assistant=new Event_has_assistant(1,984512374);
        control.inscribirParticipanteEvento(event_has_assistant);
        array=control.consultaTodosParticipantesEvento(1);
        for(int i=0;i<array.size();i++){
            System.out.println(array.get(i).getName());
        }*/
        //----------------------------------------------------------------------------------
        
        //Prueba de registrar a un participante nuevo en el sistema.
        //----------------------------------------------------------------------------------
        /*AssistantDAO assistantdao = new AssistantDAO();
        Assistant assistant = new Assistant();
        assistant.setDni(84654654);
        assistant.setName("Paolo");
        assistant.setLastname("Perez");
        assistant.setAge(20);
        assistant.setTelephone("645645");
        assistant.setMail("paolo@gmail.com");
        assistant.setUsername("paolo54");
        assistant.setPassword("65464");
        if(assistantdao.registrarAsistente(assistant)){
            System.out.println("Asistente registrado correctamente");
        }*/
        //----------------------------------------------------------------------------------
        
        //Prueba de crear un evento
        //----------------------------------------------------------------------------------
        // EventDAO eventdao = new EventDAO();
        Event event = new Event();
        event.setTitle("Opera");
        event.setDescription("Opera profesional");
        event.setDate("2019-10-05");
        event.setState("Activo");
        event.setIdambiente(1);//El ambiente  llave foranea
        event.setDni(71313976);//El dni del administrador que crea el evento    llave foranea
        // if(eventdao.registrarEvento(event)){
        //     System.out.println("Evento creado");
        // }
        //----------------------------------------------------------------------------------
    }
}
