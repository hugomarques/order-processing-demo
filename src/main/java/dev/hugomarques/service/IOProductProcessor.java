package dev.hugomarques.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class IOProductProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(IOProductProcessor.class);


    public void processProductBatch(int regionId, int warehouseId, int sectorId, List<Integer> productIds) {
        try {
            Thread.sleep(50); // simulate gRPC latency

            // Simulate a larger memory allocation
            StringBuilder response = new StringBuilder();
            for (int i = 0; i < 5000; i++) {
                response.append(UUID.randomUUID());
            }

            LOGGER.debug("Processed {} products in region {}, warehouse {}, sector {}",
                    productIds.size(), regionId, warehouseId, sectorId);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
