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

import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

import org.derefaz.d4d.antenna.AntennaInfo;
import org.derefaz.d4d.antenna.AntennaPositions;
import org.derefaz.d4d.reader.ARFFReader;
import org.derefaz.d4d.reader.LineHandler;

public class AreaDrivenData implements LineHandler {

    private final HashMap<String, AreaDrivenRow> areas;
    private final AntennaPositions positions;

    public AreaDrivenData(String _arrfPath, AntennaPositions _positions) throws IOException {
        this.areas = new HashMap<>();
        this.positions = _positions;
        ARFFReader reader = new ARFFReader();
        reader.read(_arrfPath, this);

    }

    @Override
    /**
     * @ATTRIBUTE ant_id NUMERIC
    @ATTRIBUTE num_calls NUMERIC
    @ATTRIBUTE num_calls_made NUMERIC
    @ATTRIBUTE num_calls_recv NUMERIC
    @ATTRIBUTE calls_type {made, received}
    @ATTRIBUTE mean_calls_made NUMERIC
    @ATTRIBUTE mean_calls_recv NUMERIC
    @ATTRIBUTE dur_calls_made NUMERIC
    @ATTRIBUTE dur_calls_recv NUMERIC
    @ATTRIBUTE dur_calls_type {made, received}
    @ATTRIBUTE mean_dur_calls_made NUMERIC
    @ATTRIBUTE mean_dur_calls_recv NUMERIC
     */
    public void load(StringTokenizer _tokenizer) {
        String antId = _tokenizer.nextToken();
        String numCalls = _tokenizer.nextToken();
        String numCallsMade = _tokenizer.nextToken();
        String numCallsRecv = _tokenizer.nextToken();
        _tokenizer.nextToken(); // calls_type
        _tokenizer.nextToken(); // mean_calls_made
        _tokenizer.nextToken(); // mean_calls_recv
        String durCallsMade = _tokenizer.nextToken(); // dur_calls_made
        String durCallsRecv = _tokenizer.nextToken(); // dur_calls_recv

        AntennaStatistic antenna = new AntennaStatistic(antId, Integer.valueOf(numCallsMade),
                Integer.valueOf(numCallsRecv), Long.valueOf(durCallsMade), Long.valueOf(durCallsRecv));

        AntennaInfo antennaInfo = this.positions.getInfo(antId);
        if (antennaInfo == null) {
            System.out.println("unknown antenna id: " + antId);
            return;
        }
        String areaId = antennaInfo.getAdminArea2();

        AreaDrivenRow area = this.areas.containsKey(areaId) ? this.areas.get(areaId) : new AreaDrivenRow(areaId);
        area.add(antenna);
        this.areas.put(areaId, area);
    }

    public void generate(String _baseDir) {
        try {
            String filePath = _baseDir + "/area_driven_data.arff";
            System.out.println("creating file: " + filePath + "...");
            FileOutputStream outputStream = new FileOutputStream(filePath);

            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(dataOutputStream));

            writer.write("% 1. Title: Area Driven Dataset\n");
            writer.write("% \n");
            writer.write("% 2. Sources:\n");
            writer.write("%      (a) Creator: C. Badenes\n");
            writer.write("%      (b) Antenna Driven Data\n");
            writer.write("%      (c) Orange D4D\n");
            writer.write("%      (d) Date: January, 2013\n");
            writer.write("% \n");
            writer.write("@RELATION area\n");
            writer.write("\n");
            writer.write("@ATTRIBUTE area {Abidjan, Niakaramandougou, Zuenoula, Bondoukou, Oume, Tabou, Issia, Seguela, Tiebissou-Department, Toumodi, Bia, Dimbokro, Adiake, Dimtokros, Divo, Ferkessedougou, Jaqueville-Department, Kadiolo, Tiassale, Gagnoa, Soubre, Agboville, Bocanda, Man, Odienne, Bouna, Beounm, Korhogo, Alepe, Grand-Bassam, M_bahiakro, San-Pedro, Danane, Yamoussoukro, Juabeso, Lakota, Mankono, Aboisso, Bangolo, Biankouma, Jomoro, Sinfra, Grand-Lahou, Guiglo, Dabakala, Agnibilekrou, null, Abengourou, Tanda, Katiola, Duekoue, Toulepleu, Bounfie, Daoukro, Sassandra, Yamoussourkro, Vavoua, Bongouanou, Tengrela, Bouake, Beoumi, Touba, Dabou, Adzope, Sakassou, Boundiali, Daloa}\n");
            writer.write("@ATTRIBUTE num_antennas NUMERIC\n");
            writer.write("@ATTRIBUTE num_calls NUMERIC\n");
            writer.write("@ATTRIBUTE num_calls_by_antenna NUMERIC\n");
            writer.write("@ATTRIBUTE num_calls_made NUMERIC\n");
            writer.write("@ATTRIBUTE num_calls_recv NUMERIC\n");
            writer.write("@ATTRIBUTE mean_dur_calls_made NUMERIC\n");
            writer.write("@ATTRIBUTE mean_dur_calls_recv NUMERIC\n");
            writer.write("\n");
            writer.write("@DATA\n");
            writer.write("\n");
            Integer index = 0;
            Integer limit = this.areas.keySet().size();
            for (String key : this.areas.keySet()) {
                System.out.println("write record [" + index++ + "|" + limit + "]");
                AreaDrivenRow data = this.areas.get(key);
                writer.write(data.getArea() + ",");
                writer.write(data.getNumAntenna() + ",");
                writer.write(data.getTotalCalls() + ",");
                writer.write(String.valueOf(data.getTotalCalls() / data.getNumAntenna()) + ",");
                writer.write(data.getNumCallsMade() + ",");
                writer.write(data.getNumCallsRecv() + ",");
                writer.write(data.getMeanCallsMade() + ",");
                writer.write(data.getMeanCallsRecv() + "");
                writer.write("\n");
            }
            writer.flush();
            dataOutputStream.flush();
            dataOutputStream.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
