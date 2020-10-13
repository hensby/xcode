package antra.countFile;

import antra.FolderNotFoundException;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class countFiles {
    public static void countFiles(Criteria criteria) throws Exception{
        String path = criteria.getFolderPath();
        boolean include = criteria.getIncludeSubfolder();
        try {
            File file = new File(path);  // get file list where the path has
            File[] array = file.listFiles();  // get the folder list
            if(array == null || array.length == 0) {
                throw new FolderNotFoundException("file Not found");
            }
            String[] fileNames = new String[array.length];
            Set<String> extenSet = new HashSet<String>();
            if(!include) {
                int count = 0;
                for (File name : array) {
                    if (name.isFile()) {
                        String tmp[] = name.toString().split("/");
                        String[] fileName = tmp[tmp.length - 1].split("\\.");
                        fileNames[count++] = fileName[0];
                        extenSet.add(fileName[1]);
                    }
                }
                System.out.println("There are " + count + " file(s) inside folder {" + path + "} with extension" + extenSet.toString());

            } else {
                int countFile = 0, countFolder = 0;
                for (File name : array) {
                    if (name.isFile()) {
                        String tmp[] = name.toString().split("/");
                        String[] fileName = tmp[tmp.length - 1].split("\\.");
                        fileNames[countFile++] = fileName[0];
                        extenSet.add(fileName[1]);
                    } else {
                        String tmp[] = name.toString().split("/");
                        String fileName = tmp[tmp.length - 1];
                        fileNames[countFolder++] = fileName;
                    }
                }
                System.out.println("There are " + countFile + " file(s) and " + countFolder + " folder(s) inside folder {" + path + "} with extension" + extenSet.toString());
            }
            criteria.setExtensions(extenSet);
        } catch (Exception e) {
            e.printStackTrace();
            start();
        }
        System.out.println("\nCriteria path name:\n " + criteria.getFolderPath() +"\n");
        System.out.println("Criteria include Subfolder:\n " + criteria.getIncludeSubfolder() + "\n");
        System.out.println("Criteria extensions: \n" + criteria.getExtensions().toString());

    }


    public static void start() throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("please input path: ");
        String path = s.nextLine();
        countFiles(new Criteria(path, true));
    }

    public static void main(String[] args) throws Exception {
        start();
        ///Users/wanghengchao/OneDrive - Capital University of Serbia/material
    }
}
