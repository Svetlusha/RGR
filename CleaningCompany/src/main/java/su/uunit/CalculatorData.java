package su.uunit;

/**
 * Абстрактный класс от которого наследуется класс Calc
 * 
 */
public abstract class CalculatorData {
    
    /** Кол-во окон. */
    private int okon;
    
    /** Дополнительная стоимость */
    private double dopolnenieRUB;

    /**
     * Переопределение метода toString для того, чтобы передавать строку в готовом виде
     *
     */
    @Override
    public String toString() {
        return "Количество окон = " + okon  +
                "\nДополнительная плата = " + dopolnenieRUB + " руб.";
    }

   
    protected CalculatorData(int okon, double dopolnenieRUB) {
        this.okon = okon;
        this.dopolnenieRUB = dopolnenieRUB;
    }

  
    public int getOkon() {
        return okon;
    }
    
    
    public void setOkon(int okon) {
    	this.okon=okon;
    }

    
    public double getDopolnenieRUB() {
        return dopolnenieRUB;
    }
    
   
    public void setDopolnenieRUB(double dopolnenieRUB) {
    	this.dopolnenieRUB=dopolnenieRUB;
    }
}
