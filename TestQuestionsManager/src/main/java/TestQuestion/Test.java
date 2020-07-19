package TestQuestion;

/**
 * @Author ZMQ
 * 2020/7/18
 * @since 1.8
 */
public class Test {
    public static void main(String[] args){
        QuestionInfoDaoImpl qif = new QuestionInfoDaoImpl();
        qif.menu();
        BaseDao.close(QuestionInfoDaoImpl.con,QuestionInfoDaoImpl.stt,QuestionInfoDaoImpl.rs);
    }
}
