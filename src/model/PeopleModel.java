package model;

import java.util.*;

public class PeopleModel {
    static Set<People> peopleHashSet = new HashSet<>();

    public void loginQuanLyNguoiDoc(Scanner sc) {
        int choose = -1;
        while (choose != 0) {
            choose = tryCatchLuaChon(sc);
            switch (choose) {
                case 1:
                    addPeople(sc);
                    break;
                case 2:
                    detelePeople(sc);
                    break;
                case 3:
                    fixPeople(sc);
                    break;
                case 4:
                    searchPeople(sc);
                    break;
                case 5:
                    System.out.println("Exit");
                    System.exit(5);
                    break;
                case 0:
                    System.out.println("Quay lại");
                    break;
            }
        }
    }

    //Method add people
    public void addPeople(Scanner sc) {
        System.out.println("Nhập mã người đọc");
        String idPeople = sc.nextLine();
        System.out.println("Nhập tên người đọc");
        String namePeople = sc.nextLine();
        System.out.println("Nhập số điện thoại người đọc");
        String phoneNumber = sc.nextLine();
        System.out.println("Nhập địa chỉ người đọc");
        String address = sc.nextLine();
        boolean ketQua = kiemTraIdPeople(idPeople);
        if (ketQua == false){
            People people = new People(idPeople, namePeople, phoneNumber, address);
            peopleHashSet.add(people);
            System.out.println("Thêm thành công");
        } else {
            System.out.println("Người đọc đã tồn tại.");
        }

    }
    // kiểm tra ID đã tồn tại chưa
    public boolean kiemTraIdPeople(String idPeople){
        for (People p : peopleHashSet){
            if (p.getIdPeople().equals(idPeople)){
                return true;
            }
        }
        return false;

    }

    public void detelePeople(Scanner sc) {
        if (peopleHashSet.isEmpty()){
            System.out.println("Chưa có thông tin người đọc nào");
            return;
        }
        System.out.println("Nhập Mã Người cần xóa");
        String idPeople = sc.nextLine();
        Iterator<People> it = peopleHashSet.iterator();
        while (it.hasNext()) {
            if (peopleHashSet.isEmpty()){
                System.out.println("Chưa có thông tin người đọc nào");
                break;
            }
            People p = it.next();
            boolean ketQua = kiemTraIdPeople(idPeople);
            if (ketQua == true){
                it.remove();
                System.out.println("Đã xóa thành công");
                return;
            }
            if (ketQua == false){
                System.out.println("Không tìm thấy người đọc nào có Mã: " + idPeople);
                return;
            }
        }
    }

    public void fixPeople(Scanner sc) {
        if (peopleHashSet.isEmpty()){
            System.out.println("Chưa có thông tin người đọc nào");
            return;
        }
        int choose = tryCatchFix(sc);
        switch (choose) {
            case 1:
                fixIdPeople(sc);
                break;
            case 2:
                fixNamePeople(sc);
                break;
            case 3:
                fixPhoneNumberPeople(sc);
                break;
            case 4:
                fixAddressPeople(sc);
                break;
        }
    }

    public void fixIdPeople(Scanner sc) {
        System.out.println("Nhập Mã cần tìm");
        String keyword = sc.nextLine();
        System.out.println("Nhập mã cần thay đổi");
        String idPeople = sc.nextLine();
        boolean ketQua = kiemTraIdPeople(idPeople);
        Iterator<People> it = peopleHashSet.iterator();
        while (it.hasNext()) {
            People p = it.next();
            if (!p.getIdPeople().equals(keyword)){
                System.out.println("Không tìm thấy người đọc nào có Mã: " + keyword);
                return;
            }
            if (ketQua == false){
                p.setIdPeople(idPeople);
                System.out.println("Thông tin đã được thay đổi");
            } else {
                System.out.println("Mã người đọc đã tồn tại");
            }
        }
    }

    public void fixNamePeople(Scanner sc) {
        System.out.println("Nhập Mã cần tìm");
        String keyword = sc.nextLine();
        System.out.println("Nhập tên cần thay đổi");
        String keyword1 = sc.nextLine();
        Iterator<People> it = peopleHashSet.iterator();
        while (it.hasNext()) {
            People p = it.next();
            if (!p.getIdPeople().equals(keyword)){
                System.out.println("Không tìm thấy người đọc nào có Mã: " + keyword);
                return;
            }
            if (p.getIdPeople().equals(keyword)) {
                p.setNamePeople(keyword1);
                System.out.println("Thông tin đã được thay đổi");
                return;
            }
        }
    }

    public void fixPhoneNumberPeople(Scanner sc) {
        System.out.println("Nhập Mã cần tìm");
        String keyword = sc.nextLine();
        System.out.println("Nhập số điện thoại cần thay đổi");
        String keyword1 = sc.nextLine();
        Iterator<People> it = peopleHashSet.iterator();
        while (it.hasNext()) {
            People p = it.next();
            if (!p.getIdPeople().equals(keyword)){
                System.out.println("Không tìm thấy người đọc nào có Mã: " + keyword);
                return;
            }
            if (p.getIdPeople().equals(keyword)) {
                p.setNumberPhone(keyword1);
                System.out.println("Thông tin đã được thay đổi");
                return;
            }
        }
    }
    public void fixAddressPeople(Scanner sc) {
        System.out.println("Nhập Mã cần tìm");
        String keyword = sc.nextLine();
        System.out.println("Nhập địa chỉ cần thay đổi");
        String keyword1 = sc.nextLine();
        Iterator<People> it = peopleHashSet.iterator();
        while (it.hasNext()) {
            People p = it.next();
            if (!p.getIdPeople().equals(keyword)){
                System.out.println("Không tìm thấy người đọc nào có Mã: " + keyword);
                return;
            }
            if (p.getIdPeople().equals(keyword)) {
                p.setAddress(keyword1);
                System.out.println("Thông tin đã được thay đổi");
                return;
            }
        }
    }

    public void searchPeople(Scanner sc) {
        if (peopleHashSet.isEmpty()){
            System.out.println("Chưa có thông tin người đọc nào");
            return;
        }
        System.out.println("Nhập Mã cần tìm");
        String keyword = sc.nextLine();
        Iterator<People> it = peopleHashSet.iterator();
        while (it.hasNext()) {
            People p = it.next();
            if (!p.getIdPeople().equals(keyword)){
                System.out.println("Không tìm thấy người đọc nào có Mã: " + keyword);
                return;
            }
            if (p.getIdPeople().equals(keyword)) {
                System.out.println(p.toString());
                return;
            }
        }
    }

    public void xuat() {
        for (People p : peopleHashSet) {
            System.out.println(p.toString());
        }
    }

    public static int tryCatchLuaChon(Scanner sc) {
        int choose;
        try {
            System.out.println("1. Thêm người đọc");
            System.out.println("2. Xóa người đọc");
            System.out.println("3. Sửa thông tin người đọc");
            System.out.println("4. TÌm kiếm thông tin người đọc");
            System.out.println("5. Exit");
            System.out.println("0. Quay Lại");
            choose = Integer.parseInt(sc.nextLine());
            if (choose > 5) {
                System.out.println("Giá trị nhập không đúng. Vui lòng chỉ nhập đúng mục lục");
                System.out.println("Vui lòng nhập lại");
                tryCatchLuaChon(sc);
            }
        } catch (Exception ex) {
            System.out.println("Giá trị nhập không đúng. Vui lòng chỉ nhập đúng mục lục");
            System.out.println("Vui lòng nhập lại");
            return tryCatchLuaChon(sc);
        }
        return choose;
    }

    public static int tryCatchFix(Scanner sc) {
        int choose;
        try {
            System.out.println("1. Thay đổi mã người đọc");
            System.out.println("2. Thay đổi tên người đọc");
            System.out.println("3. Thay đổi số điện thoại người đọc");
            System.out.println("4. Thay đổi địa chỉ người đọc");
            System.out.println("0. Quay Lại");
            choose = Integer.parseInt(sc.nextLine());
            if (choose > 4) {
                System.out.println("Giá trị nhập không đúng. Vui lòng chỉ nhập đúng mục lục");
                System.out.println("Vui lòng nhập lại");
                tryCatchFix(sc);
            }
        } catch (Exception ex) {
            System.out.println("Giá trị nhập không đúng. Vui lòng chỉ nhập đúng mục lục");
            System.out.println("Vui lòng nhập lại");
            return tryCatchFix(sc);
        }
        return choose;
    }

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
