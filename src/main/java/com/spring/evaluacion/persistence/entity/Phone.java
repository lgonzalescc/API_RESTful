package com.spring.evaluacion.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "phones")
@Getter
@Setter
public class Phone {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 15)
    private String number;

    @Column(name = "city_code", length = 5, nullable = false)
    private String citycode;

    @Column(name = "country_code", length = 5, nullable = false)
    private String countrycode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
