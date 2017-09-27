/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import robocode.*;
import java.awt.Color;

/**
 *
 * @author asmat
 */
public class MyFirstRobot extends AdvancedRobot {

    public void run() {

        // Initialization of the robot should be put here
        // After trying out your robot, try uncommenting the import at the top,
        // and the next line:
        setColors(Color.red, Color.blue, Color.green); // body,gun,radar

        // Robot main loop
        while (true) {
            // Replace the next 4 lines with any behavior you would like
            double distance = Math.random() * 300;
            double angle = Math.random() * 45;
            turnGunRight(angle);
            fire(angle);
            fireBullet(angle);
            ahead(distance);
            turnGunLeft(angle);
            back(distance);
            turnGunRight(angle);
        }
    }

    /**
     * onScannedRobot: What to do when you see another robot
     */
    public void onScannedRobot(ScannedRobotEvent e) {
        // Replace the next line with any behavior you would like
        fire(1);
    }

    /**
     * onHitByBullet: What to do when you're hit by a bullet
     */
    public void onHitByBullet(HitByBulletEvent e) {
        // Replace the next line with any behavior you would like
        back(10);
    }

    /**
     * onHitWall: What to do when you hit a wall
     */
    public void onHitWall(HitWallEvent e) {
        // Replace the next line with any behavior you would like
        back(20);
        ahead(300);
        
    }

}
