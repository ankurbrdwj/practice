package gangoffour.classic.behavioral.command;

import gangoffour.classic.behavioral.command.CommandBase;

public class MoveCommand implements CommandBase {
private Car car;
    @Override
    public void execute() {
        System.out.println("Invoking Move Car Command");
        this.car.move();
    }
}
