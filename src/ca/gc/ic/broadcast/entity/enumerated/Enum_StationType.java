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
public enum Enum_StationType {

  /**
   * AM Radio
   */
  AM("am_station", "AM Radio"),
  /**
   * FM Radio
   */
  FM("fm_station", "FM Radio"),
  /**
   * Satellite Digital Audio Radio
   */
  SDAR("sdar_station", "Satellite Digital Audio Radio"),
  /**
   * Broadcast Television
   */
  TV("tv_station", "Broadcast Television");
  private String stationType;
  private String description;

  private Enum_StationType(String stationType, String description) {
    this.stationType = stationType;
    this.description = description;
  }

  /**
   * Get a human readable description. e.g. 'Satellite Digital Audio Radio'
   * <p/>
   * @return
   */
  public String getDescription() {
    return description;
  }

  /**
   * Get the database station type differentiating value. e.g. 'tv_station'
   * <p/>
   * @return
   */
  public String getStationType() {
    return stationType;
  }

  /**
   * Return a dot-delimited name. e.g. 'ca.gc.ic.stationType.TV'
   * <p/>
   * @return
   */
  public String getStationTypeName() {
    return "ca.gc.ic.stationType." + name();
  }

  @Override
  public String toString() {
    return description;
  }

  /**
   * Find an enumBanner object by its 2-character name code.
   * <p/>
   * @param stationType the station type class discriminator
   * @return
   */
  public static Enum_StationType findByStationType(String stationType) {
    for (Enum_StationType type : Enum_StationType.values()) {
      if (type.getStationType().equalsIgnoreCase(stationType)) {
        return type;
      }
    }
    return null;
  }

  /**
   * Find an Enum_StationType class by its name. e.g. 'TV'
   * <p/>
   * @param name the name. not case sensitive
   * @return
   */
  public static Enum_StationType findByName(String name) {
    for (Enum_StationType type : Enum_StationType.values()) {
      if (type.name().equalsIgnoreCase(name)) {
        return type;
      }
    }
    return null;
  }

  /**
   * Find an enumBanner object by its 2-character name code.
   * <p/>
   * @param dbCode the 2-character code
   * @return
   */
  public static Enum_StationType findByDbCode(String dbCode) {
    /**
     * This method will receive WSIF WirelessServiceType codes. e.g.
     * 'TVTX.A_CA'. The matching strategy is therefore to identify if the dbCode
     * BEGINS with any Enum_StationType name.
     * <p/>
     * Although the order looks wrong DO NOT EDIT THIS METHOD without reading
     * the logic behind the implementation.
     */
    if (dbCode != null) {
      for (Enum_StationType type : Enum_StationType.values()) {
        if (dbCode.toUpperCase().startsWith(type.name())) {
          return type;
        }
      }
    }
    return null;
  }
}
