package com.entity;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "countries")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Country {
    @Id
    @Column(name = "countryid", unique = true, nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "countryname")
    private String name;

    @ManyToMany(mappedBy = "countries")
    private Set<Movie> movies = new HashSet<>();
}
