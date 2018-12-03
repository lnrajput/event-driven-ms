package com.acc.cloud.ms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acc.cloud.ms.domain.User;

/**
 * The repository for managing {@link User} data.
 *
 * @author Laxminarayan Rajput
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
