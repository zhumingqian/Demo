import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author ZhuMingQ
 * 2020/7/18 11:25
 */
public class Test {
    public static void main(String[] args){
//        List<DVDInfo> listD = new ArrayList<DVDInfo>();
//        listD.add(new DVDInfo(1,"罗马夏日",0," "));
//        listD.add(new DVDInfo(2,"风声鹤唳",0," "));
//        listD.add(new DVDInfo(3,"浪漫满屋",0," "));
        DVDManager dm = new DVDManager();
        dm.menu();
    }
}
