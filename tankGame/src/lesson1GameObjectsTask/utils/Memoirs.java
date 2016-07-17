package lesson1GameObjectsTask.utils;

import lesson1GameObjectsTask.AbstractTank;
import lesson1GameObjectsTask.tanks.TankType;

import static lesson1GameObjectsTask.utils.Utils.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;



/**
 * Saves tank action to the file.
 * It takes tank name and type as filename.
 * File legend:
 * <Tank Class Name><Tank Type><Action>...<Action>
 *
 */
public class Memoirs {
    //private BufferedInputStream bis;
    //private BufferedOutputStream bos;
    //private Reader iFile;
   // private Writer oFile;
    private BufferedReader fileRead;
    private BufferedWriter fileWrite;
    private String fileName;
    private java.util.List<String> memories;
    private int curPosition;

    public Memoirs(String fileName, boolean read) {

        if (read) {
            memories = new ArrayList<>();
            curPosition = 0;

        }

        this.fileName = fileName;

    }

    public Memoirs(String fileName) {
        this(fileName, false);
    }

    public void clearFile() {
        File file = new File(fileName);
        if (!file.exists()) {
           try {

               file.createNewFile();

           } catch (IOException e) {
               System.out.println("Can`t create file: " + fileName + ". Exeption:\n" + e);
           }
        }
        try (
                BufferedWriter fileWrite = new BufferedWriter(new FileWriter(fileName, false), 512);
        )
        {

            fileWrite.write("\n");

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void writeActionToFile(String str) {


        try (
                BufferedWriter fileWrite = new BufferedWriter(new FileWriter(fileName, true), 512);
        )
        {

            fileWrite. write(str + "\n");

        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public void writeActionToFile(AbstractTank tank, TankAction action) {
        String str = String.valueOf(tankTypeWriteConverter(tank));
        char ch  = actionWriteConverter(action);
        str = str +ch;
        System.out.println(str);

        try (
                BufferedWriter fileWrite = new BufferedWriter(new FileWriter(fileName, true), 512);
                )
        {

            fileWrite. write(str + "\n");

        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public void readActionFile() {
        String action;

        try (
                BufferedReader fileRead = new BufferedReader(new FileReader(fileName), 512);
                )
        {
            while ((action = fileRead.readLine()) != null) {
                memories.add(action);

            }

        } catch (IOException e) {
            System.out.println(e);
        }

        if(memories.size() > 1) {
            curPosition = 1; //first elevment \n
        }
    }

    public String getCurString(){
        return memories.get(curPosition);
    }

    public String getCurStringGoNext(){
        return memories.get(curPosition++);
    }

    public int goNext() { //refactor from iterator
        if(curPosition < memories.size()-1) {
            return ++curPosition;
        }
        return -1;
    }

    public TankType getCurTankType() {
        return tankTypeReadConverter(memories.get(curPosition).charAt(0));
    }

    public TankAction getCurTankAction() {
        return actionReadConverter(memories.get(curPosition).charAt(1));
    }

    public void readTankFile(AbstractTank tank) {
        Class tankClass = tank.getClass();
        String tankName;
        String tankType; //Mock

        try
        {
           // tank. = (String) oos.readObject();
           // tankType = (String) oos.readObject();
            System.out.println(fileRead.readLine());

        } catch (IOException e) {
            System.out.println(e);
        }//catch (ClassNotFoundException e) {
         //   System.out.println(e);
        //}
    }
/*
    public List<TankAction> readActionFile(AbstractTank tank) {
        List<TankAction> tankActions = new ArrayList<>();

        try (
                ObjectInputStream oos = new ObjectInputStream(bis);
        )
        {
            TankAction curTankAction;

            while((curTankAction = (TankAction) oos.readObject()) != null) {
                tankActions.add(curTankAction);
            }

        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        return tankActions;
    }

 */



/*

    public void writeActionToFile(TankAction action) {

        try
        {
               bos.write(actionWriteConverter(action));

            } catch (IOException e) {
                System.out.println(e);
            }

    }
    public void writeTankToFile(AbstractTank tank) {
        Class tankClass = tank.getClass();
        String tankName = tankClass.getName();
        String tankType = "agressor"; //Mock

        try
        {
            bos.write(tankTypeWriteConverter(tank));

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public List<TankAction> readActionFromFile() {
        List<TankAction> tankActions = new ArrayList<>();

        try (
                ObjectInputStream oos = new ObjectInputStream(bis);
        )
        {
            TankAction curTankAction;

            while((curTankAction = (TankAction) oos.readObject()) != null) {
                tankActions.add(curTankAction);
            }

        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        return tankActions;
    }

    public void fileToWrite(String fileName) {

        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter(fileName), 512);
        ) {
            fileWrite = bw;
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public void fileToRead(String fileName) {

        try (
                BufferedReader br = new BufferedReader(new FileReader(fileName), 512);
        ) {


            fileRead = br;
        } catch (IOException e) {
            System.out.println(e);
        }

    }



    public void fileToWrite(AbstractTank tank) {
        Class tankClass = tank.getClass();
        String fileName = tankClass.getName();
        //BufferedOutputStream bos = null;
        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter(fileName), 512);
             ) {
            fileWrite = bw;
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public void fileToRead(AbstractTank tank) {
        Class tankClass = tank.getClass();
        String fileName = tankClass.getName();
        //BufferedOutputStream bos = null;
        try (
                BufferedReader br = new BufferedReader(new FileReader(fileName), 512);
        ) {


            fileRead = br;
        } catch (IOException e) {
            System.out.println(e);
        }

    }
*/
}
