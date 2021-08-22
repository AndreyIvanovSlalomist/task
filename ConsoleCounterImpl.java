package ru.ivanov.task.consolecounter.impl;

import ru.ivanov.task.consolecounter.ConsoleCounter;
import ru.ivanov.task.logger.Logger;
import ru.ivanov.task.logger.impl.FileLoggerImpl;
import ru.ivanov.task.resultsender.ResultSender;
import ru.ivanov.task.resultsender.impl.ResultSenderImpl;
import ru.ivanov.task.textsplitter.TextSplitter;
import ru.ivanov.task.textsplitter.impl.TextSplitterImpl;
import ru.ivanov.task.textsupplier.TextSupplier;
import ru.ivanov.task.textsupplier.impl.TextSupplierImpl;
import ru.ivanov.task.wordcounter.WordCounter;
import ru.ivanov.task.wordcounter.impl.WordCounterImpl;

public class ConsoleCounterImpl implements ConsoleCounter {

    private static final Logger logger = new FileLoggerImpl();

    public void consoleCount(String url) {
        try {
            WordCounter wordCounter = prepareWordCounter(url);
            sendResult(wordCounter);
        } catch (Exception e) {
            logger.error(e);
        }
    }

    private WordCounter prepareWordCounter(String url) throws Exception {
        TextSupplier textSupplier = new TextSupplierImpl(url);
        TextSplitter textSplitter = new TextSplitterImpl();
        return new WordCounterImpl(textSupplier, textSplitter);
    }

    private void sendResult(WordCounter wordCounter) {
        ResultSender resultSender = new ResultSenderImpl();
        resultSender.send(wordCounter.getResult());
    }

}
