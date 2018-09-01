package data;

/**
 *
 * @author student
 */
public class TSamochod {

    protected String marka;
    protected double pB;
    protected double pM;
    protected double zP;

    public TSamochod(String marka, double pB, double pM, double zP) {
        this.marka = marka;
        this.pB = pB;
        this.pM = pM;
        this.zP = zP;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public double getpB() {
        return pB;
    }

    public void setpB(double pB) {
        this.pB = pB;
    }

    public double getpM() {
        return pM;
    }

    public void setpM(double pM) {
        this.pM = pM;
    }

    public double getzP() {
        return zP;
    }

    public void setzP(double zP) {
        this.zP = zP;
    }

    public void jedz(double jakSzybko, double jakDaleko) {
        if (jakSzybko < 0 || jakDaleko < 0) {
            throw new IllegalArgumentException("Parametr nie może być ujemny!!!");
        }

        double v = jakSzybko > pM ? pM : jakSzybko;
        System.out.println("Prędkość samochodu: " + v + " km/h");

        double z = zuzyciePaliwa(v);
        double zLitrow = jakDaleko * z / 100;
        System.out.println("Zużycie paliwa na trasę: " + zLitrow + " l");

        int tankowania = (int) (zLitrow/pB);
        System.out.println("Liczba tankowań: " + tankowania);
        
        double czas = jakDaleko/v + tankowania/6.0;
        System.out.println("Czas jazdy: " + czas + " godz.");
    }
    
    protected double zuzyciePaliwa(double v){
        double z = zP;
        if (v < 0.3 * pM || v > 0.8 * pM) {
            z *= 1.2;           // z = z + 0.2 * z;
        }
        return z;
    }
}
