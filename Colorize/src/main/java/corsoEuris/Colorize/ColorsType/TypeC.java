package com.ires.computers.models;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="computers")

public class Computer
{
    @Id
    @GeneratedValue
    @Column(name="COLORS")
    private String COLORS;

    @Column(name="RGB")

    private float RGB;

    @Column(name="HEX")

    private float HEX;

    @Column(name="HSL")

    private float HSL;

    public String getCOLORS() {
        return COLORS;
    }

    public void setCOLORS(String COLORS) {
        this.COLORS = COLORS;
    }

    public float getRGB() {
        return RGB;
    }

    public void setRGB(float RGB) {
        this.RGB = RGB;
    }

    public float getHEX() {
        return HEX;
    }

    public void setHEX(float HEX) {
        this.HEX = HEX;
    }

    public float getHSL() {
        return HSL;
    }

    public void setHSL(float HSL) {
        this.HSL = HSL;
    }
