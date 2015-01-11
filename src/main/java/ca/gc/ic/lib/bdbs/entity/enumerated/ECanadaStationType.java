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
  /**
   * A human readable description. e.g. 'Satellite Digital Audio Radio'
   */
  private final String description;

  private ECanadaStationType(String description) {
    this.description = description;
  }

  public String getName() {
    return name();
  }

  /**
   * Get a human readable description. e.g. 'Satellite Digital Audio Radio'
   * <p>
   * @return a non-null, non-empty String
   */
  public String getDescription() {
    return description;
  }

  @Override
  public String toString() {
    return name() + " - " + description;
  }
}
