/**********************************************************************
 * 
 * Copyright (c) 2013 Carlos Badenes (cbadenes@gmail.com) .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 * 
 * @author cbadenes@gmail.com - initial API and implementation
 * @date Jan 19, 2013
 **********************************************************************/
package org.derefaz.d4d.area;

import java.util.HashMap;

public class AreaDrivenRow {

    private final String area;
    private final HashMap<String, AntennaStatistic> antennas;
    private long numCallsMade;
    private long numCallsRecv;
    private long durCallsMade;
    private long durCallsRecv;

    public AreaDrivenRow(String _area) {
        this.area = _area;
        this.antennas = new HashMap<>();
        this.numCallsMade = 0;
        this.numCallsRecv = 0;
        this.durCallsMade = 0;
        this.durCallsRecv = 0;
    }

    public AreaDrivenRow add(AntennaStatistic _antenna) {
        if (this.antennas.containsKey(_antenna.getId()))
            System.out.println("[ERROR] Duplicated antenna id: " + _antenna.getId());
        this.antennas.put(_antenna.getId(), _antenna);
        this.numCallsMade += _antenna.getNumCallsMade();
        this.numCallsRecv += _antenna.getNumCallsRecv();
        this.durCallsMade += _antenna.getDurCallsMade();
        this.durCallsRecv += _antenna.getDurCallsRecv();
        return this;
    }

    public int getNumAntenna() {
        return this.antennas.keySet().size();
    }

    public long getNumCallsMade() {
        return this.numCallsMade;
    }

    public long getNumCallsRecv() {
        return this.numCallsRecv;
    }

    public long getMeanCallsMade() {
        return this.durCallsMade / this.numCallsMade;
    }

    public long getMeanCallsRecv() {
        return this.durCallsRecv / this.numCallsRecv;
    }

    public long getTotalCalls() {
        return this.numCallsMade + this.numCallsRecv;
    }

    public String getArea() {
        return this.area;
    }
}
