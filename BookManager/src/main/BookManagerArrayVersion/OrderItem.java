package BookManagerArrayVersion;

/**
 *
 * 订单列表
 * @Author ZhuMingQ
 * 2020/7/18 16:57
 */
public class OrderItem {
    /**
     * 图书名称
     */
    private String bookName;
    /**
     * 图书单价
     */
    private Double price;
    /**
     * 购买数量
     */
    private Integer num;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * 打印信息
     */
    public void print(){
        System.out.println(getBookName()+"\t\t"+getNum()+"\t\t"+getPrice());
    }
}
