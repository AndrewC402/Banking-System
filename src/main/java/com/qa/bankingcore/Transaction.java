package com.qa.bankingcore;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Transaction {
    private double amt;
    private Instant when = Instant.now();

    public Transaction(double amt) {
        this.amt = amt;
    }

    public double getAmt() {
        return amt;
    }

    public String getWhen() {
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.UK).withZone(ZoneId.systemDefault());
        when = Instant.now();
        String timeStamp = formatter.format(when);
        return timeStamp;
    }
}
