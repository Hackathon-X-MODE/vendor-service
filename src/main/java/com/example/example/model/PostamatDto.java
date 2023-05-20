package com.example.example.model;

import com.example.example.domain.embeded.Location;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostamatDto {
    private UUID id;

    private String externalId;

    private Location location;

    private int size;

    private LocalDateTime lastDateActivity;


    private URL videoLink;

    private LocalDate postamatInit;
}
