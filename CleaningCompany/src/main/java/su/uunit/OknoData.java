package su.uunit;

/**
 * Класс собирающий и передающий данные
 * 
 * Наследуется от абстрактного класса CalculatorData
 */
public final class OknoData extends CalculatorData {

    /** Высота окна */
    private double visota;
    
    /** Ширина окна */
    private double shirina;
    
    

    /**
     * Переопределение метода toString для того, чтобы передавать строку в готовом виде
     */
    @Override
    public String toString() {
        return super.toString() + "\nВысота окон = " + visota+ " м." +
                "\nШирина окон = " + shirina + "м.\n\n";
    }

    public OknoData(int okon, double visota, double shirina, int dopolnenieRUB) {
        super(okon, dopolnenieRUB);
        this.visota = visota;
        this.shirina = shirina;
    }


    public double getVisota() {
        return visota;
    }
    

    public void setVisota(double visota) {
    	this.visota=visota;
    }


    public double getShirina() {
        return shirina;
    }
    

    public void setShirina(int shirina) {
    	this.shirina=shirina;
    }

}