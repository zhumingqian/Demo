package BookManagerArrayVersion;

import java.util.*;

/**
 * 功能菜单
 * @Author ZhuMingQ
 * 2020/7/18 17:07
 */
public class FunctionMenu {
    /**
     * 存放全部图书
     */
    static List<Book> listB = new ArrayList<Book>();
    Order ord = new Order();
    List<OrderItem> listOdi = new ArrayList<>();

    /**
     * 初始化List<Book>里面存放的内容
     */
    static {
        listB.add(new Book(1,"红楼梦        ",99.5,999));
        listB.add(new Book(2,"西游记        ",129.0,809));
        listB.add(new Book(3,"水浒传        ",118.5,799));
        listB.add(new Book(4,"三国演义       ",199.5,600));
        listB.add(new Book(5,"假如我有三天光明",59.9,100));
        listB.add(new Book(6,"鲁滨逊漂流记    ",49.0,999));
        listB.add(new Book(7,"围城           ",49.5,999));
        listB.add(new Book(8,"天才在左疯子在右 ",99.0,999));
        listB.add(new Book(9,"平凡的世界      ",39.5,999));
        listB.add(new Book(10,"呐喊           ",69.0,999));
    }

    /**
     * 主菜单功能
     */
    public void menu(){
        System.out.println("1.查看所有图书信息 \n 2.购买图书 \n 3.退出");
        Scanner input = new Scanner(System.in);
        try {
            int cho = input.nextInt();
            switch (cho){
                case 1:queryAll();
                    break;
                case 2:buyBook();
                    break;
                case 3:
                    System.out.println("谢谢使用!");
                    System.exit(0);
                    break;
            }
        }catch (InputMismatchException e){
            System.out.println("输入不符合规范！");
            menu();
        }
        menu();
    }
    /**
     * 查询所有图书信息
     */
    public void queryAll(){
        System.out.println("          图书列表");
        System.out.println("编号\t书名\t\t\t\t单价\t库存");
        System.out.println("-----------------------------------");
        for (Book b:
             listB) {
            b.print();
        }
        System.out.println("-----------------------------------");
    }
    /**
     * 购买图书功能
     */
    public void buyBook(){
        queryAll();
        int count=1;
        int orderId=1;
        do {
            OrderItem odi = new OrderItem();
            Scanner input = new Scanner(System.in);
            System.out.println("请输入图书编号选择图书:");
            int choId = input.nextInt();
            for(int i = 0 ; i < listB.size() ; i++){
                if(listB.get(i).getBookId() == choId){
                    System.out.println("请输入购买图书数量：");
                    int choNum = input.nextInt();
                    odi.setBookName(listB.get(i).getBookName());
                    odi.setNum(choNum);
                    odi.setPrice(listB.get(i).getPrice());
                    listB.get(i).setStorage(listB.get(i).getStorage()-choNum);
                    listOdi.add(odi);
                    count++;
                    orderId++;
                }
            }
            if(count < 3){
                System.out.println("请继续购买图书。");
            }
        }while(count < 4);
        ord.setOrderId("0000"+orderId);
        ord.setListOrderItem(listOdi);
        System.out.println("购买成功!");
        System.out.println("正在打印订单.........");
        orderPrint();
        orderId++;
    }
    /**
     * 打印订单
     */
    public void orderPrint(){
        System.out.println("          图书订单");
        System.out.println("图书订单号:"+ord.getOrderId());
        System.out.println("图书名称\t\t\t\t购买数量\t购买单价");
        System.out.println("--------------------------------");
        for (OrderItem ot:
             ord.getListOrderItem()) {
            ot.print();
            ord.setTotal(ord.getTotal() + (ot.getNum() * ot.getPrice()));
        }
        System.out.println("--------------------------------");
        System.out.println("订单总额:"+ord.getTotal());
        System.out.println("日期:"+new Date());
        System.out.println("********************************");
    }
}
