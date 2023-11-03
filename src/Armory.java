import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class Armory {
    private String military;
    public ArrayList<Weapon> weapons = new ArrayList<>();
    public ArrayList<Control> operations = new ArrayList<>();
    public ArrayList<Soldier> soldiers = new ArrayList<>();
    public int NumWeapons = 1;
    public int NumSoldiers = 1;
    public int NumOperations = 1;
    public String getMilitary(){return military;}
    public void setMilitary(String military){this.military = military;}
    public Armory() {}
    public Armory(Weapon weapon,Soldier soldier,Control operation,String military){
        initArg(weapon,soldier,operation,military);
    }
    public void initArg(Weapon weapon, Soldier soldier, Control operation, String military) {
        if (military.isEmpty()) {
            exit(-1);
        }
        else {
            setMilitary(military);
            this.weapons.add(this.NumWeapons - 1,weapon);
            this.soldiers.add(this.NumSoldiers - 1,soldier);
            this.operations.add(this.NumOperations - 1,operation);
        }
    }
    public void WeaponToArmory(Weapon weapon){
        this.NumWeapons += 1;
        this.weapons.add(weapon);
    }
    public void SoldierToArmory(Soldier soldier){
        this.NumSoldiers += 1;
        this.soldiers.add(soldier);
    }
    public void OperationToArmory(Control operation){
        this.NumOperations += 1;
        this.operations.add(operation);
    }
    public void InputArmory(Weapon weapon, Soldier soldier, Control operation) {
        String military;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер ячейки склада (Н-р: А3):");
        military = sc.nextLine();
        initArg(weapon, soldier, operation, military);
    }
    void OutputArmory() {
        System.out.println("\nСписок складского оружия:");
        for (int i = 0,j = 1; i < this.NumWeapons; i++) {
            System.out.println("|" + j++ + "|Название: " + this.weapons.get(i).getName() +"\n   Год выпуска: " + this.weapons.get(i).getRelease() + "\n   Компания: " + this.weapons.get(i).company.getName() + "\n   Дата основания: " + this.weapons.get(i).company.getFound());

        }
        System.out.println("\nСписок призванных солдат:");
        for (int i = 0,j = 1; i < this.NumSoldiers; i++) {
            System.out.println("|" + j++ + "|ФИО: " + this.soldiers.get(i).getName() + "\n   Дата призыва: " + this.soldiers.get(i).getDraft() +"\n   Прописка по адресу: " + this.soldiers.get(i).getAddress());
        }
        System.out.println("\nОперации на складе:");
        for (int i = 0, j = 1; i < this.NumOperations; i++) {
            System.out.println("|" + j++ + "|Оружие: " + this.operations.get(i).weapon.getName() +"\n   Солдат: " + this.operations.get(i).soldier.getName() + "\n   Дата операции: " + this.operations.get(i).getDate() + "\n   Вид операции: " + this.operations.get(i).getOperation());
        }
        System.out.println(" ");
    }
}
