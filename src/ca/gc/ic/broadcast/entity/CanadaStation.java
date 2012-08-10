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
import java.io.Serializable;
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
@Table(name = "ca_station")
@XmlRootElement
@XmlSeeAlso({CanadaStationAm.class, CanadaStationFm.class, CanadaStationSdar.class, CanadaStationTv.class})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ca.gc.ic/broadcast/entity")
@NamedQueries({
  @NamedQuery(name = "CanadaStation.findAll", query = "SELECT c FROM CanadaStation c"),
  @NamedQuery(name = "CanadaStation.findByStationType", query = "SELECT c FROM CanadaStation c WHERE c.stationType = :stationType"),
  @NamedQuery(name = "CanadaStation.findByBanner", query = "SELECT c FROM CanadaStation c WHERE c.canadaStationPK.banner = :banner"),
  @NamedQuery(name = "CanadaStation.findByCallSign", query = "SELECT c FROM CanadaStation c WHERE c.canadaStationPK.callSign = :callSign"),
  @NamedQuery(name = "CanadaStation.findByChannel", query = "SELECT c FROM CanadaStation c WHERE c.channel = :channel")})
public class CanadaStation implements Serializable {

  @XmlTransient
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected CanadaStationPK canadaStationPK;
  @Basic(optional = false)
  @Column(name = "station_type", nullable = false, length = 4)
  @XmlAttribute(required = true)
  private String stationType;
  @Basic(optional = false)
  @Column(name = "channel", nullable = false)
  @XmlAttribute
  private int channel;
  @Basic(optional = false)
  @Column(name = "hagl", nullable = false)
  @XmlAttribute
  private float hagl;
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
  @Column(name = "border", precision = 12)
  @XmlAttribute
  private float border;
  @Column(name = "brdr_lat", length = 6)
  @XmlAttribute
  private String brdrLat;
  @Column(name = "brdr_long", length = 7)
  @XmlAttribute
  private String brdrLong;
  @Column(name = "can_land", precision = 12)
  @XmlAttribute
  private float canLand;
  @Column(name = "cert_numb", length = 6)
  @XmlAttribute
  private String certNumb;
  @Column(name = "city", length = 25)
  @XmlAttribute
  private String city;
  @Column(name = "clazz", length = 2)
  @XmlAttribute
  private String clazz;
  @Column(name = "dec_number")
  @XmlAttribute
  private int decNumber;
  @Column(name = "doc_file")
  @XmlAttribute
  private int docFile;
  @Column(name = "fre_land", precision = 12)
  @XmlAttribute
  private float freLand;
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
  @Column(name = "usa_land", precision = 12)
  @XmlAttribute
  private float usaLand;
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
            + "] hagl [" + hagl
            + "] latitude [" + latitude
            + "] longitude [" + longitude
            + "] bcMode [" + bcMode
            + "] border [" + border
            + "] brdrLat [" + brdrLat
            + "] brdrLong [" + brdrLong
            + "] canLand [" + canLand
            + "] certNumb [" + certNumb
            + "] city [" + city
            + "] clazz [" + clazz
            + "] decNumber [" + decNumber
            + "] docFile [" + docFile
            + "] freLand [" + freLand
            + "] frequency [" + frequency
            + "] network [" + network
            + "] okDump [" + okDump
            + "] province [" + province
            + "] ssCode [" + ssCode
            + "] stCreat [" + stCreat
            + "] stMod [" + stMod
            + "] unattended [" + unattended
            + "] usaLand [" + usaLand
            + "]\n comment [" + comment
            + "]\n regionalFiling [" + regionalFiling
            + "]\n feedSignal [" + feedSignal
            + "]\n tsid [" + tsid
            + "]\n comment [" + comment
            + "]\n antennaList [" + antennaList
            + ']';
  }
}
