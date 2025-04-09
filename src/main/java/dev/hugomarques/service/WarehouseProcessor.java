package dev.hugomarques.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WarehouseProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(WarehouseProcessor.class);

    @Autowired
    private SectorProcessor sectorProcessor;

    public void processWarehouse(int regionId, int warehouseId) {
        LOGGER.info("Processing region: {}, warehouse: {}", regionId, warehouseId);
        for (int sector = 0; sector < 3; sector++) {
            sectorProcessor.processSector(regionId, warehouseId, sector);
        }
    }

}
