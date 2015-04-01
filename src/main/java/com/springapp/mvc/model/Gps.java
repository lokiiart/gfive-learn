package com.springapp.mvc.model;

import javax.persistence.*;

/**
 * Created by loki on 3/31/15.
 */
@Entity
@Table(name="GPS")
public class Gps {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String longitude;
    private String latitude;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "id="+id;
    }
}
