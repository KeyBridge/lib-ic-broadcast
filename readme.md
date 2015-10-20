Industry Canada BDBS Broadcast Data Extract (AM-FM-TV)
======================================================

This data source provides a cleaned and normalized version of the Industry Canada Broadcast (AM-FM-TV) database system, commonly called BDBS.

The BDBS database provides programmatic access to technical details for all licensed AM, FM, TV and SDAR transmitters approved for operation within Canada.

Data on applications under consideration is considered confidential by Industry Canada and is not available.

Background
---------- 
For purposes of protecting Canadian TV stations (serving locations wholly within Canada) from interference from unlicensed TV bands transmitting devices (TV white space devices), the TV white space database systems are to use Canadian TV station engineering data from Industry Canada’s licensing system rather than the Canadian records in the Commission’s Consolidated Database System (CDBS). (The Canadian station records in the CDBS contain data for internationally coordinated TV station agreements, which may not reflect actual station operations.) 

Schema Update
-------------
The logical data model XML schema is now included under docs/xsd.

In this v2.0.0 release we updated the BDBS logical data model to use Elements instead of Attributes. This is more in keeping with standard XML encoding strategies. However we did not invest the (significant) amount of time required to code each element to begin with a capital letter and each attribute to begin with a lower case letter, as is the standard. The v2.0.0 logical data model is closer but still does not 100% comport with XML encoding standard practice.

Images of the v2.0.0 software objects are available in docs/images.

Missing SDARS Data
------------ 
In 2013 Industry Canada ceased publication of SDARS data. The last version we retrieved (February 09, 2013) is included in the docs/data directory.

Home base
--------- 
Additional documentation about this project is available on the Key Bridge web site at https://keybridgeglobal.com. Look under the Data and Databases section for further details.

## Licensed under GPLv.3
Copyright (C) Key Bridge Global LLC 

This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License for more details.


