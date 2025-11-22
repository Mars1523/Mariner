package frc.robot.commands.autos.AutoSequences;

import java.io.SequenceInputStream;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.autos.AutoDrive;
import frc.robot.subsystems.SwerveSubsystem;

public class Forward extends SequentialCommandGroup {

    SwerveSubsystem swerveSub;

    public Forward(SwerveSubsystem swerveSub) {
        this.swerveSub = swerveSub;
        addCommands(new AutoDrive(swerveSub, 2, 0.5));
    }
}
