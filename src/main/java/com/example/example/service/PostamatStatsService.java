package com.example.example.service;

import com.example.example.client.OrderClient;
import com.example.example.model.stats.PostamatStat;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostamatStatsService {

    private final PostamatService postamatService;
    private final OrderClient orderClient;
    public PostamatStat getStats(UUID postamatId) {
        final var postamat = this.postamatService.get(postamatId);


        return PostamatStat.builder()
                .availableSlots(postamat.getSize())
                .takenSlots(this.orderClient.filter(postamatId,"DELIVERED").getTotalElements())
                .build();

    }
}
