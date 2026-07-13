package com.viagens.rotaunica.handlers;

import java.util.UUID;

public class ExcursionNotFoundException extends RuntimeException{

    public ExcursionNotFoundException(UUID uuid) {
        super("Excursion not found: " + uuid);
    }
}
