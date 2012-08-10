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
  A("Allotment", false),
  /**
   * Allotment
   */
  AL("Allotment", false),
  /**
   * Approved By Crtc
   */
  AP("Approved By CRTC", true),
  /**
   * Authorized By Industry Canada
   */
  AU("Authorized By Industry Canada", true),
  /**
   * Second Allotment
   */
  C("Second Allotment", false),
  /**
   * Conditionally Approved
   */
  CN("Conditionally Approved", false),
  /**
   * Contruction Permit
   */
  CP("Contruction Permit", false),
  /**
   * Incomplete
   */
  IC("Incomplete", false),
  /**
   * Illegal
   */
  IL("Illegal", false),
  /**
   * Operating
   */
  O("Operating", true),
  /**
   * Operational
   */
  OP("Operational", true),
  /**
   * Proposal
   */
  P("Proposal", false),
  /**
   * Proposed Channel
   */
  PC("Proposed Channel", false),
  /**
   * Preliminary
   */
  PR("Preliminary", false),
  /**
   * Referred To Crtc
   */
  RE("Referred To CRTC", false),
  /**
   * Short Duration
   */
  SD("Short Duration", false),
  /**
   * Tentative Deletion
   */
  TD("Tentative Deletion", false),
  /**
   * Temporary Operation
   */
  TO("Temporary Operation", true),
  /**
   * Temporary Proposal
   */
  TP("Temporary Proposal", false),
  /**
   * Under Consideration
   */
  UC("Under Consideration", false),
  /**
   * Unacceptable
   */
  UN("Unacceptable", false),
  /**
   * Cancelled
   */
  X("Cancelled", false),
  /**
   * Cancelled
   */
  XX("Cancelled", false);
  private String description;
  /**
   * Indicates whether the station is on or off air. TRUE means the station is
   * transmitting and should be protected.
   */
  private boolean transmitting;

  private Enum_Banner(String description, boolean transmitting) {
    this.description = description;
    this.transmitting = transmitting;
  }

  public String getDescription() {
    return description;
  }

  public boolean isTransmitting() {
    return transmitting;
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
