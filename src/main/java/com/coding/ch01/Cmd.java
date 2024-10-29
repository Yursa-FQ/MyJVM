package com.coding.ch01;


import java.util.Arrays;

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

}
