package frc.robot.commands;

import java.util.Optional;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.path.PathConstraints;

import edu.wpi.first.apriltag.AprilTagFieldLayout;
import edu.wpi.first.apriltag.AprilTagFields;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Transform2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj2.command.Command;

public class GoTo{
    
    public int reefNTagID;
    public int reefNETagID;
    public int reefNWTagID;
    public int reefSTagID;
    public int reefSETagID;
    public int reefSWTagID;
    public int csLeftTagID;
    public int csRightTagID;
    public int processorTagID;

    Optional<Alliance> alliance = DriverStation.getAlliance();

    public GoTo(){
        if (alliance.isPresent()){
            if(alliance.get() == Alliance.Red){
                reefNTagID = 0;
                reefNETagID = 0;
                reefNWTagID = 0;
                reefNTagID = 0;
                reefNETagID = 0;
                reefNWTagID = 0;
                csLeftTagID = 0;
                csRightTagID = 0;
                processorTagID = 0;
            }
            if(alliance.get() == Alliance.Blue){
                reefNTagID = 0;
                reefNETagID = 0;
                reefNWTagID = 0;
                reefNTagID = 0;
                reefNETagID = 0;
                reefNWTagID = 0;
                csLeftTagID = 0;
                csRightTagID = 0;
                processorTagID = 0;
            }
        }
        else{
            reefNTagID = 0;
            reefNETagID = 0;
            reefNWTagID = 0;
            reefNTagID = 0;
            reefNETagID = 0;
            reefNWTagID = 0;
            csLeftTagID = 0;
            csRightTagID = 0;
            processorTagID = 0;
        }
    }   

    public PathConstraints constraints = new PathConstraints(1.75, 2, 360, 360);


    private Pose2d inFrontOfTag(int id){
        Transform2d rot180 = new Transform2d(Translation2d.kZero, Rotation2d.k180deg);
        var field = AprilTagFieldLayout.loadField(AprilTagFields.k2025ReefscapeWelded);
        var tag = field.getTagPose(id).get().toPose2d();
        var offset = new Transform2d(1, 0, new Rotation2d());
        Pose2d infrontOfTag = tag.plus(offset).transformBy(rot180);
        return infrontOfTag;
    }


    public Command reefN(){
        return AutoBuilder.pathfindToPose(inFrontOfTag(reefNTagID), constraints);
    }
    public Command reefNE(){
        return AutoBuilder.pathfindToPose(inFrontOfTag(reefNETagID), constraints);
    }
    public Command reefNW(){
        return AutoBuilder.pathfindToPose(inFrontOfTag(reefNWTagID), constraints);
    }
    public Command reefS(){
        return AutoBuilder.pathfindToPose(inFrontOfTag(reefSTagID), constraints);
    }
    public Command reefSE(){
        return AutoBuilder.pathfindToPose(inFrontOfTag(reefSETagID), constraints);
    }
    public Command reefSW(){
        return AutoBuilder.pathfindToPose(inFrontOfTag(reefSWTagID), constraints);
    }
    public Command coralStationLeft(){
        return AutoBuilder.pathfindToPose(inFrontOfTag(csLeftTagID), constraints);
    }
    public Command coralStationRight(){
        return AutoBuilder.pathfindToPose(inFrontOfTag(csRightTagID), constraints);
    }
    public Command processor(){
        return AutoBuilder.pathfindToPose(inFrontOfTag(processorTagID), constraints);
    }
    public Command testTag8(){
        return AutoBuilder.pathfindToPose(inFrontOfTag(8), constraints);
    }
    
}
