import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.exit;

public class Control {
    final int LEN = 30;
    final int DATE = 11;
    private String operation;
    private String date;
    public Weapon weapon;
    public Soldier soldier;
    public String getOperation() {return operation;}
    public String getDate() {return date;}
    public void setOperation(String operation) {this.operation = operation;}
    public void setDate(String date) {this.date = date;}
    public void setWeapon(Weapon weapon) {this.weapon = weapon;}
    public void setSoldier(Soldier soldier) {this.soldier = soldier;}
    public Control() {}
    public Control(String operation, String date, Weapon weapon, Soldier soldier) {
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
        System.out.println("Введите дату совершения операции в формате ДД.ММ.ГГГГ:");
        date = sc.nextLine();
        initArg(operation, date, weapon, soldier);
    }
}
