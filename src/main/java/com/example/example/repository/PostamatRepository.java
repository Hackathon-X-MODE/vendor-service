package com.example.example.repository;

import com.example.example.domain.PostamatEntity;
import com.example.example.model.PostamatFilter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Repository
public interface PostamatRepository extends JpaRepository<PostamatEntity, UUID>, JpaSpecificationExecutor<PostamatEntity> {

    Optional<PostamatEntity> findByVendor_IdAndExternalId(UUID vendorId, String externalId);


    List<PostamatEntity> findAllByVendor_Id(UUID vendorId);

    default List<PostamatEntity> findAll(PostamatFilter filter) {
        var spec = Specification.<PostamatEntity>where(null);

        if (CollectionUtils.isEmpty(filter.getVendors())) {
            spec = spec.and(
                    (root, query, criteriaBuilder) ->
                            root.join("vendor").get("id").in(filter.getVendors())

            );
        }

        if (Objects.nonNull(filter.getAddress())) {
            final var value = "%" + filter.getAddress().toLowerCase(Locale.ROOT) + "%";
            spec = spec.and(
                    (root, query, criteriaBuilder) ->
                            criteriaBuilder.like(
                                    criteriaBuilder.lower(root.get("location").get("address")),
                                    value
                            )
            );
        }


        if (Objects.nonNull(filter.getSizeAt())) {
            spec = spec.and(
                    (root, query, criteriaBuilder) ->
                            criteriaBuilder.greaterThanOrEqualTo(
                                    root.get("size"),
                                    filter.getSizeAt()
                            )
            );
        }


        if (Objects.nonNull(filter.getSizeTo())) {
            spec = spec.and(
                    (root, query, criteriaBuilder) ->
                            criteriaBuilder.lessThanOrEqualTo(
                                    root.get("size"),
                                    filter.getSizeTo()
                            )
            );
        }


        return this.findAll(spec);
    }
}
