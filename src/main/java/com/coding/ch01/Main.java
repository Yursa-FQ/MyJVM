package com.coding.ch01;

/**
 * @author racher
 */

public class Main {
    public static void main(String[] args) {
        Cmd cmd = Cmd.parseCmd(args);

        if (cmd.isVersionFlag()) {
            System.out.println("version 0.0.1");
        } else if (cmd.isHelpFlag() || cmd.getClassName() == null || cmd.getClassName().isEmpty()) {
            Cmd.printUsage();
        } else {
            startJVM(cmd);
        }
    }

    public static void startJVM(Cmd cmd) {
        // 这里可以添加启动 JVM 的逻辑
        System.out.println("Starting JVM with class: " + cmd.getClassName());
        for (String arg : cmd.getArgs()) {
            System.out.println("Argument: " + arg);
        }
    }
}
