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
package ca.gc.ic.broadcast.entity.enumerated;

/**
 *
 * @author jesse
 */
public enum Enum_StationClass {

  /**
   * Class A
   */
  A("Class A"),
  /**
   * Class A1
   */
  A1("Class A1"),
  /**
   * Class B
   */
  B("Class B"),
  /**
   * Class B1
   */
  B1("Class B1"),
  /**
   * Class C
   */
  C("Class C"),
  /**
   * Class C1
   */
  C1("Class C1"),
  /**
   * Class C2
   */
  C2("Class C2"),
  /**
   * Carrier Current
   */
  CC("Carrier Current"),
  /**
   * American Ten Watter
   */
  D("Low Power TV"),
  /**
   * Micro-Wave Fixed
   */
  F("Micro-Wave Fixed"),
  /**
   * Low Power
   */
  LP("Low Power"),
  /**
   * UHF Regular (U.S. Analog)
   */
  N("UHF Regular (U.S. Analog)"),
  /**
   * Regular VHF & MCTV
   */
  R("Regular VHF & MCTV"),
  /**
   * High-Power TV
   */
  S("High-Power TV"),
  /**
   * S-Dars
   */
  SA("Sattelite Digital Audio Radio"),
  /**
   * Very Low Power
   */
  VL("Very Low Power"),
  /**
   * Very Low Power TV Analog
   */
  VLP("Very Low Power TV Analog"),
  /**
   * DTV Upper VHF
   */
  VU("DTV Upper VHF");
  private String description;

  private Enum_StationClass(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

  /**
   * Find an enumBanner object by its 2-character name code.
   * <p/>
   * @param dbCode the 2-character code
   * @return
   */
  public static Enum_StationClass findByDbCode(String dbCode) {
    for (Enum_StationClass enum_Banner : Enum_StationClass.values()) {
      if (enum_Banner.name().equalsIgnoreCase(dbCode)) {
        return enum_Banner;
      }
    }
    return null;
  }
}
