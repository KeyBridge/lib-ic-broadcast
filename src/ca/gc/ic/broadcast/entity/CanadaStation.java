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

import ca.gc.ic.broadcast.entity.enumerated.Enum_CanadaBanner;
import ca.gc.ic.broadcast.entity.enumerated.Enum_CanadaStationClass;
import ca.gc.ic.broadcast.entity.enumerated.Enum_CanadaStationType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 * Logical data model container for the CANADA CanadaStation (ca_station) table.
 * <p/>
 * This abstract object is extended by the AM, FM, TV and SDAR station subtypes.
 * <p/>
 * @author jesse
 */
@Entity
@Inheritance
@DiscriminatorColumn(name = "station_type")
@Table(name = "ca_station", uniqueConstraints = {
  @UniqueConstraint(columnNames = {"call_sign", "banner"})
})
@XmlRootElement
@XmlSeeAlso({CanadaStationAm.class, CanadaStationFm.class, CanadaStationSdar.class, CanadaStationTv.class})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ca.gc.ic/broadcast/entity")
@NamedQueries({
  @NamedQuery(name = "CanadaStation.findAll", query = "SELECT c FROM CanadaStation c"),
  @NamedQuery(name = "CanadaStation.findByStationType", query = "SELECT c FROM CanadaStation c WHERE c.stationType = :stationType"),
  /**
   * SQL Query to identify valid stations by type. E.G. stationType = 'TV' and
   * banner in 'AP, AU, OP'.
   */
  @NamedQuery(name = "CanadaStation.findByStationTypeAndBanner", query = "SELECT c FROM CanadaStation c WHERE c.stationType = :stationType AND c.canadaStationPK.banner = :banner"),
  @NamedQuery(name = "CanadaStation.countByStationType", query = "SELECT COUNT(c) FROM CanadaStation c WHERE c.stationType = :stationType"),
  @NamedQuery(name = "CanadaStation.findByBanner", query = "SELECT c FROM CanadaStation c WHERE c.canadaStationPK.banner = :banner"),
  @NamedQuery(name = "CanadaStation.findByCallSign", query = "SELECT c FROM CanadaStation c WHERE c.canadaStationPK.callSign = :callSign"),
  @NamedQuery(name = "CanadaStation.findByChannel", query = "SELECT c FROM CanadaStation c WHERE c.channel = :channel")})
public abstract class CanadaStation implements Serializable {

  private static final long serialVersionUID = 1L;
  /**
   * The CanadaStation table compound primary key object.
   */
  @EmbeddedId
  protected CanadaStationPK canadaStationPK;
  /**
   * Enumerated Discriminator Column used to identify the type of station this
   * record represents.
   * <p/>
   * Supported valued are: AM, FM, SDAR, TV.
   */
  @Enumerated(EnumType.STRING)
  @Basic(optional = false)
  @Column(name = "station_type", nullable = false, length = 4)
  @XmlAttribute(required = true)
  private Enum_CanadaStationType stationType;
  /**
   * The CHANNEL; The channel value varies by Station Type and is context
   * dependent.
   */
  @Basic(optional = false)
  @Column(name = "channel", nullable = false)
  @XmlAttribute
  private int channel;
  /**
   * Latitude coordinate in degrees of the Station Transmitter
   */
  @Basic(optional = false)
  @Column(name = "latitude", nullable = false)
  @XmlAttribute
  private double latitude;
  /**
   * Longitude coordinate in degrees of the Station Transmitter
   */
  @Basic(optional = false)
  @Column(name = "longitude", nullable = false)
  @XmlAttribute
  private double longitude;
  /**
   * Broadcasting Mode; S: Stereo, M: Mono, P: Second Audio Channels or B: Both
   */
  @Column(name = "bc_mode")
  @XmlAttribute
  private Character bcMode;
  /**
   * Closest distance to Canada US Border (km)
   */
  @Column(name = "border", precision = 12)
  @XmlAttribute
  private double border;
  /**
   * N.Latitude used when BORDER last calculated
   */
  @Column(name = "brdr_lat", length = 6)
  @XmlAttribute
  private String brdrLat;
  /**
   * W.Longitude used when BORDER last calculated
   */
  @Column(name = "brdr_long", length = 7)
  @XmlAttribute
  private String brdrLong;
  /**
   * Broadcasting Certificate Number "FANNNN"
   */
  @Column(name = "cert_numb", length = 6)
  @XmlAttribute
  private String certNumb;
  /**
   * City name.
   */
  @Column(name = "city", length = 25)
  @XmlAttribute
  private String city;
  /**
   * The Canadian class of this Station;
   * <p/>
   * For Canadian Stations, A, A1, B, C, C1, LP, VLP;
   * <p/>
   * For Non-Canadian Stations, A, B, B1, C, C1, C2, D.
   */
  @Column(name = "clazz", length = 2)
  @XmlAttribute
  @Enumerated(EnumType.STRING)
  private Enum_CanadaStationClass stationClass;
  /**
   * CRTC Decision Number "YYNNNN"
   */
  @Column(name = "dec_number")
  @XmlAttribute
  private int decNumber;
  /**
   * I.C. file number
   */
  @Column(name = "doc_file")
  @XmlAttribute
  private int docFile;
  /**
   * Broadcast frequency in MHz.
   * <p/>
   * AM Station frequencies are originally recorded in kHz but are automatically
   * converted to MHz upon import into the ca_station table.
   */
  @Column(name = "frequency", precision = 12)
  @XmlAttribute
  private double frequency;
  /**
   * The broadcast Network (CBCE, CBCF, IND, INDE, INDF, BCMH, or none)
   */
  @Column(name = "network", length = 4)
  @XmlAttribute
  private String network;
  /**
   * Last date of record update for the Consultants dump
   */
  @Column(name = "ok_dump", length = 8)
  @Temporal(javax.persistence.TemporalType.DATE)
  @XmlAttribute
  private Date okDump;
  /**
   * Province (Canada) / State (US)
   */
  @Column(name = "province", length = 2)
  @XmlAttribute
  private String province;
  /**
   * Short Spacing Code; "*O#aa"
   */
  @Column(name = "ss_code", length = 5)
  @XmlAttribute
  private String ssCode;
  /**
   * Date station entered in database
   */
  @Column(name = "st_creat", length = 8)
  @Temporal(javax.persistence.TemporalType.DATE)
  @XmlAttribute
  private Date stCreat;
  /**
   * Date station last modified
   */
  @Column(name = "st_mod", length = 8)
  @Temporal(javax.persistence.TemporalType.DATE)
  @XmlAttribute
  private Date stMod;
  /**
   * Unattended Operation Code (Y, N)
   */
  @Column(name = "unattended")
  @XmlAttribute
  private Character unattended;
  /**
   * Closest distance to Canada Land Edge
   */
  @Column(name = "can_land", precision = 12)
  @XmlAttribute
  private double landDistanceCanada;
  /**
   * Closest distance to French Land Edge near Newfoundland
   */
  @Column(name = "fre_land", precision = 12)
  @XmlAttribute
  private double landDistanceFrenchNewfoundland;
  /**
   * Closest distance to USA Land Edge
   */
  @Column(name = "usa_land", precision = 12)
  @XmlAttribute
  private double landDistanceUSA;
  /**
   * List of Antenna objects. In the Canada database each antenna record
   * describes a different polarization for the same physical antenna.
   */
  @ManyToMany(mappedBy = "canadaStationList")
  private List<Antenna> antennaList;
  /**
   * RegionalFiling table reference.
   */
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "canadaStation")
  private RegionalFiling regionalFiling;
  /**
   * FeedSignal table reference.
   * <p/>
   * Source of feed signals for TV services.
   */
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "canadaStation")
  private FeedSignal feedSignal;
  /**
   * Contour table reference.
   */
  @OneToMany(mappedBy = "canadaStation")
  private List<Contour> contourList;
  /**
   * Transmission Signal Identifier (TSID) is a 16-bit packet contained within
   * the Extended Data Services (XDS) of EIA-608B.
   */
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "canadaStation")
  private Tsid tsid;
  /**
   * Comment table reference. (This table contains user information)
   */
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "canadaStation")
  private Comment comment;

  public CanadaStation() {
  }

  public CanadaStation(CanadaStationPK canadaStationPK) {
    this.canadaStationPK = canadaStationPK;
  }

  public CanadaStation(Enum_CanadaBanner banner, String callSign) {
    this.canadaStationPK = new CanadaStationPK(banner, callSign);
  }

  //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
  /**
   * @return The CanadaStation table compound primary key object.
   */
  public CanadaStationPK getCanadaStationPK() {
    if (canadaStationPK == null) {
      canadaStationPK = new CanadaStationPK();
    }
    return canadaStationPK;
  }

  public void setCanadaStationPK(CanadaStationPK canadaStationPK) {
    this.canadaStationPK = canadaStationPK;
  }

  /**
   * @return The type of station.
   */
  public Enum_CanadaStationType getStationType() {
    return stationType;
  }

  public void setStationType(Enum_CanadaStationType stationType) {
    this.stationType = stationType;
  }

  /**
   * @return The CHANNEL; The channel value varies by Station Type and is
   *         context dependent.
   */
  public int getChannel() {
    return channel;
  }

  public void setChannel(int channel) {
    this.channel = channel;
  }

  /**
   * @return Latitude coordinate in degrees of the Station Transmitter
   */
  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  /**
   * @return Longitude coordinate in degrees of the Station Transmitter
   */
  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  /**
   * @return Broadcasting Mode; S: Stereo, M: Mono, P: Second Audio Channels or
   *         B: Both
   */
  public Character getBcMode() {
    return bcMode;
  }

  public void setBcMode(Character bcMode) {
    this.bcMode = bcMode;
  }

  /**
   * Closest distance to Canada US Border(km)
   * <p/>
   * @return
   */
  public double getBorder() {
    return border;
  }

  public void setBorder(double border) {
    this.border = border;
  }

  /**
   * @return N.Latitude used when BORDER last calculated
   */
  public String getBrdrLat() {
    return brdrLat;
  }

  public void setBrdrLat(String brdrLat) {
    this.brdrLat = brdrLat;
  }

  /**
   * @return W.Longitude used when BORDER last calculated
   */
  public String getBrdrLong() {
    return brdrLong;
  }

  public void setBrdrLong(String brdrLong) {
    this.brdrLong = brdrLong;
  }

  /**
   * @return Certificate Number "FANNNN"
   */
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
   * @return The Canadian class of this Station;
   */
  public Enum_CanadaStationClass getStationClass() {
    return stationClass;
  }

  public void setStationClass(Enum_CanadaStationClass stationClass) {
    this.stationClass = stationClass;
  }

  /**
   * @return CRTC Decision Number "YYNNNN"
   */
  public int getDecNumber() {
    return decNumber;
  }

  public void setDecNumber(int decNumber) {
    this.decNumber = decNumber;
  }

  public int getDocFile() {
    return docFile;
  }

  public void setDocFile(int docFile) {
    this.docFile = docFile;
  }

  /**
   * @return Broadcast frequency in MHz.
   */
  public double getFrequency() {
    return frequency;
  }

  public void setFrequency(double frequency) {
    this.frequency = frequency;
  }

  /**
   * @return Closest distance to Canada Land Edge
   */
  public double getLandDistanceCanada() {
    return landDistanceCanada;
  }

  public void setLandDistanceCanada(double landDistanceCanada) {
    this.landDistanceCanada = landDistanceCanada;
  }

  /**
   * @return Closest distance to French Land Edge near Newfoundland
   */
  public double getLandDistanceFrenchNewfoundland() {
    return landDistanceFrenchNewfoundland;
  }

  public void setLandDistanceFrenchNewfoundland(double landDistanceFrenchNewfoundland) {
    this.landDistanceFrenchNewfoundland = landDistanceFrenchNewfoundland;
  }

  /**
   * @return Closest distance to USA Land Edge
   */
  public double getLandDistanceUSA() {
    return landDistanceUSA;
  }

  public void setLandDistanceUSA(double landDistanceUSA) {
    this.landDistanceUSA = landDistanceUSA;
  }

  /**
   * @return The broadcast Network (CBCE, CBCF, IND, INDE, INDF, BCMH, or none)
   */
  public String getNetwork() {
    return network;
  }

  public void setNetwork(String network) {
    this.network = network;
  }

  /**
   * @return Last date of record update for the Consultants dump
   */
  public Date getOkDump() {
    return okDump;
  }

  public void setOkDump(Date okDump) {
    this.okDump = okDump;
  }

  /**
   * @return 2-character Province (Canada) / State (US)
   */
  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  /**
   * @return Short Spacing Code; "*O#aa"
   */
  public String getSsCode() {
    return ssCode;
  }

  public void setSsCode(String ssCode) {
    this.ssCode = ssCode;
  }

  /**
   * @return Date station entered in database
   */
  public Date getStCreat() {
    return stCreat;
  }

  public void setStCreat(Date stCreat) {
    this.stCreat = stCreat;
  }

  /**
   * @return Date station last modified
   */
  public Date getStMod() {
    return stMod;
  }

  public void setStMod(Date stMod) {
    this.stMod = stMod;
  }

  /**
   * @return Unattended Operation Code (Y, N)
   */
  public boolean getUnattended() {
    return unattended != null ? unattended.equals('Y') : false;
  }

  public void setUnattended(boolean unattended) {
    this.unattended = unattended ? 'Y' : 'N';
  }

  /**
   * In the Canada database each antenna record describes a different
   * polarization for the same physical antenna. A list of antenna objects is
   * therefore required.
   * <p/>
   * @return List of Antenna objects for this station.
   */
  public List<Antenna> getAntennaList() {
    if (antennaList == null) {
      antennaList = new ArrayList<Antenna>();
    }
    return antennaList;
  }

  public void setAntennaList(List<Antenna> antennaList) {
    this.antennaList = antennaList;
  }

  /**
   * @return RegionalFiling information.
   */
  public RegionalFiling getRegionalFiling() {
    return regionalFiling;
  }

  public void setRegionalFiling(RegionalFiling regionalFiling) {
    this.regionalFiling = regionalFiling;
  }

  /**
   * @return FeedSignal information
   */
  public FeedSignal getFeedSignal() {
    return feedSignal;
  }

  public void setFeedSignal(FeedSignal feedSignal) {
    this.feedSignal = feedSignal;
  }

  /**
   *
   * @return List of Contour records.
   */
  public List<Contour> getContourList() {
    if (contourList == null) {
      contourList = new ArrayList<Contour>();
    }
    return contourList;
  }

  public void setContourList(List<Contour> contourList) {
    this.contourList = contourList;
  }

  /**
   * @return Transmission Signal Identifier record.
   */
  public Tsid getTsid() {
    return tsid;
  }

  public void setTsid(Tsid tsid) {
    this.tsid = tsid;
  }

  /**
   * @return Comment information. (This table contains user information)
   */
  public Comment getComment() {
    return comment;
  }

  public void setComment(Comment comment) {
    this.comment = comment;
  }

  /**
   * @return WGS_84
   */
  public String getDatum() {
    return "WGS_84";
  }
  //</editor-fold>

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (canadaStationPK != null ? canadaStationPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {

    if (!(object instanceof CanadaStation)) {
      return false;
    }
    CanadaStation other = (CanadaStation) object;
    if ((this.canadaStationPK == null && other.canadaStationPK != null) || (this.canadaStationPK != null && !this.canadaStationPK.equals(other.canadaStationPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "CanadaStation"
      + " canadaStationPK [" + canadaStationPK
      + "]\n stationType [" + stationType
      + "] channel [" + channel
      + "] latitude [" + latitude
      + "] longitude [" + longitude
      + "] bcMode [" + bcMode
      + "] border [" + border
      + "] brdrLat [" + brdrLat
      + "] brdrLong [" + brdrLong
      + "] certNumb [" + certNumb
      + "] city [" + city
      + "] stationClass [" + stationClass
      + "] decNumber [" + decNumber
      + "] docFile [" + docFile
      + "] frequency [" + frequency
      + "] network [" + network
      + "] okDump [" + okDump
      + "] province [" + province
      + "] ssCode [" + ssCode
      + "] stCreat [" + stCreat
      + "] stMod [" + stMod
      + "] unattended [" + unattended
      + "] landDistanceCanada [" + landDistanceCanada
      + "] landDistanceFrenchNewfoundland [" + landDistanceFrenchNewfoundland
      + "] landDistanceUSA [" + landDistanceUSA
      + "]\n comment [" + comment
      + "]\n regionalFiling [" + regionalFiling
      + "]\n feedSignal [" + feedSignal
      + "]\n tsid [" + tsid
      + "]\n comment [" + comment
      + "]\n antennaList [" + antennaList
      + ']';
  }
}
