import java.util.ArrayList;

//Разумное использование производного класса
public class WeaponMode extends Weapon implements OutputAll{
    private ArrayList<String> mods = new ArrayList<>();
    private static int NumWeapMods = 0;
    //Вызов конструктора базового класса в производном классе
    public WeaponMode(String name, Company company, int release, ArrayList<String> mods) {
        super(name, company, release);
        NumWeapMods++;
        this.mods = mods;
    }
    public WeaponMode(String name, Company company, int release){
        super(name, company, release);
        NumWeapMods++;
    }
    //Перегрузка метода базового класса в производном классе
    @Override
    public void InputWeapon(Company company) {
        super.InputWeapon(company);
    }
    public WeaponMode() {
        NumWeapMods++;
    }
    public void AddMode(String mode) {
        mods.add(mode);
    }
    public void Output() {
        super.Output();
        for (int i = 0; i < mods.size(); i++) {
            System.out.println("   Модификация <" + mods.get(i) + ">\n");
        }
    }
    public static int getCountMode() {
        return NumWeapMods;
    }
};
