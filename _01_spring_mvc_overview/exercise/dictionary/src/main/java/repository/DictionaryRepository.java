package repository;


import java.util.HashMap;
import java.util.Map;

public class DictionaryRepository implements Repository{
    private static Map<String,String> map;
    static {
        map = new HashMap<>();
        map.put("hello","xin chào");
        map.put("goodbye","tạm biệt");
        map.put("sorry","xin lỗi");
        map.put("student","sinh viên");
    }
    @Override
    public String findValue(String string) {
        return map.get(string);
    }
}
