package me.bogeun.yajalal.repository;

import me.bogeun.yajalal.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
