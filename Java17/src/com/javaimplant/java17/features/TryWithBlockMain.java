package com.javaimplant.java17.features;

import com.javaimplant.java17.features.interfaces.IConstants;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TryWithBlockMain implements IConstants {
    static void main() {
        System.out.println("App Name: " + APP_NAME);
        System.out.println("Version: " + VERSION);
        System.out.println("Paths: " + paths);
        System.out.println("User Home: " + USER_HOME);
        oldWay();
        newWay();
    }

    private static void newWay() {
        try (BufferedReader br = new BufferedReader(new FileReader(paths))) {
            int j = 0;
            StringBuilder jj = new StringBuilder();
            while ((j = br.read()) != -1) {
                jj.append((char) j);
            }
            System.out.println(jj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void oldWay() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(paths));
            int j = 0;
            StringBuilder jj = new StringBuilder();
            while ((j = br.read()) != -1) {
                jj.append((char) j);
            }
            System.out.println(jj);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
