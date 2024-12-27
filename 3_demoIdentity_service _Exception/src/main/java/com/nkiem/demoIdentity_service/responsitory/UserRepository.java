package com.nkiem.demoIdentity_service.responsitory;


import com.nkiem.demoIdentity_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByUserName(String userName);
}
