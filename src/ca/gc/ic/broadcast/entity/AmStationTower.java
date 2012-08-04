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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author jesse
 */
@Entity
@Table(name = "params")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ca.gc.ic/broadcast/entity")
@NamedQueries({
  @NamedQuery(name = "AmStationTower.findAll", query = "SELECT a FROM AmStationTower a"),
  @NamedQuery(name = "AmStationTower.findByCallsBanr", query = "SELECT a FROM AmStationTower a WHERE a.amStationTowerPK.callsBanr = :callsBanr"),
  @NamedQuery(name = "AmStationTower.findByDncCode", query = "SELECT a FROM AmStationTower a WHERE a.amStationTowerPK.dncCode = :dncCode"),
  @NamedQuery(name = "AmStationTower.findByTowerNumb", query = "SELECT a FROM AmStationTower a WHERE a.amStationTowerPK.towerNumb = :towerNumb"),
  @NamedQuery(name = "AmStationTower.findByFieldratio", query = "SELECT a FROM AmStationTower a WHERE a.fieldratio = :fieldratio"),
  @NamedQuery(name = "AmStationTower.findBySpacing", query = "SELECT a FROM AmStationTower a WHERE a.spacing = :spacing"),
  @NamedQuery(name = "AmStationTower.findByOrienta", query = "SELECT a FROM AmStationTower a WHERE a.orienta = :orienta"),
  @NamedQuery(name = "AmStationTower.findByPhasing", query = "SELECT a FROM AmStationTower a WHERE a.phasing = :phasing"),
  @NamedQuery(name = "AmStationTower.findByHeight", query = "SELECT a FROM AmStationTower a WHERE a.height = :height"),
  @NamedQuery(name = "AmStationTower.findByTypeAnt", query = "SELECT a FROM AmStationTower a WHERE a.typeAnt = :typeAnt"),
  @NamedQuery(name = "AmStationTower.findByA", query = "SELECT a FROM AmStationTower a WHERE a.a = :a"),
  @NamedQuery(name = "AmStationTower.findByB", query = "SELECT a FROM AmStationTower a WHERE a.b = :b"),
  @NamedQuery(name = "AmStationTower.findByC", query = "SELECT a FROM AmStationTower a WHERE a.c = :c"),
  @NamedQuery(name = "AmStationTower.findByD", query = "SELECT a FROM AmStationTower a WHERE a.d = :d")})
public class AmStationTower implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected AmStationTowerPK amStationTowerPK;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(precision = 12)
  @XmlAttribute
  private Float fieldratio;
  @Column(precision = 12)
  @XmlAttribute
  private Float spacing;
  @Column(precision = 12)
  @XmlAttribute
  private Float orienta;
  @Column(precision = 12)
  @XmlAttribute
  private Float phasing;
  @Column(precision = 12)
  @XmlAttribute
  private Float height;
  @Column(name = "type_ant")
  @XmlAttribute
  private Integer typeAnt;
  @Column(precision = 12)
  @XmlAttribute
  private Float a;
  @Column(precision = 12)
  @XmlAttribute
  private Float b;
  @Column(precision = 12)
  @XmlAttribute
  private Float c;
  @Column(precision = 12)
  @XmlAttribute
  private Float d;
  @JoinColumns({
    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign"),
    @JoinColumn(name = "banner", referencedColumnName = "banner")})
  @ManyToOne
  private AmStation amStation;

  public AmStationTower() {
  }

  public AmStationTower(AmStationTowerPK amStationTowerPK) {
    this.amStationTowerPK = amStationTowerPK;
  }

  public AmStationTower(String callsBanr, String dncCode, int towerNumb) {
    this.amStationTowerPK = new AmStationTowerPK(callsBanr, dncCode, towerNumb);
  }

  public AmStationTowerPK getAmStationTowerPK() {
    return amStationTowerPK;
  }

  public void setAmStationTowerPK(AmStationTowerPK amStationTowerPK) {
    this.amStationTowerPK = amStationTowerPK;
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

  public AmStation getAmStation() {
    return amStation;
  }

  public void setAmStation(AmStation amStation) {
    this.amStation = amStation;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (amStationTowerPK != null ? amStationTowerPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof AmStationTower)) {
      return false;
    }
    AmStationTower other = (AmStationTower) object;
    if ((this.amStationTowerPK == null && other.amStationTowerPK != null) || (this.amStationTowerPK != null && !this.amStationTowerPK.equals(other.amStationTowerPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.AmStationTower[ amStationTowerPK=" + amStationTowerPK + " ]";
  }
}
