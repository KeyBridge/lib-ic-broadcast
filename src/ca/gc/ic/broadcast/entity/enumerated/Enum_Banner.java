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
 * Enumerated list of banner codes. This is a consolidated list of all banner
 * codes including AM, FM, TV and SDAR stations taken from the 'lookup' table
 * and cross-referenced with the respective station tables to ensure 100%
 * coverage.
 * <p/>
 * @author jesse
 */
public enum Enum_Banner {

  /**
   * Allotment
   */
  A("Allotment"),
  /**
   * Allotment
   */
  AL("Allotment"),
  /**
   * Approved By Crtc
   */
  AP("Approved By CRTC"),
  /**
   * Authorized By Industry Canada
   */
  AU("Authorized By Industry Canada"),
  /**
   * Second Allotment
   */
  C("Second Allotment"),
  /**
   * Conditionally Approved
   */
  CN("Conditionally Approved"),
  /**
   * Contruction Permit
   */
  CP("Contruction Permit"),
  /**
   * Incomplete
   */
  IC("Incomplete"),
  /**
   * Illegal
   */
  IL("Illegal"),
  /**
   * Operating
   */
  O("Operating"),
  /**
   * Operational
   */
  OP("Operational"),
  /**
   * Proposal
   */
  P("Proposal"),
  /**
   * Proposed Channel
   */
  PC("Proposed Channel"),
  /**
   * Preliminary
   */
  PR("Preliminary"),
  /**
   * Referred To Crtc
   */
  RE("Referred To CRTC"),
  /**
   * Short Duration
   */
  SD("Short Duration"),
  /**
   * Tentative Deletion
   */
  TD("Tentative Deletion"),
  /**
   * Temporary Operation
   */
  TO("Temporary Operation"),
  /**
   * Temporary Proposal
   */
  TP("Temporary Proposal"),
  /**
   * Under Consideration
   */
  UC("Under Consideration"),
  /**
   * Unacceptable
   */
  UN("Unacceptable"),
  /**
   * Cancelled
   */
  X("Cancelled"),
  /**
   * Cancelled
   */
  XX("Cancelled");
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
