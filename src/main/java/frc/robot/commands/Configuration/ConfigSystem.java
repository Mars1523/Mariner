package frc.robot.commands.Configuration;

import java.util.List;

import edu.wpi.first.apriltag.AprilTag;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.SetpointConstants.OptionArrays;
import frc.robot.Constants.SetpointConstants.OptionArrays.ConfigOption;
import frc.robot.subsystems.AlgaeSub;
import frc.robot.subsystems.CoralArm;
import frc.robot.subsystems.Elevator;

public class ConfigSystem extends InstantCommand {

    int choice;
    List<ConfigOption> positionList;

    CoralArm coralArm;
    Elevator elevatorSub;
    AlgaeSub algaeSub;

    public ConfigSystem(List<ConfigOption> positionList, int choice, CoralArm coralArm, Elevator elevatorSub, AlgaeSub algaeSub) {

        addRequirements(coralArm);
        addRequirements(elevatorSub);
        addRequirements(algaeSub);

        this.positionList = positionList;
        this.coralArm = coralArm;
        this.elevatorSub = elevatorSub;
        this.algaeSub = algaeSub;

    }

    @Override
    public void execute() {
        ConfigOption configOption = positionList.get(choice);

        //coralArm.setCoralWristSetpoint(configOption.coralAngle);
        elevatorSub.setPosition(configOption.elevatorSetpoint);
        algaeSub.setAlgaeSetpoint(configOption.algaeAngle);
    }

    // public Command configureCommand(int choice){
    //     return run(() -> configure(choice));
    // }


}
