package com.exalt;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
 


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
 
 
public class JavaCallJasperReport {
 
    public static void main(String[] args) throws JRException,
            ClassNotFoundException, SQLException {
 
        String reportSrcFile = "D:/Sample_Country.jrxml";
         
        // First, compile jrxml file.
        JasperReport jasperReport =    JasperCompileManager.compileReport(reportSrcFile);
 
        Connection conn = ConnectionUtils.getConnection();
 
        // Parameters for report
        // Map<String, Object> parameters = new HashMap<String, Object>();
        
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("Country_Name", "India");
        
        JasperPrint print = JasperFillManager.fillReport(jasperReport,parameters, conn);
 
        // Make sure the output directory exists.
        File outDir = new File("D:/jasperoutput");
        outDir.mkdirs();
 
        // PDF Exportor.
        JRPdfExporter exporter = new JRPdfExporter();
 
        ExporterInput exporterInput = new SimpleExporterInput(print);
        // ExporterInput
        exporter.setExporterInput(exporterInput);
 
        // ExporterOutput
        OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(
                "D:/jasperoutput/CountryDetailsReport3.pdf");
        // Output
        exporter.setExporterOutput(exporterOutput);
 
        //
        SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
        exporter.setConfiguration(configuration);
        exporter.exportReport();
 
        System.out.print("Done!");
    }
}
