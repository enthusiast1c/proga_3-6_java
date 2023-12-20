import java.util.Scanner;

import static java.lang.System.exit;

public class Company extends AbstractCompany<String,String,String> implements Cloneable{
    static final int DATE = 11;
    private String name;
    private String found;
    private String address;
    public String getName() {return name;}
    public String getFound() {return found;}
    public String getAddress() {return address;}
    public void setName(String name) {this.name = name;}
    public void setFound(String found) {this.found = found;}
    public Company(){}
    public void setAddress(String address) {this.address = address;}

    public Company(String name, String found, String address) {
        initArg(name,found,address);
    }
    public void initArg(String name, String found, String address) {
        if (name.isEmpty() || address.isEmpty()) {
            exit(-1);
        }
        else if (found.length() != DATE - 1) {
            System.out.println("Некорректная дата");
            exit(-1);
        }
        else {
            setName(name);
            setFound(found);
            setAddress(address);
        }
    }
    public void InputCompany(){
        String name,found,address;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите название компании:");
        name = sc.nextLine();
        char[] date;
        do {
            do {
                System.out.println("Введите дату основания в формате ДД/ММ/ГГГГ:");
                found = sc.nextLine();
                date = found.toCharArray();
            } while (date[0] < '0' || date[0] > '3' || date[1] < '0' || (date[1] > '1' && date[0] > '2') || date[1] > '9' || date[2] != '/' || date[3] < '0' || date[3] > '1' || date[4] < '0' || (date[4] > '0' && date[3] > '2') || date[4] > '9' || date[5] != '/' || date[6] < '0' || date[6] > '9' || date[7] < '0' || date[7] > '9' || date[8] < '0' || date[8] > '9' || date[9] < '0' || date[9] > '9');
        } while (found.length() != 10);
        System.out.println("Введите адрес компании:");
        address = sc.nextLine();
        this.initArg(name, found, address);
    }
    //Клонирование
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    public Company deepClone() throws CloneNotSupportedException {
        Company clonedCompany = (Company) super.clone();
        clonedCompany.setName(new String(this.name));
        clonedCompany.setAddress(new String(this.address));
        clonedCompany.setFound(new String(this.found));
        return clonedCompany;
    }
}
