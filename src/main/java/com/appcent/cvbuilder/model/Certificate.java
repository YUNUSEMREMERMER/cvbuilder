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
@Table(name = "certificate")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","cvInfo","cvId"})
public class Certificate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "certificateId")
    private Long certificateId;

    @Column(name = "programName")
    private String programName;

    @Column(name = "issuer")
    private String issuer;

    @Column(name = "receiveDate")
    private Date receiveDate;

    @Column(name = "cvId")
    private Long cvId;

    @ManyToOne()
    @JoinColumn(name = "cvId",insertable = false,updatable = false)
    private CVInfo cvInfo;
}
