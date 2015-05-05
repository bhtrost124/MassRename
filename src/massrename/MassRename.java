/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package massrename;

import java.io.File;
import java.util.Scanner;
import javax.swing.JFileChooser;

/**
 *
 * @author Bryce
 */
public class MassRename {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File[] fileList;
        File file, renamedFile;
        Scanner stdIn = new Scanner(System.in);
        JFileChooser chooser = new JFileChooser("C:\\Users\\Bryce");
        String directory, extension, fileName, numString;
        char again;
        int currentNum;
        boolean doAgain = false;
        chooser.setFileSelectionMode(chooser.DIRECTORIES_ONLY);
        do
        {
            chooser.showOpenDialog(null);
            file = chooser.getSelectedFile();
            directory = file.getPath();
            fileList = file.listFiles();
            System.out.print("What number do you wish to start with: ");
            currentNum = stdIn.nextInt();
            for (int i = 0; i < fileList.length; i++)
            {
                file = fileList[i];
                fileName = file.getName();
                extension = fileName.substring(fileName.lastIndexOf(".") + 1);
                System.out.print(fileName + " has been renamed to ");
                numString = Integer.toString(currentNum);
                if (numString.length() == 1)
                {
                    numString = "00" + numString;
                }
                else if (numString.length() == 2)
                {
                    numString = "0" + numString;
                }
                renamedFile = new File(directory + "\\" + numString + "." + extension);
                file.renameTo(renamedFile);
                System.out.println(renamedFile.getName());
                currentNum++;
            }
            System.out.print("Would you like to rename another folder (y/n)? ");
            again = stdIn.next().charAt(0);
            if (again == 'y')
            {
                doAgain = true;
            }
            else
            {
                doAgain = false;
            }
        } while (doAgain);
    }
    
}
