package com.coding.ch01;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author racher
 */
public class Cmd {
    private boolean helpFlag;
    private boolean versionFlag;
    private String cpOption;
    private String className;
    private String[] args;

    public Cmd(boolean helpFlag, boolean versionFlag, String cpOption, String className, String[] args) {
        this.helpFlag = helpFlag;
        this.versionFlag = versionFlag;
        this.cpOption = cpOption;
        this.className = className;
        this.args = args;
    }

    public Cmd() {
    }

    public boolean isHelpFlag() {
        return helpFlag;
    }

    public boolean isVersionFlag() {
        return versionFlag;
    }

    public String getCpOption() {
        return cpOption;
    }

    public String getClassName() {
        return className;
    }

    public String[] getArgs() {
        return args;
    }

    @Override
    public String toString() {
        return "Cmd{" +
                "helpFlag=" + helpFlag +
                ", versionFlag=" + versionFlag +
                ", cpOption='" + cpOption + '\'' +
                ", className='" + className + '\'' +
                ", args=" + Arrays.toString(args) +
                '}';
    }

    @NotNull
    public static Cmd parseCmd(String[] args) {
        Cmd cmd = new Cmd();

        // 解析命令行参数
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            if (arg.equals("-help") || arg.equals("-?")) {
                cmd.helpFlag = true;
            } else if (arg.equals("-version")) {
                cmd.versionFlag = true;
            } else if (arg.equals("-classpath") || arg.equals("-cp")) {
                if (i + 1 < args.length) {
                    cmd.cpOption = args[++i];
                }
            } else {
                cmd.className = arg;
                cmd.args = new String[args.length - i - 1];
                System.arraycopy(args, i + 1, cmd.args, 0, cmd.args.length);
                break;
            }
        }

        return cmd;
    }

    public static void printUsage() {
        System.out.println("Usage: java Cmd [options] class [args...]");
        System.out.println("Options:");
        System.out.println("  -help    print help message");
        System.out.println("  -?       print help message");
        System.out.println("  -version print version and exit");
        System.out.println("  -classpath <path>  specify classpath");
        System.out.println("  -cp <path>         specify classpath");
    }
}
