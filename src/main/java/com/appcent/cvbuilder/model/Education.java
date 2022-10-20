package com.appcent.cvbuilder.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.appcent.cvbuilder.model.education.EducationDepartment;
import com.appcent.cvbuilder.model.education.EducationLevel;
import com.appcent.cvbuilder.model.education.University;
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
@Table(name = "education")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","cvInfo","cvId","educationLevelId","educationDepartmentId","universityId"})
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "educationId")
    private Long educationId;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "endDate")
    private Date endDate;

    @Column(name = "isStillStudent")
    private Boolean isStillStudent;

    @Column(name = "cvId")
    private Long cvId;

    @ManyToOne()
    @JoinColumn(name = "cvId",insertable = false,updatable = false)
    private CVInfo cvInfo;

    @Column(name = "educationLevelId")
    private Long educationLevelId;

    @ManyToOne()
    @JoinColumn(name = "educationLevelId",insertable = false,updatable = false)
    private EducationLevel educationLevel;

    @Column(name = "universityId")
    private Long universityId;

    @ManyToOne()
    @JoinColumn(name = "universityId",insertable = false,updatable = false)
    private University university;

    @Column(name = "educationDepartmentId")
    private Long educationDepartmentId;

    @ManyToOne()
    @JoinColumn(name = "educationDepartmentId",insertable = false,updatable = false)
    private EducationDepartment department;
}
