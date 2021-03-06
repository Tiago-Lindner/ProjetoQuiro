package control;

import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Consulta;
import model.Paciente;

@Path("/consulta")
@Transactional
public class ConsultaWS {

   @GET
   @Path("/salvar/{texto}/{idPac}")
   @Produces(MediaType.APPLICATION_JSON)
   public Consulta salvar(@PathParam("texto") String texto, @PathParam("idPac") Long idPac){

    Consulta consulta = new Consulta();
    consulta.setConfirma(texto);
    consulta.persistAndFlush();

    Paciente pac = Paciente.findById(idPac);
    if (pac == null)
        throw new BadRequestException("Paciente não encontrado"); 

    pac.addConsulta(consulta);
    pac.persistAndFlush();

    return consulta;
   }
    
}
