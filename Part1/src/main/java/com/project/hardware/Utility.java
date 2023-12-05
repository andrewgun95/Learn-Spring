package com.project.hardware;


import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("util")
public class Utility {

    private Printer printer;
    private Scanner scanner;

    public Utility() {
    }

    @Resource(name = "print")
    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    @Resource(name = "scan")
    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public void print(String document) {
        if (printer == null)
            System.out.println("Printer not defined!");
        else
            printer.use(document);
    }

    public void scan(String document) {
        if (scanner == null)
            System.out.println("Scanner not defined!");
        else
            scanner.use(document);
    }

    @Override
    public String toString() {
        return "Utility{" +
                "printer=" + printer +
                ", scanner=" + scanner +
                '}';
    }
}
