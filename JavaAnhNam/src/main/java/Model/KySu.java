package Model;

import Common.GioiTinhEnum;

public class KySu extends CanBo{
    private String nganhDaoTao;

    public KySu(String hoTen, int tuoi, GioiTinhEnum gioiTinh, String nganhDaoTao) {
        super(hoTen, tuoi, gioiTinh);
        this.nganhDaoTao = nganhDaoTao;
    }

    public String getNganhDaoTao() {
        return nganhDaoTao;
    }

    public void setNganhDaoTao(String nganhDaoTao) {
        this.nganhDaoTao = nganhDaoTao;
    }

    @Override
    public String toString() {
        return String.format(
                "Kỹ sư    {id=%-4d | Họ tên=%-20s | Tuổi=%-2d | Giới tính=%-4s | Ngành đào tạo=%-15s}",
                getId(), getHoTen(), getTuoi(), getGioiTinh().toString(), nganhDaoTao
        );
    }
}
