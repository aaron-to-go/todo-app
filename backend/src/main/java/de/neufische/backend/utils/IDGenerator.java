package de.neufische.backend.utils;

import java.util.UUID;

public class IDGenerator {

    public String generateID() {
        return UUID.randomUUID().toString();
    }

}
