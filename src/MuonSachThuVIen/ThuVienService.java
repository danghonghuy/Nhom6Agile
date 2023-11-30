package MuonSachThuVIen;

import QuanLyKhachHang.TaiKhoanKH;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class ThuVienService {

    List<listSach> listSach = new ArrayList<>();
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = null;

    public List<listSach> getAll() {
        sql = " select tensach,theloai,tacgia from sach";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                listSach LS = new listSach(rs.getString(1), rs.getString(2), rs.getString(3));
                listSach.add(LS);
            }
            return listSach;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<TaiKhoanKH> DSTK() {
        List<TaiKhoanKH> ds = new ArrayList<>();
        sql = " select * from taikhoankhachhang ";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                TaiKhoanKH tk = new TaiKhoanKH(rs.getInt(1), rs.getString(2), rs.getString(3));
                ds.add(tk);
            }
            return ds;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public boolean addKH(String taikhoan, String matkhau) {
        sql = " insert into taikhoankhachhang (taikhoan,matkhau) values (?,?) ";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, taikhoan);
            ps.setString(2, matkhau);
            int rowAdd = ps.executeUpdate();
            if (rowAdd > 0) {

                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean dangNhap(String taiKhoan, String matKhau) {
        sql = "select * from taikhoankhachhang where taikhoan = ? and matkhau = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, taiKhoan);
            ps.setString(2, matKhau);
            rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();;
            return false;
        }

    }

    public boolean xoaTK(String taiKhoan) {

        sql = "delete from taikhoankhachhang where taikhoan = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, taiKhoan);
            int i = ps.executeUpdate();
            return i > 0;

        } catch (Exception e) {
            return false;
        }
    }

    public boolean taiKhoanTonTai(String taiKhoan) {
        List<TaiKhoanKH> listTK = DSTK();
        for (TaiKhoanKH taiKhoanKH : listTK) {
            if (taiKhoanKH.getTaiKhoan().equals(taiKhoan)) {
                return true;
            }

        }
        return false;

    }

    public List<listSach> searchSach(String tenSach) {
        List<listSach> listS = new ArrayList<>();
        sql = "select * from sach where tensach like ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + tenSach + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                listSach ls = new listSach(rs.getString(1), rs.getString(2), rs.getString(3));
                listS.add(ls);

            }

        } catch (Exception e) {
        }
        return listS;
    }

    public static void main(String[] args) {
        ThuVienService TVS = new ThuVienService();
        List<listSach> kq = TVS.getAll();
        for (listSach sach : kq) {
            System.out.println(sach.toString());

        }

    }

}
