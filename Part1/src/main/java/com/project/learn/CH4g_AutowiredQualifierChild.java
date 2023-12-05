package com.project.learn;

import com.project.logger.LogWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CH4g_AutowiredQualifierChild {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ch4g.xml");

        // do stuff ...
        Logger logger = context.getBean("logger", Logger.class);
        Date now = new Date();
        DateFormat formatter = new SimpleDateFormat("dd/M/yyyy");

        logger.console(formatter.format(now) + " successful write into console !");
        logger.file(formatter.format(now) + " successful write into file !");

        ((ClassPathXmlApplicationContext) context).close();
    }

    public static class Logger {

        private LogWriter consoleWriter;
        private LogWriter fileWriter;

        public Logger() {
        }

        @Autowired
        @Qualifier("console")
        public void setConsoleWriter(LogWriter consoleWriter) {
            this.consoleWriter = consoleWriter;
        }

        @Autowired
        @Qualifier("file")
        public void setFileWriter(LogWriter fileWriter) {
            this.fileWriter = fileWriter;
        }

        private void console(String str) {
            consoleWriter.write(str);
        }

        private void file(String str) {
            fileWriter.write(str);
        }
    }

}
