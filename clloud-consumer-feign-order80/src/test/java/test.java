

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class test {
    public static void main(String[] args) {
//Date date =null;
String dzsj="20201001102241";

        Date date = new Date();
        try {
            date = new SimpleDateFormat("yyyyMMddHHmmss").parse(dzsj);//先按照原格式转换为时间
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String str = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);//再将时间转换为对应格式字符串

//        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("yyyyMMdd HH:mm:ss");
//        try {
//            date = simpleDateFormat.parse(dzsj);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        System.out.println(str);

        String TimeNow = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());
        System.out.println(TimeNow);
    }
}
