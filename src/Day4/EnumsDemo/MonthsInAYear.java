package Day4.EnumsDemo;

public enum MonthsInAYear{
    JANUARY(31,3),
    FEBRUARY(29, 4),
    MARCH(31,5),
    APRIL(30,5),
    MAY(31,7),
    JUNE(30,9),
    JULY(31,10),
    AUGUST(31,6),
    SEPTEMBER(30,3),
    OCTOBER(31,2),
    NOVEMBER(30,1),
    DECEMBER(31,2);


    final int daysInAMonth;
    final int holidays;
    MonthsInAYear(int daysInAMonth, int holidays){
        this.daysInAMonth = daysInAMonth;
        this.holidays = holidays;
    }
}

