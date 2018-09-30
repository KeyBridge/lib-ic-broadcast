/*
 * Copyright 2018 Key Bridge. All rights reserved. Use is subject to license
 * terms.
 *
 * This software code is protected by Copyrights and remains the property of
 * Key Bridge and its suppliers, if any. Key Bridge reserves all rights in and to
 * Copyrights and no license is granted under Copyrights in this Software
 * License Agreement.
 *
 * Key Bridge generally licenses Copyrights for commercialization pursuant to
 * the terms of either a Standard Software Source Code License Agreement or a
 * Standard Product License Agreement. A copy of either Agreement can be
 * obtained upon request by sending an email to info@keybridgewireless.com.
 *
 * All information contained herein is the property of Key Bridge and its
 * suppliers, if any. The intellectual and technical concepts contained herein
 * are proprietary.
 */
package ca.gc.ic.lib.bdbs.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Key Bridge
 */
@Entity
@Table(name = "params")
@XmlAccessorType(XmlAccessType.FIELD)
public class Params implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected ParamsPK paramsPK;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "fieldratio")
  private Double fieldratio;
  @Column(name = "spacing")
  private Double spacing;
  @Column(name = "orienta")
  private Double orienta;
  @Column(name = "phasing")
  private Double phasing;
  @Column(name = "height")
  private Double height;
  @Column(name = "type_ant")
  private Integer typeAnt;
  @Column(name = "a")
  private Double a;
  @Column(name = "b")
  private Double b;
  @Column(name = "c")
  private Double c;
  @Column(name = "d")
  private Double d;
  @JoinColumns({
    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign")
    , @JoinColumn(name = "banner", referencedColumnName = "banner")})
  @ManyToOne
  @XmlTransient
  private Facility facility;

  public Params() {
  }

  public Params(ParamsPK paramsPK) {
    this.paramsPK = paramsPK;
  }

  public Params(String callsBanr, String dncCode, int towerNumb) {
    this.paramsPK = new ParamsPK(callsBanr, dncCode, towerNumb);
  }

  public ParamsPK getParamsPK() {
    return paramsPK;
  }

  public void setParamsPK(ParamsPK paramsPK) {
    this.paramsPK = paramsPK;
  }

  public Double getFieldratio() {
    return fieldratio;
  }

  public void setFieldratio(Double fieldratio) {
    this.fieldratio = fieldratio;
  }

  public Double getSpacing() {
    return spacing;
  }

  public void setSpacing(Double spacing) {
    this.spacing = spacing;
  }

  public Double getOrienta() {
    return orienta;
  }

  public void setOrienta(Double orienta) {
    this.orienta = orienta;
  }

  public Double getPhasing() {
    return phasing;
  }

  public void setPhasing(Double phasing) {
    this.phasing = phasing;
  }

  public Double getHeight() {
    return height;
  }

  public void setHeight(Double height) {
    this.height = height;
  }

  public Integer getTypeAnt() {
    return typeAnt;
  }

  public void setTypeAnt(Integer typeAnt) {
    this.typeAnt = typeAnt;
  }

  public Double getA() {
    return a;
  }

  public void setA(Double a) {
    this.a = a;
  }

  public Double getB() {
    return b;
  }

  public void setB(Double b) {
    this.b = b;
  }

  public Double getC() {
    return c;
  }

  public void setC(Double c) {
    this.c = c;
  }

  public Double getD() {
    return d;
  }

  public void setD(Double d) {
    this.d = d;
  }

  public Facility getFacility() {
    return facility;
  }

  public void setFacility(Facility facility) {
    this.facility = facility;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (paramsPK != null ? paramsPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Params)) {
      return false;
    }
    Params other = (Params) object;
    if ((this.paramsPK == null && other.paramsPK != null) || (this.paramsPK != null && !this.paramsPK.equals(other.paramsPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.lib.bdbs.entity.Params[ paramsPK=" + paramsPK + " ]";
  }

}
