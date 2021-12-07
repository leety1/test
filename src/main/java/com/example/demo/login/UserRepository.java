
package com.example.demo.login;

import java.util.Optional;
import com.example.demo.login.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	Optional<UserEntity> findByName(String name);
}