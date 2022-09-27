
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAmount;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
//import java.time.temporal.Temporal;

/**
 *
 * @author
 */
public class Fechas {

    public static void main(String[] args) throws ParseException {

        /////////////////////////////////////////////////
        //LocalDate
        localDate();

        //LocalTime
        localTime();

        ////////////////////////////////////////
        //LocaldateTime
        localDateTime();

        //////////////////////////////////////////
        //Date
        date();

        ///////////////////////////////////////
        //Calendar
        calendar();

        /////////////////////////////////////
        //gregorian Calendar
        //gregorianCalendar();
        //////////////////////////////////
        //OffsetDateTime
        offSet();

    }

    private static void localDate() {

        ///Local date
        System.out.println("LocalDate///////////////////");
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);//fecha actual

        LocalDate localParse = LocalDate.parse("2018-02-01");
        System.out.println(localParse);//parseo de una fecha

        localParse = localParse.minusDays(2);
        System.out.println(localParse);

        localParse = localParse.plusYears(4);
        System.out.println(localParse);

        DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        String fecha = localDate.format(formater);
        System.out.println("dd MMMM yyyy = " + fecha);

        DateTimeFormatter formater2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("dd/MM/yyyy = " + localDate.format(formater2));

        DateTimeFormatter formater3 = DateTimeFormatter.ofPattern("dd/MM/yy");
        System.out.println("dd/MM/yy = " + localDate.format(formater3));

        DateTimeFormatter formater4 = DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy");
        System.out.println("EEEE, dd MMMM yyyy = " + localDate.format(formater4));

        DateTimeFormatter formater5 = DateTimeFormatter.ofPattern("E, dd MMM yyyy");
        System.out.println("E, dd MMM yyyy = " + localDate.format(formater5));

        DateTimeFormatter formater6 = DateTimeFormatter.ofPattern("yyyy");
        System.out.println("yyyy = " + localDate.format(formater6));

        System.out.println(localDate.getYear());

        LocalDate localfecha1 = LocalDate.parse("2022-07-19");
        LocalDate localfecha2 = LocalDate.parse("2022-08-19");
        TemporalAmount amount = Period.between(localfecha1, localfecha2);
        //Temporal temp = amount.addTo(localDate);
        System.out.println("resta de el tiempo entre las dos fechas 2022-07-19 y 2022-08-19 = " + localfecha1.minus(amount));
        System.out.println("diferencia dias " + amount.getUnits().get(1).getDuration().toDays());

        localfecha1 = localfecha1.minusDays(19);
        localfecha1 = localfecha1.minusMonths(7);
        //localfecha1 = localfecha1.minusYears(localfecha2.getYear());
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNacimiento = LocalDate.parse("28/09/1995", formatter);
        Period edad = Period.between(fechaNacimiento, LocalDate.now());
        System.out.println(String.format("%d años, %d meses y %d días",
        edad.getYears(),
        edad.getMonths(),
        edad.getDays()));

        System.out.println("resta 2022-07-19 menos 7 meses 19 dias = " + localfecha1);
        System.out.println("");
    }

    private static void localTime() {
        System.out.println("LocalTime//////////////////////");
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalTime localTimeParse = LocalTime.parse("06:45:32");
        System.out.println(localTimeParse);

        System.out.println(localTimeParse.minusMinutes(46));
        System.out.println(localTimeParse.plusMinutes(20));

        DateTimeFormatter formaterTime1 = DateTimeFormatter.ofPattern("hh:mm:ss");
        System.out.println("hh:mm:ss = " + localTime.format(formaterTime1));

        DateTimeFormatter formaterTime2 = DateTimeFormatter.ofPattern("kk:mm:ss a");
        System.out.println("kk:mm:ss = " + localTime.format(formaterTime2));

        DateTimeFormatter formaterTime3 = DateTimeFormatter.ofPattern("kk : mm : ss.SSSS a");
        System.out.println("kk : mm : ss.SSSS a = " + localTime.format(formaterTime3));

        DateTimeFormatter formaterTime4 = DateTimeFormatter.ofPattern("kk : mm ");
        System.out.println("kk : mm  = " + localTime.format(formaterTime4));

        LocalTime hora = LocalTime.now();
        DateTimeFormatter f = DateTimeFormatter.ofPattern("'Son las' h 'y' mm");
        System.out.println(hora.format(f));

        LocalTime localTime1 = LocalTime.parse("06:45:32");
        LocalTime localTime2 = LocalTime.parse("02:50:33");

        localTime1 = localTime1.minusHours(localTime2.getHour());
        localTime1 = localTime1.minusMinutes(localTime2.getMinute());
        localTime1 = localTime1.minusSeconds(localTime2.getSecond());

        System.out.println("06:45:32 menos 02:50:33 = " + localTime1);

        LocalTime localTime3 = LocalTime.parse("05:00:00");
        LocalTime localTime4 = LocalTime.parse("06:14:03");
        long hours = ChronoUnit.HOURS.between(localTime3, localTime4);
        long minutes = ChronoUnit.MINUTES.between(localTime3, localTime4) % 60;
        long seconds = ChronoUnit.SECONDS.between(localTime3, localTime4) % 60;
        System.out.println("El tiempo transcurrido de " + localTime3 + " a " + localTime4
                + " es de " + hours + " horas " + minutes
                + " minutos " + seconds + " segundos");

        LocalDateTime loDT = LocalDateTime.now();
        System.out.println("fecha hora " + loDT + " a hora " + loDT.toLocalTime());
        System.out.println("");
    }

    private static void localDateTime() {

        System.out.println("LocalDateTime//////////////////////");
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formaterTime = DateTimeFormatter.ofPattern("EEEE, dd / MMMM / yyyy  kk:mm:ss");
        System.out.println(localDateTime.format(formaterTime));

        DateTimeFormatter formaterTime2 = DateTimeFormatter.ofPattern("'el dia de hoy es' EEEE, dd / MMMM / yyyy 'a las' hh:mm:ss");
        System.out.println(localDateTime.format(formaterTime2));
        System.out.println(localDateTime);

        LocalDateTime localDateTime1 = LocalDateTime.parse("2018-05-11T22:14:00");
        LocalDateTime localDateTime2 = LocalDateTime.parse("2018-07-13T22:25:00");
        TemporalAmount amount = Period.between(localDateTime1.toLocalDate(), localDateTime2.toLocalDate());

        Long anios = amount.get(amount.getUnits().get(0));
        Long meses = amount.get(amount.getUnits().get(1));
        Long dias = amount.get(amount.getUnits().get(2));
        Long horas = (ChronoUnit.HOURS.between(localDateTime1, localDateTime2)) % 24;
        Long minutos = (ChronoUnit.MINUTES.between(localDateTime1, localDateTime2)) % 60;
        Long segundos = (ChronoUnit.SECONDS.between(localDateTime1, localDateTime2)) % 60;

        System.out.println("el tiempo transcurrido de " + localDateTime1 + " a " + localDateTime2
                + " es de " + anios + " años " + meses + " meses " + dias + " dias " + horas + " horas "
                + minutos + " minutos " + segundos + " segundos");

        //TemporalAmount amount = Period.between(localDateTime1.toLocalDate(), localDateTime2.toLocalDate());
        //System.out.println(amount.get(amount.getUnits().get(0)));
        LocalDate hoy = LocalDate.now();
        LocalTime ahora = LocalTime.now();
        LocalDateTime fecha = LocalDateTime.of(hoy, ahora);
        System.out.println(fecha);

        System.out.println("");

    }

    private static void date() {
        //Date 
        System.out.println("Date//////////////////////");
        Calendar cal = Calendar.getInstance();
        //cal.set(2017, 06, 29, 8, 30);
        Date date = cal.getTime();
        System.out.println(ZoneOffset.getAvailableZoneIds());
        TimeZone timeZone = TimeZone.getTimeZone("Mexico/BajaSur");
        SimpleDateFormat formatterWithTimeZone = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
        formatterWithTimeZone.setTimeZone(timeZone);
        String sDate = formatterWithTimeZone.format(date);
        System.out.println("La fecha hora " + timeZone.getID() + " is: " + sDate);

        TimeZone timeZone2 = TimeZone.getTimeZone("America/Chicago");
        formatterWithTimeZone.setTimeZone(timeZone2);
        sDate = formatterWithTimeZone.format(date);
        System.out.println("La fecha hora " + timeZone2.getID() + " is: " + sDate);

        System.out.println("");

    }

    private static void calendar() {

        System.out.println("Calendar//////////////////////");
        Calendar c = Calendar.getInstance();
        System.out.println(c);
        System.out.println(c.getTime());
        SimpleDateFormat formato1 = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
        System.out.println(formato1.format(c.getTime()));
        System.out.println("hora del dia " + c.get(Calendar.HOUR_OF_DAY));

        SimpleDateFormat formato2 = new SimpleDateFormat();
        formato2.setTimeZone(TimeZone.getTimeZone("Mexico/BajaSur"));
        System.out.println("cambio zona horaria " + c.getTimeZone().getID() + " " + formato2.format(c.getTime()));

        Calendar calendar2 = Calendar.getInstance(TimeZone.getTimeZone("Mexico/BajaSur"));
        //calendar2.setTimeZone(TimeZone.getTimeZone("Mexico/BajaSur"));
        System.out.println(calendar2.get(Calendar.HOUR_OF_DAY));
        System.out.println(calendar2.getTime());//se puede ver que el cambio de zona horaria no impacta a getTime

        calendar2.add(Calendar.HOUR, 1); //sumar horas
        System.out.println(calendar2.get(Calendar.HOUR_OF_DAY));

        calendar2.add(Calendar.HOUR_OF_DAY, -1);//restar horas
        System.out.println(calendar2.get(Calendar.HOUR_OF_DAY));

        Calendar c3 = Calendar.getInstance();
        Calendar c4 = Calendar.getInstance();
        c3.set(2018, 4, 5); //el mes se queda en el dia 30 por eso aumenta de mes
        System.out.println("sabe si la fecha es menor, mayor o igual " + c3.compareTo(c4));

        Long milisegundos = c4.getTimeInMillis() - c3.getTimeInMillis();
        milisegundos = milisegundos / 1000;
        int segundos = Integer.parseInt(milisegundos.toString());
        //c3.set(Calendar.SECOND, segundos);
        int minutos = segundos / 60;
        int horas = minutos / 60;
        int dias = horas / 24;
        System.out.println(c3.getTime() + " " + segundos + " " + minutos + " " + horas + " " + dias);
        System.out.println(c4.getTime());
        c4.set(Calendar.HOUR, -horas);
        System.out.println(c4.getTime());
        c4 = Calendar.getInstance();
        c4.add(Calendar.MONTH, 1);
        LocalDate localDate1 = LocalDate.of(c3.get(Calendar.YEAR), c3.get(Calendar.MONTH), c3.get(Calendar.DAY_OF_MONTH));
        LocalDate localDate2 = LocalDate.of(c4.get(Calendar.YEAR), c4.get(Calendar.MONTH), c4.get(Calendar.DAY_OF_MONTH));
        System.out.println("localdate " + localDate1);
        System.out.println("localdate2 " + localDate2);
        TemporalAmount temporal = Period.between(localDate1, localDate2);
        System.out.println("años transcurridos " + temporal.get(temporal.getUnits().get(0)) + " meses transcurridos " + temporal.get(temporal.getUnits().get(1)));
        System.out.println(c3.getTime().toString());

        System.out.println("");
    }

    private static void gregorianCalendar() {
        Calendar cal = Calendar.getInstance();

        /* Creating an object of
             GregorianCalendar Class */
        GregorianCalendar gcal = new GregorianCalendar();

        /* Displaying Current Date using
             Calendar Class */
        System.out.println("Calendar date: "
                + cal.getTime());

        /* Displaying Current Date using
             GregorianCalendar Class */
        System.out.println("Gregorian date: "
                + gcal.getTime());

    }

    private static void offSet() throws ParseException {

        System.out.println("/////////////////////////");
        OffsetDateTime offSetDateTime = OffsetDateTime.now();
        DateTimeFormatter formaterTime = DateTimeFormatter.ofPattern("EEEE, dd / MMMM / yyyy  kk:mm:ss");
        System.out.println(offSetDateTime.format(formaterTime));
        System.out.println("zona horaria " + offSetDateTime.getOffset());
        System.out.println(offSetDateTime);

        //OffsetDateTime date = OffsetDateTime.parse("2018-24-03T12:30:30+01:00");
        OffsetDateTime date = OffsetDateTime.parse("2022-09-01T13:05:53.396193100-05:00");
        System.out.println(date);

        OffsetDateTime offSetDateTimeParse = OffsetDateTime.of(LocalDateTime.parse("2018-05-11T22:14:03"), ZoneOffset.UTC);
        System.out.println(offSetDateTimeParse);

        //cambio de zona de horario
        OffsetDateTime offSetDateTimeHorario = OffsetDateTime.now(ZoneId.of("Mexico/BajaSur"));
        System.out.println(offSetDateTimeHorario);

        System.out.println(offSetDateTime.getLong(ChronoField.HOUR_OF_DAY));
        //TemporalAmount temporal = Period.between(LocalDate.MIN, LocalDate.MAX)

        LocalDate local = offSetDateTime.toLocalDate();
        LocalDate local2 = offSetDateTimeParse.toLocalDate();
        TemporalAmount amount = Period.between(local2, local);
        System.out.println("años transcurridos " + amount.get(amount.getUnits().get(0)));

        System.out.println("conversion a hora " + offSetDateTime.toLocalTime());
        System.out.println("conversiona a fecha hora " + offSetDateTime.toLocalDateTime());
        System.out.println("obtener dia del mes " + offSetDateTime.getDayOfMonth());
        System.out.println("obtener dia de la semana " + offSetDateTime.getDayOfWeek());
        System.out.println("obtener dia del año " + offSetDateTime.getDayOfYear());
        System.out.println("obtener dia el mes " + offSetDateTime.getMonth());

        System.out.println(offSetDateTime.toEpochSecond() - offSetDateTimeParse.toEpochSecond());

        Long minutos = (offSetDateTime.toEpochSecond() - offSetDateTimeParse.toEpochSecond()) / 60;
        Long horas = minutos / 60;

        System.out.println("horas " + horas);
        Long dias = horas / 24;
        System.out.println(dias);

        Long años = dias / 365;
        System.out.println(años);

        DateTimeFormatter formaterTime2 = DateTimeFormatter.ofPattern("yyyyMMdd");
        //System.out.println("formato " + formaterTime2.parse("20220227"));

        TemporalAccessor t = formaterTime2.parse("20220127");
        System.out.println(t.get(ChronoField.YEAR));
        System.out.println(t.get(ChronoField.MONTH_OF_YEAR));
        System.out.println(t.get(ChronoField.DAY_OF_MONTH));
        //System.out.println(t.get(ChronoField.HOUR_OF_DAY));
        //System.out.println(t.get(ChronoField.SECOND_OF_MINUTE));
        //System.out.println(t.get(ChronoField.MINUTE_OF_HOUR));

        LocalTime localTime = LocalTime.MIN;
        try {
            localTime = LocalTime.of(t.get(ChronoField.HOUR_OF_DAY), t.get(ChronoField.MINUTE_OF_HOUR), t.get(ChronoField.SECOND_OF_MINUTE));
        } catch (Exception e) {

        }
        LocalDate localdate = LocalDate.of(t.get(ChronoField.YEAR), t.get(ChronoField.MONTH_OF_YEAR), t.get(ChronoField.DAY_OF_MONTH));

        LocalDateTime localDateTime = LocalDateTime.of(localdate, localTime);

        OffsetDateTime offset = OffsetDateTime.of(localDateTime, ZoneOffset.UTC);

        System.out.println("fecha " + offset.getMonthValue());
        System.out.println("hora " + offset.getHour());
        //offSetDateParse = formaterTimeParse.parse("");

        System.out.println("20220127 convierte yyyyMMdd a " + convertidor("20220127", "yyyyMMdd"));

        System.out.println("2022012713 convierte yyyyMMddHH a "+convertidor("2022012713", "yyyyMMddHH"));

        System.out.println("20220127132214 convierte a yyyyMMddHHmmss "+convertidor("20220127132214", "yyyyMMddHHmmss"));

        System.out.println(LocalDateTime.parse("2018-05-11T22:14:03").toString()+" convierte yyyy-MM-dd'T'HH:mm:ss a "+convertidor(LocalDateTime.parse("2018-05-11T22:14:03").toString(), "yyyy-MM-dd'T'HH:mm:ss"));

        System.out.println(convertidor(LocalDateTime.now().toString(), "yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS"));

        System.out.println(convertidor(LocalTime.now().toString(), "HH:mm:ss.SSSSSSSSS").toLocalTime());

        System.out.println("132714 convierte HHmmss a "+convertidor("132714", "HHmmss").toLocalTime());

        OffsetDateTime offsetDate = OffsetDateTime.now();
        System.out.println("mes Ingles " + offsetDate.getMonth());
        System.out.println("mes español " + offsetDate.getMonth().getDisplayName(TextStyle.FULL, new Locale("es", "ES")));
        System.out.println("mes español primera letra " + offsetDate.getMonth().getDisplayName(TextStyle.NARROW, new Locale("es", "ES")));
        System.out.println("mes español primera letra " + offsetDate.getMonth().getDisplayName(TextStyle.NARROW_STANDALONE, new Locale("es", "ES")));
        System.out.println("mes español primera letra " + offsetDate.getMonth().getDisplayName(TextStyle.SHORT, new Locale("es", "ES")));
        //System.out.println("mes español primera letra "+offsetDate.getMonth().getDisplayName(TextStyle.SHORT_STANDALONE, new Locale("es", "ES")));

        String mesPrimerMayuscula = offsetDate.getMonth().getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
        String primeraLetraMayuscula = mesPrimerMayuscula.substring(0,1).toUpperCase() + mesPrimerMayuscula.substring(1,mesPrimerMayuscula.length());
        //mesPrimerMayuscula.replaceFirst(primeraLetraMayuscula);
        System.out.println("primera mayuscula " + primeraLetraMayuscula);

        //para sacar el nombre del mes en español al igual se puede hacer con localDate
        Month mes = LocalDate.now().getMonth();
        // Obtienes el nombre del mes 
        String nombre = mes.getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
        System.out.println("nombre con local Date "+nombre);
    }

    private static OffsetDateTime convertidor(String fecha, String patron) {
        DateTimeFormatter formaterTime2 = DateTimeFormatter.ofPattern(patron);

        TemporalAccessor temporal = formaterTime2.parse(fecha);
        LocalTime localTime = LocalTime.MIN;
        LocalDate localdate = LocalDate.MIN;
        try {
            localTime = LocalTime.of(temporal.get(ChronoField.HOUR_OF_DAY), temporal.get(ChronoField.MINUTE_OF_HOUR), temporal.get(ChronoField.SECOND_OF_MINUTE));
        } catch (Exception e) {

        }

        try {
            localdate = LocalDate.of(temporal.get(ChronoField.YEAR), temporal.get(ChronoField.MONTH_OF_YEAR), temporal.get(ChronoField.DAY_OF_MONTH));
        } catch (Exception e) {

        }

        LocalDateTime localDateTime = LocalDateTime.of(localdate, localTime);
        OffsetDateTime offset = OffsetDateTime.of(localDateTime, ZoneOffset.UTC);
        return offset;
    }

}
