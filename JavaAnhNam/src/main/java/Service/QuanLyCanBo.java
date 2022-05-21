package Service;

import Common.GioiTinhEnum;
import Model.CanBo;
import Model.CongNhan;
import Model.KySu;
import Model.NhanVien;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class QuanLyCanBo {
    static List<CanBo> danhSachCanBo = new ArrayList<>();

    static {
        danhSachCanBo.add(new KySu("Trình Đức Minh", 30, GioiTinhEnum.NAM, "IT"));
        danhSachCanBo.add(new NhanVien("Nguyễn Thị Giang", 23, GioiTinhEnum.NỮ, "Kế toán"));
        danhSachCanBo.add(new CongNhan("Nguyễn Tiến Đạt", 32, GioiTinhEnum.NAM, 4));
    }

    // Controller?
    public void batDau() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int choice = 1;
        while (choice != 0) {
            System.out.println("\n----------------------------------------------------");
            System.out.println("=== CHƯƠNG TRÌNH QUẢN LÝ CÁN BỘ ===");
            System.out.println("1. Xem danh sách cán bộ\n" +
                    "2. Thêm mới cán bộ\n" +
                    "3. Tìm kiếm cán bộ theo tên\n" +
                    "0.Thoát chương trình");
            System.out.print("Lựa chọn: ... ");
            choice = Integer.parseInt(sc.nextLine());
            System.out.println();
            // Dừng một lúc cho tự nhiên
            TimeUnit.SECONDS.sleep(2);
            switch (choice) {
                case 1 -> getDanhSachCanBo();
                case 2 -> them(sc);
                case 3 -> timTheoTen(sc);
                default -> System.out.println("Vui lòng chọn đúng các lựa chọn từ 1 đến 3");
            }
            // Dừng một lúc cho tự nhiên
            TimeUnit.SECONDS.sleep(2);
        }
    }

    // Danh sach cán bộ
    private static void getDanhSachCanBo() {
        System.out.println("Danh sách cán bộ của công ty: ");
        for (CanBo canBo : danhSachCanBo) {
            System.out.println(canBo.toString());
        }
    }

    // Thêm cán bộ
    public void them(Scanner sc) {
        // Chọn phân loại cán bộ
        System.out.println("Phân loại cán bộ - 1.Công nhân | 2.Kỹ sư | 3.Nhân viên");
        int loaiCanBo = Integer.parseInt(sc.nextLine());

        // Lấy các thông tin chung
        System.out.print("Họ và tên cán bộ: ");
        String hoTen = sc.nextLine();
        System.out.print("Tuổi cán bộ: ");
        int tuoi = Integer.parseInt(sc.nextLine());
        System.out.print("Giới tính(1.Nam - 2.Nữ - 3.Khác): ");
        GioiTinhEnum gioitinh = GioiTinhEnum.values()[Integer.parseInt(sc.nextLine()) - 1];

        // Lấy các thông tin riêng theo loại cán bộ, sau đấy thêm vào danh sách
        if (loaiCanBo == 1) {
            int capBac = themCongNhan(sc);
            CongNhan congNhan = new CongNhan(hoTen, tuoi, gioitinh, capBac);
            danhSachCanBo.add(congNhan);
            System.out.println("Đã thêm mới công nhân!");
        } else if (loaiCanBo == 2) {
            String nganhDaoTao = themKySu(sc);
            KySu kySu = new KySu(hoTen, tuoi, gioitinh, nganhDaoTao);
            danhSachCanBo.add(kySu);
            System.out.println("Đã thêm mới kỹ sư!");

        } else if (loaiCanBo == 3) {
            String congViec = themNhanVien(sc);
            NhanVien nhanVien = new NhanVien(hoTen, tuoi, gioitinh, congViec);
            danhSachCanBo.add(nhanVien);
            System.out.println("Đã thêm mới nhân viên!");
        } else {
            System.out.println("Vui lòng chọn đúng phân loại cán bộ");
        }
    }

    // Lấy thông tin riêng của công nhân
    private int themCongNhan(Scanner sc) {
        System.out.print("Cấp bậc (1-10): ");
        int capBac = Integer.parseInt(sc.nextLine());
        // Kiểm tra input cấp bậc từ 1-10, cho nhập lại nếu sai
        if(capBac < 1 || capBac > 10){
            System.out.println("Cấp bậc chỉ từ 1 đến 10!");
            return themCongNhan(sc);
        }
        return capBac;
    }

    // Lấy thông tin riêng của kỹ sư
    private String themKySu(Scanner sc) {
        System.out.print("Ngành đào tạo: ");
        return sc.nextLine();
    }

    // Lấy thông tin riêng của nhân viên
    private String themNhanVien(Scanner sc) {
        System.out.print("Công việc: ");
        return sc.nextLine();
    }

    // Tìm kiếm theo họ tên
    // - lấy keywords
    // - gọi hàm xử lí logic
    // - in ra kết quả
    public void timTheoTen(Scanner sc) {
        System.out.print("Nhập tên cán bộ cần tìm: ");
        String keywords = sc.nextLine();
        List<CanBo> results = logicTimTheoTen(keywords);
        if (results.isEmpty()) {
            System.out.println("Không tìm thấy kết quả");
        } else {
            System.out.println("Kết quả tìm kiếm: ");
            for (CanBo canBo : results) {
                System.out.println(canBo.toString());
            }
        }
    }

    // Tìm kiếm theo họ tên - xử lý logic
    private List<CanBo> logicTimTheoTen(String keywords) {
        List<CanBo> results = new ArrayList<>();
        for (CanBo canBo : danhSachCanBo) {
            if (canBo.getHoTen().toLowerCase().contains(keywords.toLowerCase())) {
                results.add(canBo);
            }
        }
        return results;
    }
}
