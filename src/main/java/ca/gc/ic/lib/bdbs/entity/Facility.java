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

import ca.gc.ic.lib.bdbs.entity.type.FacilityType;
import ca.gc.ic.lib.bdbs.entity.type.StationClassType;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 * Data model container for the CANADA Facility table.
 * <p>
 * The Facility is a consolidated / hybrid record that incorporates fields from
 * the AM, FM, TV and SDAR station descriptions. This abstract object is not
 * used directly, but instead is extended by the AM, FM, TV and SDAR station
 * subtype implementations.
 * <p>
 * Facility implementations are differentiated in the database by the
 * facilityType ("station_type") field.
 *
 * @author Key Bridge
 * @since v3.0.0 rebuild 09/30/18 to mirror the physical data model.
 */
@Entity
@Table(name = "facility")
@NamedQueries({
  @NamedQuery(name = "Facility.findAll", query = "SELECT f FROM Facility f")
  /**
   * Find facilities of the indicated type and Banner code.
   */
  , @NamedQuery(name = "Facility.findByFacilityTypeAndBanner", query = "SELECT f FROM Facility f WHERE f.facilityType  = :facilityType AND f.facilityPK.banner = :banner")
  , @NamedQuery(name = "Facility.findByCallSign", query = "SELECT f FROM Facility f WHERE f.facilityPK.callSign LIKE :callSign")
})
@XmlRootElement(name = "Facility")
@XmlType(name = "Facility")
@XmlAccessorType(XmlAccessType.FIELD)
public class Facility implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected FacilityPK facilityPK;

  /**
   * Table discriminator. Facility implementations are differentiated in the
   * database by the "facility_type" field.
   */
  @Enumerated(EnumType.STRING)
  @Basic(optional = false)
  @Column(name = "facility_type")
  private FacilityType facilityType;
  /**
   * The transmitting CHANNEL; The channel value varies by Station Type and is
   * context dependent.
   */
  @Basic(optional = false)
  @Column(name = "channel")
  private int channel;
  /**
   * Latitude coordinate in decimal degrees of the Station Transmitter
   */
  @Basic(optional = false)
  @Column(name = "latitude")
  private String latitude;
  /**
   * Longitude coordinate in decimal degrees of the Station Transmitter
   */
  @Basic(optional = false)
  @Column(name = "longitude")
  private String longitude;
  /**
   * Broadcasting Mode; [S: Stereo, M: Mono, P: Second Audio Channels or B:
   * Both]
   */
  @Column(name = "bc_mode")
  private Character bcMode;
  /**
   * Beam Tilt Angle in Degrees; -10.0 to 10.0
   */
  @Column(name = "beam_tilt")
  private Double beamTilt;
  /**
   * Closest distance to Canada / U.S. Border (km)
   */
  @Column(name = "border")
  private Double border;
  /**
   * N.Latitude used when BORDER last calculated
   */
  @Column(name = "brdr_lat")
  private String brdrLat;
  /**
   * W.Longitude used when BORDER last calculated
   */
  @Column(name = "brdr_long")
  private String brdrLong;
  /**
   * Closest distance to Canada Land Edge
   */
  @Column(name = "can_land")
  private Double canLand;
  /**
   * Broadcasting Certificate Number. Format is "FANNNN"
   */
  @Column(name = "cert_numb")
  private String certNumb;
  /**
   * The station City name.
   */
  @Column(name = "city")
  private String city;
  /**
   * The (StationClassType enumerated) Canadian class code of this Station;
   * <p>
   * For Canadian Stations: [A, A1, B, C, C1, LP, VLP]
   * <p>
   * For Non-Canadian Stations: [A, B, B1, C, C1, C2, D]
   */
  @Column(name = "clazz")
  private String clazz;
  /**
   * Canadian Radio-television and Telecommunications Commission (CRTC) Decision
   * Number. Format is "YYNNNN"
   */
  @Column(name = "dec_number")
  private Integer decNumber;
  /**
   * Industry Canada document file number
   */
  @Column(name = "doc_file")
  private Integer docFile;
  /**
   * Effective Height of Antenna Above Terrain
   * <p>
   * -1,200.0 to 2,000.0 meters
   */
  @Column(name = "ehaat")
  private Double ehaat;
  /**
   * Closest distance to French Land Edge near Newfoundland
   */
  @Column(name = "fre_land")
  private Double freLand;
  /**
   * Broadcast frequency in MHz.
   * <p>
   * AM Station frequencies are originally recorded in kHz but are automatically
   * converted to MHz upon import into the ca_station table.
   */
  @Column(name = "frequency")
  private Double frequency;
  /**
   * Ground Level at Tower Base above Sea Level in Meters. (AMSL)
   * <p>
   * Documentation allows range of 0.0 to 9,999.9. Database range is 0 to 2955.
   */
  @Column(name = "ground_lev")
  private Double groundLev;
  /**
   * The broadcast Network (CBCE, CBCF, IND, INDE, INDF, BCMH, or none)
   */
  @Column(name = "network")
  private String network;
  /**
   * Last date of record update for the "Consultants" database export dump
   */
  @Column(name = "ok_dump")
  private String okDump;
  /**
   * Overall Height Above ground in Meters
   * <p>
   * Documentation allows range of 0.0 to 999.9. Database range is 0 to 797.
   */
  @Column(name = "overall_h")
  private Double overallH;
  /**
   * The station province (Canada) or state (US)
   */
  @Column(name = "province")
  private String province;
  /**
   * Radiating Center Above Mean Sea Level (AMSL) in meters.
   * <p>
   * <p>
   * Developer note: The BDBS documentation appears to be in error and cites
   * this values as "Radiating Center Above Ground Level 0.0 to 5,000.0 metres".
   * However the earlier document entry for FM stations identifies this field as
   * "Above Mean Sea Level 0.0 to 5000.0 metres".
   * <p>
   * Corrected in May 2013 "Broadcast Data Extract (AM-FM-TV) - Corrective Notes
   * to User Manual": Radiating Center Above Mean Sea Level.
   * <p>
   * Documentation allows range of 0.0 to 5,000.0 meters. Database range is 0 to
   * 2632.
   */
  @Column(name = "rad_center")
  private Double radCenter;
  /**
   * Short Spacing Code; "*O#aa"
   */
  @Column(name = "ss_code")
  private String ssCode;
  /**
   * Date the station was first entered in the database
   */
  @Column(name = "st_creat")
  private String stCreat;
  /**
   * Date the station record was last modified in the database
   */
  @Column(name = "st_mod")
  private String stMod;
  /**
   * Unattended Operation Code (Y, N)
   */
  @Column(name = "unattended")
  private Character unattended;
  /**
   * Closest distance to USA Land Edge
   */
  @Column(name = "usa_land")
  private Double usaLand;
  /**
   * Comment table reference. (This table contains user information)
   */
  @OneToMany(mappedBy = "facility")
  private Collection<Comments> comments;
  /**
   * Feed Signal table reference.
   * <p>
   * This defines the source of a feed signal for a TV service.
   */
  @OneToMany(mappedBy = "facility")
  private Collection<Feeds> feeds;
  /**
   * List of Antenna objects. In the Canada database each antenna record
   * describes a different polarization for the same physical antenna.
   */
  @OneToMany(mappedBy = "facility")
  private Collection<Apatstat> antennaPatterns;
  /**
   * Regional Filing table reference.
   */
  @OneToMany(mappedBy = "facility")
  private Collection<Region> regions;
  /**
   * Transmission Signal Identifier (TSID) is a 16-bit packet contained within
   * the Extended Data Services (XDS) of EIA-608B.
   */
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "facility")
  private Tsid tsid;
  /**
   * Contour table reference. This is not used for white space calculations and
   * is therefore hidden in the logical data model..
   */
  @OneToMany(mappedBy = "facility")
  private Collection<Contours> contours;

  //<editor-fold defaultstate="collapsed" desc="AM broadcast facility fields">
  /**
   * RSS Night Interference Free Value
   */
  @Column(name = "euvalu")
  private Double euvalu;
  /**
   * IFRB Number for day time
   */
  @Column(name = "ifrbn_d")
  private Double ifrbnD;
  /**
   * IFRB Number for night time
   */
  @Column(name = "ifrbn_n")
  private Double ifrbnN;
  @Column(name = "latitude2")
  private String latitude2;
  @Column(name = "longitude2")
  private String longitude2;
  @Column(name = "par_rms_c")
  private Double parRmsC;
  @Column(name = "par_rms_d")
  private Double parRmsD;
  @Column(name = "par_rms_n")
  private Double parRmsN;
  @Column(name = "powercrit")
  private Double powercrit;
  @Column(name = "powerday")
  private Double powerday;
  @Column(name = "powernight")
  private Double powernight;
  @Column(name = "q_crit")
  private Double qCrit;
  @Column(name = "q_day")
  private Double qDay;
  @Column(name = "q_night")
  private Double qNight;
  @Column(name = "status1")
  private String status1;
  @Column(name = "status2")
  private String status2;
  @OneToMany(mappedBy = "facility")
  private Collection<Extend> extendCollection;
  @OneToMany(mappedBy = "facility")
  private Collection<Params> paramsCollection;
  @OneToMany(mappedBy = "facility")
  private Collection<Augment> augmentCollection;
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="FM broadcast facility fields">
  @Column(name = "erpvpk")
  private Double erpvpk;
  @Column(name = "auto_prog")
  private String autoProg;
  @Column(name = "erphav")
  private Double erphav;
  @Column(name = "erphpk")
  private Double erphpk;
  @Column(name = "scmo")
  private Character scmo;
  //</editor-fold>

  //<editor-fold defaultstate="collapsed" desc="Television broadcast facility fields">
  /**
   * Allocation Planning Zone 0, 1 or 2
   */
  @Column(name = "alloc_zone")
  private Integer allocZone;
  /**
   * Antenna Mode: O, D, Space; Omnidirectional or Directional
   */
  @Column(name = "ant_mode")
  private Character antMode;
  /**
   * Closed Captioning; Y or N
   */
  @Column(name = "close_cap")
  private Character closeCap;
  /**
   * ERP Aural Average in Watts
   * <p>
   * 0 to 1,000,000
   */
  @Column(name = "erpaav")
  private Double erpaav;
  /**
   * ERP Aural Peak Power in Watts
   * <p>
   * 0 to 1,000,000
   */
  @Column(name = "erpapk")
  private Double erpapk;
  /**
   * Indicator that the television transmitter is a Analog or Digital operation.
   * This field is interpreted conveniently in the method {@link #isDigital()}.
   * <p>
   * The Canada 'tvstatio' database table contains the following values for this
   * field [0, 1, 2], with active records showing the following values [0, 1].
   * <p>
   * BDBS Documentation claims this is the ERP Average Power at Tilt Angle in
   * watts [0 to 5,000,000]. However, FCC guidance and the data indicate this
   * field is used to positively differentiate Analog vs. Digital operation as
   * follows:
   * <p>
   * The modulation field specifies the type of operation (analog or digital).
   * TV modulation information is contained in the table column ERPATA and coded
   * as 0=Analog; 1=Digital and 2=Post-transition.
   * <p>
   * Corrected in May 2013 "Broadcast Data Extract (AM-FM-TV) - Corrective Notes
   * to User Manual".
   */
  @Column(name = "erpata")
  private Integer erpata;
  /**
   * ERP Visual Average in Watts
   * <p>
   * Database range is 0 to 609,000.
   */
  @Column(name = "erpvav")
  private Double erpvav;
  /**
   * ERP Peak Visual Power at Tilt Angle in Watts
   * <p>
   * Documentation allows range of 0 to over 5,000,000. This field is not set in
   * the database (always zero).
   */
  @Column(name = "erpvta")
  private Double erpvta;
  /**
   * Limitation Identification code "LAAAA".
   *
   * @deprecated Not used in logical data model.
   */
  @Column(name = "limit_code")
  private String limitCode;
  /**
   * Refers to Off-set Precision. Valid Y, Space.
   */
  @Column(name = "off_prec")
  private Character offPrec;
  /**
   * Refers to TV Off-set Code. Space, +, -, Z.
   */
  @Column(name = "offset")
  private Character offset;
  //</editor-fold>

  public Facility() {
    this.facilityPK = new FacilityPK();
  }

  //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
  public FacilityPK getFacilityPK() {
    return facilityPK;
  }

  public void setFacilityPK(FacilityPK facilityPK) {
    this.facilityPK = facilityPK;
  }

  public FacilityType getFacilityType() {
    return facilityType;
  }

  public void setFacilityType(FacilityType facilityType) {
    this.facilityType = facilityType;
  }

  public int getChannel() {
    return channel;
  }

  public void setChannel(int channel) {
    this.channel = channel;
  }

  public Double getErpvpk() {
    return erpvpk;
  }

  public void setErpvpk(Double erpvpk) {
    this.erpvpk = erpvpk;
  }

  public Double getEhaat() {
    return ehaat;
  }

  public void setEhaat(Double ehaat) {
    this.ehaat = ehaat;
  }

  /**
   * Get the Latitude converted to decimal degrees.
   *
   * @return the Latitude
   */
  public Double getLatitude() {
//    return latitude;
//       * N.Latitude of the FEED SOURCE(ddmmss)
    Pattern p = Pattern.compile("(\\d\\d)(\\d\\d)(\\d\\d)");
    Matcher m = p.matcher(latitude);
    if (m.find()) {
      return DMStoDEC(Integer.valueOf(m.group(0)),
                      Integer.valueOf(m.group(1)),
                      Double.valueOf(m.group(2)),
                      "N");
    }
    return null;
  }

  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  /**
   * Get the Longitude converted to decimal degrees.
   *
   * @return the Latitude
   */
  public Double getLongitude() {
//       * W.Longitude of the FEED SOURCE(dddmmss)
    Pattern p = Pattern.compile("(\\d\\d\\d)(\\d\\d)(\\d\\d)");
    Matcher m = p.matcher(longitude);
    if (m.find()) {
      return DMStoDEC(Integer.valueOf(m.group(0)),
                      Integer.valueOf(m.group(1)),
                      Double.valueOf(m.group(2)),
                      "W");
    }
    return null;
  }

  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  public Integer getAllocZone() {
    return allocZone;
  }

  public void setAllocZone(Integer allocZone) {
    this.allocZone = allocZone;
  }

  public Character getAntMode() {
    return antMode;
  }

  public void setAntMode(Character antMode) {
    this.antMode = antMode;
  }

  public String getAutoProg() {
    return autoProg;
  }

  public void setAutoProg(String autoProg) {
    this.autoProg = autoProg;
  }

  public Character getBcMode() {
    return bcMode;
  }

  public void setBcMode(Character bcMode) {
    this.bcMode = bcMode;
  }

  public Double getBeamTilt() {
    return beamTilt;
  }

  public void setBeamTilt(Double beamTilt) {
    this.beamTilt = beamTilt;
  }

  public Double getBorder() {
    return border;
  }

  public void setBorder(Double border) {
    this.border = border;
  }

  public String getBrdrLat() {
    return brdrLat;
  }

  public void setBrdrLat(String brdrLat) {
    this.brdrLat = brdrLat;
  }

  public String getBrdrLong() {
    return brdrLong;
  }

  public void setBrdrLong(String brdrLong) {
    this.brdrLong = brdrLong;
  }

  public Double getCanLand() {
    return canLand;
  }

  public void setCanLand(Double canLand) {
    this.canLand = canLand;
  }

  public String getCertNumb() {
    return certNumb;
  }

  public void setCertNumb(String certNumb) {
    this.certNumb = certNumb;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  /**
   * The (enumerated) Canadian class code of this facility;
   * <p>
   * For Canadian Stations: [A, A1, B, C, C1, LP, VLP]
   * <p>
   * For Non-Canadian Stations: [A, B, B1, C, C1, C2, D]
   *
   * @return The (enumerated) Canadian class code of this facility;
   */
  public StationClassType getClazz() {
    return clazz != null ? StationClassType.valueOf(clazz) : null;
  }

  public void setClazz(String clazz) {
    this.clazz = clazz;
  }

  public Character getCloseCap() {
    return closeCap;
  }

  public void setCloseCap(Character closeCap) {
    this.closeCap = closeCap;
  }

  public Integer getDecNumber() {
    return decNumber;
  }

  public void setDecNumber(Integer decNumber) {
    this.decNumber = decNumber;
  }

  public Integer getDocFile() {
    return docFile;
  }

  public void setDocFile(Integer docFile) {
    this.docFile = docFile;
  }

  public Double getErpaav() {
    return erpaav;
  }

  public void setErpaav(Double erpaav) {
    this.erpaav = erpaav;
  }

  public Double getErpapk() {
    return erpapk;
  }

  public void setErpapk(Double erpapk) {
    this.erpapk = erpapk;
  }

  public Integer getErpata() {
    return erpata;
  }

  public void setErpata(Integer erpata) {
    this.erpata = erpata;
  }

  public Double getErphav() {
    return erphav;
  }

  public void setErphav(Double erphav) {
    this.erphav = erphav;
  }

  public Double getErphpk() {
    return erphpk;
  }

  public void setErphpk(Double erphpk) {
    this.erphpk = erphpk;
  }

  public Double getErpvav() {
    return erpvav;
  }

  public void setErpvav(Double erpvav) {
    this.erpvav = erpvav;
  }

  public Double getErpvta() {
    return erpvta;
  }

  public void setErpvta(Double erpvta) {
    this.erpvta = erpvta;
  }

  public Double getEuvalu() {
    return euvalu;
  }

  public void setEuvalu(Double euvalu) {
    this.euvalu = euvalu;
  }

  public Double getFreLand() {
    return freLand;
  }

  public void setFreLand(Double freLand) {
    this.freLand = freLand;
  }

  public Double getFrequency() {
    return frequency;
  }

  public void setFrequency(Double frequency) {
    this.frequency = frequency;
  }

  public Double getGroundLev() {
    return groundLev;
  }

  public void setGroundLev(Double groundLev) {
    this.groundLev = groundLev;
  }

  public Double getIfrbnD() {
    return ifrbnD;
  }

  public void setIfrbnD(Double ifrbnD) {
    this.ifrbnD = ifrbnD;
  }

  public Double getIfrbnN() {
    return ifrbnN;
  }

  public void setIfrbnN(Double ifrbnN) {
    this.ifrbnN = ifrbnN;
  }

  /**
   * Get the Latitude converted to decimal degrees.
   *
   * @return the Latitude
   */
  public Double getLatitude2() {
//    return latitude;
//       * N.Latitude of the FEED SOURCE(ddmmss)
    Pattern p = Pattern.compile("(\\d\\d)(\\d\\d)(\\d\\d)");
    Matcher m = p.matcher(latitude2);
    if (m.find()) {
      return DMStoDEC(Integer.valueOf(m.group(0)),
                      Integer.valueOf(m.group(1)),
                      Double.valueOf(m.group(2)),
                      "N");
    }
    return null;
  }

  public void setLatitude2(String latitude2) {
    this.latitude2 = latitude2;
  }

  public String getLimitCode() {
    return limitCode;
  }

  public void setLimitCode(String limitCode) {
    this.limitCode = limitCode;
  }

  /**
   * Get the Longitude converted to decimal degrees.
   *
   * @return the Latitude
   */
  public Double getLongitude2() {
//       * W.Longitude of the FEED SOURCE(dddmmss)
    Pattern p = Pattern.compile("(\\d\\d\\d)(\\d\\d)(\\d\\d)");
    Matcher m = p.matcher(longitude2);
    if (m.find()) {
      return DMStoDEC(Integer.valueOf(m.group(0)),
                      Integer.valueOf(m.group(1)),
                      Double.valueOf(m.group(2)),
                      "W");
    }
    return null;
  }

  public void setLongitude2(String longitude2) {
    this.longitude2 = longitude2;
  }

  public String getNetwork() {
    return network;
  }

  public void setNetwork(String network) {
    this.network = network;
  }

  public Character getOffPrec() {
    return offPrec;
  }

  public void setOffPrec(Character offPrec) {
    this.offPrec = offPrec;
  }

  public Character getOffset() {
    return offset;
  }

  public void setOffset(Character offset) {
    this.offset = offset;
  }

  public LocalDate getOkDump() {
    /**
     * Converts string encoded data information into a date instance encoding
     * strategy is: yyyyMMDD This method is called from the JPA
     * dynamically-generated SQL script to load the ca_station table.
     */

    return okDump != null ? LocalDate.of(Integer.parseInt(okDump.substring(0, 3)),
                                         Integer.parseInt(okDump.substring(4, 5)),
                                         Integer.parseInt(okDump.substring(5, 6)))
           : null;
  }

  public void setOkDump(String okDump) {
    this.okDump = okDump;
  }

  public Double getOverallH() {
    return overallH;
  }

  public void setOverallH(Double overallH) {
    this.overallH = overallH;
  }

  public Double getParRmsC() {
    return parRmsC;
  }

  public void setParRmsC(Double parRmsC) {
    this.parRmsC = parRmsC;
  }

  public Double getParRmsD() {
    return parRmsD;
  }

  public void setParRmsD(Double parRmsD) {
    this.parRmsD = parRmsD;
  }

  public Double getParRmsN() {
    return parRmsN;
  }

  public void setParRmsN(Double parRmsN) {
    this.parRmsN = parRmsN;
  }

  public Double getPowercrit() {
    return powercrit;
  }

  public void setPowercrit(Double powercrit) {
    this.powercrit = powercrit;
  }

  public Double getPowerday() {
    return powerday;
  }

  public void setPowerday(Double powerday) {
    this.powerday = powerday;
  }

  public Double getPowernight() {
    return powernight;
  }

  public void setPowernight(Double powernight) {
    this.powernight = powernight;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public Double getQCrit() {
    return qCrit;
  }

  public void setQCrit(Double qCrit) {
    this.qCrit = qCrit;
  }

  public Double getQDay() {
    return qDay;
  }

  public void setQDay(Double qDay) {
    this.qDay = qDay;
  }

  public Double getQNight() {
    return qNight;
  }

  public void setQNight(Double qNight) {
    this.qNight = qNight;
  }

  public Double getRadCenter() {
    return radCenter;
  }

  public void setRadCenter(Double radCenter) {
    this.radCenter = radCenter;
  }

  public Character getScmo() {
    return scmo;
  }

  public void setScmo(Character scmo) {
    this.scmo = scmo;
  }

  public String getSsCode() {
    return ssCode;
  }

  public void setSsCode(String ssCode) {
    this.ssCode = ssCode;
  }

  public LocalDate getStCreat() {
    /**
     * Converts string encoded data information into a date instance encoding
     * strategy is: yyyyMMDD This method is called from the JPA
     * dynamically-generated SQL script to load the ca_station table.
     */
    return stCreat != null ? LocalDate.of(Integer.parseInt(stCreat.substring(0, 3)),
                                          Integer.parseInt(stCreat.substring(4, 5)),
                                          Integer.parseInt(stCreat.substring(5, 6)))
           : null;
  }

  public void setStCreat(String stCreat) {
    this.stCreat = stCreat;
  }

  public LocalDate getStMod() {
    /**
     * Converts string encoded data information into a date instance encoding
     * strategy is: yyyyMMDD This method is called from the JPA
     * dynamically-generated SQL script to load the ca_station table.
     */
    return stMod != null ? LocalDate.of(Integer.parseInt(stMod.substring(0, 3)),
                                        Integer.parseInt(stMod.substring(4, 5)),
                                        Integer.parseInt(stMod.substring(5, 6)))
           : null;
  }

  public void setStMod(String stMod) {
    this.stMod = stMod;
  }

  public String getStatus1() {
    return status1;
  }

  public void setStatus1(String status1) {
    this.status1 = status1;
  }

  public String getStatus2() {
    return status2;
  }

  public void setStatus2(String status2) {
    this.status2 = status2;
  }

  public Character getUnattended() {
    return unattended;
  }

  public void setUnattended(Character unattended) {
    this.unattended = unattended;
  }

  public Double getUsaLand() {
    return usaLand;
  }

  public void setUsaLand(Double usaLand) {
    this.usaLand = usaLand;
  }

  @XmlTransient
  public Collection<Augment> getAugmentCollection() {
    return augmentCollection;
  }

  public void setAugmentCollection(Collection<Augment> augmentCollection) {
    this.augmentCollection = augmentCollection;
  }

  @XmlTransient
  public Collection<Extend> getExtendCollection() {
    return extendCollection;
  }

  public void setExtendCollection(Collection<Extend> extendCollection) {
    this.extendCollection = extendCollection;
  }

  @XmlTransient
  public Collection<Comments> getComments() {
    if (comments == null) {
      comments = new ArrayList<>();
    }
    return comments;
  }

  public void setComments(Collection<Comments> comments) {
    this.comments = comments;
  }

  @XmlTransient
  public Collection<Feeds> getFeeds() {
    if (feeds == null) {
      feeds = new ArrayList<>();
    }
    return feeds;
  }

  public void setFeeds(Collection<Feeds> feeds) {
    this.feeds = feeds;
  }

  @XmlTransient
  public Collection<Apatstat> getAntennaPatterns() {
    if (antennaPatterns == null) {
      antennaPatterns = new ArrayList<>();
    }
    return antennaPatterns;
  }

  public void setAntennaPatterns(Collection<Apatstat> antennaPatterns) {
    this.antennaPatterns = antennaPatterns;
  }

  @XmlTransient
  public Collection<Params> getParamsCollection() {
    if (paramsCollection == null) {
      paramsCollection = new ArrayList<>();
    }
    return paramsCollection;
  }

  public void setParamsCollection(Collection<Params> paramsCollection) {
    this.paramsCollection = paramsCollection;
  }

  @XmlTransient
  public Collection<Region> getRegions() {
    if (regions == null) {
      regions = new ArrayList<>();
    }
    return regions;
  }

  public void setRegions(Collection<Region> regions) {
    this.regions = regions;
  }

  public Tsid getTsid() {
    return tsid;
  }

  public void setTsid(Tsid tsid) {
    this.tsid = tsid;
  }

  @XmlTransient
  public Collection<Contours> getContours() {
    if (contours == null) {
      contours = new ArrayList<>();
    }
    return contours;
  }

  public void setContours(Collection<Contours> contours) {
    this.contours = contours;
  }//</editor-fold>

  /**
   * Convert DMS to decimal
   *
   * @param deg       degrees
   * @param min       minutes
   * @param sec       seconds
   * @param direction direction [N, S, E, W]
   * @return values converted to degrees.
   */
  private double DMStoDEC(int deg, int min, double sec, String direction) {
    double decimalDegree = deg + ((double) min + (sec / 60)) / 60;
    double directionMultiplier = 1;
    if ("S".equalsIgnoreCase(direction) || "W".equalsIgnoreCase(direction)) {
      directionMultiplier = -1;
    }
    return directionMultiplier * decimalDegree;
  }

  /**
   * Test this Entity record to determine if it represents a valid transmitter
   * configuration.
   *
   * @return TRUE if the Provinces are in Canada and the banner code indicates
   *         the record is current and transmitting.
   * @throws Exception If the station is not transmitting.
   */
  public boolean isValid() throws Exception {
    if (!Arrays.asList(new String[]{"AB", "BC", "MB", "NB", "NF", "NS", "NT", "ON", "PE", "QC", "SK", "YT"}).contains(province)) {
      throw new Exception(toString() + " province [" + province + "] is not a recognized Canadian province.");
    }
    if (facilityPK == null) {
      throw new Exception(toString() + " has a null or empty Primary Key.");
    }
    if (!facilityPK.getBanner().isTransmitting()) {
      throw new Exception(toString() + " (" + facilityPK.getBanner().getDescription() + ") is a non-transmitting configuration.");
    }
    return true;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 23 * hash + Objects.hashCode(this.facilityPK);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Facility other = (Facility) obj;
    return Objects.equals(this.facilityPK, other.facilityPK);
  }

  @Override
  public String toString() {
    return "Facility  " + facilityPK;
  }

}
