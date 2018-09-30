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

import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Logical data model container for the CANADA FeedSignal (feeds) table.
 * <p>
 * This table is used to identify the upstream transmitter system for repeater
 * and translator stations.
 *
 * @author Key Bridge
 */
@Entity
@Table(name = "feeds")
@XmlAccessorType(XmlAccessType.FIELD)
public class Feeds implements Serializable {

  private static final long serialVersionUID = 1L;
  /**
   * @deprecated Not used in the logical data model.
   */
  @Id
  @Basic(optional = false)
  @Column(name = "calls_banr")
  private String callsBanr;
  /**
   * Feed Identifier; A or B
   */
  @Column(name = "feed_id")
  private String feedId;
  /**
   * Feed input channel: 0, 2 - 83, or 2500 - 2680
   */
  @Column(name = "feed_chan")
  private Double feedChan;
  /**
   * Type of FEED LINK; O, U, S, C
   */
  @Column(name = "link_type")
  private String linkType;
  /**
   * Name of the SOURCE of the FEED. Call sign reference.
   */
  @Column(name = "feed_call")
  private String feedCall;
  /**
   * N.Latitude of the FEED SOURCE (ddmmss)
   */
  @Column(name = "feed_lat")
  private String feedLat;
  /**
   * W.Longitude of the FEED SOURCE (dddmmss)
   */
  @Column(name = "feed_long")
  private String feedLong;
  @JoinColumns({
    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign")
    , @JoinColumn(name = "banner", referencedColumnName = "banner")})
  @ManyToOne
  @XmlTransient
  private Facility facility;

  public Feeds() {
  }

  //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
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

  public Double getFeedChan() {
    return feedChan;
  }

  public void setFeedChan(Double feedChan) {
    this.feedChan = feedChan;
  }

  public String getLinkType() {
    return linkType;
  }

  public void setLinkType(String linkType) {
    this.linkType = linkType;
  }

  public String getFeedCall() {
    return feedCall;
  }

  public void setFeedCall(String feedCall) {
    this.feedCall = feedCall;
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
  }

  public Facility getFacility() {
    return facility;
  }

  public void setFacility(Facility facility) {
    this.facility = facility;
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

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 47 * hash + Objects.hashCode(this.callsBanr);
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
    final Feeds other = (Feeds) obj;
    return Objects.equals(this.callsBanr, other.callsBanr);
  }

}
