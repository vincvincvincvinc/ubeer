package com.ubeer.ubeer.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "image")
public class ImageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "url", nullable = false)
    private String url;


    @ManyToOne
    @JoinColumn(name = "beer_id", referencedColumnName = "ID")
    @JsonIgnoreProperties("image")
    private BeerEntity beer;

    @ManyToOne
    @JoinColumn(name = "brewery_id", referencedColumnName = "ID")
    @JsonIgnoreProperties("image")
    private BreweryEntity brewery;


    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BeerEntity getBeer() {
        return beer;
    }

    public void setBeer(BeerEntity beer) {
        this.beer = beer;
    }
}
