import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;
import java.util.Comparator;

public class Armory implements OutputAll{
    private String military;
    public ArrayList<Weapon> weapons = new ArrayList<>();
    public ArrayList<Control> operations = new ArrayList<>();
    public ArrayList<Soldier> soldiers = new ArrayList<>();
    public ArrayList<WeaponMode> weaponmods = new ArrayList<>();

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
    public void WeaponModeToArmory(WeaponMode weaponmode) {
        this.NumWeapons += 1;
        this.weaponmods.add(weaponmode);
    }
    public int GetNumWeapons(){
        return NumWeapons;
    }
    public int GetNumSoldiers(){
        return NumSoldiers;
    }
    public void InputArmory(Weapon weapon, Soldier soldier, Control operation) {
        String military;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер ячейки склада (Н-р: А3):");
        military = sc.nextLine();
        initArg(weapon, soldier, operation, military);
    }
    //Сортировка оружия по году выпуска
    public void SortWeapon() {
        System.out.println("(\"Выполнение сортировки оружия.");
        weapons.sort(Comparator.comparingInt(Weapon::getRelease));
        System.out.println("Выполнение сортировки оружия с модификацией");
        weaponmods.sort(Comparator.comparingInt(WeaponMode::getRelease));
    }
    //Поиск оружия,оружия с модификацией по названию
    public int SearchWeapon(String name) {
        for (Weapon actualweapon : weapons) {
            if (actualweapon.getName().equals(name)) {
                System.out.println("Найденное оружие по запросу: ");
                actualweapon.Output();
                return 1;
            }
        }
        for (WeaponMode actualmode : weaponmods) {
            if (actualmode.getName().equals(name)) {
                System.out.println("Найденное оружие с модификацией по запросу: ");
                actualmode.Output();
                return 1;
            }
        }
        System.out.println("Оружие с таким названием отсутсвтует\n");
        return -1;
    }
    public void Output() {
        System.out.println("\nСписок складского оружия:\n" + "Всего на складе: " + (Weapon.getNum()-WeaponMode.getCountMode()));
        for (int i = 0; i < (Weapon.getNum() - WeaponMode.getCountMode()); i++) {
            System.out.print("|" + (i + 1) + "|");
            this.weapons.get(i).Output();
        }
        System.out.println("Список складской модификации:\n" + "Всего на складе: " + WeaponMode.getCountMode());
        if (WeaponMode.getCountMode() != 0) {
            for (int i = 0; i < WeaponMode.getCountMode(); i++) {
                System.out.print("|" + (i + 1) + "|");
                this.weaponmods.get(i).Output();
            }
        }
        System.out.println("\nСписок призванных солдат:\n" + "Всего на складе: " + Soldier.getNum());
        for (int i = 0,j = 1; i < this.NumSoldiers; i++) {
            System.out.println("|" + j++ + "|ФИО: " + this.soldiers.get(i).getName() + "\n   Дата призыва: " + this.soldiers.get(i).getDraft() +"\n   Прописка по адресу: " + this.soldiers.get(i).getAddress());
        }
        System.out.println("\nОперации на складе:\n" + "Всего на складе: " + Control.getNum());
        for (int i = 0, j = 1; i < this.NumOperations; i++) {
            System.out.println("|" + j++ + "|Оружие: " + this.operations.get(i).weapon.getName() +"\n   Солдат: " + this.operations.get(i).soldier.getName() + "\n   Дата операции: " + this.operations.get(i).getDate() + "\n   Вид операции: " + this.operations.get(i).getOperation());
        }
        System.out.println(" ");
    }
}
