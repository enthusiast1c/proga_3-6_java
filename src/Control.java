import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.exit;

public class Control {
    static final int DATE = 11;
    private static int NOper = 0;
    private String operation;
    private String date;
    public Weapon weapon;
    public Soldier soldier;
    public static int getNum(){
        return NOper;
    }
    public String getOperation() {return operation;}
    public String getDate() {return date;}
    public void setOperation(String operation) {this.operation = operation;}
    public void setDate(String date) {this.date = date;}
    public void setWeapon(Weapon weapon) {this.weapon = weapon;}
    public void setSoldier(Soldier soldier) {this.soldier = soldier;}
    public Control() {NOper++;}
    public Control(String operation, String date, Weapon weapon, Soldier soldier) {
        NOper++;
        initArg(operation,date,weapon,soldier);
    }
    public void initArg(String operation, String date, Weapon weapon, Soldier soldier){
        if (operation.isEmpty() || date.length() != DATE - 1) {
            exit(-1);
        }
        else {
            setWeapon(weapon);
            setSoldier(soldier);
            setOperation(operation);
            setDate(date);
        }
    }
    public void InputControl(Weapon weapon, Soldier soldier) {
        String operation, date;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Введите тип совершённой операции (Выдача/Сдача):");
            operation = sc.nextLine();
        } while ((!Objects.equals(operation, "Выдача")) && (!Objects.equals(operation, "Сдача")));
        char[] dt;
        do {
            do {
                System.out.println("Введите дату совершения операции в формате ДД/ММ/ГГГГ:");
                date = sc.nextLine();
                dt = date.toCharArray();
            } while (dt[0] < '0' || dt[0] > '3' || dt[1] < '0' || (dt[1] > '1' && dt[0] > '2') || dt[1] > '9' || dt[2] != '/' || dt[3] < '0' || (dt[3] == '1' && dt[4] > '2') || dt[3] > '1' || dt[4] < '0' || (dt[4] > '0' && dt[3] > '2') || dt[4] > '9' || dt[5] != '/' || dt[6] < '0' || dt[6] > '9' || dt[7] < '0' || dt[7] > '9' || dt[8] < '0' || dt[8] > '9' || dt[9] < '0' || dt[9] > '9');
        } while (date.length() != 10);
        initArg(operation, date, weapon, soldier);
    }
}
