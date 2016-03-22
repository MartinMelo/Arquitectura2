package Arq.RestComponent;

import Arq.Controllers.EstadoController;
import org.apache.cxf.annotations.UseAsyncMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by Martin Alejandro Melo
 * on 22/03/2016.
 */
@Path("/estado")
@Component
public class Estado {

    @Autowired
    private EstadoController estadoController;

    @GET
    @Path("")
    @UseAsyncMethod
    public Response estadoSimple() {
        return this.estadoController.estadoActualSimple();
    }
    @GET
    @Path("/completo")
    @UseAsyncMethod
    public Response estadoCompleto() {
        return this.estadoController.estadoActualCompleto();
    }
}
