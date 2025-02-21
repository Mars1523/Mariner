package frc.robot.commands.Configuration;

import java.util.List;

import edu.wpi.first.apriltag.AprilTag;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.SetpointConstants.Options;
import frc.robot.Constants.SetpointConstants.ConfigOption;
import frc.robot.subsystems.AlgaeArm;
import frc.robot.subsystems.CoralArm;
import frc.robot.subsystems.Elevator;

public class ConfigSystem extends InstantCommand{

    int choice;

    CoralArm coralArm;
    Elevator elevatorSub;
    AlgaeArm algaeArm;
    Options options;
    ConfigOption configOption;

    public ConfigSystem(ConfigOption configOption, CoralArm coralArm, Elevator elevatorSub, AlgaeArm algaeArm) {

        addRequirements(coralArm);
        addRequirements(elevatorSub);
        addRequirements(algaeArm);

        
        this.coralArm = coralArm;
        this.elevatorSub = elevatorSub;
        this.algaeArm = algaeArm;
        this.configOption = configOption;

    }

    @Override
    public void execute() {
    
        coralArm.setCoralWristSetpoint(configOption.coralAngle);
        elevatorSub.setPosition(configOption.elevatorSetpoint);
        algaeArm.setAlgaeSetpoint(configOption.algaeAngle);
    }

    // public Command configureCommand(int choice){
    //     return run(() -> configure(choice));
    // }


}
