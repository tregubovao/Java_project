package lesson6;

import java.util.Objects;


public class Notebook {
    private String brand;
    private String model;
    private double screenSize;
    private String screenResolution;
    int ssdVolume;
    private int ramVolume;
    private int cpuFrequency;
    private int NumberOfCoresOfCpu;
    private int id;
    private int price;
    int quantity;


    public Notebook(String brand, String model, double screenSize, String screenResolution, int ssdVolume,
                    int ramVolume, int cpuFrequency, int numberOfCoresOfCpu, int id) {
        this.brand = brand;
        this.model = model;
        this.screenSize = screenSize;
        this.screenResolution = screenResolution;
        this.ssdVolume = ssdVolume;
        this.ramVolume = ramVolume;
        this.cpuFrequency = cpuFrequency;
        this.NumberOfCoresOfCpu = numberOfCoresOfCpu;
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Марка: %s; Модель: %s; Размер экрана, дюймов: %s; Разрешение экрана: %s; " +
                        "Размер SSD, ГБ: %s; Объем оперативной памяти, ГБ: %s;\nчастота процессора, МГц: %s; Количество ядер: %s; Код товара: %s; Цена, руб.: %s, в наличии, шт.: %s.",
                brand, model, screenSize, screenResolution, ssdVolume, ramVolume, cpuFrequency, NumberOfCoresOfCpu, id, price,quantity);
    }

    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public boolean equals(Object obj) {
        Notebook t = (Notebook) obj;
        return Objects.equals(brand, t.brand) && Objects.equals(model, t.model) && Objects.equals(screenResolution,
                t.screenResolution) && ssdVolume == t.ssdVolume && ramVolume == t.ramVolume && cpuFrequency == t.cpuFrequency &&
                NumberOfCoresOfCpu == t.NumberOfCoresOfCpu && id == t.id && price == t.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, screenSize, screenResolution, ssdVolume, ramVolume, cpuFrequency,
                NumberOfCoresOfCpu, id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }




}
