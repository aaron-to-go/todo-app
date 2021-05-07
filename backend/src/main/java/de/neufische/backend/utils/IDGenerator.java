package de.neufische.backend.utils;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IDGenerator {

    public String generateID() {
        return UUID.randomUUID().toString();
    }

}
