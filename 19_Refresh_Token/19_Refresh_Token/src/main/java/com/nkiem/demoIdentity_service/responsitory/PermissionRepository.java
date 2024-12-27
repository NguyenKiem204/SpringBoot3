package com.nkiem.demoIdentity_service.responsitory;

import com.nkiem.demoIdentity_service.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, String> {
    List<Permission> findAllByNameIn(Set<Permission> permissions);
}
