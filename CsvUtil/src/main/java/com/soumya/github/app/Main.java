package com.soumya.github.app;

import com.soumya.github.util.CsvUtils;
import com.soumya.github.vo.Product;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Read from csv
        List<Product> data = CsvUtils.csvReaderUtil(Product.class, "in/Product.csv");
        for(Product p: data){
            System.out.println(p);
        }

        //Write to csv
        String[] cols = {"maker", "id", "name"};
        CsvUtils.csvWriterUtil(Product.class, data, "in/Out.csv", cols);

    }
}
