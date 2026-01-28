package com.ecommerce.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "addresses")
@Data
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addressId")
    private Long addressId;

    @NotBlank
    @Size(min = 2, message = "Street name must contain 2 characters")
    private String street;

    @NotBlank
    @Size(min = 2, message = "Building name must contain 2 characters")
    private String buildingName;

    @NotBlank
    @Size(min = 2, message = "City name must contain 4 characters")
    private String city;

    @NotBlank
    @Size(min = 2, message = "State name must contain 2 characters")
    private String state;

    @NotBlank
    @Size(min = 2, message = "Country name must contain 2 characters")
    private String country;

    @NotBlank
    @Size(min = 4, message = "Pin code name must contain 4 characters")
    private String pincode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Address(String street, String pincode, String country, String state, String city, String buildingName) {
        this.street = street;
        this.pincode = pincode;
        this.country = country;
        this.state = state;
        this.city = city;
        this.buildingName = buildingName;
    }
}
