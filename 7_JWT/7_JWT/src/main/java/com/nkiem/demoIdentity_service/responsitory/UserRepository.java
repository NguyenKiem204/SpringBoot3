package com.nkiem.demoIdentity_service.responsitory;


import com.nkiem.demoIdentity_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByUserName(String userName);
    Optional<User> findByUserName(String userName);
}
