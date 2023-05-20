package com.example.example.domain;

import com.example.example.domain.embeded.Location;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Table(name = "postamat", uniqueConstraints = @UniqueConstraint(columnNames = {"external_id", "vendor_id"}, name = "external_id_unique"))
@Entity
@ToString
@Accessors(chain = true)
public class PostamatEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "external_id", nullable = false)
    private String externalId;

    @Embedded
    private Location location;


    @ManyToOne
    @ToString.Exclude
    @JsonIgnore
    @JoinColumn(name = "vendor_id", nullable = false)
    private VendorEntity vendor;


    private int size;

    @Column(name = "last_date_activity")
    private LocalDateTime lastDateActivity;

    @Column(name = "video_link")
    private URL videoLink;

    /**
     * Дата тех обслуживания
     */
    @Column(name = "postamat_init")
    private LocalDate postamatInit;
}
