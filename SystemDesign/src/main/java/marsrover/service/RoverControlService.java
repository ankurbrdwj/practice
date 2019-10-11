package marsrover.service;

import marsrover.domain.Rover;

public class RoverControlService {

    public Rover moverRover(Rover rover, String command) {
        char[] array = command.toCharArray();
        for (char c : array) {
            switch (c) {
                case 'M':
                    if (rover.getDirection() == 'N') {
                        rover.setyCoordinate(rover.getyCoordinate() + 1);
                    }
                    if (rover.getDirection() == 'S') {
                        rover.setyCoordinate(rover.getyCoordinate() - 1);
                    }
                    if (rover.getDirection() == 'E') {
                        rover.setxCoordinate(rover.getxCoordinate() - 1);
                    }
                    if (rover.getDirection() == 'W') {
                        rover.setxCoordinate(rover.getxCoordinate() + 1);
                    }
                    break;
                case 'L':
                    if (rover.getDirection() == 'N') {
                        rover.setDirection('E');
                    }
                    if (rover.getDirection() == 'S') {
                        rover.setDirection('W');
                    }
                    if (rover.getDirection() == 'E') {
                        rover.setDirection('S');
                    }
                    if (rover.getDirection() == 'W') {
                        rover.setDirection('N');
                    }
                    break;
                case 'R':
                    if (rover.getDirection() == 'N') {
                        rover.setDirection('W');
                    }
                    if (rover.getDirection() == 'S') {
                        rover.setDirection('E');
                    }
                    if (rover.getDirection() == 'E') {
                        rover.setDirection('N');
                    }
                    if (rover.getDirection() == 'W') {
                        rover.setDirection('S');
                    }
                default:

            }
        }
        return rover;
    }

}
