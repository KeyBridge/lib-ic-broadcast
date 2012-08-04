/*
 *   Copyright (C) 2012 Caulfield IP Holdings (Caulfield)
 *   and/or its affiliates.
 *   All rights reserved. Use is subject to license terms.
 *
 *   Software Code is protected by Caulfield Copyrights. Caulfield hereby
 *   reserves all rights in and to Caulfield Copyrights and no license is
 *   granted under Caulfield Copyrights in this Software License Agreement.
 *   Caulfield generally licenses Caulfield Copyrights for commercialization
 *   pursuant to the terms of either Caulfield's Standard Software Source Code
 *   License Agreement or Caulfield's Standard Product License Agreement.
 *
 *   A copy of Caulfield's either License Agreement can be obtained on request
 *   by email from: info@caufield.org.
 */
package ca.gc.ic.broadcast.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jesse
 */
@Entity
@Table(name = "params")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "AmStationParameter.findAll", query = "SELECT a FROM AmStationParameter a"),
  @NamedQuery(name = "AmStationParameter.findByCallsBanr", query = "SELECT a FROM AmStationParameter a WHERE a.amStationParameterPK.callsBanr = :callsBanr"),
  @NamedQuery(name = "AmStationParameter.findByDncCode", query = "SELECT a FROM AmStationParameter a WHERE a.amStationParameterPK.dncCode = :dncCode"),
  @NamedQuery(name = "AmStationParameter.findByTowerNumb", query = "SELECT a FROM AmStationParameter a WHERE a.amStationParameterPK.towerNumb = :towerNumb"),
  @NamedQuery(name = "AmStationParameter.findByFieldratio", query = "SELECT a FROM AmStationParameter a WHERE a.fieldratio = :fieldratio"),
  @NamedQuery(name = "AmStationParameter.findBySpacing", query = "SELECT a FROM AmStationParameter a WHERE a.spacing = :spacing"),
  @NamedQuery(name = "AmStationParameter.findByOrienta", query = "SELECT a FROM AmStationParameter a WHERE a.orienta = :orienta"),
  @NamedQuery(name = "AmStationParameter.findByPhasing", query = "SELECT a FROM AmStationParameter a WHERE a.phasing = :phasing"),
  @NamedQuery(name = "AmStationParameter.findByHeight", query = "SELECT a FROM AmStationParameter a WHERE a.height = :height"),
  @NamedQuery(name = "AmStationParameter.findByTypeAnt", query = "SELECT a FROM AmStationParameter a WHERE a.typeAnt = :typeAnt"),
  @NamedQuery(name = "AmStationParameter.findByA", query = "SELECT a FROM AmStationParameter a WHERE a.a = :a"),
  @NamedQuery(name = "AmStationParameter.findByB", query = "SELECT a FROM AmStationParameter a WHERE a.b = :b"),
  @NamedQuery(name = "AmStationParameter.findByC", query = "SELECT a FROM AmStationParameter a WHERE a.c = :c"),
  @NamedQuery(name = "AmStationParameter.findByD", query = "SELECT a FROM AmStationParameter a WHERE a.d = :d")})
public class AmStationParameter implements Serializable {
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected AmStationParameterPK amStationParameterPK;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "fieldratio", precision = 12)
  private Float fieldratio;
  @Column(name = "spacing", precision = 12)
  private Float spacing;
  @Column(name = "orienta", precision = 12)
  private Float orienta;
  @Column(name = "phasing", precision = 12)
  private Float phasing;
  @Column(name = "height", precision = 12)
  private Float height;
  @Column(name = "type_ant")
  private Integer typeAnt;
  @Column(name = "a", precision = 12)
  private Float a;
  @Column(name = "b", precision = 12)
  private Float b;
  @Column(name = "c", precision = 12)
  private Float c;
  @Column(name = "d", precision = 12)
  private Float d;
  @JoinColumns({
    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign"),
    @JoinColumn(name = "banner", referencedColumnName = "banner")})
  @ManyToOne
  private CanadaStation canadaStation;

  public AmStationParameter() {
  }

  public AmStationParameter(AmStationParameterPK amStationParameterPK) {
    this.amStationParameterPK = amStationParameterPK;
  }

  public AmStationParameter(String callsBanr, String dncCode, int towerNumb) {
    this.amStationParameterPK = new AmStationParameterPK(callsBanr, dncCode, towerNumb);
  }

  public AmStationParameterPK getAmStationParameterPK() {
    return amStationParameterPK;
  }

  public void setAmStationParameterPK(AmStationParameterPK amStationParameterPK) {
    this.amStationParameterPK = amStationParameterPK;
  }

  public Float getFieldratio() {
    return fieldratio;
  }

  public void setFieldratio(Float fieldratio) {
    this.fieldratio = fieldratio;
  }

  public Float getSpacing() {
    return spacing;
  }

  public void setSpacing(Float spacing) {
    this.spacing = spacing;
  }

  public Float getOrienta() {
    return orienta;
  }

  public void setOrienta(Float orienta) {
    this.orienta = orienta;
  }

  public Float getPhasing() {
    return phasing;
  }

  public void setPhasing(Float phasing) {
    this.phasing = phasing;
  }

  public Float getHeight() {
    return height;
  }

  public void setHeight(Float height) {
    this.height = height;
  }

  public Integer getTypeAnt() {
    return typeAnt;
  }

  public void setTypeAnt(Integer typeAnt) {
    this.typeAnt = typeAnt;
  }

  public Float getA() {
    return a;
  }

  public void setA(Float a) {
    this.a = a;
  }

  public Float getB() {
    return b;
  }

  public void setB(Float b) {
    this.b = b;
  }

  public Float getC() {
    return c;
  }

  public void setC(Float c) {
    this.c = c;
  }

  public Float getD() {
    return d;
  }

  public void setD(Float d) {
    this.d = d;
  }

  public CanadaStation getCanadaStation() {
    return canadaStation;
  }

  public void setCanadaStation(CanadaStation canadaStation) {
    this.canadaStation = canadaStation;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (amStationParameterPK != null ? amStationParameterPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof AmStationParameter)) {
      return false;
    }
    AmStationParameter other = (AmStationParameter) object;
    if ((this.amStationParameterPK == null && other.amStationParameterPK != null) || (this.amStationParameterPK != null && !this.amStationParameterPK.equals(other.amStationParameterPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.AmStationParameter[ amStationParameterPK=" + amStationParameterPK + " ]";
  }

}
