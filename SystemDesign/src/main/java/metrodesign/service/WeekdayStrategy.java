package metrodesign.service;

public class WeekdayStrategy implements FareStrategy {
    @Override
    public String getName() {
        return "WEEKDAY_STRATEGY";
    }

    @Override
    public double getFarePerStation() {
        return 7.00;
    }
}
