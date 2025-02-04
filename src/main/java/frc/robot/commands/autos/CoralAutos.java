package frc.robot.commands.autos;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CoralArm;

public class CoralAutos {

    public class AutoIntakeCoral extends Command {
        private CoralArm coralArm = new CoralArm();

        AutoIntakeCoral(CoralArm coralArm) {
            addRequirements(coralArm);
            this.coralArm = coralArm;
        }

        @Override
        public void execute() {
            coralArm.intakeCoral();
        }

        @Override
        public void end(boolean interrupted) {
            coralArm.stopCoralRoller();
        }

        @Override
        public boolean isFinished() {
            return coralArm.hasCoral();
        }
    }

    public class AutoScoreCoral extends Command {
        private CoralArm coralArm = new CoralArm();

        public AutoScoreCoral(CoralArm coralArm) {
            addRequirements(coralArm);
            this.coralArm = coralArm;
        }

        @Override
        public void execute() {
            coralArm.releaseCoral();
        }

        @Override
        public void end(boolean interrupted) {
            coralArm.stopCoralRoller();
        }

        @Override
        public boolean isFinished() {
            return !coralArm.hasCoral();
        }
    }

}
