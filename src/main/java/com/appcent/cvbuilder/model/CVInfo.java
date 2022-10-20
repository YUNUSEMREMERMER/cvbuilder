package com.appcent.cvbuilder.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cvInformation")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","cityId"})
public class CVInfo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cvId")
    private Long cvId;

    @Column(name = "userId")
    private Long userId;

    @ManyToOne()
    @JoinColumn(name = "userId",insertable = false,updatable = false)
    @JsonIgnore()
    private User user;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "picture")
    private String picture;

    @Column(name = "shortResume")
    private String shortResume;

    @Column(name = "cvLink")
    private String cvLink;
    
    @Column(name="cityId")
    private Long cityId;

    @OneToOne()
    @JoinColumn(name = "cityId",insertable = false,updatable = false)
    private City city;

    @OneToMany(mappedBy = "cvInfo",cascade = CascadeType.ALL)
    private List<Link> links;

    @OneToMany(mappedBy = "cvInfo",cascade = CascadeType.ALL)
    private List<Experience> experiences;

    @OneToMany(mappedBy = "cvInfo",cascade = CascadeType.ALL)
    private List<Project> projects;

    @OneToMany(mappedBy = "cvInfo",cascade = CascadeType.ALL)
    private List<Education> educations;

    @OneToMany(mappedBy = "cvInfo",cascade = CascadeType.ALL)
    private List<Language> languages;

    @OneToMany(mappedBy = "cvInfo",cascade = CascadeType.ALL)
    private List<Skill> skills;

    @OneToMany(mappedBy = "cvInfo",cascade = CascadeType.ALL)
    private List<Certificate> certificates;

    @OneToMany(mappedBy = "cvInfo",cascade = CascadeType.ALL)
    private List<Achievement> achievements;

    @OneToMany(mappedBy = "cvInfo",cascade = CascadeType.ALL)
    private List<Hobby> hobbies;
}
