package com.d288.ecommerce.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;


@Entity
@Table(name="countries")
@Getter
@Setter
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="country_id")
    private Long id;

    @Column(name="country")
    private String country_name;

    @OneToMany(cascade=CascadeType.ALL, mappedBy = "country")
    private Set<Division> divisions ;

    @Column(name="create_date")
    @CreationTimestamp
    private Date create_date;

    @Column(name="last_update")
    @UpdateTimestamp
    private Date last_update;

    // Generated getters and setters due to Lombok issue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public Set<Division> getDivisions() {
        return divisions;
    }

    public void setDivisions(Set<Division> divisions) {
        this.divisions = divisions;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }
}
