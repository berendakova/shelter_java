package utils;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import exceptions.DbException;

import java.io.*;
import java.util.List;

/**
 *
 */
public class DB {


    private final static String path = "users.csv";


    public static void addEntry(String db, String[] data) throws DbException {

        try {
            File f = new File("/home/tanya/IdeaProjects/shelter_v3/user.csv");
            FileWriter writer = new FileWriter(f,true);

            writer.write("\n"+data[0]+","+data[1]+","+data[2]);
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            throw new DbException();
        }
    }

    public static List<String[]> getAllEntries(String db) throws DbException {
        try {
            CSVReader reader = new CSVReader(new FileReader(path));
            return reader.readAll();
        } catch (IOException ex) {
            throw new DbException();
        }
    }
    }


