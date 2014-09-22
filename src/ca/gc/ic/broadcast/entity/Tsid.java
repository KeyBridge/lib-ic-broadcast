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
import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 * Logical data model container for the CANADA Tsid (tsid) table.
 * <p/>
 * Contains Station TSID information.
 * <p/>
 * TSID (which stands for Transmission Signal Identifier) is a 16-bit packet
 * contained within the Extended Data Services (XDS) of EIA-608B. Each station
 * is given a unique TSID identifier that has been assigned by the FCC to insert
 * into their Station signal. The recent FCC mandate states the TSID packet must
 * be present in the broadcasters NTSC signal if the broadcaster chooses to have
 * PSIP guide information.
 * <p/>
 * “The FCC emphasized that when the NTSC channel is announced in PSIP,
 * transmission of the NTSC TSID in line 21, field 2 of the NTSC broadcast is
 * now mandatory (as required by A/65B)”.
 * <p/>
 * In short, to ensure proper operation of digital receivers, the TSID data
 * within the NTSC signal must be present. DTV receivers will compare the TSID
 * information received in the PSIP with the TSID information in the
 * corresponding NTSC broadcast, verifying that the NTSC signal referenced in
 * the PSIP is actually the desired signal.
 * <p/>
 * @author jesse
 */
@Entity
@Table(name = "tsid")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http://ca.gc.ic/broadcast/entity")
@NamedQueries({
  @NamedQuery(name = "Tsid.findAll", query = "SELECT t FROM Tsid t"),
  @NamedQuery(name = "Tsid.findByProvince", query = "SELECT t FROM Tsid t WHERE t.province = :province"),
  @NamedQuery(name = "Tsid.findByCity", query = "SELECT t FROM Tsid t WHERE t.city = :city"),
  @NamedQuery(name = "Tsid.findByCallSign", query = "SELECT t FROM Tsid t WHERE t.tsidPK.callSign = :callSign"),
  @NamedQuery(name = "Tsid.findByBanner", query = "SELECT t FROM Tsid t WHERE t.tsidPK.banner = :banner"),
  @NamedQuery(name = "Tsid.findByChannel", query = "SELECT t FROM Tsid t WHERE t.channel = :channel"),
  @NamedQuery(name = "Tsid.findByTsid", query = "SELECT t FROM Tsid t WHERE t.tsid = :tsid")})
public class Tsid implements Serializable {

  @XmlTransient
  private static final long serialVersionUID = 1L;
  @EmbeddedId
  @XmlElement(required = true)
  protected TsidPK tsidPK;
  @Column(name = "province", length = 2)
  @XmlAttribute
  private String province;
  @Column(name = "city", length = 32)
  @XmlAttribute
  private String city;
  @Column(name = "channel")
  @XmlAttribute
  private int channel;
  /**
   * The Transmission Signal Identifier. A 16-bit packet contained within the
   * MPEG-2 Extended Data Services (XDS) of EIA-608B.
   */
  @Column(name = "tsid", length = 4)
  @XmlAttribute
  private String tsid;
  @JoinColumns({
    @JoinColumn(name = "call_sign", referencedColumnName = "call_sign", nullable = false, insertable = false, updatable = false),
    @JoinColumn(name = "banner", referencedColumnName = "banner", nullable = false, insertable = false, updatable = false)})
  @OneToOne(optional = false)
  @XmlTransient
  private CanadaStation canadaStation;

  public Tsid() {
  }

  public Tsid(TsidPK tsidPK) {
    this.tsidPK = tsidPK;
  }

  public Tsid(String callSign, ECanadaBanner banner) {
    this.tsidPK = new TsidPK(callSign, banner);
  }

  public TsidPK getTsidPK() {
    return tsidPK;
  }

  public void setTsidPK(TsidPK tsidPK) {
    this.tsidPK = tsidPK;
  }

  public String getProvince() {
    return province;
  }

  public void setProvince(String province) {
    this.province = province;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public int getChannel() {
    return channel;
  }

  public void setChannel(int channel) {
    this.channel = channel;
  }

  public String getTsid() {
    return tsid;
  }

  public void setTsid(String tsid) {
    this.tsid = tsid;
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
    hash += (tsidPK != null ? tsidPK.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {

    if (!(object instanceof Tsid)) {
      return false;
    }
    Tsid other = (Tsid) object;
    if ((this.tsidPK == null && other.tsidPK != null) || (this.tsidPK != null && !this.tsidPK.equals(other.tsidPK))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "ca.gc.ic.broadcast.entity.Tsid[ tsidPK=" + tsidPK + " ]";
  }
}
