package com.example.guide.connect.model;

import jakarta.persistence.*;

@Entity
@Table(name = "guides")
public class Guide extends User { //imherited from User

    @Column(columnDefinition = "TEXT")
    private String biography;

    @Column
    private String languages;

    @Column
    private Double pricing;

    @Column
    private String profilePhoto;

    public String getBiography() { return biography; }
    public void setBiography(String biography) { this.biography = biography; }

    public String getLanguages() { return languages; }
    public void setLanguages(String languages) { this.languages = languages; }

    public Double getPricing() { return pricing; }
    public void setPricing(Double pricing) { this.pricing = pricing; }

    public String getProfilePhoto() { return profilePhoto; }
    public void setProfilePhoto(String profilePhoto) { this.profilePhoto = profilePhoto; }
}