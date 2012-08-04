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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author jesse
 */
@Entity
@Table(name = "feeds")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ca.gc.ic/broadcast/entity")
@NamedQueries({
  @NamedQuery(name = "SignalFeed.findAll", query = "SELECT s FROM SignalFeed s"),
  @NamedQuery(name = "SignalFeed.findByCallsBanr", query = "SELECT s FROM SignalFeed s WHERE s.callsBanr = :callsBanr"),
  @NamedQuery(name = "SignalFeed.findByFeedId", query = "SELECT s FROM SignalFeed s WHERE s.feedId = :feedId"),
  @NamedQuery(name = "SignalFeed.findByFeedChan", query = "SELECT s FROM SignalFeed s WHERE s.feedChan = :feedChan"),
  @NamedQuery(name = "SignalFeed.findByLinkType", query = "SELECT s FROM SignalFeed s WHERE s.linkType = :linkType"),
  @NamedQuery(name = "SignalFeed.findByFeedCall", query = "SELECT s FROM SignalFeed s WHERE s.feedCall = :feedCall"),
  @NamedQuery(name = "SignalFeed.findByFeedLat", query = "SELECT s FROM SignalFeed s WHERE s.feedLat = :feedLat"),
  @NamedQuery(name = "SignalFeed.findByFeedLong", query = "SELECT s FROM SignalFeed s WHERE s.feedLong = :feedLong")})
public class SignalFeed implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional = false)
  @Column(name = "calls_banr", nullable = false, length = 32)
  @XmlAttribute
  private String callsBanr;
  @Column(name = "feed_id", length = 1)
  @XmlAttribute
  private String feedId;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "feed_chan", precision = 12)
  @XmlAttribute
  private Float feedChan;
  @Column(name = "link_type", length = 1)
  @XmlAttribute
  private String linkType;
  @Column(name = "feed_call", length = 12)
  @XmlAttribute
  private String feedCall;
  @Column(name = "feed_lat", precision = 12)
  @XmlAttribute
  private Float feedLat;
  @Column(name = "feed_long", precision = 12)
  @XmlAttribute
  private Float feedLong;
  @JoinColumns({
    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign"),
    @JoinColumn(name = "banner", referencedColumnName = "banner")})
  @ManyToOne
  private AmStation amStation;

  public SignalFeed() {
  }

  public SignalFeed(String callsBanr) {
    this.callsBanr = callsBanr;
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

  public Float getFeedChan() {
    return feedChan;
  }

  public void setFeedChan(Float feedChan) {
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

  public Float getFeedLat() {
    return feedLat;
  }

  public void setFeedLat(Float feedLat) {
    this.feedLat = feedLat;
  }

  public Float getFeedLong() {
    return feedLong;
  }

  public void setFeedLong(Float feedLong) {
    this.feedLong = feedLong;
  }

  public AmStation getAmStation() {
    return amStation;
  }

  public void setAmStation(AmStation amStation) {
    this.amStation = amStation;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (callsBanr != null ? callsBanr.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof SignalFeed)) {
      return false;
    }
    SignalFeed other = (SignalFeed) object;
    if ((this.callsBanr == null && other.callsBanr != null) || (this.callsBanr != null && !this.callsBanr.equals(other.callsBanr))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.SignalFeed[ callsBanr=" + callsBanr + " ]";
  }
}
