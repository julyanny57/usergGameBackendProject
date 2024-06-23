package com.gameproject.usergameproject.repository;

import com.gameproject.usergameproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
