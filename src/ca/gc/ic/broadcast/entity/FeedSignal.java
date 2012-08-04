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
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jesse
 */
@Entity
@Table(name = "feeds")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "FeedSignal.findAll", query = "SELECT f FROM FeedSignal f"),
  @NamedQuery(name = "FeedSignal.findByCallsBanr", query = "SELECT f FROM FeedSignal f WHERE f.callsBanr = :callsBanr"),
  @NamedQuery(name = "FeedSignal.findByFeedId", query = "SELECT f FROM FeedSignal f WHERE f.feedId = :feedId"),
  @NamedQuery(name = "FeedSignal.findByFeedChan", query = "SELECT f FROM FeedSignal f WHERE f.feedChan = :feedChan"),
  @NamedQuery(name = "FeedSignal.findByLinkType", query = "SELECT f FROM FeedSignal f WHERE f.linkType = :linkType"),
  @NamedQuery(name = "FeedSignal.findByFeedCall", query = "SELECT f FROM FeedSignal f WHERE f.feedCall = :feedCall"),
  @NamedQuery(name = "FeedSignal.findByFeedLat", query = "SELECT f FROM FeedSignal f WHERE f.feedLat = :feedLat"),
  @NamedQuery(name = "FeedSignal.findByFeedLong", query = "SELECT f FROM FeedSignal f WHERE f.feedLong = :feedLong"),
  @NamedQuery(name = "FeedSignal.findByCallSign", query = "SELECT f FROM FeedSignal f WHERE f.feedSignalPK.callSign = :callSign"),
  @NamedQuery(name = "FeedSignal.findByBanner", query = "SELECT f FROM FeedSignal f WHERE f.feedSignalPK.banner = :banner")})
public class FeedSignal implements Serializable {

  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected FeedSignalPK feedSignalPK;
  @Column(name = "calls_banr", length = 32)
  private String callsBanr;
  @Column(name = "feed_id", length = 1)
  private String feedId;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "feed_chan", precision = 12)
  private float feedChan;
  @Column(name = "link_type", length = 1)
  private String linkType;
  @Column(name = "feed_call", length = 12)
  private String feedCall;
  @Column(name = "feed_lat", precision = 12)
  private float feedLat;
  @Column(name = "feed_long", precision = 12)
  private float feedLong;
  @JoinColumns({
    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign", nullable = false, insertable = false, updatable = false),
    @JoinColumn(name = "banner", referencedColumnName = "banner", nullable = false, insertable = false, updatable = false)})
  @OneToOne(optional = false)
  private CanadaStation canadaStation;

  public FeedSignal() {
  }

  public FeedSignal(FeedSignalPK feedSignalPK) {
    this.feedSignalPK = feedSignalPK;
  }

  public FeedSignal(String callSign, String banner) {
    this.feedSignalPK = new FeedSignalPK(callSign, banner);
  }

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

  public float getFeedChan() {
    return feedChan;
  }

  public void setFeedChan(float feedChan) {
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

  public float getFeedLat() {
    return feedLat;
  }

  public void setFeedLat(float feedLat) {
    this.feedLat = feedLat;
  }

  public float getFeedLong() {
    return feedLong;
  }

  public void setFeedLong(float feedLong) {
    this.feedLong = feedLong;
  }

  public CanadaStation getCanadaStation() {
    return canadaStation;
  }

  public void setCanadaStation(CanadaStation canadaStation) {
    this.canadaStation = canadaStation;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (feedSignalPK != null ? feedSignalPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
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
    return "ca.gc.ic.broadcast.entity.FeedSignal[ feedSignalPK=" + feedSignalPK + " ]";
  }
}
