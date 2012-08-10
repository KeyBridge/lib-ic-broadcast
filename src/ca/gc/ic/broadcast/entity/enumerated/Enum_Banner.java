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
public enum Enum_Banner {

  /**
   * Allotment
   */
  AL("Allotment"),
  /**
   * Approved
   */
  AP("Approved"),
  /**
   * Authorized
   */
  AU("Authorized"),
  /**
   * Construction Permit
   */
  CP("Construction Permit"),
  /**
   * Denied
   */
  DE("Denied"),
  /**
   * Incomplete
   */
  IC("Incomplete"),
  /**
   * Illegal
   */
  IL("Illegal"),
  /**
   * Operational
   */
  OP("Operational"),
  /**
   * Proposed Channel
   */
  PC("Proposed Channel"),
  /**
   * Referred to CRTC
   */
  RE("Referred to CRTC"),
  /**
   * Tentative Deletion
   */
  TD("Tentative Deletion"),
  /**
   * Temp. Operation
   */
  TO("Temp. Operation"),
  /**
   * Approved by CRTC
   */
  UA("Approved by CRTC"),
  /**
   * Under Consideration
   */
  UC("Under Consideration"),
  /**
   * Unacceptable
   */
  UN("Unacceptable");
  private String description;

  private Enum_Banner(String description) {
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
  public static Enum_Banner findByDbCode(String dbCode) {
    for (Enum_Banner enum_Banner : Enum_Banner.values()) {
      if (enum_Banner.name().equalsIgnoreCase(dbCode)) {
        return enum_Banner;
      }
    }
    return null;
  }
}
