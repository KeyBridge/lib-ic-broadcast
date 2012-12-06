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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author jesse
 */
@Entity
@Table(name = "apatdesc")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ca.gc.ic/broadcast/entity")
@NamedQueries({
  @NamedQuery(name = "Antenna.findAll", query = "SELECT a FROM Antenna a"),
  @NamedQuery(name = "Antenna.findByPattKey", query = "SELECT a FROM Antenna a WHERE a.pattKey = :pattKey"),
  @NamedQuery(name = "Antenna.findByHorVer", query = "SELECT a FROM Antenna a WHERE a.horVer = :horVer"),
  @NamedQuery(name = "Antenna.findByPattNumb", query = "SELECT a FROM Antenna a WHERE a.pattNumb = :pattNumb"),
  @NamedQuery(name = "Antenna.findByPattType", query = "SELECT a FROM Antenna a WHERE a.pattType = :pattType"),
  @NamedQuery(name = "Antenna.findByPunits", query = "SELECT a FROM Antenna a WHERE a.punits = :punits"),
  @NamedQuery(name = "Antenna.findByNumpoints", query = "SELECT a FROM Antenna a WHERE a.numpoints = :numpoints"),
  @NamedQuery(name = "Antenna.findByPattDate", query = "SELECT a FROM Antenna a WHERE a.pattDate = :pattDate")})
public class Antenna implements Serializable {

  @XmlTransient
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "patt_key", nullable = false)
  @XmlAttribute
  private Integer pattKey;
  @Column(name = "hor_ver", length = 1)
  @XmlAttribute
  private String horVer;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "patt_numb", precision = 12)
  @XmlAttribute
  private Double pattNumb;
  @Column(name = "patt_type", length = 12)
  @XmlAttribute
  private String pattType;
  @Column(name = "punits", precision = 12)
  @XmlAttribute
  private Double punits;
  @Column(name = "numpoints", precision = 12)
  @XmlAttribute
  private Double numpoints;
  /**
   * Date encoded as yyyyMMdd
   */
  @Column(name = "patt_date", precision = 12)
  @XmlTransient
  private String pattDate;
  @JoinTable(name = "apatstat", joinColumns = {
    @JoinColumn(name = "patt_key", referencedColumnName = "patt_key", nullable = false)}, inverseJoinColumns = {
    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign", nullable = false),
    @JoinColumn(name = "banner", referencedColumnName = "banner", nullable = false)})
  @ManyToMany
  @XmlTransient
  private List<CanadaStation> canadaStationList;
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "antenna")
  private List<RadiationPattern> radiationPatternList;
  /**
   * The date this pattern data was imported into the Canada database. This
   * field is post-loaded from the pattDate value.
   */
  @Transient
  @XmlAttribute(name = "patDate")
  private Date datePatternData;

  public Antenna() {
  }

  public Antenna(int pattKey) {
    this.pattKey = pattKey;
  }

  //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
  public Integer getPattKey() {
    return pattKey;
  }

  public void setPattKey(Integer pattKey) {
    this.pattKey = pattKey;
  }

  public String getHorVer() {
    return horVer;
  }

  public void setHorVer(String horVer) {
    this.horVer = horVer;
  }

  public Double getPattNumb() {
    return pattNumb;
  }

  public void setPattNumb(Double pattNumb) {
    this.pattNumb = pattNumb;
  }

  public String getPattType() {
    return pattType;
  }

  public void setPattType(String pattType) {
    this.pattType = pattType;
  }

  public Double getPunits() {
    return punits;
  }

  public void setPunits(Double punits) {
    this.punits = punits;
  }

  public Double getNumpoints() {
    return numpoints;
  }

  public void setNumpoints(Double numpoints) {
    this.numpoints = numpoints;
  }

  public String getPattDate() {
    return pattDate;
  }

  public void setPattDate(String pattDate) {
    this.pattDate = pattDate;
  }

  public List<CanadaStation> getCanadaStationList() {
    return canadaStationList;
  }

  public void setCanadaStationList(List<CanadaStation> canadaStationList) {
    this.canadaStationList = canadaStationList;
  }

  public List<RadiationPattern> getRadiationPatternList() {
    if (radiationPatternList == null) {
      radiationPatternList = new ArrayList<RadiationPattern>();
    }
    return radiationPatternList;
  }

  public void setRadiationPatternList(List<RadiationPattern> radiationPatternList) {
    this.radiationPatternList = radiationPatternList;
  }

  public Date getDatePatternData() {
    return datePatternData;
  }

  public void setDatePatternData(Date datePatternData) {
    this.datePatternData = datePatternData;
  }//</editor-fold>

  /**
   * Process and convert the antenna values after loading from the database.
   */
  @PostLoad
  public void postLoad() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    try {
      datePatternData = sdf.parse(pattDate);
    } catch (ParseException ex) {
//      Logger.getLogger(Antenna.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (pattKey != null ? pattKey.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {

    if (!(object instanceof Antenna)) {
      return false;
    }
    Antenna other = (Antenna) object;
    if ((this.pattKey == null && other.pattKey != null) || (this.pattKey != null && !this.pattKey.equals(other.pattKey))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Antenna"
      + " pattKey [" + pattKey
      + "] horVer [" + horVer
      + "] pattNumb [" + pattNumb
      + "] pattType [" + pattType
      + "] punits [" + punits
      + "] numpoints [" + numpoints
      + "] pattDate [" + pattDate
      + "] canadaStationList [" + canadaStationList
      + "]\n radiationPatternList [" + radiationPatternList
      + ']';
  }
}
