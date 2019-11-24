package gangoffour.classic.behavioral.command;

public class StopCommand implements CommandBase {
    private Car car;

    @Override
    public void execute() {
        System.out.println("Invoking Stop Car gangoffour.classic.behavioral.command.command");
        this.car.stop();
    }
}
