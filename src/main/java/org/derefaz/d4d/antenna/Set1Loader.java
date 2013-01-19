package org.derefaz.d4d.antenna;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.StringTokenizer;
import java.util.TimeZone;

import org.derefaz.d4d.reader.LineHandler;

public class Set1Loader implements LineHandler {

    private final SimpleDateFormat dateFormatter;
    private final Calendar calendar;
    private AntennaDrivenData store;

    public Set1Loader() {
        this.dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        this.calendar = Calendar.getInstance(TimeZone.getTimeZone("Africa/Abidjan"));
    }

    @Override
    public void load(StringTokenizer _tokenizer) {
        String dateString = _tokenizer.nextToken() + "_" + _tokenizer.nextToken();
        String antOriId = _tokenizer.nextToken();
        String antTerId = _tokenizer.nextToken();
        String num = _tokenizer.nextToken();
        String dur = _tokenizer.nextToken();

        try {
            this.calendar.setTime(this.dateFormatter.parse(dateString));

            // numCallsMade
            AntennaDrivenRow antOri = this.store.exists(antOriId) ? this.store.get(antOriId) : new AntennaDrivenRow(
                    antOriId);
            antOri.incrCallsMade(calendar, Integer.valueOf(num), Long.valueOf(dur), antTerId);
            this.store.put(antOri);

            // numCallsReceived
            AntennaDrivenRow antTer = this.store.exists(antTerId) ? this.store.get(antTerId) : new AntennaDrivenRow(
                    antTerId);
            antTer.incrCallsReceived(calendar, Integer.valueOf(num), Long.valueOf(dur), antOriId);
            this.store.put(antTer);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public void setStore(AntennaDrivenData _store) {
        this.store = _store;
    }

    public static void main(String[] args) {
        String line = "2011-12-05 00:00:00     15      913     10      3008";
        StringTokenizer tokenizer = new StringTokenizer(line);

        Set1Loader loader = new Set1Loader();
        loader.setStore(new AntennaDrivenData());
        loader.load(tokenizer);
    }
}
