package com.company;

import java.util.*;

public class Main {

    class DivisionByZeroException extends ArithmeticException {

    }

    public static void main(String []args){
        String arg1 = "";
        String arg2 = "";
        Integer arg1num = 0;
        Integer arg2num = 0;
        Integer output = 0;
        Integer index;
        boolean isArg1Empty, isArg2Empty;

        List<String> args2 = Arrays.asList(args);

        for(int i = 0; i < args.length; i++) {

            String str = args[i];

            isArg1Empty = arg1.isEmpty();
            isArg2Empty = arg2.isEmpty();

            if(!isArg1Empty) {
                arg1num = Integer.parseInt(arg1);
            }

            if(!isArg2Empty) {
                arg2num = Integer.parseInt(arg2);
            }

            if(args2.contains("*")) {
                index = args2.indexOf("*");
                if(isArg1Empty) {
                    arg1num = Integer.parseInt(args[i + 1]);
                }
                arg2num = Integer.parseInt(args[index + 1]);
                arg1num = Integer.parseInt(args[index - 1]);
                output *= arg1num * arg2num;
                continue;
            }

            if(args2.contains("/")) {
                index = args2.indexOf("/");
                if(isArg1Empty) {
                    arg1num = Integer.parseInt(args[i + 1]);
                }
                arg2num = Integer.parseInt(args[index + 1]);
                arg1num = Integer.parseInt(args[index - 1]);
                output /= arg1num / arg2num;
                continue;
            }

            switch (str) {
                case "+":
                    if(isArg1Empty) {
                        arg1num = Integer.parseInt(args[i + 1]);
                    }
                    output += arg1num + arg2num;
                    break;
                case "-":
                    if(isArg1Empty) {
                        arg1num = Integer.parseInt(args[i + 1]);
                    }
                    output -= arg1num - arg2num;
                    break;
                default:
                    if(isArg2Empty) arg2 = str;
                    else arg1 = str;
                    break;
            }
        }

        System.out.println(output);
    }
}
