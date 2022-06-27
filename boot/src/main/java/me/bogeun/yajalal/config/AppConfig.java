package me.bogeun.yajalal.config;

import me.bogeun.yajalal.adapter.PlayerServicePortImpl;
import me.bogeun.yajalal.adapter.TeamServicePortImpl;
import me.bogeun.yajalal.adapter.UserServicePortImpl;
import me.bogeun.yajalal.port.incoming.PlayerServicePort;
import me.bogeun.yajalal.port.incoming.TeamServicePort;
import me.bogeun.yajalal.port.incoming.UserServicePort;
import me.bogeun.yajalal.port.outgoing.PlayerPersistencePort;
import me.bogeun.yajalal.port.outgoing.TeamPersistencePort;
import me.bogeun.yajalal.port.outgoing.UserPersistencePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public UserServicePort userServicePort(UserPersistencePort userPersistencePort) {
        return new UserServicePortImpl(userPersistencePort);
    }

    @Bean
    public PlayerServicePort playerServicePort(PlayerPersistencePort playerPersistencePort) {
        return new PlayerServicePortImpl(playerPersistencePort);
    }

    @Bean
    public TeamServicePort teamServicePort(TeamPersistencePort teamPersistencePort) {
        return new TeamServicePortImpl(teamPersistencePort);
    }

}
