package dao;

public class Utilitaire {
    public String parse_String_to_Date(String str_to_date){
        str_to_date=str_to_date.replace('/','-');
        str_to_date=str_to_date.replace('.','-');
        str_to_date=str_to_date.replace(' ','-');
        str_to_date=str_to_date.replace(',','-');
        str_to_date=str_to_date.replace(';','-');
        str_to_date=str_to_date.replace(':','-');
        if(str_to_date.charAt(2)=='-'){
            str_to_date="20"+str_to_date;
        }
        return str_to_date;
    }
    public static Object toObject(Class clazz, String value) throws Exception {
        if (Boolean.class == clazz) {
            return Boolean.parseBoolean(value);
        }
        if (Byte.class == clazz) {
            return Byte.parseByte(value);
        }
        if (Short.class == clazz) {
            return Short.parseShort(value);
        }
        if (Integer.class == clazz) {
            return Integer.parseInt(value);
        }
        if (Long.class == clazz) {
            return Long.parseLong(value);
        }
        if (Float.class == clazz) {
            return Float.parseFloat(value);
        }
        if (Double.class == clazz) {
            return Double.parseDouble(value);
        }
        if (String.class == clazz) {
            return value;
        }
        throw new Exception("Type undefined " + clazz + " " + value);
    }
    public static String parse_String_to_Time(String str_to_time){
        str_to_time=str_to_time.replace('h',':');
        str_to_time=str_to_time.replace('H',':');
        str_to_time=str_to_time.replace('m',':');
        str_to_time=str_to_time.replace('M',':');
        str_to_time=str_to_time.replace('s',' ');
        str_to_time=str_to_time.replace('S',' ');
        str_to_time=str_to_time.replace('-',':');
        str_to_time=str_to_time.replace('.',':');
        str_to_time=str_to_time.replace(' ',':');
        str_to_time=str_to_time.replace('/',':');
        String ante_meridian=str_to_time.substring(str_to_time.length()-2);
        //comparaison si la lettre apres l heure est p: ou a:
        if(ante_meridian.compareToIgnoreCase("p:")==0 || ante_meridian.compareToIgnoreCase("a:")==0){
            String h=String.valueOf(str_to_time.charAt(0));
            if(str_to_time.charAt(1)!=':'){
                h=str_to_time.substring(0,1);
            }
            if(ante_meridian.compareToIgnoreCase("p:")==0){
                Integer h_to_integer=new Integer(h);
                int i=h_to_integer;
                i=i+12;
                if(i==24){
                    i=0;
                }else if(i>24){
                    i=i-12;
                }
                h_to_integer=new Integer(i);
                h=h_to_integer.toString();
                if(str_to_time.charAt(1)!=':'){
                    str_to_time=h+str_to_time.substring(2);
                }else{
                    str_to_time=h+str_to_time.substring(1);
                }
            }
            str_to_time=str_to_time.substring(0,str_to_time.length()-2);
        }
        if(str_to_time.charAt(str_to_time.length()-1)==':'){
            str_to_time=str_to_time.substring(0,str_to_time.length()-1);
        }
        if(str_to_time.length()<=5){
            str_to_time=str_to_time+":00";
        }
        return str_to_time;
    }
}
