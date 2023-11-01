import java.util.Scanner;

import static java.lang.System.exit;

public class Soldier {
    final int LEN = 30;
    final int DATE = 11;
    private String name;
    private String draft_date;
    private String address;

    public String getName() {return name;}
    public String getDraft_date() {return draft_date;}
    public String getAddress() {return address;}
    public void setName(String name) {this.name = name;}
    public void setDraft_date(String draft_date) {this.draft_date = draft_date;}
    public void setAddress(String address) {this.address = address;}
    public Soldier() {}
    public Soldier(String name) {
        this.name = name;
        this.draft_date = "11.12.1345";
        this.address = "Летная, 13";
    }

    public Soldier(String name, String draft_name, String address) {
        initArg(name,draft_name,address);
    }
    public void initArg(String name, String draft_date, String address) {
        if (name.isEmpty() || draft_date.length() != DATE - 1 || address.isEmpty()) {
            exit(-1);
        }
        else {
            setName(name);
            setDraft_date(draft_date);
            setAddress(address);
        }
    }
    public void InputSoldier(){
        String name, draft_date, address;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите Фамилия И.О. солдата:");
        name = sc.nextLine();
        char[] date;
        do {
            do {
                System.out.println("Введите дату призыва солдата в формате ДД.ММ.ГГГГ:");
                draft_date = sc.nextLine();
                date = draft_date.toCharArray();
            } while (date[0] < '0' || date[0] > '3' || date[1] < '0' || (date[1] > '1' && date[0] > '2') || date[1] > '9' || date[2] != '.' || date[3] < '0' || (date[3] == '1' && date[4] > '2') || date[3] > '1' || date[4] < '0' || (date[4] > '0' && date[3] > '2') || date[4] > '9' || date[5] != '.' || date[6] < '0' || date[6] > '9' || date[7] < '0' || date[7] > '9' || date[8] < '0' || date[8] > '9' || date[9] < '0' || date[9] > '9');
        } while (draft_date.length() != 10);
        System.out.println("Введите адрес прописки солдата:");
        address = sc.nextLine();
        initArg(name, draft_date, address);
    }
}
