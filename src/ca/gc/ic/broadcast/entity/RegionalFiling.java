/* 
 * Copyright (C) 2014 Jesse Caulfield <jesse@caulfield.org>
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
package ca.gc.ic.broadcast.entity;

import ca.gc.ic.broadcast.entity.enumerated.ECanadaBanner;
import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author jesse
 */
@Entity
@Table(name = "region")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ca.gc.ic/broadcast/entity")
@NamedQueries({
  @NamedQuery(name = "RegionalFiling.findAll", query = "SELECT r FROM RegionalFiling r"),
  @NamedQuery(name = "RegionalFiling.findByCallsBanr", query = "SELECT r FROM RegionalFiling r WHERE r.callsBanr = :callsBanr"),
  @NamedQuery(name = "RegionalFiling.findByRegion", query = "SELECT r FROM RegionalFiling r WHERE r.region = :region"),
  @NamedQuery(name = "RegionalFiling.findByDistrict", query = "SELECT r FROM RegionalFiling r WHERE r.district = :district"),
  @NamedQuery(name = "RegionalFiling.findByInspecRep", query = "SELECT r FROM RegionalFiling r WHERE r.inspecRep = :inspecRep"),
  @NamedQuery(name = "RegionalFiling.findByPainting", query = "SELECT r FROM RegionalFiling r WHERE r.painting = :painting"),
  @NamedQuery(name = "RegionalFiling.findBySprDat", query = "SELECT r FROM RegionalFiling r WHERE r.sprDat = :sprDat"),
  @NamedQuery(name = "RegionalFiling.findByRspDat", query = "SELECT r FROM RegionalFiling r WHERE r.rspDat = :rspDat"),
  @NamedQuery(name = "RegionalFiling.findByStdett", query = "SELECT r FROM RegionalFiling r WHERE r.stdett = :stdett"),
  @NamedQuery(name = "RegionalFiling.findByAirClear", query = "SELECT r FROM RegionalFiling r WHERE r.airClear = :airClear"),
  @NamedQuery(name = "RegionalFiling.findByInspecDat", query = "SELECT r FROM RegionalFiling r WHERE r.inspecDat = :inspecDat"),
  @NamedQuery(name = "RegionalFiling.findByRcfDat", query = "SELECT r FROM RegionalFiling r WHERE r.rcfDat = :rcfDat"),
  @NamedQuery(name = "RegionalFiling.findByStatType", query = "SELECT r FROM RegionalFiling r WHERE r.statType = :statType"),
  @NamedQuery(name = "RegionalFiling.findByDocfex", query = "SELECT r FROM RegionalFiling r WHERE r.docfex = :docfex"),
  @NamedQuery(name = "RegionalFiling.findByProvince", query = "SELECT r FROM RegionalFiling r WHERE r.province = :province"),
  @NamedQuery(name = "RegionalFiling.findByCountry", query = "SELECT r FROM RegionalFiling r WHERE r.country = :country"),
  @NamedQuery(name = "RegionalFiling.findByCallSign", query = "SELECT r FROM RegionalFiling r WHERE r.regionalFilingPK.callSign = :callSign"),
  @NamedQuery(name = "RegionalFiling.findByBanner", query = "SELECT r FROM RegionalFiling r WHERE r.regionalFilingPK.banner = :banner")})
public class RegionalFiling implements Serializable {

  @XmlTransient
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  @XmlElement(required = true)
  protected RegionalFilingPK regionalFilingPK;
  @Column(name = "calls_banr", length = 32)
  @XmlAttribute(required = true)
  private String callsBanr;
  @Column(name = "region", length = 1)
  @XmlAttribute
  private String region;
  @Column(name = "district", length = 2)
  @XmlAttribute
  private String district;
  @Column(name = "inspec_rep", length = 1)
  @XmlAttribute
  private String inspecRep;
  @Column(name = "painting", length = 4)
  @XmlAttribute
  private String painting;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "spr_dat", precision = 12)
  @XmlAttribute
  private double sprDat;
  @Column(name = "rsp_dat", precision = 12)
  @XmlAttribute
  private double rspDat;
  @Column(name = "stdett", precision = 12)
  @XmlAttribute
  private double stdett;
  @Column(name = "air_clear", precision = 12)
  @XmlAttribute
  private double airClear;
  @Column(name = "inspec_dat", precision = 12)
  @XmlAttribute
  private double inspecDat;
  @Column(name = "rcf_dat", precision = 12)
  @XmlAttribute
  private double rcfDat;
  @Column(name = "stat_type", length = 2)
  @XmlAttribute
  private String statType;
  @Column(name = "docfex", length = 4)
  @XmlAttribute
  private String docfex;
  @Column(name = "province", length = 2)
  @XmlAttribute
  private String province;
  @Column(name = "country", length = 2)
  @XmlAttribute
  private String country;
  @JoinColumns({
    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign", nullable = false, insertable = false, updatable = false),
    @JoinColumn(name = "banner", referencedColumnName = "banner", nullable = false, insertable = false, updatable = false)})
  @OneToOne(optional = false)
  @XmlTransient
  private CanadaStation canadaStation;

  public RegionalFiling() {
  }

  public RegionalFiling(RegionalFilingPK regionalFilingPK) {
    this.regionalFilingPK = regionalFilingPK;
  }

  public RegionalFiling(String callSign, ECanadaBanner banner) {
    this.regionalFilingPK = new RegionalFilingPK(callSign, banner);
  }

  public RegionalFilingPK getRegionalFilingPK() {
    return regionalFilingPK;
  }

  public void setRegionalFilingPK(RegionalFilingPK regionalFilingPK) {
    this.regionalFilingPK = regionalFilingPK;
  }

  public String getCallsBanr() {
    return callsBanr;
  }

  public void setCallsBanr(String callsBanr) {
    this.callsBanr = callsBanr;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public String getInspecRep() {
    return inspecRep;
  }

  public void setInspecRep(String inspecRep) {
    this.inspecRep = inspecRep;
  }

  public String getPainting() {
    return painting;
  }

  public void setPainting(String painting) {
    this.painting = painting;
  }

  public double getSprDat() {
    return sprDat;
  }

  public void setSprDat(double sprDat) {
    this.sprDat = sprDat;
  }

  public double getRspDat() {
    return rspDat;
  }

  public void setRspDat(double rspDat) {
    this.rspDat = rspDat;
  }

  public double getStdett() {
    return stdett;
  }

  public void setStdett(double stdett) {
    this.stdett = stdett;
  }

  public double getAirClear() {
    return airClear;
  }

  public void setAirClear(double airClear) {
    this.airClear = airClear;
  }

  public double getInspecDat() {
    return inspecDat;
  }

  public void setInspecDat(double inspecDat) {
    this.inspecDat = inspecDat;
  }

  public double getRcfDat() {
    return rcfDat;
  }

  public void setRcfDat(double rcfDat) {
    this.rcfDat = rcfDat;
  }

  public String getStatType() {
    return statType;
  }

  public void setStatType(String statType) {
    this.statType = statType;
  }

  public String getDocfex() {
    return docfex;
  }

  public void setDocfex(String docfex) {
    this.docfex = docfex;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
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
    hash += (regionalFilingPK != null ? regionalFilingPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {

    if (!(object instanceof RegionalFiling)) {
      return false;
    }
    RegionalFiling other = (RegionalFiling) object;
    if ((this.regionalFilingPK == null && other.regionalFilingPK != null) || (this.regionalFilingPK != null && !this.regionalFilingPK.equals(other.regionalFilingPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.RegionalFiling[ regionalFilingPK=" + regionalFilingPK + " ]";
  }
}
