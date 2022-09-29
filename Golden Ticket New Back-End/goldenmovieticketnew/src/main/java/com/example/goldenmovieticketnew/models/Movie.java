package com.example.goldenmovieticketnew.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Document(collection = "movies")
@Data
public class Movie   {

    public Movie(){

    }
    public Movie(String name, String smallImageURl, String shortDescription, String longDescription, String largeImageURL, String director, String actors, String categories, LocalDate releaseDate, int duration, String trailerURL, String language, String rated, int isShowing) {
        this.name = name;
        this.smallImageURl = smallImageURl;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.largeImageURL = largeImageURL;
        this.director = director;
        this.actors = actors;
        this.categories = categories;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.trailerURL = trailerURL;
        this.language = language;
        this.rated = rated;
        this.isShowing = isShowing;
    }


    @Id
    private String id;
    private String name;
    private String smallImageURl;
    private String shortDescription;
    private String longDescription;
    private String largeImageURL;
    private String director;
    private String actors;
    private String categories;
    private LocalDate releaseDate;
    private int duration;

    private String trailerURL;
    private String language;
    private String rated;
    private int isShowing;

    private String createdDate;




    private String lastModifiedDate;
}