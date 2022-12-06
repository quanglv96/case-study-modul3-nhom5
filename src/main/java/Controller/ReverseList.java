package Controller;

import com.mysql.cj.result.LocalDateTimeValueFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReverseList {
    public <E> List<E> reverse(List<E> list){
        ArrayList<E> newList=new ArrayList<>();
        for (int i = (list.size()-1); i >=0; i--) {
            newList.add(list.get(i));
        }
        return newList;
    }
}
