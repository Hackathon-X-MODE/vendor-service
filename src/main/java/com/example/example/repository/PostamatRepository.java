package com.example.example.repository;

import com.example.example.domain.PostamatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PostamatRepository extends JpaRepository<PostamatEntity, UUID> {

    Optional<PostamatEntity> findByVendor_IdAndExternalId(UUID vendorId, String externalId);


    List<PostamatEntity> findAllByVendor_Id(UUID vendorId);
}
