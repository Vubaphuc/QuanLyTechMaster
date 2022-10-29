package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class LibraryCardModel {

    Set<LibraryCard> libraryCardSet = new HashSet<>();

    public void loginMuonSach(Scanner sc){
        while (true){
            int choose = tryCatchLoginMuonSach(sc);
            if (choose == 0){
                break;
            }
            switch (choose){
                case 1:
                    loginLoanCard(sc);
                    break;
                case 2:
                    traSach(sc);
                    break;
            }

        }
    }

    public void loginLoanCard(Scanner sc){
        if (BookModel.bookSet.isEmpty()){
            System.out.println("Không có quyển sách nào trong thư viện");
            return;
        }
        System.out.println("Nhập mã sách cần mượn");
        String keyword = sc.nextLine();
        System.out.println("Nhập số lượng mượn");
        String nameBook = null;
        int numberBook = 0;
        int keywordNumber = soLuongMuon(sc);
        if (BookModel.bookSet.isEmpty()){
            System.out.println("Không còn sách trong thư viện");
        }
        if (keywordNumber == 0){
            System.out.println("Nhập số lượng lớn hơn 0");
            return;
        }

        Iterator<Book> it = BookModel.bookSet.iterator();
        while (it.hasNext()){
            Book b = it.next();
            boolean ketQua = kiemTraMaSach(keyword);
            if (ketQua == true && b.getBookNumber() >= keywordNumber && b.getBookNumber() != 0){
                nameBook = b.getNameBook();
                numberBook = keywordNumber;
                loanCard(sc,nameBook,numberBook);
                b.setBookNumber(b.getBookNumber()-keywordNumber);
                System.out.println("Tạo Phiếu thành công");
                return;
            }
            if (ketQua == true && b.getBookNumber() == 0){
                System.out.println("Sách có mã: " + keyword + " đã cho mượn hết");
            }
            if (ketQua == true && b.getBookNumber() < keywordNumber && b.getBookNumber() > 0){
                System.out.println("Số lượng sách không đủ");
                System.out.println("Số lượng sách còn lại là: " + b.getBookNumber());
            }
            if (ketQua == false){
                System.out.println("Không có sách nào có mã: " + keyword);
                return;
            }
        }

    }

    public boolean kiemTraMaSach(String keyword){
        Iterator<Book> it = BookModel.bookSet.iterator();
        while (it.hasNext()) {
            Book b = it.next();
            if (b.getIdBook().equals(keyword)) {
                return true;
            }
        }
        return false;
    }
    public void loanCard(Scanner sc, String nameBook, int numberBook){
        System.out.println("Nhập Tên người mượn");
        String nameLoan = sc.nextLine();
        boolean ketQua = kiemTra(nameLoan);
        if (ketQua == true){
            System.out.println("Người mượn vẫn chưa trả sách mượn trước. Vui lòng trả lại sách trước khi mượn mới");
            return;
        } else {
            LocalDate ngayMuon = tryCatchLocalDateBorrow(sc);
            LocalDate ngayTra = tryCatchLocalDatePay(sc);
            boolean ketqua1 = soSanh(ngayTra, ngayMuon);
            if (ketqua1 == true){
                LibraryCard libraryCard = new LibraryCard(nameLoan,nameBook,numberBook, ngayMuon,ngayTra);
                libraryCardSet.add(libraryCard);
            } else {
                System.out.println("Ngày trả phải sau ngày mượn");
                loginLoanCard(sc);
            }
        }

    }

    public boolean kiemTra(String nameLoan){
        for (LibraryCard li : libraryCardSet ){
            if (li.getNameCard().equals(nameLoan)){
                return true;
            }
        }
        return false;
    }
    public boolean soSanh(LocalDate ngayTra, LocalDate ngayMuon){
        if (ngayTra.isAfter(ngayMuon)){
            return true;
        } else {
            return false;
        }
    }

    public void traSach(Scanner sc){
        if (libraryCardSet.isEmpty()){
            System.out.println("Không có người mượn sách nào!");
            return;
        }
        System.out.println("Nhập tên người mượn");
        String keyword = sc.nextLine();
        Iterator<LibraryCard> it = libraryCardSet.iterator();
        while (it.hasNext()){
            LibraryCard libraryCard = it.next();
            if (libraryCard.getNameCard().equals(keyword)){
                for (Book b : BookModel.bookSet){
                    b.setBookNumber(libraryCard.getNumberBorrow());
                }
                it.remove();
                System.out.println("Đã trả sách OK");
            }
            if (!libraryCard.getNameCard().equals(keyword)){
                System.out.println("Người mượn không có trong danh sách mượn");
            }
        }
    }

    public static LocalDate tryCatchLocalDateBorrow(Scanner sc){
        try {
            System.out.println("Nhập ngày Mượn");
            String dayBorrow = sc.nextLine();
            LocalDate dB = LocalDate.parse(dayBorrow, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return dB;
        } catch (Exception ex){
            System.out.println("Đinh dạng ngày không đúng. Vui lòng nhập đúng định dạng (dd/MM/yyyy)");
            return tryCatchLocalDateBorrow(sc);
        }
    }

    public static int soLuongMuon(Scanner sc){
        int number;
        try {
            number = Integer.parseInt(sc.nextLine());
        } catch (Exception ex){
            System.out.println("Định dạng không đúng. Vui lòng nhập số thực(1, 2 , ...");
            return soLuongMuon(sc);
        }
        return number;
    }

    public static LocalDate tryCatchLocalDatePay(Scanner sc){
        try {
            System.out.println("Nhập ngày trả");
            String dayPay = sc.nextLine();
            LocalDate dP = LocalDate.parse(dayPay, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return dP;
        } catch (Exception ex){
            System.out.println("Đinh dạng ngày không đúng. Vui lòng nhập đúng định dạng (dd/MM/yyyy)");
            return tryCatchLocalDatePay(sc);
        }
    }
    public static int tryCatchLoginMuonSach(Scanner sc) {
        int choose;
        try {
            System.out.println("1. Tạo phiếu mượn sách");
            System.out.println("2. Người đọc trả sách");
            System.out.println("0. Quay Lại");
            choose = Integer.parseInt(sc.nextLine());
            if (choose > 3) {
                System.out.println("Giá trị nhập không đúng. Vui lòng chỉ nhập đúng mục lục");
                System.out.println("Vui lòng nhập lại");
                tryCatchLoginMuonSach(sc);
            }
        } catch (Exception ex) {
            System.out.println("Giá trị nhập không đúng. Vui lòng chỉ nhập đúng mục lục");
            System.out.println("Vui lòng nhập lại");
            return tryCatchLoginMuonSach(sc);
        }
        return choose;
    }
}
