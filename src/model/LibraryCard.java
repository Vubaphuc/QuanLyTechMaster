package model;

import java.time.LocalDate;

public class LibraryCard {
    private String nameCard;
    private String nameBookBorrow;
    private int numberBorrow;
    private LocalDate dayBorrow;
    private LocalDate dayPay;


    public LibraryCard(String nameCard, String nameBookBorrow, int numberBorrow, LocalDate dayBorrow, LocalDate dayPay) {
        this.nameCard = nameCard;
        this.nameBookBorrow = nameBookBorrow;
        this.numberBorrow = numberBorrow;
        this.dayBorrow = dayBorrow;
        this.dayPay = dayPay;
    }

    public String getNameCard() {
        return nameCard;
    }

    public void setNameCard(String nameCard) {
        this.nameCard = nameCard;
    }

    public String getNameBookBorrow() {
        return nameBookBorrow;
    }

    public void setNameBookBorrow(String nameBookBorrow) {
        this.nameBookBorrow = nameBookBorrow;
    }

    public int getNumberBorrow() {
        return numberBorrow;
    }

    public void setNumberBorrow(int numberBorrow) {
        this.numberBorrow = numberBorrow;
    }

    public LocalDate getDayBorrow() {
        return dayBorrow;
    }

    public void setDayBorrow(LocalDate dayBorrow) {
        this.dayBorrow = dayBorrow;
    }

    public LocalDate getDayPay() {
        return dayPay;
    }

    public void setDayPay(LocalDate dayPay) {
        this.dayPay = dayPay;
    }


}
