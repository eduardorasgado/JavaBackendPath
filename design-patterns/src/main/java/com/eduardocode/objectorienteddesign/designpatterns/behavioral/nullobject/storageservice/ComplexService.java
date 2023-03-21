package com.eduardocode.objectorienteddesign.designpatterns.behavioral.nullobject.storageservice;

public class ComplexService {

    private String reportName;
    private StorageService storageService;

    public ComplexService(StorageService storageService) {
        this.storageService = storageService;
        reportName = "A Complex Report";
    }

    public ComplexService(String reportName, StorageService storageService) {
        this.reportName = reportName;
        this.storageService = storageService;
    }

    public void generateReport() {
        System.out.println("Starting a complex report build!");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Done with report..");
        storageService.save(new Report(reportName));
    }
}
