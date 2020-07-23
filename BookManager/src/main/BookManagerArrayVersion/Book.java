package BookManagerArrayVersion;

/**
 * 图书类
 * @Author ZhuMingQ
 * 2020/7/18 16:57
 */
public class Book {
    /**
     * 图书编号
     */
    private Integer bookId;
    /**
     * 图书名称
     */
    private String bookName;
    /**
     * 图书单价
     */
    private Double price;
    /**
     * 库存数量
     */
    private Integer storage;

    public Book(Integer bookId, String bookName, Double price, Integer storage) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.price = price;
        this.storage = storage;
    }

    public Book(){}

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

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

    public Integer getStorage() {
        return storage;
    }

    public void setStorage(Integer storage) {
        this.storage = storage;
    }

    /**
     * 打印图书信息
     */
    public void print(){
        System.out.println(getBookId()+"\t\t"+getBookName()+"\t\t"+getPrice()+"\t"+getStorage());
    }
}
