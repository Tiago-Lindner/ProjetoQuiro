package control;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Paciente;

@Path("/pac")
@Transactional
public class PacienteWS {
    
    @GET
    @Path("/salvar/{nome}")
    @Produces(MediaType.APPLICATION_JSON)
    public Paciente salvar(@PathParam("nome") String nome) {
        Paciente pac = new Paciente();
        pac.setNome(nome);
        pac.persist();
        return pac;
    }

    @GET
    @Path("/listar")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public List<Paciente> list() {
        // 3 - O método `listAll` recupera todos os objetos da classe User.
        return Paciente.listAll();
    }

    

}
