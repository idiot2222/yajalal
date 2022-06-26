package me.bogeun.controller;

import lombok.RequiredArgsConstructor;
import me.bogeun.domain.Player;
import me.bogeun.payload.player.PlayerCreateDto;
import me.bogeun.payload.player.PlayerUpdateDto;
import me.bogeun.port.incoming.PlayerServicePort;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/player")
public class PlayerApiController {

    private final PlayerServicePort playerServicePort;

    @PostMapping("/create/{userId}")
    public String createPlayer(@PathVariable Long userId,
                               @RequestBody PlayerCreateDto createDto) {
        playerServicePort.createPlayer(createDto, userId);

        return "ok";
    }

    @GetMapping("/info/{playerId}")
    public Player playerInfo(@PathVariable Long playerId) {
        return playerServicePort.getPlayerById(playerId);
    }

    @PostMapping("/update/{playerId}")
    public Player updatePlayerInfo(@PathVariable Long playerId,
                                   @RequestBody PlayerUpdateDto updateDto) {
        return playerServicePort.updatePlayer(updateDto, playerId);
    }

    @PostMapping("/delete/{playerId}")
    public String deletePlayer(@PathVariable Long playerId) {
        try {
            playerServicePort.deletePlayer(playerId);
        } catch (IllegalArgumentException e) {
            return "error";
        }

        return "ok";
    }

}
