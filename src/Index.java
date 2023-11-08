public class Index {
    static public int Armament(Armory armory){
        return (int) ((double) ((armory.NumWeapons + armory.NumSoldiers) * 100)/ armory.NumOperations);
    }
}
