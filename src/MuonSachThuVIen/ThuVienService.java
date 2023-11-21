
package MuonSachThuVIen;

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

    public static void main(String[] args) {
        ThuVienService TVS = new ThuVienService();
        List<listSach> kq = TVS.getAll();
        for (listSach sach : kq) {
            System.out.println(sach.toString());
            
        }
    }
}
