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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlTransient;

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

  @XmlTransient
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected AmStationParameterPK amStationParameterPK;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "fieldratio", precision = 12)
  @XmlAttribute
  private float fieldratio;
  @Column(name = "spacing", precision = 12)
  @XmlAttribute
  private float spacing;
  @Column(name = "orienta", precision = 12)
  @XmlAttribute
  private float orienta;
  @Column(name = "phasing", precision = 12)
  @XmlAttribute
  private float phasing;
  @Column(name = "height", precision = 12)
  @XmlAttribute
  private float height;
  @Column(name = "type_ant")
  @XmlAttribute
  private int typeAnt;
  @Column(name = "a", precision = 12)
  @XmlAttribute
  private float a;
  @Column(name = "b", precision = 12)
  @XmlAttribute
  private float b;
  @Column(name = "c", precision = 12)
  @XmlAttribute
  private float c;
  @Column(name = "d", precision = 12)
  @XmlAttribute
  private float d;
  @JoinColumns({
    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign"),
    @JoinColumn(name = "banner", referencedColumnName = "banner")})
  @ManyToOne
  @XmlAttribute
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

  public float getFieldratio() {
    return fieldratio;
  }

  public void setFieldratio(float fieldratio) {
    this.fieldratio = fieldratio;
  }

  public float getSpacing() {
    return spacing;
  }

  public void setSpacing(float spacing) {
    this.spacing = spacing;
  }

  public float getOrienta() {
    return orienta;
  }

  public void setOrienta(float orienta) {
    this.orienta = orienta;
  }

  public float getPhasing() {
    return phasing;
  }

  public void setPhasing(float phasing) {
    this.phasing = phasing;
  }

  public float getHeight() {
    return height;
  }

  public void setHeight(float height) {
    this.height = height;
  }

  public int getTypeAnt() {
    return typeAnt;
  }

  public void setTypeAnt(int typeAnt) {
    this.typeAnt = typeAnt;
  }

  public float getA() {
    return a;
  }

  public void setA(float a) {
    this.a = a;
  }

  public float getB() {
    return b;
  }

  public void setB(float b) {
    this.b = b;
  }

  public float getC() {
    return c;
  }

  public void setC(float c) {
    this.c = c;
  }

  public float getD() {
    return d;
  }

  public void setD(float d) {
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
