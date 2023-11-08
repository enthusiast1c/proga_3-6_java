public class Index {
    static public int Armament(Armory armory){
        return (int) ((int)((double)(armory.NumOperations * (armory.NumSoldiers * 0.6 + armory.NumWeapons * 0.4))) * 7.5);
    }
}
