package com.nkiem.demoIdentity_service.responsitory;

import com.nkiem.demoIdentity_service.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
}
