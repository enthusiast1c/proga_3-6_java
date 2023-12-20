import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        company.InputCompany();
        Weapon weapon = new Weapon();
        weapon.InputWeapon(company);
        Soldier soldier = new Soldier();
        soldier.InputSoldier();
        Control operation = new Control();
        operation.InputControl(weapon,soldier);
        Armory armory = new Armory();
        armory.InputArmory(weapon,soldier,operation);
        Scanner sc = new Scanner(System.in);
        Soldier s = new Soldier();
        Platoon platoon;
        int exit = 0;
        do {
            System.out.println("Оружейный склад.");
            int choice;
            do {
                System.out.println("Выберите действие:\n |1|Вывести оружейный склад\n |2|Добавить солдата\n |3|Добавить оружие\n |4|Добавить выдачу/сдачу оружия\n |5|Рассчитать индекс вооруженности\n |6|Организация взвода\n |7|Конструкция try-catch\n |8|Тестирование клонирования\n |9|Завершение программы\nВаш выбор: ");
                choice = sc.nextInt();
            } while (choice < 1 || choice > 9);
            switch (choice) {
                case 1:
                    armory.Output();
                    break;
                case 2:
                    Soldier NewSoldier = new Soldier();
                    NewSoldier.InputSoldier();
                    armory.SoldierToArmory(NewSoldier);
                    armory.Output();
                    break;
                case 3:
                    int p;
                    do {
                        System.out.println("Добавление снаряжения:\n|1|Добавить оружие\n|2|Добавить оружие с модификацией\n|3|Вернуться назад\nВаш выбор: ");
                        do {
                            p = sc.nextInt();
                        } while (p < 1 || p > 3);
                        Weapon NewWeapon = new Weapon();
                        Company NewCompany = new Company();
                        if (p == 1) {
                            NewCompany.InputCompany();
                            NewWeapon.InputWeapon(NewCompany);
                            armory.WeaponToArmory(NewWeapon);
                        }
                        else if (p == 2) {
                            NewCompany.InputCompany();
                            WeaponMode weaponmode = new WeaponMode();
                            weaponmode.InputWeapon(NewCompany);
                            System.out.println("\nВведите количество модификаций (не более 2)\nВаш выбор: ");
                            int k;
                            do {
                                k = sc.nextInt();
                            } while (k < 1 || k > 2);
                            String str;
                            for (int i = 0; i < k; i++) {
                                System.out.println("Введите " + (i + 1) + " модификацию:" + "\n");
                                do{
                                    str = sc.nextLine();
                                }while (str.isEmpty());
                                weaponmode.AddMode(str);
                            }
                            armory.WeaponModeToArmory(weaponmode);
                        }
                    } while (p != 3);
                    break;
                case 4:
                    int k;
                    do {
                        System.out.println("Желаете использовать имеющееся оружие?\n|1|Да\n|2|Нет\nВаш выбор: ");
                        k = sc.nextInt();
                    } while (k < 1 || k > 2);
                    Weapon w = new Weapon();
                    if (k == 1) {
                        armory.Output();
                        System.out.println("\nВведите номер оружия из списка: ");
                        int NumOfWeapon;
                        do {
                            NumOfWeapon = sc.nextInt();
                        } while (NumOfWeapon<1 || NumOfWeapon>armory.GetNumWeapons());
                        w = armory.weapons.get(NumOfWeapon - 1);
                    }
                    else {
                        Company NewCompanyFirst = new Company();
                        NewCompanyFirst.InputCompany();
                        w.InputWeapon(NewCompanyFirst);
                        armory.WeaponToArmory(w);
                    }
                    System.out.println("\nЖелаете использовать имеющегося солдата ?\n|1|Да\n|2|Нет\nВаш выбор: ");
                    do {
                        k = sc.nextInt();
                    } while (k < 1 || k > 2);
                    if (k == 1) {
                        armory.Output();
                        System.out.println("\nВведите номер солдата из списка: ");
                        int NumOfSoldier;
                        do {
                            NumOfSoldier = sc.nextInt();
                        } while (NumOfSoldier<1 || NumOfSoldier>armory.GetNumSoldiers());
                        s = armory.soldiers.get(NumOfSoldier - 1);
                    }
                    else {
                        s.InputSoldier();
                        armory.SoldierToArmory(s);
                    }
                    Control NewOperation = new Control();
                    NewOperation.InputControl(w,s);
                    armory.OperationToArmory(NewOperation);
                    break;
                case 5:
                    System.out.println("Вооруженность военской части: " + Index.Armament(armory) + "\n");
                    break;
                case 6:
                    int n;
                    platoon = new Platoon();
                    do {
                        System.out.println("\nОрганизация взвода.Выберите действие:\n\n|1|Добавить солдата\n|2|Вывести взвод\n|3|Вернуться назад\n\nВаш выбор: ");
                        do {
                            n = sc.nextInt();
                        } while (n < 1 || n > 3);
                        if (n == 1) {
                            int id;
                            System.out.println("Введите номер роты ( до " + (1 + platoon.GetNtroop()) + ")");
                            do {
                                id = sc.nextInt();
                                id -= 1;
                            } while (id < 0 || id > platoon.GetNtroop());
                            armory.Output();
                            System.out.println("\nВведите номер солдата из списка: ");
                            int NumOfSoldier;
                            do {
                                NumOfSoldier = sc.nextInt();
                            } while (NumOfSoldier<1 || NumOfSoldier>armory.GetNumSoldiers());
                            s = armory.soldiers.get(NumOfSoldier - 1);
                            platoon.AddSoldier(id, s);
                        }
                        if (n == 2) {
                            platoon.OutputPlatoon();
                        }
                    } while (n != 3);
                    break;
                case 7:
                    try{
                        Soldier exs = new Soldier("271277");
                    }catch(IllegalArgumentException exs){
                        System.out.println(exs.getMessage());
                    }
                    break;
                case 8:
                    Company StartCompany = new Company();
                    StartCompany.setName("Степанидзе");
                    StartCompany.setAddress("Тамбовская,13");
                    StartCompany.setFound("27/12/1977");
                    Weapon StartWeapon = new Weapon();
                    StartWeapon.setName("M4A1-S");
                    StartWeapon.setRelease(2000);
                    StartWeapon.setCompany(StartCompany);
                    try {
                        System.out.println("\nИзначальное оружие : " + StartWeapon.company.getName());
                        System.out.println("Меняем компанию у изначального оружия.");
                        Weapon shallowClonedWeapon = StartWeapon.shallowClone();
                        Weapon deepClonedWeapon = StartWeapon.deepClone();
                        StartCompany.setName("Титикатзе");
                        StartWeapon.setCompany(StartCompany);
                        System.out.println("Изначальное оружие : " + StartWeapon.company.getName());
                        System.out.println("Мелкое клонирование(название клон-компании): " + shallowClonedWeapon.company.getName());
                        System.out.println("Глубокое клонирование(название клон-компании): " + deepClonedWeapon.company.getName() + "\n");
                    } catch (CloneNotSupportedException e) {
                        System.out.println("Клонирование невозможно!");
                    }
                    break;
                case 9:
                    int yesno;
                    do {
                        System.out.println("Вы уверены, что хотите выйти?\n|1|Да\n|2|Нет\nВаш выбор: ");
                        yesno = sc.nextInt();
                    } while (yesno != 1 && yesno != 2);
                    if (yesno == 1) {
                        exit = 1;
                        break;
                    }
            }
        } while (exit == 0);
    }
}