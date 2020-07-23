package BookManagerArrayVersion;

import java.util.Date;
import java.util.List;

/**
 *
 * 订单管理
 * @Author ZhuMingQ
 * 2020/7/18 16:57
 */
public class Order {
    /**
     * 订单号
     */
    private String orderId;
    /**
     * 订单总额
     */
    private double total=0;
    /**
     * 订单日期
     */
    private Date date;
    /**
     * 订单项列表
     */
    private List<OrderItem> listOrderItem;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<OrderItem> getListOrderItem() {
        return listOrderItem;
    }

    public void setListOrderItem(List<OrderItem> listOrderItem) {
        this.listOrderItem = listOrderItem;
    }
}
