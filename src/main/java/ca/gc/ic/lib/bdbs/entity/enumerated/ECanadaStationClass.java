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
package ca.gc.ic.lib.bdbs.entity.enumerated;

/**
 * An enumeration of the allowed 'CLASS' field values in the Canada station
 * tables 'am_statio', 'fm_statio', 'tv_statio' and 'sdars'.
 * <p/>
 To prevent Java language conflict the table field is named 'clazz' and the
 Java object (this) is named 'ECanadaStationClass'.
 <p/>
 * Some classes are used across service types. For example. 'A' is used for AM,
 * FM and TV stations.
 * <p/>
 * @author jesse
 */
public enum ECanadaStationClass {

  /**
   * Class A. Present in AM stations. Present in FM and TV stations. For TV
   * stations this is an NTSC UHF station.
   */
  A("Class A"),
  /**
   * Class A1. Present in FM stations.
   */
  A1("Class A1"),
  /**
   * Class B. Present in AM, FM and TV stations. For TV stations this is an NTSC
   * UHF station.
   */
  B("Class B"),
  /**
   * Class B1. Present in FM stations.
   */
  B1("Class B1"),
  /**
   * Class C. Present in AM, FM and TV stations. For TV stations this is an NTSC
   * UHF station.
   */
  C("Class C"),
  /**
   * Class C1. Present in FM stations.
   */
  C1("Class C1"),
  /**
   * Class C2. Present in FM stations.
   */
  C2("Class C2"),
  /**
   * Carrier Current
   */
  CC("Carrier Current"),
  /**
   * American Low Power Station. Present in FM and TV stations. For TV stations
   * this is an NTSC Class D low power TV station.
   */
  D("Low Power"),
  /**
   * Micro-Wave Fixed. Present in TV stations.
   */
  F("Micro-Wave Fixed"),
  /**
   * Low Power. Present in AM, FM and TV stations. For TV stations this is an
   * Low power NTSC VHF/UHF station.
   */
  LP("Low Power"),
  /**
   * UHF Regular (U.S. Analog). Present in TV stations.
   */
  N("UHF Regular (U.S. Analog)"),
  /**
   * Regular VHF & MCTV. Present in TV stations.
   */
  R("Regular VHF & MCTV"),
  /**
   * High-Power TV Analog. Present in TV stations.
   */
  S("High-Power TV Analog"),
  /**
   * Satelite Digital Audio Radio (S-Dars)
   */
  SA("Satelite Digital Audio Radio"),
  /**
   * Very Low Power. Present in TV stations. For TV stations this is a digital
   * transition station (low VHF band).
   */
  VL("Very Low Power Digital"),
  /**
   * Very Low Power TV Analog. Present in FM and TV stations.
   */
  VLP("Very Low Power Analog"),
  /**
   * DTV Upper VHF. For TV stations this is a digital transition station (upper
   * VHF band)
   */
  VU("DTV Upper VHF");
  private final String description;

  private ECanadaStationClass(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  /**
   * Find an ECanadaStationClass object by its 2 or 3-character database code.
   * <p/>
   * @param dbCode The 2 or 3-character database code (not case-sensistive)
   * @return null if no match
   */
  public static ECanadaStationClass findByDbCode(String dbCode) {
    for (ECanadaStationClass enum_Banner : ECanadaStationClass.values()) {
      if (enum_Banner.name().equalsIgnoreCase(dbCode)) {
        return enum_Banner;
      }
    }
    return null;
  }
}
