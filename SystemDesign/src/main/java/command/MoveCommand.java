package command;

public class MoveCommand implements CommandBase{
private Car car;
    @Override
    public void execute() {
        System.out.println("Invoking Move Car Command");
        this.car.move();
    }
}
