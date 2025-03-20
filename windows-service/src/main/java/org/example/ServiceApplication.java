package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiceApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(ServiceApplication.class);

    private static Thread thread;
    private static volatile boolean stopRequested;

    @Override
    public void run(String... args) throws Exception {
        LOG.info("Started");
        thread = Thread.currentThread();
        while (!stopRequested) {
            Thread.sleep(1000);
        }
        LOG.info("Stopped");
    }

    /**
     * The method which will be called when the Windows service started.
     */
    public static void startService(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }

    /**
     * The method which will be called when the Windows service stopped.
     */
    public static void stopService(String[] args) {
        LOG.info("Stopping");
        stopRequested = true;
        try {
            thread.join();
        } catch (InterruptedException e) {
        }
    }

    public static void main(String[] args) {
        startService(args);
    }
}
