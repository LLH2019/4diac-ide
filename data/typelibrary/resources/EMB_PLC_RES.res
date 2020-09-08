<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<!DOCTYPE FBType SYSTEM "http://www.holobloc.com/xml/LibraryElement.dtd">
<ResourceType Comment="Most basic resource for executing FB networks" Name="EMB_PLC_RES">
  <Identification Description="Copyright (c) 2020 TU Wien/ACIN&#13;&#10; &#13;&#10;This program and the accompanying materials are made&#13;&#10;available under the terms of the Eclipse Public License 2.0&#13;&#10;which is available at https://www.eclipse.org/legal/epl-2.0/&#13;&#10;&#13;&#10;SPDX-License-Identifier: EPL-2.0"
    Function="This resource provides the most basic functionality of an IEC 61131 resource, namely executing FBDs."/>
  <VersionInfo Author="Martin Melik Merkumians" Date="2020-09-17" Organization="TU Wien/ACIN" Version="1.0"/>
  <VarDeclaration Name="CYCLE_TIME" Type="TIME" InitialValue="T#100ms" Comment="Cycle Time of the PLC Resource, 0 means continuous mode" /> 
  <FBNetwork>
  </FBNetwork>
</ResourceType>