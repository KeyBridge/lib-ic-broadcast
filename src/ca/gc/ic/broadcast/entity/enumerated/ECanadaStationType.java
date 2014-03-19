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
 * Enumerated values for the CanadaStation station_type field.
 * <p/>
 * @author jesse
 */
public enum ECanadaStationType {

  /**
   * AM Radio
   */
  AM("AM Radio"),
  /**
   * FM Radio
   */
  FM("FM Radio"),
  /**
   * Satellite Digital Audio Radio
   */
  SDAR("Satellite Digital Audio Radio"),
  /**
   * Broadcast Television
   */
  TV("Broadcast Television");
  private final String description;

  private ECanadaStationType(String description) {
    this.description = description;
  }

  /**
   * @return A human readable description. e.g. 'Satellite Digital Audio Radio'
   */
  public String getDescription() {
    return description;
  }

  /**
   * @return A dot-delimited name. e.g. 'ca.gc.ic.stationType.TV'
   */
  public String getNameDotDelimited() {
    return "ca.gc.ic.stationType." + name();
  }

  @Override
  public String toString() {
    return description;
  }
}
