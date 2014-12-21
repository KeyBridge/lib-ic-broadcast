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

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author jesse
 */
@Entity
@Table(name = "params")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ca.gc.ic/broadcast/entity")
@NamedQueries({
  @NamedQuery(name = "AmStationParameter.findAll", query = "SELECT a FROM AmStationParameter a"),
  @NamedQuery(name = "AmStationParameter.findByCallsBanr", query = "SELECT a FROM AmStationParameter a WHERE a.amStationParameterPK.callsBanr = :callsBanr"),
  @NamedQuery(name = "AmStationParameter.findByDncCode", query = "SELECT a FROM AmStationParameter a WHERE a.amStationParameterPK.dncCode = :dncCode"),
  @NamedQuery(name = "AmStationParameter.findByTowerNumb", query = "SELECT a FROM AmStationParameter a WHERE a.amStationParameterPK.towerNumb = :towerNumb"),
  @NamedQuery(name = "AmStationParameter.findByFieldratio", query = "SELECT a FROM AmStationParameter a WHERE a.fieldratio = :fieldratio"),
  @NamedQuery(name = "AmStationParameter.findBySpacing", query = "SELECT a FROM AmStationParameter a WHERE a.spacing = :spacing"),
  @NamedQuery(name = "AmStationParameter.findByOrienta", query = "SELECT a FROM AmStationParameter a WHERE a.orienta = :orienta"),
  @NamedQuery(name = "AmStationParameter.findByPhasing", query = "SELECT a FROM AmStationParameter a WHERE a.phasing = :phasing"),
  @NamedQuery(name = "AmStationParameter.findByHeight", query = "SELECT a FROM AmStationParameter a WHERE a.height = :height"),
  @NamedQuery(name = "AmStationParameter.findByTypeAnt", query = "SELECT a FROM AmStationParameter a WHERE a.typeAnt = :typeAnt"),
  @NamedQuery(name = "AmStationParameter.findByA", query = "SELECT a FROM AmStationParameter a WHERE a.a = :a"),
  @NamedQuery(name = "AmStationParameter.findByB", query = "SELECT a FROM AmStationParameter a WHERE a.b = :b"),
  @NamedQuery(name = "AmStationParameter.findByC", query = "SELECT a FROM AmStationParameter a WHERE a.c = :c"),
  @NamedQuery(name = "AmStationParameter.findByD", query = "SELECT a FROM AmStationParameter a WHERE a.d = :d")})
public class AmStationParameter implements Serializable {

  @XmlTransient
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  protected AmStationParameterPK amStationParameterPK;
  // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
  @Column(name = "fieldratio", precision = 12)
  @XmlAttribute
  private double fieldratio;
  @Column(name = "spacing", precision = 12)
  @XmlAttribute
  private double spacing;
  @Column(name = "orienta", precision = 12)
  @XmlAttribute
  private double orienta;
  @Column(name = "phasing", precision = 12)
  @XmlAttribute
  private double phasing;
  @Column(name = "height", precision = 12)
  @XmlAttribute
  private double height;
  @Column(name = "type_ant")
  @XmlAttribute
  private int typeAnt;
  @Column(name = "a", precision = 12)
  @XmlAttribute
  private double a;
  @Column(name = "b", precision = 12)
  @XmlAttribute
  private double b;
  @Column(name = "c", precision = 12)
  @XmlAttribute
  private double c;
  @Column(name = "d", precision = 12)
  @XmlAttribute
  private double d;
  @JoinColumns({
    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign"),
    @JoinColumn(name = "banner", referencedColumnName = "banner")})
  @ManyToOne
  @XmlTransient
  private CanadaStation canadaStation;

  public AmStationParameter() {
  }

  public AmStationParameter(AmStationParameterPK amStationParameterPK) {
    this.amStationParameterPK = amStationParameterPK;
  }

  public AmStationParameter(String callsBanr, String dncCode, int towerNumb) {
    this.amStationParameterPK = new AmStationParameterPK(callsBanr, dncCode, towerNumb);
  }

  public AmStationParameterPK getAmStationParameterPK() {
    return amStationParameterPK;
  }

  public void setAmStationParameterPK(AmStationParameterPK amStationParameterPK) {
    this.amStationParameterPK = amStationParameterPK;
  }

  public double getFieldratio() {
    return fieldratio;
  }

  public void setFieldratio(double fieldratio) {
    this.fieldratio = fieldratio;
  }

  public double getSpacing() {
    return spacing;
  }

  public void setSpacing(double spacing) {
    this.spacing = spacing;
  }

  public double getOrienta() {
    return orienta;
  }

  public void setOrienta(double orienta) {
    this.orienta = orienta;
  }

  public double getPhasing() {
    return phasing;
  }

  public void setPhasing(double phasing) {
    this.phasing = phasing;
  }

  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  public int getTypeAnt() {
    return typeAnt;
  }

  public void setTypeAnt(int typeAnt) {
    this.typeAnt = typeAnt;
  }

  public double getA() {
    return a;
  }

  public void setA(double a) {
    this.a = a;
  }

  public double getB() {
    return b;
  }

  public void setB(double b) {
    this.b = b;
  }

  public double getC() {
    return c;
  }

  public void setC(double c) {
    this.c = c;
  }

  public double getD() {
    return d;
  }

  public void setD(double d) {
    this.d = d;
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
    hash += (amStationParameterPK != null ? amStationParameterPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {

    if (!(object instanceof AmStationParameter)) {
      return false;
    }
    AmStationParameter other = (AmStationParameter) object;
    if ((this.amStationParameterPK == null && other.amStationParameterPK != null) || (this.amStationParameterPK != null && !this.amStationParameterPK.equals(other.amStationParameterPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.AmStationParameter[ amStationParameterPK=" + amStationParameterPK + " ]";
  }
}
