package com.cybertek.controller;

import com.cybertek.entity.Cinema;
import com.cybertek.entity.User;
import com.cybertek.repository.CinemaRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cinema")
@Tag(name="Cinema", description = "Cinema API")
public class CinemaController {

    @Autowired
    private CinemaRepository cinemaRepository;

    @GetMapping
    @Operation(summary = "Read all cinemas")
    public List<Cinema> readAll(){
        return cinemaRepository.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Read one cinema by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Cinema.class))}),
            @ApiResponse(responseCode = "400", description = "Something went wrong", content = @Content),
            @ApiResponse(responseCode = "404", description = "Cinema not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "No cinema value present", content = @Content)
    })
    public Cinema readById(@PathVariable("id") Long id) throws Exception {
        Optional<Cinema> cinema = cinemaRepository.findById(id);
        if (!cinema.isPresent()){
            throw new Exception("This cinema is not found...");
        }
        return cinema.get();
    }

    @PostMapping("/create")
    @Operation(summary = "Create cinema")
    public Cinema create(@RequestBody Cinema cinema){
        return cinemaRepository.save(cinema);
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Update cinema")
    public Cinema update(@PathVariable("id") long id, @RequestBody Cinema cinema){
        Cinema newCinema = cinemaRepository.findById(id).get();
        newCinema.setName(cinema.getName());
        newCinema.setSponsoredName(cinema.getSponsoredName());
        return cinemaRepository.save(newCinema);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete cinema")
    public void delete(@PathVariable("id") long id){
        cinemaRepository.deleteById(id);
    }
}
