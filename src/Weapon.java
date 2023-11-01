import java.util.Scanner;

import static java.lang.System.exit;

public class Weapon {
    private int rel_year;
    private String name;
    public Company company;

    public int getRel_year() {return rel_year;}
    public String getName() {return name;}
    public Company getCompany() {return company;}

    public void setRel_year(int rel_year) {this.rel_year = rel_year;}
    public void setName(String name) {this.name = name;}
    public void setCompany(Company company) {this.company = company;}
    public Weapon() {}
    public Weapon(Company company) {
        this.name = "FAMAS";
        this.rel_year = 2000;
        this.company = company;
    }
    public void initArg(String name, Company company, int rel_year) {
        if (name.isEmpty() || rel_year < 1000) {
            exit(-1);
        }
        else {
            setName(name);
            setCompany(company);
            setRel_year(rel_year);
        }
    }
    public Weapon(String name, Company company, int rel_year) {
        initArg(name,company,rel_year);
    }
    public void InputWeapon(Company company) {
        int rel_year;
        String name;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите модель оружия:");
        name = sc.nextLine();
        System.out.println("Введите год выпуска:");
        do {
            rel_year = sc.nextInt();
            if (rel_year < 1132) {
                System.out.println("Повторите попытку.");
            }
        } while (rel_year < 1132);
        initArg(name, company, rel_year);
    }
}
