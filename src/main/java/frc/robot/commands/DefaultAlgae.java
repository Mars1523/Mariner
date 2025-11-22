package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.AlgaeArm;

public class DefaultAlgae extends Command {
    // controllers
    private final Joystick primaryJoy;
    private final XboxController secondaryController;
    AlgaeArm algaeSub;

    public DefaultAlgae(AlgaeArm algaeSub, Joystick primaryJoy,
            XboxController secondaryController) {
        addRequirements(algaeSub);
        this.primaryJoy = primaryJoy;
        this.algaeSub = algaeSub;
        this.secondaryController = secondaryController;
    }

    public void execute() {
        // when get button
        // intake until something detects the ball
        // then stop the motors and hold them there
        // when get outtake button
        // release until no ball is there anymore
        // then stop the motors
        // when get controllerjoystick y input
        // take Y input and apply that to the setpoint
        // we will need pid to keep the pivot motor upwards instead of it falling back
        // down
    }

}
