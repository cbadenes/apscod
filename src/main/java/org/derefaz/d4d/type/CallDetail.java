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
package org.derefaz.d4d.type;

public class CallDetail {

    private int num;
    private long duration;
    private final int days;

    public CallDetail(int _days) {
        this.days = _days;
        this.num = 0;
        this.duration = 0;
    }

    public CallDetail incr(int _num, long _dur) {
        this.num += _num;
        this.duration += _dur;
        return this;
    }

    /**
     * @return the num
     */
    public int getNum() {
        return this.num;
    }

    /**
     * @return the duration
     */
    public long getDuration() {
        return this.duration;
    }

    public long getMeanDuration() {
        if (this.num == 0)
            return 0;
        return this.duration / this.num;
    }

    public int getMeanNum() {
        if (this.days == 0)
            return 0;
        return this.num / this.days;
    }

}
