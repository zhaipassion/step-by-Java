/**
 *
 */
package com.bob.enumeration;

/**
 * @author Bob
 */
public enum LightColor {
    RED("RedLight", 1), YELLOW("YellowLight", 2), GREEN("GreenLight", 3); //Attention please, here is the ";" ,not ","

    private String lightName;
    private Integer innerNum;

    private LightColor(String lightName, Integer innerNum) {    // Construction always "private",remind it.
        this.lightName = lightName;
        this.innerNum = innerNum;
    }

    public String toString() {
        return "lightName is : " + this.lightName + "innerNum is : " + this.innerNum;
    }
}
