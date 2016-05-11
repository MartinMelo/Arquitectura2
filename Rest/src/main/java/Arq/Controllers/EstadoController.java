package Arq.Controllers;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import java.util.Date;

/**
 * Created by Martin Alejandro Melo
 * on 22/03/2016.
 */
@Component
public class EstadoController {

    /**
     * Devuelve un simple 202.
     * @return Response
     */
    public Response estadoActualSimple() {
        return Response.status(202).build();
    }

    /**
     * Devuelve un 202 con informacion mas completa.
     * @return
     */
    public Response estadoActualCompleto() {
        JSONObject estado = new JSONObject();
        estado.put("fecha", new Date());
        estado.put("estado", "Funciona Todo Perfecto");
        estado.put("detalle", "Esto es absurdo");
        return Response.ok(estado.toString()).build();
    }
}
