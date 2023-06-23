package com.example.springproject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productoffer")
public class Productoffer {
    @Id
    @Column(name = "offerid", nullable = false, length = 20)
    private String offerid;

    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "hascode", length = 40)
    private String hascode;

    @Column(name = "offername", length = 70)
    private String offername;

    @Column(name = "qty")
    private Integer qty;

    @Column(name = "unit", length = 30)
    private String unit;

    @Column(name = "unitprice")
    private Integer unitprice;

    public String getOfferid() {
        return offerid;
    }

    public void setOfferid(String offerid) {
        this.offerid = offerid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHascode() {
        return hascode;
    }

    public void setHascode(String hascode) {
        this.hascode = hascode;
    }

    public String getOffername() {
        return offername;
    }

    public void setOffername(String offername) {
        this.offername = offername;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getUnitprice() {
        return unitprice;
    }

    public void setUnitprice(Integer unitprice) {
        this.unitprice = unitprice;
    }

}