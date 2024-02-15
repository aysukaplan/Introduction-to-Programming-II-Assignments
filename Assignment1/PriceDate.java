import java.util.ArrayList;

public class PriceDate {
    private int day;
    private int month;
    private int year;

    public PriceDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public PriceDate(String dateString){
        //be careful about this split
        String[] sep = dateString.split("\\.");
        int _day = Integer.parseInt(sep[0]);
        int _month = Integer.parseInt(sep[1]);
        int _year = Integer.parseInt(sep[2]);
        this.day = _day;
        this.month = _month;
        this.year = _year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDateString(){
        //returns the date as a string
        //first element of arraylist is day second is month
        ArrayList<String> str = new ArrayList<>();
        if(String.valueOf(this.day).length() == 1){
            String day = "0" + String.valueOf(this.day);
            str.add(day);
        }
        else{
            str.add(String.valueOf(this.day));
        }
        if(String.valueOf(this.month).length() == 1){
            String mon = "0" + String.valueOf(this.month);
            str.add(mon);
        }
        else{
            str.add(String.valueOf(this.month));
        }

        return str.get(0) + "." + str.get(1) + "." + this.year;
    }
}

