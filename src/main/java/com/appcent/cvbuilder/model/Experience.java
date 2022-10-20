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

import com.appcent.cvbuilder.model.experience.JobDepartment;
import com.appcent.cvbuilder.model.experience.JobPosition;
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
@Table(name = "experience")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","cvInfo","cvId","jobPositionId","jobDepartmentId"})
public class Experience{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experienceId")
    private Long experienceId;

    @Column(name = "companyName")
    private String companyName;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "endDate")
    private Date endDate;

    @Column(name = "jobDescription")
    private String jobDescription;
    
    @Column(name = "isStillWorking")
    private Boolean isStillWorking;

    @Column(name = "cvId")
    private Long cvId;

    @Column(name = "jobPositionId")
    private Long jobPositionId;

    @Column(name="jobDepartmentId")
    private Long jobDepartmentId;

    @ManyToOne()
    @JoinColumn(name = "cvId",insertable = false,updatable = false)
    private CVInfo cvInfo;

    @ManyToOne()
    @JoinColumn(name = "jobPositionId",insertable = false,updatable = false)
    private JobPosition jobPosition;

    @ManyToOne()
    @JoinColumn(name = "jobDepartmentId",insertable = false,updatable = false)
    private JobDepartment jobDepartment;
}
