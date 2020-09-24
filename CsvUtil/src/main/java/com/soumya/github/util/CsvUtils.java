package com.soumya.github.util;

import com.opencsv.bean.*;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.soumya.github.vo.Product;

import java.io.*;
import java.util.List;

public class CsvUtils {

    public static <T> List<T> csvReaderUtil(Class<T> beanClass, String inFile){
        List<T> result = null;
        try{
            Reader reader = new BufferedReader(new FileReader(inFile));
            CsvToBean<T> csvReader = new CsvToBeanBuilder<T>(reader)
                    .withType(beanClass)
                    .build();
            result = csvReader.parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static <T> void csvWriterUtil(Class<T> beanClass, List<T> data, String outputFile, String[] columMapping){
        try{
            Writer writer = new BufferedWriter(new FileWriter(outputFile));
            ColumnPositionMappingStrategy<T> strategy = new ColumnPositionMappingStrategy<>();
            strategy.setType(beanClass);
            strategy.setColumnMapping(columMapping);
            StatefulBeanToCsv<T> statefulBeanToCsv =new StatefulBeanToCsvBuilder<T>(writer)
                    .withMappingStrategy(strategy)
                    .build();
            writer.write(String.join(",",columMapping)+"\n");
            statefulBeanToCsv.write(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        } catch (CsvDataTypeMismatchException e) {
            e.printStackTrace();
        }
    }

}
