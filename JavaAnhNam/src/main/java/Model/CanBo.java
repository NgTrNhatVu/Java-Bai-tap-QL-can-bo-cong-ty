package Model;

import Common.GioiTinhEnum;

public class CanBo {
    private int id;
    private String hoTen;
    private int tuoi;
    private GioiTinhEnum gioiTinh;

    public CanBo(String hoTen, int tuoi, GioiTinhEnum gioiTinh) {
        this.hoTen = hoTen;
        if (tuoi < 1 || tuoi > 100) {
            throw new IllegalArgumentException("Tuổi cán bộ không hợp lệ");
        }
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
    }

    public int getId() {
        return id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public GioiTinhEnum getGioiTinh() {
        return gioiTinh;
    }

    @Override
    public String toString() {
        return "CanBo{" +
                "id=" + id +
                ", hoTen='" + hoTen + '\'' +
                ", tuoi=" + tuoi +
                ", gioiTinh=" + gioiTinh +
                '}';
    }
}
