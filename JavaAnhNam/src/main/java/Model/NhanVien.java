package Model;

import Common.GioiTinhEnum;

public class NhanVien extends CanBo {
    private String congViec;

    public NhanVien(String hoTen, int tuoi, GioiTinhEnum gioiTinh, String congViec) {
        super(hoTen, tuoi, gioiTinh);
        this.congViec = congViec;
    }

    public String getCongViec() {
        return congViec;
    }

    public void setCongViec(String congViec) {
        this.congViec = congViec;
    }

    @Override
    public String toString() {
        return String.format(
                "Nhân viên{id=%-4d | Họ tên=%-20s | Tuổi=%-2d | Giới tính=%-4s | Công việc=%-15s}",
                getId(), getHoTen(), getTuoi(), getGioiTinh().toString(), congViec
        );
    }
}
