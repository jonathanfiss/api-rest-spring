package com.jonathanfiss.ApiRestSpringBoot.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import java.time.ZonedDateTime;

@MappedSuperclass
@Data
@Entity
public abstract class BaseEntity {

    private ZonedDateTime createAt;
    private ZonedDateTime updatedAt;
    private String createAt;

}
