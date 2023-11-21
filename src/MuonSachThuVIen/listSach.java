package MuonSachThuVIen;

public class listSach {

    private String tenSach;
    private String theLoai;
    private String tacGia;

    public listSach() {
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public listSach(String tenSach, String theLoai, String tacGia) {
        this.tenSach = tenSach;
        this.theLoai = theLoai;
        this.tacGia = tacGia;
    }

    public Object[] toDataRow() {
        return new Object[]{this.tenSach, this.theLoai, this.tacGia};
    }

    @Override
    public String toString() {
        return "Tên sách: " + tenSach + ", Thể loại: " + theLoai + ", Tác giả: " + tacGia;
    }

}
