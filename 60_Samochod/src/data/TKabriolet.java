package data;

/**
 *
 * @author student
 */
public class TKabriolet extends TSamochod{
    private boolean dach_otwarty;
    
    public TKabriolet(String marka, double pB, double pM, double zP) {
        super(marka, pB, pM, zP);
        dach_otwarty = false;
    }
    
    public void otworz_dach(){
        dach_otwarty = true;
    }
    
    public void zamknij_dach(){
        dach_otwarty = false;
    }
    
    @Override
    protected double zuzyciePaliwa(double v) {
        return dach_otwarty ? 1.15 * super.zuzyciePaliwa(v):super.zuzyciePaliwa(v); 
    }
}
