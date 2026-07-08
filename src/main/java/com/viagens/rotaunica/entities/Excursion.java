package com.viagens.rotaunica.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Excursion {

    @Id
    @UuidGenerator
    private UUID id;

    private String title;
    private String description;
    private String descriptionURL;

    private String buyLink;
    private float price;
}
