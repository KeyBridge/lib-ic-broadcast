/*
 * Copyright (C) 2014 Key Bridge Global LLC
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ca.gc.ic.lib.bdbs.entity;

import ca.gc.ic.lib.bdbs.entity.enumerated.ECanadaBanner;
import ca.gc.ic.lib.bdbs.entity.enumerated.ECanadaStationClass;
import ca.gc.ic.lib.bdbs.entity.enumerated.ECanadaStationType;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 * Logical data model container for the CANADA CanadaStation (ca_station) table.
 * <p>
 * The CanadaStation is a consolidated / hybrid record that incorporates fields
 * from the AM, FM, TV and SDAR station descriptions. This abstract object is
 * not used directly, but instead is extended by the AM, FM, TV and SDAR station
 * subtype implementations.
 * <p>
 * Station implementations are differentiated in the database by the stationType
 * ("station_type") field.
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
   * Find stations of the indicated station type with a Banner code that
   * indicates the station is transmitting.
   */
  @NamedQuery(name = "CanadaStation.findCallSignByStationTypeAndBanner", query = "SELECT c.canadaStationPK.callSign FROM CanadaStation c WHERE c.stationType = :stationType AND c.canadaStationPK.banner = :banner"),
//  @NamedQuery(name = "CanadaStation.countTransmitting", query = "SELECT COUNT(c) FROM CanadaStation c WHERE c.stationType = :stationType AND c.canadaStationPK.banner IN ('AP', 'AU', 'O', 'OP', 'TO')"),
  /**
   * SQL Query to identify valid stations by type. E.G. stationType = 'TV' and
   * banner in 'AP, AU, OP'.
   */
  @NamedQuery(name = "CanadaStation.findByStationTypeAndBanner", query = "SELECT c FROM CanadaStation c WHERE c.stationType = :stationType AND c.canadaStationPK.banner = :banner"),
  @NamedQuery(name = "CanadaStation.countByStationType", query = "SELECT COUNT(c) FROM CanadaStation c WHERE c.stationType = :stationType"),
  @NamedQuery(name = "CanadaStation.findByBanner", query = "SELECT c FROM CanadaStation c WHERE c.canadaStationPK.banner = :banner"),
  @NamedQuery(name = "CanadaStation.findByCallSign", query = "SELECT c FROM CanadaStation c WHERE c.canadaStationPK.callSign LIKE :callSign"),
  @NamedQuery(name = "CanadaStation.findByCallSignAndBanner", query = "SELECT c FROM CanadaStation c WHERE c.canadaStationPK.callSign LIKE :callSign AND c.canadaStationPK.banner = :banner"),
  @NamedQuery(name = "CanadaStation.findByChannel", query = "SELECT c FROM CanadaStation c WHERE c.channel = :channel")})
public abstract class CanadaStation implements Serializable {

  private static final long serialVersionUID = 1L;
  /**
   * The CanadaStation table compound primary key object. Contains the call sign
   * and status banner.
   */
  @EmbeddedId
  @XmlElement(required = true)
  protected CanadaStationPK canadaStationPK;
  /**
   * The (Enumerated) station type discriminator. This column is used to
   * identify the type of station in the database that this record represents.
   * <p/>
   * Supported valued are: [AM, FM, SDAR, TV].
   */
  @Enumerated(EnumType.STRING)
  @Basic(optional = false)
  @Column(name = "station_type", nullable = false, length = 4)
  @XmlElement(required = true)
  private ECanadaStationType stationType;
  /**
   * The transmitting CHANNEL; The channel value varies by Station Type and is
   * context dependent.
   */
  @Basic(optional = false)
  @Column(name = "channel", nullable = false)
  @XmlElement(required = true)
  private int channel;
  /**
   * Latitude coordinate in decimal degrees of the Station Transmitter
   */
  @Basic(optional = false)
  @Column(name = "latitude", nullable = false)
  @XmlElement(required = true)
  private Double latitude;
  /**
   * Longitude coordinate in decimal degrees of the Station Transmitter
   */
  @Basic(optional = false)
  @Column(name = "longitude", nullable = false)
  @XmlElement(required = true)
  private Double longitude;
  /**
   * Broadcasting Mode; [S: Stereo, M: Mono, P: Second Audio Channels or B:
   * Both]
   */
  @Column(name = "bc_mode")
  @XmlElement(required = true)
  private Character bcMode;
  /**
   * Closest distance to Canada / U.S. Border (km)
   */
  @Column(name = "border", precision = 12)
  @XmlElement
  private double border;
  /**
   * N.Latitude used when BORDER last calculated
   */
  @Column(name = "brdr_lat", length = 6)
  @XmlElement
  private String brdrLat;
  /**
   * W.Longitude used when BORDER last calculated
   */
  @Column(name = "brdr_long", length = 7)
  @XmlElement
  private String brdrLong;
  /**
   * Broadcasting Certificate Number. Format is "FANNNN"
   */
  @Column(name = "cert_numb", length = 6)
  @XmlElement
  private String certNumb;
  /**
   * The station City name.
   */
  @Column(name = "city", length = 25)
  @XmlElement
  private String city;
  /**
   * The (enumerated) Canadian class code of this Station;
   * <p/>
   * For Canadian Stations: [A, A1, B, C, C1, LP, VLP]
   * <p/>
   * For Non-Canadian Stations: [A, B, B1, C, C1, C2, D]
   */
  @Column(name = "clazz", length = 2)
  @XmlElement
  @Enumerated(EnumType.STRING)
  private ECanadaStationClass stationClass;
  /**
   * Canadian Radio-television and Telecommunications Commission (CRTC) Decision
   * Number. Format is "YYNNNN"
   */
  @Column(name = "dec_number")
  @XmlElement
  private int decNumber;
  /**
   * Industry Canada document file number
   */
  @Column(name = "doc_file")
  @XmlElement
  private int docFile;
  /**
   * Broadcast frequency in MHz.
   * <p/>
   * AM Station frequencies are originally recorded in kHz but are automatically
   * converted to MHz upon import into the ca_station table.
   */
  @Column(name = "frequency", precision = 12)
  @XmlElement
  private double frequency;
  /**
   * The broadcast Network (CBCE, CBCF, IND, INDE, INDF, BCMH, or none)
   */
  @Column(name = "network", length = 4)
  @XmlElement
  private String network;
  /**
   * Last date of record update for the "Consultants" database export dump
   */
  @Column(name = "ok_dump", length = 8)
  @Temporal(javax.persistence.TemporalType.DATE)
  @XmlElement
  private Date okDump;
  /**
   * The station province (Canada) or state (US)
   */
  @Column(name = "province", length = 2)
  @XmlElement
  private String province;
  /**
   * Short Spacing Code; "*O#aa"
   */
  @Column(name = "ss_code", length = 5)
  @XmlElement
  private String ssCode;
  /**
   * Date the station was first entered in the database
   */
  @Column(name = "st_creat", length = 8)
  @Temporal(javax.persistence.TemporalType.DATE)
  @XmlElement
  private Date stCreat;
  /**
   * Date the station record was last modified in the database
   */
  @Column(name = "st_mod", length = 8)
  @Temporal(javax.persistence.TemporalType.DATE)
  @XmlElement
  private Date stMod;
  /**
   * Unattended Operation Code (Y, N)
   */
  @Column(name = "unattended")
  @XmlElement
  private Character unattended;
  /**
   * Closest distance to Canada Land Edge
   */
  @Column(name = "can_land", precision = 12)
  @XmlElement
  private double landDistanceCanada;
  /**
   * Closest distance to French Land Edge near Newfoundland
   */
  @Column(name = "fre_land", precision = 12)
  @XmlElement
  private double landDistanceFrenchNewfoundland;
  /**
   * Closest distance to USA Land Edge
   */
  @Column(name = "usa_land", precision = 12)
  @XmlElement
  private double landDistanceUSA;
  /**
   * List of Antenna objects. In the Canada database each antenna record
   * describes a different polarization for the same physical antenna.
   */
  @ManyToMany(mappedBy = "canadaStationList")
  @XmlElement(required = true)
  private List<Antenna> antennaList;
  /**
   * Regional Filing table reference.
   */
  @XmlTransient
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "canadaStation")
  private RegionalFiling regionalFiling;
  /**
   * Feed Signal table reference.
   * <p/>
   * This defines the source of a feed signal for a TV service.
   */
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "canadaStation")
  private FeedSignal feedSignal;
  /**
   * Contour table reference. This is not used for white space calculations and
   * is therefore hidden in the logical data model..
   */
  @XmlTransient
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
  @XmlElement(required = true)
  private Comment comment;

  public CanadaStation() {
  }

  public CanadaStation(CanadaStationPK canadaStationPK) {
    this.canadaStationPK = canadaStationPK;
  }

  public CanadaStation(ECanadaBanner banner, String callSign) {
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
  public ECanadaStationType getStationType() {
    return stationType;
  }

  public void setStationType(ECanadaStationType stationType) {
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
   * Closest distance to Canada US Border (km)
   * <p/>
   * @return the closest distance to Canada US Border (km)
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
  public ECanadaStationClass getStationClass() {
    return stationClass;
  }

  public void setStationClass(ECanadaStationClass stationClass) {
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
      antennaList = new ArrayList<>();
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
      contourList = new ArrayList<>();
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
  }//</editor-fold>

  /**
   * Test this Entity record to determine if it represents a valid transmitter
   * configuration.
   * <p/>
   * @return TRUE if the Provinces are in Canada and the banner code indicates
   *         the record is current and transmitting.
   * @throws Exception If the station is not transmitting.
   */
  public boolean isValid() throws Exception {
    if (!Arrays.asList(new String[]{"AB", "BC", "MB", "NB", "NF", "NS", "NT", "ON", "PE", "QC", "SK", "YT"}).contains(province)) {
      throw new Exception(canadaStationPK.toString() + " province [" + province + "] is not a recognized Canadian province.");
    }
    if (canadaStationPK == null) {
      throw new Exception(canadaStationPK + " has a null or empty Primary Key.");
    }
    if (!canadaStationPK.getBanner().isTransmitting()) {
      throw new Exception(canadaStationPK + " (" + canadaStationPK.getBanner().getDescription() + ") is a non-transmitting configuration.");
    }
    return true;
  }

  /**
   * Hash code is based on the call sign, latitude and longitude.
   * <p>
   * @return a unique hash code integer (always positive)
   */
  @Override
  public int hashCode() {
    int hash = 3;
    hash = 59 * hash + Objects.hash(getCanadaStationPK().getCallSign());
    hash = 59 * hash + Objects.hash(this.latitude);
    hash = 59 * hash + Objects.hash(this.longitude);
    return Math.abs(hash);
  }

  /**
   * Equals is based on call sign, latitude and longitude.
   * <p>
   * @param obj the other object to compare
   * @return TRUE if the call sign, latitude and longitude are equal
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final CanadaStation other = (CanadaStation) obj;
    if (!Objects.equals(this.getCanadaStationPK().getCallSign(), other.getCanadaStationPK().getCallSign())) {
      return false;
    }
    if (!Objects.equals(this.latitude, other.latitude)) {
      return false;
    }
    return Objects.equals(this.longitude, other.longitude);
  }

  /**
   * Get a brief summary of this Canada Station record.
   * <p>
   * @return the PK output, e.g. CanadaStation banner [" + banner + "] callSign
   *         [" + callSign + "]"
   */
  @Override
  public String toString() {
    return canadaStationPK != null
           ? canadaStationPK.toString()
           : "CanadaStation stationType[" + stationType + "]";
  }

  /**
   * Get a complete dump of the Canada Station record configuration.
   * <p>
   * @return all field values.
   */
  public String toStringFull() {
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
