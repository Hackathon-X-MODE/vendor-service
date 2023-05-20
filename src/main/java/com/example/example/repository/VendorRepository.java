package com.example.example.repository;

import com.example.example.domain.VendorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface VendorRepository extends JpaRepository<VendorEntity, UUID> {

    Optional<VendorEntity> findByCode(String code);
}
