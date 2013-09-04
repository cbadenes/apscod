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

public class AntennaStatistic {

    private final String id;

    private final int numCallsMade;

    private final int numCallsRecv;

    private final long durCallsRecv;

    private final long durCallsMade;

    public AntennaStatistic(String _id, int _numCallsMade, int _numCallsRecv, long _durCallsMade, long _durCallsRecv) {
        this.id = _id;
        this.numCallsMade = _numCallsMade;
        this.numCallsRecv = _numCallsRecv;
        this.durCallsMade = _durCallsMade;
        this.durCallsRecv = _durCallsRecv;
    }

    public String getId() {
        return id;
    }

    public int getNumCallsMade() {
        return this.numCallsMade;
    }

    public int getNumCallsRecv() {
        return this.numCallsRecv;
    }

    public long getDurCallsRecv() {
        return this.durCallsRecv;
    }

    public long getDurCallsMade() {
        return this.durCallsMade;
    }

}
