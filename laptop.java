import java.util.Objects;
import java.util.Random;

public class laptop {
    /*
     * 1 - ОЗУ
     * 2 - Объем ЖД
     * 3 - Операционная система
     * 4 - Цвет
     * */

    private int ram; // 8, 16, 32, 64
    private int hddSize; // 512, 1024, 2048
    private String os; // Windows 10, Windows 11, MacOS, Linux
    final String color; // black, silver, blue, white, red
    final String manufacturer; // Lenovo, Apple, Asus, HP, Acer

    final static int[] ramSizes = {8, 16, 32, 64};
    final static int[] hddSizes = {512, 1024, 2048};
    final static String[] osNames = {"Windows 10", "Windows 11", "MacOs", "Linux"};
    final static String[] colors = {"black", "silver", "blue", "white", "red"};
    final static String[] manufacturers = {"Lenovo", "Apple", "Asus", "HP", "Acer"};

    public laptop(int ram, int hddSize, String os, String color, String manufacturer) {
        this.manufacturer = manufacturer;
        if (manufacturer.equalsIgnoreCase("apple"))
            this.os = "MacOS";
        else
            this.os = os;
        this.ram = ram;
        this.hddSize = hddSize;
        this.color = color;
    }

    public laptop() {
        this.manufacturer = generateManufacturer(manufacturers);
        if (manufacturer.equalsIgnoreCase("apple"))
            this.os = "MacOS";
        else
            this.os = generateOS(osNames);
        this.ram = generateRAMSize(ramSizes);
        this.hddSize = generateHDDSize(hddSizes);
        this.color = generateColor(colors);
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setHddSize(int hddSize) {
        this.hddSize = hddSize;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public int getRam() {
        return ram;
    }

    public int getHddSize() {
        return hddSize;
    }

    public String getOs() {
        return os;
    }

    public boolean corresponds(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        laptop laptop = (laptop) o;

        return (laptop.getRam() <= 0 || getRam() == laptop.getRam()) &&
        (laptop.getHddSize() <= 0 || getHddSize() == laptop.getHddSize()) &&
        (laptop.getOs().length() == 0 || getOs().equalsIgnoreCase(laptop.getOs())) &&
        (laptop.color.length() == 0 || color.equalsIgnoreCase(laptop.color)) &&
        (laptop.manufacturer.length() == 0 || manufacturer.equalsIgnoreCase(laptop.manufacturer));

    }

    @Override
    public String toString() {
        return "Laptop {" +
                manufacturer +
                ", ram: " + ram +
                ", hddSize: " + hddSize +
                ", os: '" + os + '\'' +
                ", color: '" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        laptop laptop = (laptop) o;
        return getRam() == laptop.getRam() && getHddSize() == laptop.getHddSize() && getOs().equals(laptop.getOs())
                && Objects.equals(color, laptop.color) && manufacturer.equals(laptop.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRam(), getHddSize(), getOs(), color, manufacturer);
    }

    // Random generation for learning purpose
    private static int generateRAMSize(int[] ramSizes) {
        Random rnd = new Random();
        return ramSizes[rnd.nextInt(0, ramSizes.length)];
    }

    private static int generateHDDSize(int[] hddSizes) {
        Random rnd = new Random();
        return hddSizes[rnd.nextInt(0, hddSizes.length)];
    }

    private static String generateOS(String[] osNames) {
        Random rnd = new Random();
        return osNames[rnd.nextInt(0, osNames.length)];
    }

    private static String generateColor(String[] colors) {
        Random rnd = new Random();
        return colors[rnd.nextInt(0, colors.length)];
    }

    private static String generateManufacturer(String[] manufacturers) {
        Random rnd = new Random();
        return manufacturers[rnd.nextInt(0, manufacturers.length)];
    }

}

