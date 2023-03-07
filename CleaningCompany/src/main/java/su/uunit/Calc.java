package su.uunit;

/**
 Класс, вычисляющий стоимость услуги, стоимость 1 окна и площадь окна
 
 Для расчета нужно создать объект класса Calc и передать в него объект класса OknoData, который содержит все необходимые данные
 */
public class Calc {
	/** Стоимость услуги компании*/
    private double stoimost;
    /** Кол-во окон*/
    private int okon;
    /** Площадь 1 окна*/
    private double area;
    /** Стоимость 1 окна */
    private double okno;
    
    /** data - Объект класса содержит в себе четыре полей, которые передаются в метод расчета*/
    private OknoData data;

    public Calc(OknoData dto) {
        this.data = dto;
        this.okon = dto.getOkon();
    }

  
    /**
     * Метод производящий расчет
     */
    public void ras(){
       this.area = data.getShirina() * data.getVisota();
       this.okno = area * 150;
       this.stoimost = okno * okon + data.getDopolnenieRUB();
        
    }
    
    /**
     * Метод передает данные в PDFCreator
     * 
     */
    public void generationPdf() {
        ras();
        PdfCreator.create(area,okon,okno,stoimost,data.toString());
    }

    /**
     * Гетеры и сетеры 
     * 
     */
	public double getStoimost() {
		return stoimost;
	}


	public void setStoimost(double stoimost) {
		this.stoimost = stoimost;
	}


	public int getOkon() {
		return okon;
	}


	public void setOkon(int okon) {
		this.okon = okon;
	}


	public double getArea() {
		return area;
	}


	public void setArea(double area) {
		this.area = area;
	}


	public double getOkno() {
		return okno;
	}


	public void setOkno(double okno) {
		this.okno = okno;
	}


	public OknoData getDto() {
		return data;
	}


	public void setDto(OknoData dto) {
		this.data = dto;
	}
    
    
}
