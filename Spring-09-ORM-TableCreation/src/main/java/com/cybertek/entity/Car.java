package com.cybertek.entity;

import javax.persistence.*;

@Entity
public class Car {

    @Id
    private int id;

    private String make;
    private String model;

}
