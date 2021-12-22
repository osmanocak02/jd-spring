package com.cybertek.model;

import com.cybertek.enums.AddressType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name="address")
@JsonIgnoreProperties(value={"hibernate_Lazy_Initializer", "teacher"}, ignoreUnknown = true)
public class Address extends BaseEntity{

    private String city;
    private String country;
    private String state;
    private String street;

    @Column(name="postal_code")
    private String postalCode;

    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    @OneToOne(mappedBy = "address")
    @JsonBackReference
    private Student student;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private Parent parent;

    @OneToOne(mappedBy = "address")
    private Teacher teacher;


    private Integer currentTemperature;

    private Integer getCurrentTemperature(){
        return consumeTemp(this.city);
    }

    public Integer consumeTemp(String city){
        return 5;
    }


}
