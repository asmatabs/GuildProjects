/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.model;

import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author asmat
 */
@Entity
public class SuperHeroOrg {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long SuperHeroOrgId;
    
    @ManyToOne( fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = SuperHero.class)
    //@JoinColumn( name = "SuperHeroId", referencedColumnName = "SuperHeroId", insertable = true)
    private long superHeroId;
    
    @ManyToOne( fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Organization.class)
    //@JoinColumn( name = "OrgId", referencedColumnName = "OrgId", insertable = true)
    private Long orgId;

    public long getSuperHeroOrgId() {
        return SuperHeroOrgId;
    }

    public void setSuperHeroOrgId(long SuperHeroOrgId) {
        this.SuperHeroOrgId = SuperHeroOrgId;
    }

    public long getSuperHeroId() {
        return superHeroId;
    }

    public void setSuperHeroId(long superHeroId) {
        this.superHeroId = superHeroId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }



    
}
