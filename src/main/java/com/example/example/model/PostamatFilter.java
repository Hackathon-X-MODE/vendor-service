package com.example.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostamatFilter {

    private List<UUID> vendors;

    private String address;

    private Integer sizeAt;

    private Integer sizeTo;
}
