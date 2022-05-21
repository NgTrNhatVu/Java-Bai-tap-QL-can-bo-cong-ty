package Model;

import Common.GioiTinhEnum;

public class CongNhan extends CanBo {

    private int capBac;

    public CongNhan(String hoTen, int tuoi, GioiTinhEnum gioiTinh, int capBac) {
        super(hoTen, tuoi, gioiTinh);
        if (capBac < 1 || capBac > 10) {
            throw new IllegalArgumentException("Cấp bậc từ 1 đến 10");
        }
        this.capBac = capBac;
    }

    public int getCapBac() {
        return capBac;
    }

    public void setCapBac(int capBac) {
        this.capBac = capBac;
    }

    @Override
    public String toString() {
        return String.format(
                "Công nhân{id=%-4d | Họ tên=%-20s | Tuổi=%-2d | Giới tính=%-4s | Cấp bậc=%-2d}",
                getId(), getHoTen(), getTuoi(), getGioiTinh().toString(), capBac
        );
    }
}
