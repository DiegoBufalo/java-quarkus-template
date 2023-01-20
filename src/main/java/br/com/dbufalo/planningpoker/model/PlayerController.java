package br.com.dbufalo.planningpoker.model;

import org.jboss.resteasy.reactive.RestPath;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/api/v1/player")
@RequestScoped
public class PlayerController {

    @Inject
    PlayerDAO playerGenerator;

    @GET
    @Path("/{playerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Player gerarRelatorio(@RestPath Long playerId) {
        return playerGenerator.getUserInfo(playerId);
    }

    @POST
    @Path("")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Player createPlayer(Player player) {

        return playerGenerator.createPlayer(player.username, player.isSpectator());
    }
}
