package metrodesign.service;

public class WeekendStrategy implements FareStrategy {
    @Override
    public String getName() {
        return "WEEKEND_STRATEGY";
    }

    @Override
    public double getFarePerStation() {
        return 5.50;
    }
}
