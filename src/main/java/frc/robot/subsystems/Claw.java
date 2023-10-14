// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Claw extends SubsystemBase {
  /** Creates a new Claw. */
  private final CANSparkMax m_Claw = new CANSparkMax(101, MotorType.kBrushless);
  private final RelativeEncoder ClawEncoder = m_Claw.getEncoder();
  
  public Claw() {
    ClawEncoder.setPosition(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Claw", ClawEncoder.getPosition());
  }

  public void SetHandSpeed(double speed) {
    m_Claw.set(speed);
  }
  
  public Command SetHandSpeedCommand(double speed) {
    return new StartEndCommand(() -> this.SetHandSpeed(speed), () -> this.SetHandSpeed(0), this);
  }

}

