package br.com.dbufalo.planningpoker.model;

import io.agroal.api.AgroalDataSource;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@ApplicationScoped
public class PlayerDAO {

    private static final Logger log = Logger.getLogger(PlayerDAO.class);

    @Inject
    AgroalDataSource ds;

    @Inject
    EntityManager em;

    @Transactional
    public Player getUserInfo(Long playerId) {
        return runQuery(playerId);
    }


    @Transactional
    public Player createPlayer(String username, boolean isSpectator) {
        Player player =
                Player.builder()
                        .username(username)
                        .spectator(isSpectator)
                        .build();

        em.persist(player);
        Query nativeQuery = em.createNativeQuery("select * from player where username=?", Player.class);
        nativeQuery.setParameter(1, username);
        return (Player) nativeQuery.getSingleResult();
    }

    private Player runQuery(Long playerId) {
        String sql = """
                SELECT
                    id as "id",
                    username as "username",
                    spectator as "spectator"
                FROM player
                WHERE
                    player.id = ?
                """;

        try (Connection connection = ds.getConnection()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setLong(1, playerId);

                try (ResultSet rs = ps.executeQuery()) {
                    Player result = new Player();
                    while (rs.next()) {
                        result.id = rs.getLong("id");
                        result.username = rs.getString("username");
                        result.spectator = rs.getBoolean("spectator");
                    }
                    return result;
                }
            }
        } catch (Exception e) {
            log.error("Erro ao executar query", e);
            throw new RuntimeException(e);
        }
    }
}
