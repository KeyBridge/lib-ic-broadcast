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
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 * Logical data model container for the CANADA FeedSignal (feeds) table.
 * <p>
 * This table is used to identify the upstream transmitter system for repeater
 * and translator stations.
 * <p/>
 * @author jesse
 */
@Entity
@Table(name = "feeds")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ca.gc.ic/broadcast/entity")
@NamedQueries({
  @NamedQuery(name = "FeedSignal.findAll", query = "SELECT f FROM FeedSignal f"),
  @NamedQuery(name = "FeedSignal.findByCallSign", query = "SELECT f FROM FeedSignal f WHERE f.feedSignalPK.callSign = :callSign")})
public class FeedSignal implements Serializable {

  @XmlTransient
  private static final long serialVersionUID = 1L;

  @EmbeddedId
  @XmlElement(required = true)
  protected FeedSignalPK feedSignalPK;
  /**
   * @deprecated Not used in the logical data model.
   */
  @Column(name = "calls_banr", length = 32)
  @XmlTransient
  private String callsBanr;
  /**
   * Feed Identifier; A or B
   */
  @Column(name = "feed_id", length = 1)
  @XmlAttribute
  private String feedId;
  /**
   * Feed input channel: 0, 2 - 83, or 2500 - 2680
   */
  @Column(name = "feed_chan", precision = 12)
  @XmlAttribute
  private double feedChannel;
  /**
   * Type of FEED LINK; O, U, S, C
   */
  @Column(name = "link_type", length = 1)
  @XmlAttribute
  private String linkType;
  /**
   * Name of the SOURCE of the FEED. Call sign reference.
   */
  @Column(name = "feed_call", length = 12)
  @XmlAttribute
  private String feedCallSign;
  /**
   * N.Latitude of the FEED SOURCE (ddmmss)
   */
  @Column(name = "feed_lat", precision = 12)
  @XmlTransient
  private String feedLat;
  /**
   * W.Longitude of the FEED SOURCE (dddmmss)
   */
  @Column(name = "feed_long", precision = 12)
  @XmlTransient
  private String feedLong;

  /**
   * The calculated latitude value.
   */
  @Transient
  @XmlAttribute
  private Double latitude;
  /**
   * The calculated longitude value.
   */
  @Transient
  @XmlAttribute
  private Double longitude;

  @JoinColumns({
    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign", nullable = false, insertable = false, updatable = false),
    @JoinColumn(name = "banner", referencedColumnName = "banner", nullable = false, insertable = false, updatable = false)})
  @OneToOne(optional = false)
  @XmlTransient
  private CanadaStation canadaStation;

  public FeedSignal() {
  }

  public FeedSignal(FeedSignalPK feedSignalPK) {
    this.feedSignalPK = feedSignalPK;
  }

  public FeedSignal(String callSign, ECanadaBanner banner) {
    this.feedSignalPK = new FeedSignalPK(callSign, banner);
  }

  //<editor-fold defaultstate="collapsed" desc="Getters and Setters">
  public FeedSignalPK getFeedSignalPK() {
    return feedSignalPK;
  }

  public void setFeedSignalPK(FeedSignalPK feedSignalPK) {
    this.feedSignalPK = feedSignalPK;
  }

  public String getCallsBanr() {
    return callsBanr;
  }

  public void setCallsBanr(String callsBanr) {
    this.callsBanr = callsBanr;
  }

  public String getFeedId() {
    return feedId;
  }

  public void setFeedId(String feedId) {
    this.feedId = feedId;
  }

  public double getFeedChannel() {
    return feedChannel;
  }

  public void setFeedChannel(double feedChannel) {
    this.feedChannel = feedChannel;
  }

  public String getLinkType() {
    return linkType;
  }

  public void setLinkType(String linkType) {
    this.linkType = linkType;
  }

  public String getFeedCallSign() {
    return feedCallSign;
  }

  public void setFeedCallSign(String feedCallSign) {
    this.feedCallSign = feedCallSign;
  }

  public String getFeedLat() {
    return feedLat;
  }

  public void setFeedLat(String feedLat) {
    this.feedLat = feedLat;
  }

  public String getFeedLong() {
    return feedLong;
  }

  public void setFeedLong(String feedLong) {
    this.feedLong = feedLong;
  }//</editor-fold>

  /**
   * @return WGS_84
   */
  public String getDatum() {
    return "WGS_84";
  }

  /**
   * @return Latitude of the FEED SOURCE in decimal degrees.
   */
  public Double getLatitude() {
//       * N.Latitude of the FEED SOURCE(ddmmss)
    Pattern p = Pattern.compile("(\\d\\d)(\\d\\d)(\\d\\d)");
    Matcher m = p.matcher(feedLat);
    if (m.find()) {
      return DMStoDEC(Integer.valueOf(m.group(0)),
                      Integer.valueOf(m.group(1)),
                      Double.valueOf(m.group(2)),
                      "N");
    }
    return null;
  }

  /**
   * @return Longitude of the FEED SOURCE in decimal degrees.
   */
  public Double getLongitude() {
//       * W.Longitude of the FEED SOURCE(dddmmss)
    Pattern p = Pattern.compile("(\\d\\d\\d)(\\d\\d)(\\d\\d)");
    Matcher m = p.matcher(feedLong);
    if (m.find()) {
      return DMStoDEC(Integer.valueOf(m.group(0)),
                      Integer.valueOf(m.group(1)),
                      Double.valueOf(m.group(2)),
                      "W");
    }
    return null;
  }

  /**
   * Convert DMS to decimal
   * <p/>
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

  public CanadaStation getCanadaStation() {
    return canadaStation;
  }

  public void setCanadaStation(CanadaStation canadaStation) {
    this.canadaStation = canadaStation;
  }

  /**
   * Set the latitude and longitude after loading the record from the database.
   */
  @PostLoad
  private void postLoad() {
    this.latitude = getLatitude();
    this.longitude = getLongitude();
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (feedSignalPK != null ? feedSignalPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {

    if (!(object instanceof FeedSignal)) {
      return false;
    }
    FeedSignal other = (FeedSignal) object;
    if ((this.feedSignalPK == null && other.feedSignalPK != null) || (this.feedSignalPK != null && !this.feedSignalPK.equals(other.feedSignalPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "FeedSignal"
      + " feedCallSign [" + feedCallSign
      + " feedChannel [" + feedChannel
      + "] latitude [" + getLatitude()
      + "] longitude [" + getLongitude()
      + "]";
  }
}
