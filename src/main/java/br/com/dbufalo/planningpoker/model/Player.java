package br.com.dbufalo.planningpoker.model;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@RegisterForReflection
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "player")
public class Player {

    @Id
    @SequenceGenerator(name = "player_sequence", sequenceName = "player_sequence_id")
    @GeneratedValue(generator = "player_sequence")
    Long id;

    @Column(name = "username", nullable = false)
    String username;

    @Column(name = "spectator", nullable = false)
    boolean spectator;
}