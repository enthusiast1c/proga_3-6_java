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
    public String getMilitary(){return military;}
    public void setMilitary(String military){this.military = military;}
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
    void OutputArmory() {
        System.out.println("\nСписок складского оружия:");
        for (int i = 0; i < this.NumWeapons; i++) {
            System.out.println("Название: " + this.weapons.get(i).getName() +"\nГод выпуска: " + this.weapons.get(i).getRel_year() + "\nКомпания: " + this.weapons.get(i).company.getName() + "\nДата основания: " + this.weapons.get(i).company.getFound_date());
        }
        System.out.println("\nСписок призванных солдат:");
        for (int i = 0; i < this.NumSoldiers; i++) {
            System.out.println("ФИО: " + this.soldiers.get(i).getName() + "\nДата призыва: " + this.soldiers.get(i).getDraft_date() +"\nПрописка по адресу: " + this.soldiers.get(i).getAddress());
        }
        System.out.println("\nОперации на складе:");
        for (int i = 0; i < this.NumOperations; i++) {
            System.out.println("Оружие: " + this.operations.get(i).weapon.getName() +"\nСолдат: " + this.operations.get(i).soldier.getName() + "\nДата операции: " + this.operations.get(i).getDate() + "\nВид операции: " + this.operations.get(i).getOperation());
        }
        System.out.println(" ");
    }
    public void InputArmory(Weapon weapon, Soldier soldier, Control operation) {
        String military;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер ячейки склада (Н-р: ячейка А3):");
        military = sc.nextLine();
        initArg(weapon, soldier, operation, military);
    }
}
