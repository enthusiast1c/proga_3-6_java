import java.util.Scanner;

import static java.lang.System.exit;

public class Weapon {
    private int release;
    private String name;
    public Company company;

    public int getRelease() {return release;}
    public String getName() {return name;}
    public Company getCompany() {return company;}
    public void setRelease(int release) {this.release = release;}
    public void setName(String name) {this.name = name;}
    public void setCompany(Company company) {this.company = company;}
    public Weapon() {}
    public Weapon(Company company) {
        this.name = "FAMAS";
        this.release = 2000;
        this.company = company;
    }
    public void initArg(String name, Company company, int release) {
        if (name.isEmpty() || release < 1132) {
            exit(-1);
        }
        else {
            setName(name);
            setCompany(company);
            setRelease(release);
        }
    }
    public Weapon(String name, Company company, int release) {
        initArg(name,company,release);
    }
    public void InputWeapon(Company company) {
        int release;
        String name;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите модель оружия:");
        name = sc.nextLine();
        System.out.println("Введите год выпуска:");
        do {
            release = sc.nextInt();
            if (release < 1132) {
                System.out.println("Повторите попытку.");
            }
        } while (release < 1132);
        initArg(name, company, release);
    }
}
