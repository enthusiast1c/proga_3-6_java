import java.util.Scanner;

import static java.lang.System.exit;

public class Soldier {
    static final int DATE = 11;
    private static int NSold = 0;
    private String name;
    private String draft;
    private String address;
    public static int getNum(){
        return NSold;
    }

    public String getName() {return name;}
    public String getDraft() {return draft;}
    public String getAddress() {return address;}
    public void setName(String name) {this.name = name;}
    public void setDraft(String draft) {this.draft = draft;}
    public void setAddress(String address) {this.address = address;}
    public Soldier() {}
    public Soldier(String name) {//Инструкция throw
        this.name = name;
        for(int i = 0; i < name.length();i++){
            if(Character.isDigit(name.charAt(i))){
                throw new IllegalArgumentException("Неккоректный формат входных данных");
            }
        }
    }
    public Soldier(String name, String draft, String address) {
        NSold++;
        initArg(name,draft,address);
    }
    public void initArg(String name, String draft, String address) {
        if (name.isEmpty() || draft.length() != DATE - 1 || address.isEmpty()) {
            exit(-1);
        }
        else {
            setName(name);
            setDraft(draft);
            setAddress(address);
        }
    }
    public void InputSoldier(){
        NSold++;
        String name, draft, address;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите Фамилия И.О. солдата:");
        name = sc.nextLine();
        char[] date;
        do {
            do {
                System.out.println("Введите дату призыва солдата в формате ДД/ММ/ГГГГ:");
                draft = sc.nextLine();
                date = draft.toCharArray();
            } while (date[0] < '0' || date[0] > '3' || date[1] < '0' || (date[1] > '1' && date[0] > '2') || date[1] > '9' || date[2] != '/' || date[3] < '0' || (date[3] == '1' && date[4] > '2') || date[3] > '1' || date[4] < '0' || (date[4] > '0' && date[3] > '2') || date[4] > '9' || date[5] != '/' || date[6] < '0' || date[6] > '9' || date[7] < '0' || date[7] > '9' || date[8] < '0' || date[8] > '9' || date[9] < '0' || date[9] > '9');
        } while (draft.length() != 10);
        System.out.println("Введите адрес прописки солдата:");
        address = sc.nextLine();
        initArg(name, draft, address);
    }
}
