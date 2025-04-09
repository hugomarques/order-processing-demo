package dev.hugomarques.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Service
public class OrderTaskService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderTaskService.class);

    @Autowired
    private WarehouseProcessor warehouseProcessor;

    @Async
    public void processRegion(int regionId) {
        LOGGER.info("[Region {}] Starting order processing", regionId);
        IntStream.range(0, 800).forEach(warehouseId ->
                this.warehouseProcessor.processWarehouse(regionId, warehouseId)
        );
    }
}
