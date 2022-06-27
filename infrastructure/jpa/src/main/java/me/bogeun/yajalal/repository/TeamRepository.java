package me.bogeun.yajalal.repository;

import me.bogeun.yajalal.entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<TeamEntity, Long> {
}
