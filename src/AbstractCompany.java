public abstract class AbstractCompany<N,F,A> {//Асбтрактный класс
    public abstract N getName();
    public abstract F getFound();
    public abstract A getAddress();
    public abstract void setName(N name);
    public abstract void setFound(F found);
    public abstract void setAddress(A address);
    public abstract void initArg(N name, F found, A address);
}
