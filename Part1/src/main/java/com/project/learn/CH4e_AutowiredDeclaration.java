package com.project.learn;

import com.project.logger.ConsoleWriter;
import com.project.logger.FileWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CH4e_AutowiredDeclaration {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ch4e.xml");

        // do stuff ...
        Logger logger = context.getBean("logger", Logger.class);
        Date now = new Date();
        DateFormat formatter = new SimpleDateFormat("dd/M/yyyy");

        logger.console(formatter.format(now)  + " successful write into console !");
        logger.error(formatter.format(now)  + " error, something wrong with write into file !");
        logger.file(formatter.format(now) + " successful write into file !");

        ((ClassPathXmlApplicationContext) context).close();
    }

    public static class Logger {

        private ConsoleWriter consoleWriter; // have two ConsoleWriter type, must define exact name as the bean configuration

        // auto wired on properties, work even doesn't have setter
        @Autowired
        private ConsoleWriter errorWriter;

        private FileWriter fileWriter;

        public Logger() {
        }

        // auto wired on constructor
        @Autowired
        public Logger(ConsoleWriter consoleWriter, ConsoleWriter errorWriter) {
            this.consoleWriter = consoleWriter;
            this.errorWriter = errorWriter;
        }

        // auto wired on setter
        @Autowired
        public void setWriterAsFile(FileWriter fileWriter) { // there is only one FileWriter type, not necessary define exact name on setter
            this.fileWriter = fileWriter;
        }

        private void console(String str) {
            consoleWriter.write(str);
        }

        private void error(String str){
            errorWriter.write(str);
        }

        private void file(String str) {
            fileWriter.write(str);
        }
    }

}
