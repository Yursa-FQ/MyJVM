package com.coding.ch01;

import java.util.Scanner;

/**
 * @author racher
 */

public class Main {
    public static void main(String[] args) {
        Cmd.printUsage();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        // 将用户输入的参数拆分为数组
        String[] inputArgs = input.split("\\s+");
        Cmd cmd = Cmd.parseCmd(inputArgs);

        if (cmd.isVersionFlag()) {
            System.out.println("version 0.0.1");
        } else if (cmd.isHelpFlag() || cmd.getClassName() == null || cmd.getClassName().isEmpty()) {
            Cmd.printUsage();
        } else {
            startJVM(cmd);
        }
    }

    public static void startJVM(Cmd cmd) {
        // 添加启动 JVM 的逻辑
        System.out.println("Starting JVM with class: " + cmd.getClassName());
        for (String arg : cmd.getArgs()) {
            System.out.println("Argument: " + arg);
        }
    }
}
