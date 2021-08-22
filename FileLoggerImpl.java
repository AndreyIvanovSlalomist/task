package ru.ivanov.task.logger.impl;

import org.codehaus.plexus.util.ExceptionUtils;
import ru.ivanov.task.logger.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.logging.SimpleFormatter;

public class FileLoggerImpl implements Logger {
    private final String FILE_NAME = "log.txt";
    private final String ERROR = "ERROR";
    private final String INFO = "INFO";
    private final String WARNING = "WARNING";



    @Override
    public void info(Exception exception) {
        write(INFO, exception);
    }

    @Override
    public void error(Exception exception) {
        write(ERROR, exception);
    }

    @Override
    public void warning(Exception exception) {
        write(WARNING, exception);
    }

    private void write(String s, Exception exception) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)){
            writer.write(getLogMessage(s, exception));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getLogMessage(String s, Exception exception) {
         return getFormatDate() + " " + s + " " + exception.getLocalizedMessage() + "\n " + ExceptionUtils.getStackTrace(exception);
    }

    private String getFormatDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SSSSSS");
        return simpleDateFormat.format(System.currentTimeMillis());

    }
}
