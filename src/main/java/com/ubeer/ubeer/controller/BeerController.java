package com.ubeer.ubeer.controller;

import com.ubeer.ubeer.entity.BeerEntity;
import com.ubeer.ubeer.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/beers")
public class BeerController {

    @Autowired
    private BeerService beerService;

    @GetMapping
    public List<BeerEntity> getAllBeers() {
        return beerService.getAllBeers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BeerEntity> getBeerById(@PathVariable Long id) {
        BeerEntity beer = beerService.getBeerById(id);
        return ResponseEntity.ok().body(beer);
    }

    @PostMapping
    public ResponseEntity<BeerEntity> createBeer(@RequestBody BeerEntity beer) {
        BeerEntity createdBeer = beerService.createBeer(beer);
        return ResponseEntity.created(URI.create("/api/beers/" + createdBeer.getId())).body(createdBeer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BeerEntity> updateBeer(@PathVariable Long id, @RequestBody BeerEntity beer) {
        BeerEntity updatedBeer = beerService.updateBeer(id, beer);
        return updatedBeer != null ? ResponseEntity.ok(updatedBeer) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBeer(@PathVariable Long id) {
        beerService.deleteBeer(id);
        return ResponseEntity.noContent().build();
    }
}