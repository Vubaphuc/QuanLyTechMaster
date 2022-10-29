import model.Book;
import model.BookModel;
import model.LibraryCardModel;
import model.PeopleModel;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookModel bookModel = new BookModel();
        PeopleModel peopleModel = new PeopleModel();
        LibraryCardModel libraryCardModel = new LibraryCardModel();
        while (true){
            int choose = tryCatch(sc);
            switch (choose){
                case 1:
                    bookModel.loginQuanLySach(sc);
                    break;
                case 2:
                    peopleModel.loginQuanLyNguoiDoc(sc);
                    break;
                case 3:
                    libraryCardModel.loginMuonSach(sc);
                    break;
                case 0:
                    System.out.println("Thoát Chương Trình!");
                    System.exit(0);
            }
        }
    }
    public static int tryCatch(Scanner sc){
        try {
            System.out.println("1. Quản Lý Sách");
            System.out.println("2. Quản Lý Người Đọc");
            System.out.println("3. Quản Lý Mượn Sách");
            System.out.println("0. Exit");
           int choose = Integer.parseInt(sc.nextLine());
           if (choose > 3){
               System.out.println("Giá trị nhập không đúng. Vui lòng chỉ nhập từ 0 ~ 3");
               return tryCatch(sc);
           }
           return choose;

        } catch (Exception ex){
            System.out.println("Giá trị nhập không đúng. Vui lòng chỉ nhập từ 0 ~ 3");
            return tryCatch(sc);
        }
    }
}