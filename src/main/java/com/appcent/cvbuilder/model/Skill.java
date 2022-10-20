package com.appcent.cvbuilder.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.appcent.cvbuilder.model.skill.SkillName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.appcent.cvbuilder.model.skill.SkillLevel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "skill")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","cvInfo","cvId","skillNameId","skillLevelId"})
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skillId")
    private Long skillId;

    @Column(name = "cvId")
    private Long cvId;

    @ManyToOne()
    @JoinColumn(name = "cvId",insertable = false,updatable = false)
    private CVInfo cvInfo;

    @Column(name = "skillNameId")
    private Long skillNameId;

    @ManyToOne()
    @JoinColumn(name = "skillNameId",insertable = false,updatable = false)
    private SkillName skillName;

    @Column(name = "skillLevelId")
    private Long skillLevelId;

    @ManyToOne()
    @JoinColumn(name = "skillLevelId",insertable = false,updatable = false)
    private SkillLevel skillLevel;
}
