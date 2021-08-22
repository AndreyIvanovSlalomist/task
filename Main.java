package ru.ivanov.task;

import ru.ivanov.task.consolecounter.ConsoleCounter;
import ru.ivanov.task.consolecounter.impl.ConsoleCounterImpl;

public class Main {
    public static void main(String[] args) {
        ConsoleCounter consoleCounter = new ConsoleCounterImpl();
        consoleCounter.consoleCount(getUrl(args));
    }
    private static String getUrl(String[] args) {
        return args == null || args.length == 0
                ?"https://www.simbirsoft.com/"
                :args[0];
    }
}
