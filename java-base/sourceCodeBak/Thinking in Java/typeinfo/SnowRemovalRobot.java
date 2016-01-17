package com.books.book03.typeinfo;
//: typeinfo/SnowRemovalRobot.java

import java.util.Arrays;
import java.util.List;

public class SnowRemovalRobot implements Robot {
    private String name;

    public SnowRemovalRobot(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Robot.Test.test(new SnowRemovalRobot("Slusher"));
    }

    public String name() {
        return name;
    }

    public String model() {
        return "SnowBot Series 11";
    }

    public List<Operation> operations() {
        return Arrays.asList(
                new Operation() {
                    public String description() {
                        return name + " can shovel snow";
                    }

                    public void command() {
                        System.out.println(name + " shoveling snow");
                    }
                },
                new Operation() {
                    public String description() {
                        return name + " can chip ice";
                    }

                    public void command() {
                        System.out.println(name + " chipping ice");
                    }
                },
                new Operation() {
                    public String description() {
                        return name + " can clear the roof";
                    }

                    public void command() {
                        System.out.println(name + " clearing roof");
                    }
                }
        );
    }
} /* Output:
Robot name: Slusher
Robot model: SnowBot Series 11
Slusher can shovel snow
Slusher shoveling snow
Slusher can chip ice
Slusher chipping ice
Slusher can clear the roof
Slusher clearing roof
*///:~
