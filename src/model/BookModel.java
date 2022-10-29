package model;

import java.util.*;

public class BookModel {
    Scanner sc = new Scanner(System.in);
    static Set<Book> bookSet = new HashSet<>();

    // method Display Quản lý Sách
    public void loginQuanLySach(Scanner sc) {
        while (true) {
            int choose = tryCatchLoginSach(sc);
            if (choose == 0) {
                System.out.println("Quay Lại");
                break;
            }
            switch (choose) {
                case 1:
                    addBook(sc);
                    break;
                case 2:
                    deleteBook(sc);
                    break;
                case 3:
                    suaThongTinSach(sc);
                    break;
                case 4:
                    System.out.println("Exit");
                    System.exit(4);
            }
        }
    }

    // Method display thêm sách vào TechMaster

    public void addBook(Scanner sc) {
        System.out.println("Nhập Mã sách");
        String idBook = sc.nextLine();
        System.out.println("Nhập Tên Sách");
        String nameBook = sc.nextLine();
        System.out.println("Nhập Chủ Đề Sách");
        String themeBook = sc.nextLine();
        System.out.println("Nhập Tên Tác Giả");
        String author = sc.nextLine();
        System.out.println("Nhập số lượng sách");
        int numberBook = tryCatchNumber(sc);
        boolean ketQua = kiemtra(idBook);
        if (ketQua == true) {
            System.out.println("Sách đã tồn tại trong thư viện");
            return;
        }
        if (ketQua == false) {
            Book book = new Book(idBook, nameBook, themeBook, author, numberBook);
            bookSet.add(book);
            System.out.println("Thêm thành công");
        }
    }

    // Method display xóa sách trong TechMaster
    public void deleteBook(Scanner sc) {
        if (bookSet.isEmpty()) {
            System.out.println("Chưa có sách nào trong thư viện");
            return;
        }
        System.out.println("Nhập Mã Sách cần xóa");
        String idBook = sc.nextLine();
        Iterator<Book> it = bookSet.iterator();
        while (it.hasNext()) {
            Book b = it.next();
            boolean ketQua = kiemtra(idBook);
            if (ketQua == false) {
                System.out.println("Không tìm thấy người đọc nào có Mã: " + idBook);
                return;
            }
            if (ketQua == true) {
                it.remove();
                System.out.println("Đã xóa thành công");
                return;
            }
        }
    }

    // kiểm tra
    public boolean kiemtra(String idBook) {
        for (Book b : bookSet) {
            if (b.getIdBook().equals(idBook)) {
                return true;
            }
        }
        return false;
    }

    // test in ra màn hình
    public void xuat() {
        if (bookSet.isEmpty()) {
            System.out.println("Không có Book nào");
        }
        for (Book b : bookSet) {
            System.out.println(b.toString());
        }
    }

    // Method display sửa thông tin sách vào TechMaster
    public void suaThongTinSach(Scanner sc) {
        while (true) {
            if (bookSet.isEmpty()) {
                System.out.println("Chưa có sách nào trong thư viện");
                break;
            }
            int choose = tryCatchSuaThongTin(sc);
            if (choose == 0) {
                System.out.println("Quay Lại");
                break;
            }
            switch (choose) {
                case 1:
                    suaIdBook(sc);
                    break;
                case 2:
                    suaNameBook(sc);
                    break;
                case 3:
                    suaChuDeBook(sc);
                    break;
                case 4:
                    suaAuthorBook(sc);
                    break;
                case 5:
                    suaNumberBook(sc);
                    break;
                case 6:
                    System.out.println("Exit");
                    System.exit(6);
            }
        }
    }

    // Method sửa mã sách
    public void suaIdBook(Scanner sc) {
        System.out.println("Nhập Mã cần tìm");
        String keyword = sc.nextLine();
        System.out.println("Nhập mã cần thay đổi");
        String keyword1 = sc.nextLine();
        Iterator<Book> it = bookSet.iterator();
        while (it.hasNext()) {
            Book b = it.next();
            if (!b.getIdBook().equals(keyword)) {
                System.out.println("Không tìm thấy người đọc nào có Mã: " + keyword);
                return;
            }
            if (b.getIdBook().equals(keyword)) {
                b.setIdBook(keyword1);
                System.out.println("Thông tin đã được thay đổi");
                return;
            }
        }
    }

    // Method sửa tên sách
    public void suaNameBook(Scanner sc) {
        System.out.println("Nhập Mã cần tìm");
        String keyword = sc.nextLine();
        System.out.println("Nhập tên cần thay đổi");
        String keyword1 = sc.nextLine();
        Iterator<Book> it = bookSet.iterator();
        while (it.hasNext()) {
            Book b = it.next();
            if (!b.getIdBook().equals(keyword)) {
                System.out.println("Không tìm thấy người đọc nào có Mã: " + keyword);
                return;
            }
            if (b.getIdBook().equals(keyword)) {
                b.setNameBook(keyword1);
                System.out.println("Thông tin đã được thay đổi");
                return;
            }
        }
    }

    // Method sửa chủ đề sách
    public void suaChuDeBook(Scanner sc) {
        System.out.println("Nhập Mã cần tìm");
        String keyword = sc.nextLine();
        System.out.println("Nhập chủ đề cần thay đổi");
        String keyword1 = sc.nextLine();
        Iterator<Book> it = bookSet.iterator();
        while (it.hasNext()) {
            Book b = it.next();
            if (!b.getIdBook().equals(keyword)) {
                System.out.println("Không tìm thấy người đọc nào có Mã: " + keyword);
                return;
            }
            if (b.getIdBook().equals(keyword)) {
                b.setBookTheme(keyword1);
                System.out.println("Thông tin đã được thay đổi");
                return;
            }
        }
    }

    // Method sửa tên tác giả sách
    public void suaAuthorBook(Scanner sc) {
        System.out.println("Nhập Mã cần tìm");
        String keyword = sc.nextLine();
        System.out.println("Nhập tên tác giả cần thay đổi");
        String keyword1 = sc.nextLine();
        Iterator<Book> it = bookSet.iterator();
        while (it.hasNext()) {
            Book b = it.next();
            if (!b.getIdBook().equals(keyword)) {
                System.out.println("Không tìm thấy người đọc nào có Mã: " + keyword);
                return;
            }
            if (b.getIdBook().equals(keyword)) {
                b.setBookAuthor(keyword1);
                System.out.println("Thông tin đã được thay đổi");
                return;
            }
        }
    }

    // Method sửa số lượng sách
    public void suaNumberBook(Scanner sc) {
        System.out.println("Nhập Mã sách cần tìm");
        String keyword1 = sc.nextLine();
        System.out.println("Nhập Mã sách cần tìm");
        int keyword;
        keyword = tryCatchNumber(sc);

        Iterator<Book> it = bookSet.iterator();
        while (it.hasNext()) {
            Book b = it.next();
            if (b.getIdBook().equals(keyword1)) {
                System.out.println("Không tìm thấy người đọc nào có Mã: " + keyword1);
                return;
            }
            if (b.getIdBook().equals(keyword)) {
                b.setBookNumber(keyword);
                System.out.println("Thông tin đã được thay đổi");
                return;
            }
        }
    }

    // Method bắt lỗi menu
    public static int tryCatchSuaThongTin(Scanner sc) {
        try {
            System.out.println("1. Sửa Mã Sách");
            System.out.println("2. Sửa Tên Sách");
            System.out.println("3. Sửa Chủ Đề Sách");
            System.out.println("4. Sửa Tên Tác Giả Sách");
            System.out.println("5. Sửa Số Lượng Sách");
            System.out.println("6. Exit");
            System.out.println("0. Quay Lại");
            int choose = Integer.parseInt(sc.nextLine());
            if (choose > 6) {
                System.out.println("Giá trị nhập không đúng. Vui lòng chỉ nhập đúng mục lục");
                return tryCatchSuaThongTin(sc);
            }
            return choose;

        } catch (Exception ex) {
            System.out.println("Giá trị nhập không đúng. Vui lòng chỉ nhập đúng mục lục");
            return tryCatchSuaThongTin(sc);
        }
    }

    public static int tryCatchLoginSach(Scanner sc) {
        try {
            System.out.println("1. Thêm sách vào TechMaster");
            System.out.println("2. Xóa sách trong TechMaster");
            System.out.println("3. Sửa thông tin sách trong TechMaster");
            System.out.println("4. Exit");
            System.out.println("0. Quay Lại");
            int choose = Integer.parseInt(sc.nextLine());
            if (choose > 4) {
                System.out.println("Giá trị nhập không đúng. Vui lòng chỉ nhập đúng mục lục");
                return tryCatchLoginSach(sc);
            }
            return choose;

        } catch (Exception ex) {
            System.out.println("Giá trị nhập không đúng. Vui lòng chỉ nhập đúng mục lục");
            return tryCatchLoginSach(sc);
        }
    }

    // method bắt lỗi input int
    public static int tryCatchNumber(Scanner sc) {
        int numberBook = 0;
        try {
            numberBook = Integer.parseInt(sc.nextLine());
        } catch (Exception ex) {
            System.out.println("Giá trị nhập không đúng. Vui lòng chỉ nhập số!");
            System.out.println("Vui lòng nhập lại");
            tryCatchNumber(sc);
        }
        return numberBook;
    }
}
