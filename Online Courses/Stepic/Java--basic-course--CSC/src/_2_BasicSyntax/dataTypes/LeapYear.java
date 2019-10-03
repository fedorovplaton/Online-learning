package _2_BasicSyntax.dataTypes;

public class LeapYear {
    public static void main(String[] args) {
        System.out.println(leapYearCount(1));
    }
    public static int leapYearCount(int year) {
        return ((year % 100) / 4) + (((year - (year % 100)) / 100) / 4) * 97 + ((year - (year % 100)) / 100) % 4 * 24;
    }
}
