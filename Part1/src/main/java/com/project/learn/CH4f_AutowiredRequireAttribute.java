package com.project.learn;

import com.project.logger.ConsoleWriter;
import com.project.logger.FileWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CH4f_AutowiredRequireAttribute {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ch4f.xml");

        // do stuff ...
        Logger logger = context.getBean("logger", Logger.class);
        Date now = new Date();
        DateFormat formatter = new SimpleDateFormat("dd/M/yyyy");

        logger.console(formatter.format(now) + " successful write into console !");
        logger.file(formatter.format(now) + " successful write into file !");

        ((ClassPathXmlApplicationContext) context).close();
    }


    public static class Logger {

        private ConsoleWriter consoleWriter;
        private FileWriter fileWriter;

        public Logger() {
        }

        // by default auto wired is require, mean all bean dependency must defined in xml config
        @Autowired
        public void setConsoleWriter(ConsoleWriter consoleWriter) {
            this.consoleWriter = consoleWriter;
        }

        // set to not require, mean its okay when bean dependency not defined in xml config
        @Autowired(required = false)
        public void setFileWriter(FileWriter fileWriter) {
            this.fileWriter = fileWriter;
        }

        private void console(String str) {
            if (consoleWriter == null)
                System.out.println("consoleWriter not defined !");
            else
                consoleWriter.write(str);
        }

        private void file(String str) {
            if (fileWriter == null)
                System.out.println("fileWriter not defined !");
            else
                fileWriter.write(str);
        }
    }

}
