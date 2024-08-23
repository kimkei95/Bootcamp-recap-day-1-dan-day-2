package Day4.EnumsDemo;

public class Main {
    public static void main(String[] args) {
        MonthsInAYear month = MonthsInAYear.APRIL;

        System.out.println(month);
        for (MonthsInAYear months : MonthsInAYear.values()){
            System.out.println(months);
        }
        System.out.println("total hari di bulan januari: "+ MonthsInAYear.JANUARY.daysInAMonth);
        int totalHolidays =0;
        for (MonthsInAYear holiday : MonthsInAYear.values()){
            System.out.println(holiday.name()+ " memiliki "+ holiday.holidays+ " hari libur");
            totalHolidays+=holiday.holidays;
        }
        System.out.println("total number og holidays in a year: "+ totalHolidays);
    }


}

