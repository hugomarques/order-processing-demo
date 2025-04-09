package dev.hugomarques.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class SectorProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(SectorProcessor.class);
    private static final int BATCH_SIZE = 100;

    @Autowired
    private IOProductProcessor productProcessor;

    public void processSector(int regionId, int warehouseId, int sectorId) {
        int numProducts = ThreadLocalRandom.current().nextInt(1000, 10001);
        List<Integer> productIds = IntStream.range(0, numProducts).boxed().collect(Collectors.toList());

        for (int i = 0; i < productIds.size(); i += BATCH_SIZE) {
            List<Integer> batch = productIds.subList(i, Math.min(i + BATCH_SIZE, productIds.size()));
            productProcessor.processProductBatch(regionId, warehouseId, sectorId, batch);
        }
    }
}
