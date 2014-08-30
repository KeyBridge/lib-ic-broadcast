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

import ca.gc.ic.broadcast.entity.enumerated.ECanadaBanner;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.*;

/**
 * Logical data model container for the CANADA CanadaStation (ca_station) table
 * describing TV stations.
 * <p>
 * This class extends the CanadaStation object with fields specific to Broadcast
 * Television and not used by other station types. The total complement of
 * fields supported by this record is the union of both the the CanadaStation
 * and CanadaStationTv field set.
 * <p/>
 * Developer note: Some fields in the logical data model (e.g. this
 * implementation) are named differently from the physical data model (e.g.
 * database table) names to improve software clarity and usability.
 * <p/>
 * @author jesse
 */
@Entity
@DiscriminatorValue("TV")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ca.gc.ic/broadcast/entity")
public class CanadaStationTv extends CanadaStation {

  @XmlTransient
  private static final long serialVersionUID = 1L;
  /**
   * Allocation Planning Zone 0, 1 or 2
   */
  @Column(name = "alloc_zone")
  @XmlAttribute
  private Integer allocZone;
  /**
   * Antenna Mode: O, D, Space; Omnidirectional or Directional
   */
  @Column(name = "ant_mode")
  @XmlAttribute(required = true)
  private Character antMode;
  /**
   * Beam Tilt Angle in Degrees; -10.0 to 10.0
   */
  @Column(name = "beam_tilt", precision = 12)
  @XmlAttribute
  private Double beamTilt;
  /**
   * Closed Captioning; Y or N
   */
  @Column(name = "close_cap")
  @XmlAttribute
  private Character closedCaptioning;
  /**
   * Effective Height of Antenna Above Terrain
   * <p/>
   * -1,200.0 to 2,000.0 meters
   */
  @Basic(optional = false)
  @Column(name = "ehaat", nullable = false)
  @XmlAttribute
  private Double haat;
  /**
   * ERP Aural Average in Watts
   * <p/>
   * 0 to 1,000,000
   */
  @Column(name = "erpaav", precision = 12)
  @XmlAttribute
  private Double erpaav;
  /**
   * ERP Aural Peak Power in Watts
   * <p/>
   * 0 to 1,000,000
   */
  @Column(name = "erpapk", precision = 12)
  @XmlAttribute
  private Double erpapk;
  /**
   * The Documentation claims this is the ERP Average Power at Tilt Angle in
   * watts [0 to 5,000,000]. However, FCC guidance and the data indicate that
   * this field is used to positively differentiate Analog or Digital operation
   * as follows:
   * <p/>
   * The modulation field specifies the type of operation (analog or digital).
   * TV modulation information is contained in the table column ERPATA and coded
   * as 0=Analog; 1=Digital and 2=Post-transition.
   * <p/>
   * Developer note: 07/10/13: The canada 'tvstatio' database table contains the
   * following values for this field [0, 1, 2], with active records showing the
   * following values [0, 1].
   */
  @Column(name = "erpata")
  @XmlAttribute
  private Integer erpata;
  /**
   * ERP Visual Peak Power in Watts.
   * <p>
   * This value is used by default. If not set then the ERP Visual Average
   * {@link #erpvav} is used.
   * <p/>
   * Documentation allows range of 0 to over 5,000,000. Database range is 0 to
   * 846,000.
   */
  @Basic(optional = false)
  @Column(name = "erpvpk", nullable = false)
  @XmlAttribute(required = true)
  private Double erpvpk;
  /**
   * ERP Visual Average in Watts
   * <p>
   * Database range is 0 to 609,000.
   */
  @Column(name = "erpvav", precision = 12)
  @XmlAttribute
  private Double erpvav;
  /**
   * ERP Peak Visual Power at Tilt Angle in Watts
   * <p/>
   * Documentation allows range of 0 to over 5,000,000. This field is not set in
   * the database (always zero).
   */
  @Column(name = "erpvta", precision = 12)
  @XmlAttribute
  private Double erpvta;
  /**
   * Ground Level at Tower Base above Sea Level in Meters. (AMSL)
   * <p/>
   * Documentation allows range of 0.0 to 9,999.9. Database range is 0 to 2955.
   */
  @Column(name = "ground_lev", precision = 12)
  @XmlAttribute
  private Double towerElevation;
  /**
   * Limitation Identification code "LAAAA".
   * <p/>
   * @deprecated Not used in logical data model.
   */
  @Column(name = "limit_code", length = 8)
  @XmlTransient
  private String limitCode;
  /**
   * Refers to Off-set Precision. Valid Y, Space.
   */
  @Column(name = "off_prec")
  @XmlAttribute
  private Character offSetPrecision;
  /**
   * Refers to TV Off-set Code. Space, +, -, Z.
   */
  @Column(name = "offset")
  @XmlAttribute
  private Character offSetCode;
  /**
   * Overall Height Above ground in Meters
   * <p/>
   * Documentation allows range of 0.0 to 999.9. Database range is 0 to 797.
   */
  @Column(name = "overall_h", precision = 12)
  @XmlAttribute
  private Double overallHag;
  /**
   * Radiating Center Above Mean Sea Level in meters. (AMSL)
   * <p/>
   * Developer note: The BDBS documentation appears to be in error and cites
   * this values as "Radiating Center Above Ground Level 0.0 to 5,000.0 metres".
   * However the earlier document entry for FM stations identifies this field as
   * "Above Mean Sea Level 0.0 to 5000.0 metres"
   * <p/>
   * Documentation allows range of 0.0 to 5,000.0 meters. Database range is 0 to
   * 2790.
   */
  @Column(name = "rad_center", precision = 12)
  @XmlAttribute
  private Double radCenter;

  public CanadaStationTv() {
  }

  public CanadaStationTv(CanadaStationPK canadaStationPK) {
    this.canadaStationPK = canadaStationPK;
  }

  public CanadaStationTv(ECanadaBanner banner, String callSign) {
    this.canadaStationPK = new CanadaStationPK(banner, callSign);
  }

  //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
  /**
   * @return Allocation Planning Zone 0, 1 or 2
   */
  public Integer getAllocZone() {
    return allocZone;
  }

  public void setAllocZone(Integer allocZone) {
    this.allocZone = allocZone;
  }

  /**
   * @return Antenna Mode: O, D, Space; Omnidirectional or Directional
   */
  public Character getAntMode() {
    return antMode;
  }

  public void setAntMode(Character antMode) {
    this.antMode = antMode;
  }

  /**
   * @return Beam Tilt Angle in Degrees
   */
  public Double getBeamTilt() {
    return beamTilt;
  }

  public void setBeamTilt(Double beamTilt) {
    this.beamTilt = beamTilt;
  }

  /**
   * @return Closed Captioning
   */
  public boolean getClosedCaptioning() {
    return closedCaptioning != null ? closedCaptioning.equals('Y') : false;
  }

  public void setClosedCaptioning(boolean closedCaptioning) {
    this.closedCaptioning = closedCaptioning ? 'Y' : 'N';
  }

  /**
   * @return Effective Height of Antenna Above Terrain
   */
  public Double getHaat() {
    return haat;
  }

  public void setHaat(Double haat) {
    this.haat = haat;
  }

  /**
   * @return ERP Aural Average in Watts
   */
  public Double getErpaav() {
    return erpaav;
  }

  public void setErpaav(Double erpaav) {
    this.erpaav = erpaav;
  }

  /**
   * @return ERP Aural Peak Power in Watts
   */
  public Double getErpapk() {
    return erpapk;
  }

  public void setErpapk(Double erpapk) {
    this.erpapk = erpapk;
  }

  /**
   * @return ERP Average Power at Tilt Angle in watts
   */
  public Integer getErpata() {
    return erpata;
  }

  public void setErpata(Integer erpata) {
    this.erpata = erpata;
  }

  /**
   * @return ERP Visual Peak Power in Watts
   */
  public Double getErpvpk() {
    return erpvpk;
  }

  public void setErpvpk(Double erpvpk) {
    this.erpvpk = erpvpk;
  }

  /**
   * @return ERP Visual Average in Watts
   */
  public Double getErpvav() {
    return erpvav;
  }

  public void setErpvav(Double erpvav) {
    this.erpvav = erpvav;
  }

  /**
   * @return ERP Peak Visual Power at Tilt Angle in Watts
   */
  public Double getErpvta() {
    return erpvta;
  }

  public void setErpvta(Double erpvta) {
    this.erpvta = erpvta;
  }

  /**
   * @return Ground Level at Tower Base above Sea Level in Meters
   */
  public Double getTowerElevation() {
    return towerElevation;
  }

  public void setTowerElevation(Double towerElevation) {
    this.towerElevation = towerElevation;
  }

  /**
   * @deprecated Not used in the logical data model.
   */
  public String getLimitCode() {
    return limitCode;
  }

  public void setLimitCode(String limitCode) {
    this.limitCode = limitCode;
  }

  /**
   * @return Off-set Precision is valid.
   */
  public boolean getOffSetPrecision() {
    return offSetPrecision != null ? offSetPrecision.equals('Y') : false;
  }

  public void setOffSetPrecision(boolean offSetPrecision) {
    this.offSetPrecision = offSetPrecision ? 'Y' : 'N';
  }

  /**
   * @return The TV Off-set Code. Space, +, -, Z.
   */
  public Character getOffSetCode() {
    return offSetCode;
  }

  public void setOffSetCode(Character offSetCode) {
    this.offSetCode = offSetCode;
  }

  /**
   * @return Overall Height Above ground in Meters
   */
  public Double getOverallHag() {
    return overallHag;
  }

  public void setOverallHag(Double overallHag) {
    this.overallHag = overallHag;
  }

  /**
   * @return Radiating Center Above Mean Sea Level in meters.
   */
  public Double getRadCenter() {
    return radCenter;
  }

  public void setRadCenter(Double radCenter) {
    this.radCenter = radCenter;
  }//</editor-fold>

  /**
   * Boolean indicator that the television transmitter is a digital signal.
   * <p/>
   * @return TRUE for digital signals.
   */
  public boolean isDigital() {
    if (erpata == null) {
      return false;
    }
    return erpata > 0;
  }

  @Override
  public String toStringFull() {
    return "CanadaStationTv"
      + super.toString()
      + " allocZone [" + allocZone
      + "] antMode [" + antMode
      + "] beamTilt [" + beamTilt
      + "] closeCap [" + closedCaptioning
      + "] erpaav [" + erpaav
      + "] erpapk [" + erpapk
      + "] erpata [" + erpata
      + "] erpvpk [" + erpvpk
      + "] erpvav [" + erpvav
      + "] erpvta [" + erpvta
      + "] groundLev [" + towerElevation
      + "] limitCode [" + limitCode
      + "] offSetPrecision [" + offSetPrecision
      + "] offSetCode [" + offSetCode
      + "] overallHag [" + overallHag
      + "] radCenter [" + radCenter
      + ']';
  }
}
