package com.example.kosta.fileexam01;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by kosta on 2017-04-25.
 */

public class FileManager {

    private static final String FILE_NAME = "data.txt";
    private Context context;

    public FileManager(Context context) {
        this.context = context;
    }

    public void save(String saveData) {
        if(saveData == null || saveData.isEmpty()) {
            return;
        }

        FileOutputStream fout = null;

        try {
            fout = context.openFileOutput(FILE_NAME, context.MODE_PRIVATE);
            fout.write(saveData.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fout != null) fout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String load() {
        FileInputStream fin = null;
        String data = null;

        try {
            fin = context.openFileInput(FILE_NAME);

            byte[] loadData = new byte[fin.available()];
            fin.read(loadData);
            data = new String(loadData);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fin != null) fin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    public void delete() {
        context.deleteFile(FILE_NAME);
    }
}
