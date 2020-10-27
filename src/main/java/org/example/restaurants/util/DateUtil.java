package org.example.restaurants.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.SneakyThrows;

public class DateUtil {

  private static final String DATE_PATTERN = "yyyy-MM-dd";
  private static final ThreadLocal<DateFormat> THREAD_LOCAL = new ThreadLocal<>();

  @SneakyThrows
  public static Date parseString(String source) {
    return getFormat().parse(source);
  }

  private static DateFormat getFormat() {
    DateFormat dateFormat = THREAD_LOCAL.get();
    return dateFormat == null ? new SimpleDateFormat(DATE_PATTERN) : dateFormat;
  }
}
