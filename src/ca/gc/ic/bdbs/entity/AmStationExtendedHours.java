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
package ca.gc.ic.bdbs.entity;

import ca.gc.ic.bdbs.entity.enumerated.ECanadaBanner;
import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author jesse
 */
@Entity
@Table(name = "extend")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ca.gc.ic/broadcast/entity")
@NamedQueries({
  @NamedQuery(name = "AmStationExtendedHours.findAll", query = "SELECT a FROM AmStationExtendedHours a"),
  @NamedQuery(name = "AmStationExtendedHours.findByCallsBanr", query = "SELECT a FROM AmStationExtendedHours a WHERE a.callsBanr = :callsBanr"),
  @NamedQuery(name = "AmStationExtendedHours.findByNumber", query = "SELECT a FROM AmStationExtendedHours a WHERE a.number = :number"),
  @NamedQuery(name = "AmStationExtendedHours.findByAntSystem", query = "SELECT a FROM AmStationExtendedHours a WHERE a.antSystem = :antSystem"),
  @NamedQuery(name = "AmStationExtendedHours.findByStart1", query = "SELECT a FROM AmStationExtendedHours a WHERE a.start1 = :start1"),
  @NamedQuery(name = "AmStationExtendedHours.findByEnd1", query = "SELECT a FROM AmStationExtendedHours a WHERE a.end1 = :end1"),
  @NamedQuery(name = "AmStationExtendedHours.findByStart2", query = "SELECT a FROM AmStationExtendedHours a WHERE a.start2 = :start2"),
  @NamedQuery(name = "AmStationExtendedHours.findByEnd2", query = "SELECT a FROM AmStationExtendedHours a WHERE a.end2 = :end2"),
  @NamedQuery(name = "AmStationExtendedHours.findByPower", query = "SELECT a FROM AmStationExtendedHours a WHERE a.power = :power"),
  @NamedQuery(name = "AmStationExtendedHours.findByRms", query = "SELECT a FROM AmStationExtendedHours a WHERE a.rms = :rms"),
  @NamedQuery(name = "AmStationExtendedHours.findByCallSign", query = "SELECT a FROM AmStationExtendedHours a WHERE a.amStationExtendedHoursPK.callSign = :callSign"),
  @NamedQuery(name = "AmStationExtendedHours.findByBanner", query = "SELECT a FROM AmStationExtendedHours a WHERE a.amStationExtendedHoursPK.banner = :banner")})
public class AmStationExtendedHours implements Serializable {

  @XmlTransient
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected AmStationExtendedHoursPK amStationExtendedHoursPK;
  @Column(name = "calls_banr", length = 32)
  @XmlAttribute
  private String callsBanr;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "number", precision = 12)
  @XmlAttribute
  private double number;
  @Column(name = "ant_system", length = 1)
  @XmlAttribute
  private String antSystem;
  @Column(name = "start1", length = 4)
  @XmlAttribute
  private String start1;
  @Column(name = "end1", length = 4)
  @XmlAttribute
  private String end1;
  @Column(name = "start2", precision = 12)
  @XmlAttribute
  private double start2;
  @Column(name = "end2", precision = 12)
  @XmlAttribute
  private double end2;
  @Column(name = "power", precision = 12)
  @XmlAttribute
  private double power;
  @Column(name = "rms")
  @XmlAttribute
  private int rms;
  @JoinColumns({
    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign", nullable = false, insertable = false, updatable = false),
    @JoinColumn(name = "banner", referencedColumnName = "banner", nullable = false, insertable = false, updatable = false)})
  @OneToOne(optional = false)
  @XmlTransient
  private CanadaStation canadaStation;

  public AmStationExtendedHours() {
  }

  public AmStationExtendedHours(AmStationExtendedHoursPK amStationExtendedHoursPK) {
    this.amStationExtendedHoursPK = amStationExtendedHoursPK;
  }

  public AmStationExtendedHours(String callSign, ECanadaBanner banner) {
    this.amStationExtendedHoursPK = new AmStationExtendedHoursPK(callSign, banner);
  }

  public AmStationExtendedHoursPK getAmStationExtendedHoursPK() {
    return amStationExtendedHoursPK;
  }

  public void setAmStationExtendedHoursPK(AmStationExtendedHoursPK amStationExtendedHoursPK) {
    this.amStationExtendedHoursPK = amStationExtendedHoursPK;
  }

  public String getCallsBanr() {
    return callsBanr;
  }

  public void setCallsBanr(String callsBanr) {
    this.callsBanr = callsBanr;
  }

  public double getNumber() {
    return number;
  }

  public void setNumber(double number) {
    this.number = number;
  }

  public String getAntSystem() {
    return antSystem;
  }

  public void setAntSystem(String antSystem) {
    this.antSystem = antSystem;
  }

  public String getStart1() {
    return start1;
  }

  public void setStart1(String start1) {
    this.start1 = start1;
  }

  public String getEnd1() {
    return end1;
  }

  public void setEnd1(String end1) {
    this.end1 = end1;
  }

  public double getStart2() {
    return start2;
  }

  public void setStart2(double start2) {
    this.start2 = start2;
  }

  public double getEnd2() {
    return end2;
  }

  public void setEnd2(double end2) {
    this.end2 = end2;
  }

  public double getPower() {
    return power;
  }

  public void setPower(double power) {
    this.power = power;
  }

  public int getRms() {
    return rms;
  }

  public void setRms(int rms) {
    this.rms = rms;
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
    hash += (amStationExtendedHoursPK != null ? amStationExtendedHoursPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {

    if (!(object instanceof AmStationExtendedHours)) {
      return false;
    }
    AmStationExtendedHours other = (AmStationExtendedHours) object;
    if ((this.amStationExtendedHoursPK == null && other.amStationExtendedHoursPK != null) || (this.amStationExtendedHoursPK != null && !this.amStationExtendedHoursPK.equals(other.amStationExtendedHoursPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.AmStationExtendedHours[ amStationExtendedHoursPK=" + amStationExtendedHoursPK + " ]";
  }
}
