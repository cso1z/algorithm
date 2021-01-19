package com.company.leetcode;

import com.company.leetcode.utils.Log;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<String> fileList = new ArrayList<>();

    public static void main(String[] args) {

        fileList.clear();
        File rootFile = new File("src/com/company/leetcode/algorithm");
        getFiles(rootFile);
        if (!fileList.isEmpty()) {
            for (String className : fileList) {
                try {
                    Class clazz = Class.forName(className);
                    Method setMethod = clazz.getDeclaredMethod("initData");
                    setMethod.invoke(clazz.newInstance());
                    Log.wrap();
                } catch (Exception e) {
                    Log.o("error:" + className);
                    e.printStackTrace();
                }
            }
        }
    }

    private static void getFiles(File file) {
        if (file.exists()) {
            File[] files = file.listFiles();
            if (null != files) {
                for (File file2 : files) {
                    if (file2.isDirectory()) {
                        getFiles(file2);
                    } else {
                        String name = file2.getPath();
                        fileList.add(name.substring(name.indexOf("com\\"), name.indexOf(".")).replace("\\", "."));
                        Log.wrap();
                    }
                }
            }
        }
    }
}
