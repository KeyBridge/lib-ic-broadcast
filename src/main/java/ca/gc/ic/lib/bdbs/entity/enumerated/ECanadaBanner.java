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
 * Enumerated values for the CanadaStation banner field.
 * <p/>
 * This is a consolidated list of all banner codes including AM, FM, TV and SDAR
 * stations taken from the 'lookup' table and cross-referenced with the
 * respective station tables to ensure 100% coverage.
 * <p/>
 * @author Key Bridge Global LLC 
 */
public enum ECanadaBanner {

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
  UN("Unacceptable Application", false),
  /**
   * Cancelled
   */
  X("Cancelled Permit", false),
  /**
   * Cancelled
   */
  XX("Cancelled Application", false);
  /**
   * Human readable description. e.g. 'TP: Temporary Operation'
   */
  private final String description;
  /**
   * Indicates whether the station is on or off air. TRUE means the station is
   * transmitting and should be protected.
   */
  private final boolean transmitting;

  private ECanadaBanner(String description, boolean transmitting) {
    this.description = description;
    this.transmitting = transmitting;
  }

  /**
   * @return Human readable description. e.g. 'TP: Temporary Operation'
   */
  public String getDescription() {
    return name() + ": " + description;
  }

  /**
   * @return Whether the banner code is transmitting (on-air) or not.
   */
  public boolean isTransmitting() {
    return transmitting;
  }
}
