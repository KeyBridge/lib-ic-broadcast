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
package ca.gc.ic.broadcast.entity;

import ca.gc.ic.broadcast.entity.enumerated.ECanadaBanner;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author jesse
 */
@Entity
@DiscriminatorValue("AM")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ca.gc.ic/broadcast/entity")
public class CanadaStationAm extends CanadaStation {

  @XmlTransient
  private static final long serialVersionUID = 1L;

  /**
   * RSS Night Interference Free Value
   */
  @Column(name = "euvalu", precision = 12)
  @XmlAttribute
  private double euvalu;
  /**
   * IFRB Number for day time
   */
  @Column(name = "ifrbn_d", precision = 12)
  @XmlAttribute
  private double ifrbnD;
  /**
   * IFRB Number for night time
   */
  @Column(name = "ifrbn_n", precision = 12)
  @XmlAttribute
  private double ifrbnN;
  @Column(name = "latitude2", length = 6)
  @XmlAttribute
  private String latitude2;
  @Column(name = "longitude2", length = 7)
  @XmlAttribute
  private String longitude2;
  @Column(name = "par_rms_c", precision = 12)
  @XmlAttribute
  private double parRmsC;
  @Column(name = "par_rms_d", precision = 12)
  @XmlAttribute
  private double parRmsD;
  @Column(name = "par_rms_n", precision = 12)
  @XmlAttribute
  private double parRmsN;
  @Column(name = "powercrit", precision = 12)
  @XmlAttribute
  private double powercrit;
  @Column(name = "powerday", precision = 12)
  @XmlAttribute
  private double powerday;
  @Column(name = "powernight", precision = 12)
  @XmlAttribute
  private double powernight;
  @Column(name = "q_crit", precision = 12)
  @XmlAttribute
  private double qCrit;
  @Column(name = "q_day", precision = 12)
  @XmlAttribute
  private double qDay;
  @Column(name = "q_night", precision = 12)
  @XmlAttribute
  private double qNight;
  @Column(name = "status1", length = 2)
  @XmlAttribute
  private String status1;
  @Column(name = "status2", length = 2)
  @XmlAttribute
  private String status2;
  @OneToOne(cascade = CascadeType.ALL, mappedBy = "canadaStation")
  private AmStationExtendedHours amStationExtendedHours;
  @OneToMany(mappedBy = "canadaStation")
  private List<AmStationParameter> amStationParameterList;
  @OneToMany(mappedBy = "canadaStation")
  private List<AmStationAugment> amStationAugmentList;

  public CanadaStationAm() {
  }

  public CanadaStationAm(CanadaStationPK canadaStationPK) {
    this.canadaStationPK = canadaStationPK;
  }

  public CanadaStationAm(ECanadaBanner banner, String callSign) {
    this.canadaStationPK = new CanadaStationPK(banner, callSign);
  }

  //<editor-fold defaultstate="collapsed" desc="Getter and Setter">
  public double getEuvalu() {
    return euvalu;
  }

  public void setEuvalu(double euvalu) {
    this.euvalu = euvalu;
  }

  public double getIfrbnD() {
    return ifrbnD;
  }

  public void setIfrbnD(double ifrbnD) {
    this.ifrbnD = ifrbnD;
  }

  public double getIfrbnN() {
    return ifrbnN;
  }

  public void setIfrbnN(double ifrbnN) {
    this.ifrbnN = ifrbnN;
  }

  public String getLatitude2() {
    return latitude2;
  }

  public void setLatitude2(String latitude2) {
    this.latitude2 = latitude2;
  }

  public String getLongitude2() {
    return longitude2;
  }

  public void setLongitude2(String longitude2) {
    this.longitude2 = longitude2;
  }

  public double getParRmsC() {
    return parRmsC;
  }

  public void setParRmsC(double parRmsC) {
    this.parRmsC = parRmsC;
  }

  public double getParRmsD() {
    return parRmsD;
  }

  public void setParRmsD(double parRmsD) {
    this.parRmsD = parRmsD;
  }

  public double getParRmsN() {
    return parRmsN;
  }

  public void setParRmsN(double parRmsN) {
    this.parRmsN = parRmsN;
  }

  public double getPowercrit() {
    return powercrit;
  }

  public void setPowercrit(double powercrit) {
    this.powercrit = powercrit;
  }

  public double getPowerday() {
    return powerday;
  }

  public void setPowerday(double powerday) {
    this.powerday = powerday;
  }

  public double getPowernight() {
    return powernight;
  }

  public void setPowernight(double powernight) {
    this.powernight = powernight;
  }

  public double getqCrit() {
    return qCrit;
  }

  public void setqCrit(double qCrit) {
    this.qCrit = qCrit;
  }

  public double getqDay() {
    return qDay;
  }

  public void setqDay(double qDay) {
    this.qDay = qDay;
  }

  public double getqNight() {
    return qNight;
  }

  public void setqNight(double qNight) {
    this.qNight = qNight;
  }

  public String getStatus1() {
    return status1;
  }

  public void setStatus1(String status1) {
    this.status1 = status1;
  }

  public String getStatus2() {
    return status2;
  }

  public void setStatus2(String status2) {
    this.status2 = status2;
  }

  public AmStationExtendedHours getAmStationExtendedHours() {
    return amStationExtendedHours;
  }

  public void setAmStationExtendedHours(AmStationExtendedHours amStationExtendedHours) {
    this.amStationExtendedHours = amStationExtendedHours;
  }

  public List<AmStationParameter> getAmStationParameterList() {
    return amStationParameterList;
  }

  public void setAmStationParameterList(List<AmStationParameter> amStationParameterList) {
    this.amStationParameterList = amStationParameterList;
  }

  public List<AmStationAugment> getAmStationAugmentList() {
    return amStationAugmentList;
  }

  public void setAmStationAugmentList(List<AmStationAugment> amStationAugmentList) {
    this.amStationAugmentList = amStationAugmentList;
  }
  //</editor-fold>

  @Override
  public String toStringFull() {
    return "CanadaStationAm"
      + super.toString()
      + " euvalu [" + euvalu
      + "] ifrbnD [" + ifrbnD
      + "] ifrbnN [" + ifrbnN
      + "] latitude2 [" + latitude2
      + "] longitude2 [" + longitude2
      + "] parRmsC [" + parRmsC
      + "] parRmsD [" + parRmsD
      + "] parRmsN [" + parRmsN
      + "] powercrit [" + powercrit
      + "] powerday [" + powerday
      + "] powernight [" + powernight
      + "] qCrit [" + qCrit
      + "] qDay [" + qDay
      + "] qNight [" + qNight
      + "] status1 [" + status1
      + "] status2 [" + status2
      + "]\n amStationExtendedHours [" + amStationExtendedHours
      + "]\n amStationParameterList [" + amStationParameterList
      + "]\n amStationAugmentList [" + amStationAugmentList
      + ']';
  }
}
