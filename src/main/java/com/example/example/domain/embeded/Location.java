package com.example.example.domain.embeded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Location {

    @Column(name = "district")
    private String district;

    @Column(name = "administrative_district")
    private String administrativeDistrict;

    @Column(name = "entrance")
    private String entrance;

    @Column(name = "address")
    private String address;

    private String latitude;

    /**
     * долгота
     */
    private String longitude;
}
