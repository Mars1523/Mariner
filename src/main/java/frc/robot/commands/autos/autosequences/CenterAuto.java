package frc.robot.commands.autos.autosequences;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.autos.AutoNav;
import frc.robot.commands.autos.CoralAutos;

public class CenterAuto extends SequentialCommandGroup {
    public CenterAuto() {
        addCommands(
        // new AutoNav(0), //go to reef side
        // aim and score coral
        // new AutoNav(0) //go to coral station
        // aim and intake coral
        // run to reef spot again
        // aim and score coral

        );
    }
}