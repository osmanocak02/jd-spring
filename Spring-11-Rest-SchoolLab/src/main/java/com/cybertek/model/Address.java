package com.cybertek.model;

import com.cybertek.enums.AddressType;
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
@JsonIgnoreProperties(value={"hibernate_Lazy_Initializer"}, ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address extends BaseEntity{

    private String city;
    private String country;
    private String state;
    private String street;

    @Column(name="postal_code")
    private String postalCode;

    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    /*@OneToOne(mappedBy = "address")
    @JsonIgnore
    private Parent parent;*/





    //private int currentTemperature;


}
