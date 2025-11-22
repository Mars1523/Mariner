package frc.robot.commands;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClimbSub;



public class DefaultClimb extends Command {
    private final Joystick primaryJoy;
    private final XboxController secondaryController;
    ClimbSub climbSub;

    public DefaultClimb(ClimbSub climbSub, Joystick primaryJoy,
            XboxController secondaryController) {
        addRequirements(climbSub);
        this.climbSub = climbSub;
        this.primaryJoy = primaryJoy;
        this.secondaryController = secondaryController;
    }



    // when get some button. Arm down.
}
