/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyKhachHang;

/**
 *
 * @author pc
 */
public class TaiKhoanKH {

    private long ID;
    private String taiKhoan;
    private String matKhau;

    public TaiKhoanKH() {
    }

    public TaiKhoanKH(long ID, String taiKhoan, String matKhau) {
        this.ID = ID;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

    public TaiKhoanKH(String taiKhoan, String matKhau) {
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public Object[] toDataRow() {
        return new Object[]{ID, taiKhoan, matKhau};
    }

    @Override
    public String toString() {
        return taiKhoan + matKhau;
    }
}
