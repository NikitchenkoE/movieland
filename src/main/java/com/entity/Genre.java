package com.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "genres")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Genre {
    @Id
    @Column(name = "genreID", unique = true, nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column (name = "genre")
    private String name;
}
