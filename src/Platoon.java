import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;
public class Platoon {//Класс для работы с двумерным массивом
    private int Ntroop;
    private String index;
    private ArrayList<ArrayList<Soldier>> soldiers = new ArrayList<>();
    private void SetIndex(String index) {this.index = index;}
    public Scanner sc = new Scanner(System.in);
    public Platoon() {
        String index;
        System.out.println("Введите обозначение взвода:");
        index = sc.nextLine();
        SetIndex(index);
    }
    public void AddSoldier(int id, Soldier soldier) {
        if (soldiers.size() == id) {
            ArrayList<Soldier> sold = new ArrayList<>();
            sold.add(soldier);
            soldiers.add(sold);
        }
        else {
            soldiers.get(id).add(soldier);
        }
    }
    public int GetNtroop() {
        return soldiers.size();
    }
    public int GetSize(int i) {
        return soldiers.get(i).size();
    }
    public String GetIndex() {
        return index;
    }
    public void OutputPlatoon() {
        System.out.println("Взвод <<" + this.GetIndex() + ">>");
        for (int i = 0; i < soldiers.size(); i++) {
            System.out.println("В (" + (i + 1) + ") роте прикомандированы следующие солдаты:");
            for (int j = 0; j < soldiers.get(i).size(); j++) {
                System.out.println("|" + (j + 1) + "|ФИО: " + this.soldiers.get(i).get(j).getName() + "\n   Дата призыва: " + this.soldiers.get(i).get(j).getDraft() + "\n   Прописка по адресу: " + this.soldiers.get(i).get(j).getAddress());
            }
        }
    }
}
