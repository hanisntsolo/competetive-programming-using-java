package com.competetive.excercism;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
//Static imports for less code
import static java.math.BigInteger.valueOf;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.abs;
import static java.lang.System.out;
//Utilities
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Random;
import java.util.HashMap;
import java.util.AbstractMap;
import java.util.Date;
public class LogLevels {

    public static String message(String logline) {
        return logline.split(":")[1].trim();
    }

    public static String logLevel(String logline) {
        return logline.split(":")[0].trim().substring(1, (logline.split(":")[0]).length() - 1).toLowerCase();
    }

    public static String reformat(String logline) {
        return logline.split(":")[1].trim() +" "+"("+ (logline.split(":")[0]).trim().substring(1, (logline.split(":")[0]).length() - 1).toLowerCase()+")";
    }

    public static void main(String[] args) {
        String one = LogLevels.logLevel("[ERROR]: Invalid operation");
        String two = LogLevels.message("[WARNING]:  Disk almost full\r\n");
        String three = LogLevels.reformat("[INFO]: Operation completed");
        out.println(one+two+three);
    }
}