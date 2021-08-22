package ru.ivanov.task.logger;

public interface Logger {
    void info(Exception exception);
    void error(Exception exception);
    void warning(Exception exception);
}
