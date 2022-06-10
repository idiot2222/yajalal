package me.bogeun.config;

import me.bogeun.adapter.PlayerServiceImpl;
import me.bogeun.adapter.TeamServiceImpl;
import me.bogeun.adapter.UserServiceImpl;
import me.bogeun.port.incoming.PlayerServicePort;
import me.bogeun.port.incoming.TeamServicePort;
import me.bogeun.port.incoming.UserServicePort;
import me.bogeun.port.outgoing.PlayerPersistencePort;
import me.bogeun.port.outgoing.TeamPersistencePort;
import me.bogeun.port.outgoing.UserPersistencePort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public UserServicePort userServicePort(UserPersistencePort userPersistencePort) {
        return new UserServiceImpl(userPersistencePort);
    }

    @Bean
    public PlayerServicePort playerServicePort(PlayerPersistencePort playerPersistencePort) {
        return new PlayerServiceImpl(playerPersistencePort);
    }

    @Bean
    public TeamServicePort teamServicePort(TeamPersistencePort teamPersistencePort) {
        return new TeamServiceImpl(teamPersistencePort);
    }

}
