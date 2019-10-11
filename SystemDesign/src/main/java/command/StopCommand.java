package command;

public class StopCommand implements CommandBase {
    private Car car;
    @Override
    public void execute() {
        System.out.println("Invoking Stop Car command");
        this.car.stop();
    }
}
