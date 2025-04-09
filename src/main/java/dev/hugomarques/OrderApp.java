package dev.hugomarques;

import dev.hugomarques.service.WarehouseProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderApp implements CommandLineRunner {

    @Autowired
    WarehouseProcessor warehouseProcessor;

    public static void main(String[] args) {
        SpringApplication.run(OrderApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            for (int region = 0; region < 1; region++) {
                for (int warehouse = 0; warehouse < 10; warehouse++) {
                    this.warehouseProcessor.processWarehouse(region, warehouse);
                }
            }
         } catch (Exception e) {
            System.err.println("Error during processing: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("Processing completed.");
        System.exit(0);
    }
}