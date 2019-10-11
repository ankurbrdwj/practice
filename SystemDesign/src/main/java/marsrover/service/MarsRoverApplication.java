package marsrover.service;

import marsrover.domain.Rover;

import java.util.Scanner;

public class MarsRoverApplication {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int maxX=scan.nextInt();
        int maxY=scan.nextInt();
        int[][] plateau=new int[maxX][maxY];
        while(scan.hasNextLine()) {
            int posX = scan.nextInt();
            int posY = scan.nextInt();
            String direction = scan.next();
            String command = scan.next();
            Rover rover = new Rover(posX, posY, direction.charAt(0));
            RoverControlService service = new RoverControlService();
            rover = service.moverRover(rover, command);
            System.out.println(rover.toString());
        }
    }
}
