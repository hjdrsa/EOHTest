/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eoh.test.cicjpa;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import eoh.test.cicjpa.enums.CicType;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author hjd
 */
@javax.persistence.Entity
public class Cic implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "CicType")
    private CicType type = null;

    @Column(name = "Subject")
    private String subject = null;

    @Column(name = "Body")
    private String body = null;

    @Column(name = "SourceSystem")
    private String sourceSystem = null;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CicTimeStamp")
    private Date cicTimeStamp = null;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "entityID")
    private eoh.test.cicjpa.Entity entity = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the type
     */
    public CicType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(CicType type) {
        this.type = type;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * @return the sourceSystem
     */
    public String getSourceSystem() {
        return sourceSystem;
    }

    /**
     * @param sourceSystem the sourceSystem to set
     */
    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    /**
     * @return the cicTimeStamp
     */
    public Date getCicTimeStamp() {
        return cicTimeStamp;
    }

    /**
     * @param cicTimeStamp the cicTimeStamp to set
     */
    public void setCicTimeStamp(Date cicTimeStamp) {
        this.cicTimeStamp = cicTimeStamp;
    }

    /**
     * @return the entity
     */
    public eoh.test.cicjpa.Entity getEntity() {
        return entity;
    }

    /**
     * @param entity the cicEntries to set
     */
    public void setEntity(eoh.test.cicjpa.Entity entity) {
        this.entity = entity;
    }

    @Override
    public String toString() {
        return "eoh.test.cicjpa.Cic[ id=" + id + " type= " + getType() + " subject=" + getSubject() + " body=" + getBody() + " SourceSystem=" + getSourceSystem() + " cicTimeStamp=" + getCicTimeStamp() + " ]";
    }
}
