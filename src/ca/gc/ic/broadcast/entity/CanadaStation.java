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

import ca.gc.ic.broadcast.entity.enumerated.Enum_Banner;
import ca.gc.ic.broadcast.entity.enumerated.Enum_StationClass;
import ca.gc.ic.broadcast.entity.enumerated.Enum_StationType;
import java.io.Serializable;
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
  @NamedQuery(name = "CanadaStation.countByStationType", query = "SELECT COUNT(c) FROM CanadaStation c WHERE c.stationType = :stationType"),
  @NamedQuery(name = "CanadaStation.findByBanner", query = "SELECT c FROM CanadaStation c WHERE c.canadaStationPK.banner = :banner"),
  @NamedQuery(name = "CanadaStation.findByCallSign", query = "SELECT c FROM CanadaStation c WHERE c.canadaStationPK.callSign = :callSign"),
  @NamedQuery(name = "CanadaStation.findByChannel", query = "SELECT c FROM CanadaStation c WHERE c.channel = :channel")})
public abstract class CanadaStation implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected CanadaStationPK canadaStationPK;
  /**
   * Enumerated Discriminator Column used to identify the type of station this
   * record represents.
   * <p/>
   * Supported valued are: am_station, fm_station, sdar_station and tv_station.
   */
  @Basic(optional = false)
  @Column(name = "station_type", nullable = false, length = 4)
  @XmlAttribute(required = true)
  private String stationType;
  @Basic(optional = false)
  @Column(name = "channel", nullable = false)
  @XmlAttribute
  private int channel;
  @Basic(optional = false)
  @Column(name = "latitude", nullable = false)
  @XmlAttribute
  private float latitude;
  @Basic(optional = false)
  @Column(name = "longitude", nullable = false)
  @XmlAttribute
  private float longitude;
  @Column(name = "bc_mode")
  @XmlAttribute
  private Character bcMode;
  /**
   * Closest distance to Canada US Border(km)
   */
  @Column(name = "border", precision = 12)
  @XmlAttribute
  private float border;
  @Column(name = "brdr_lat", length = 6)
  @XmlAttribute
  private String brdrLat;
  @Column(name = "brdr_long", length = 7)
  @XmlAttribute
  private String brdrLong;
  @Column(name = "cert_numb", length = 6)
  @XmlAttribute
  private String certNumb;
  @Column(name = "city", length = 25)
  @XmlAttribute
  private String city;
  @Column(name = "clazz", length = 2)
  @XmlAttribute
  @Enumerated(EnumType.STRING)
  private Enum_StationClass stationClass;
  @Column(name = "dec_number")
  @XmlAttribute
  private int decNumber;
  @Column(name = "doc_file")
  @XmlAttribute
  private int docFile;
  /**
   * Broadcast frequency in MHz.
   */
  @Column(name = "frequency", precision = 12)
  @XmlAttribute
  private float frequency;
  @Column(name = "network", length = 4)
  @XmlAttribute
  private String network;
  @Column(name = "ok_dump", length = 8)
  @Temporal(javax.persistence.TemporalType.DATE)
  @XmlAttribute
  private Date okDump;
  @Column(name = "province", length = 2)
  @XmlAttribute
  private String province;
  @Column(name = "ss_code", length = 5)
  @XmlAttribute
  private String ssCode;
  @Column(name = "st_creat", length = 8)
  @Temporal(javax.persistence.TemporalType.DATE)
  @XmlAttribute
  private Date stCreat;
  @Column(name = "st_mod", length = 8)
  @Temporal(javax.persistence.TemporalType.DATE)
  @XmlAttribute
  private Date stMod;
  @Column(name = "unattended")
  @XmlAttribute
  private Character unattended;
  /**
   * Closest distance to Canada Land Edge
   */
  @Column(name = "can_land", precision = 12)
  @XmlAttribute
  private float landDistanceCanada;
  /**
   * Closest distance to French Land Edge near Newfoundland
   */
  @Column(name = "fre_land", precision = 12)
  @XmlAttribute
  private float landDistanceFrenchNewfoundland;
  /**
   * Closest distance to USA Land Edge
   */
  @Column(name = "usa_land", precision = 12)
  @XmlAttribute
  private float landDistanceUSA;
  /**
   * List of Antenna objects. In the Canada database each antenna record
   * describes a different polarization for the same physical antenna.
   */
  @ManyToMany(mappedBy = "canadaStationList")
  private List<Antenna> antennaList;
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "canadaStation")
  private RegionalFiling regionalFiling;
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "canadaStation")
  private FeedSignal feedSignal;
  @OneToMany(mappedBy = "canadaStation")
  private List<Contour> contourList;
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "canadaStation")
  private Tsid tsid;
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "canadaStation")
  private Comment comment;

  public CanadaStation() {
  }

  public CanadaStation(CanadaStationPK canadaStationPK) {
    this.canadaStationPK = canadaStationPK;
  }

  public CanadaStation(Enum_Banner banner, String callSign) {
    this.canadaStationPK = new CanadaStationPK(banner, callSign);
  }

  //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
  public CanadaStationPK getCanadaStationPK() {
    if (canadaStationPK == null) {
      canadaStationPK = new CanadaStationPK();
    }
    return canadaStationPK;
  }

  public void setCanadaStationPK(CanadaStationPK canadaStationPK) {
    this.canadaStationPK = canadaStationPK;
  }

  public Enum_StationType getStationType() {
    return Enum_StationType.findByStationType(stationType);
  }

  public void setStationType(String stationType) {
    this.stationType = stationType;
  }

  public int getChannel() {
    return channel;
  }

  public void setChannel(int channel) {
    this.channel = channel;
  }

  public float getLatitude() {
    return latitude;
  }

  public void setLatitude(float latitude) {
    this.latitude = latitude;
  }

  public float getLongitude() {
    return longitude;
  }

  public void setLongitude(float longitude) {
    this.longitude = longitude;
  }

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
  public float getBorder() {
    return border;
  }

  public void setBorder(float border) {
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

  public Enum_StationClass getStationClass() {
    return stationClass;
  }

  public void setStationClass(Enum_StationClass stationClass) {
    this.stationClass = stationClass;
  }

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
   * Broadcast frequency in MHz.
   * <p/>
   * @return
   */
  public float getFrequency() {
    /**
     * Apply multiplier depending upon station_type to normalize units to MHz.
     * <p/>
     * AM: database Frequency in kHz. Valid 530 to 1700.
     * <p/>
     * FM: Frequency in MHz 88.1 to 107.9.
     * <p/>
     * TV: Frequency in MHz.
     */
    if (Enum_StationType.AM.equals(Enum_StationType.findByDbCode(stationType))) {
      return frequency * 1000;
    }
    return frequency;
  }

  public void setFrequency(float frequency) {
    this.frequency = frequency;
  }

  public float getLandDistanceCanada() {
    return landDistanceCanada;
  }

  public void setLandDistanceCanada(float landDistanceCanada) {
    this.landDistanceCanada = landDistanceCanada;
  }

  public float getLandDistanceFrenchNewfoundland() {
    return landDistanceFrenchNewfoundland;
  }

  public void setLandDistanceFrenchNewfoundland(float landDistanceFrenchNewfoundland) {
    this.landDistanceFrenchNewfoundland = landDistanceFrenchNewfoundland;
  }

  public float getLandDistanceUSA() {
    return landDistanceUSA;
  }

  public void setLandDistanceUSA(float landDistanceUSA) {
    this.landDistanceUSA = landDistanceUSA;
  }

  public String getNetwork() {
    return network;
  }

  public void setNetwork(String network) {
    this.network = network;
  }

  public Date getOkDump() {
    return okDump;
  }

  public void setOkDump(Date okDump) {
    this.okDump = okDump;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getSsCode() {
    return ssCode;
  }

  public void setSsCode(String ssCode) {
    this.ssCode = ssCode;
  }

  public Date getStCreat() {
    return stCreat;
  }

  public void setStCreat(Date stCreat) {
    this.stCreat = stCreat;
  }

  public Date getStMod() {
    return stMod;
  }

  public void setStMod(Date stMod) {
    this.stMod = stMod;
  }

  public Character getUnattended() {
    return unattended;
  }

  public void setUnattended(Character unattended) {
    this.unattended = unattended;
  }

  public List<Antenna> getAntennaList() {
    if (antennaList == null) {
      antennaList = new ArrayList<Antenna>();
    }
    return antennaList;
  }

  public void setAntennaList(List<Antenna> antennaList) {
    this.antennaList = antennaList;
  }

  public RegionalFiling getRegionalFiling() {
    if (regionalFiling == null) {
      regionalFiling = new RegionalFiling();
    }
    return regionalFiling;
  }

  public void setRegionalFiling(RegionalFiling regionalFiling) {
    this.regionalFiling = regionalFiling;
  }

  public FeedSignal getFeedSignal() {
    if (feedSignal == null) {
      feedSignal = new FeedSignal();
    }
    return feedSignal;
  }

  public void setFeedSignal(FeedSignal feedSignal) {
    this.feedSignal = feedSignal;
  }

  public List<Contour> getContourList() {
    if (contourList == null) {
      contourList = new ArrayList<Contour>();
    }
    return contourList;
  }

  public void setContourList(List<Contour> contourList) {
    this.contourList = contourList;
  }

  public Tsid getTsid() {
    if (tsid == null) {
      tsid = new Tsid();
    }
    return tsid;
  }

  public void setTsid(Tsid tsid) {
    this.tsid = tsid;
  }

  public Comment getComment() {
    if (comment == null) {
      comment = new Comment();
    }
    return comment;
  }

  public void setComment(Comment comment) {
    this.comment = comment;
  }//</editor-fold>

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
