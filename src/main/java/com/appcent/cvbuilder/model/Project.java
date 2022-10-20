package com.appcent.cvbuilder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name = "project")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","cvInfo","cvId"})
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectId")
    private Long projectId;

    @Column(name = "projectTitle")
    private String projectTitle;

    @Column(name = "projectDescription")
    private String projectDescription;

    @Column(name = "cvId")
    private Long cvId;

    @ManyToOne()
    @JoinColumn(name = "cvId",insertable = false,updatable = false)
    private CVInfo cvInfo;

}
