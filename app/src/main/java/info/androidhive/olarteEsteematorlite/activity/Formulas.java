package info.androidhive.olarteEsteematorlite.activity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by santiagovasquez on 29/03/2017.
 */
public class Formulas {
    private Float dato1;
    private Float dato2;
    private Float dato3;
    private Float dato4;
    private Float dato5;
    private Float dato6;
    private Float dato7;
    private Float dato8;

    String name;
    String uno;
    String dos;
    String resul1;
    String resul2;
    String resul3;
    String uid;

    String txt_uno;
    String txt_dos;
    String s1;
    String s2;
    String s3;
    String s4;
    String s5;

    public Formulas(float dato1, float dato2){
        this.dato1 = dato1;
        this.dato2 = dato2;
    }

    public Formulas(float dato1, float dato2, float dato3) {
        this.dato1 = dato1;
        this.dato2 = dato2;
        this.dato3 = dato3;
    }

    public Formulas(float dato1, float dato2, float dato3, float dato4) {
        this.dato1 = dato1;
        this.dato2 = dato2;
        this.dato3 = dato3;
        this.dato4 = dato4;
    }

    public Formulas(float dato1, float dato2, float dato3, float dato4, float dato5) {
        this.dato1 = dato1;
        this.dato2 = dato2;
        this.dato3 = dato3;
        this.dato4 = dato4;
        this.dato5 = dato5;
    }

    public Formulas(float dato1, float dato2, float dato3, float dato4, float dato5, float dato6) {
        this.dato1 = dato1;
        this.dato2 = dato2;
        this.dato3 = dato3;
        this.dato4 = dato4;
        this.dato5 = dato5;
        this.dato6 = dato6;
    }

    public Formulas(float dato1, float dato2, float dato3, float dato4, float dato5, float dato6, float dato7) {
        this.dato1 = dato1;
        this.dato2 = dato2;
        this.dato3 = dato3;
        this.dato4 = dato4;
        this.dato5 = dato5;
        this.dato6 = dato6;
        this.dato7 = dato7;
    }

    public Formulas(float dato1, float dato2, float dato3, float dato4, float dato5, float dato6, float dato7, float dato8) {
        this.dato1 = dato1;
        this.dato2 = dato2;
        this.dato3 = dato3;
        this.dato4 = dato4;
        this.dato5 = dato5;
        this.dato6 = dato6;
        this.dato7 = dato7;
        this.dato8 = dato8;
    }

    public Formulas(String name, String uno, String dos, String resul1, String resul2, String resul3, String uid) {
        this.name=name;
        this.uno=uno;
        this.dos=dos;
        this.resul1=resul1;
        this.resul2=resul2;
        this.resul3=resul3;
        this.uid=uid;
    }

    public Formulas(String name, String txt_uno, String txt_dos, String s1, String s2, String s3, String s4, String s5, String uid) {
        this.name=name;
        this.txt_uno=txt_uno;
        this.txt_dos=txt_dos;
        this.s1=s1;
        this.s2=s2;
        this.s3=s3;
        this.s4=s4;
        this.s5=s5;
        this.uid=uid;
    }

    public Float[] Formula1(){
        Float result,resultmargen;
        result = ((this.dato1)/(1-this.dato2/100));
        resultmargen=result-this.dato1;
        Float[] data1=new Float[3];
        data1[0]=result;
        data1[1]=resultmargen;
        data1[2]=this.dato1;
        return data1;
    }

    public Float[] Formula3() {
        Float result,result1,result2,result3;
        result= (this.dato1/this.dato2)*100;
        result1=result*(1-this.dato2/100);
        result2=result-result1;
        result3=(result2-this.dato1);

        Float[] data3=new Float[5];
        data3[0]=result;
        data3[1]=result1;
        data3[2]=result2;
        data3[3]=result3;
        data3[4]=this.dato1;
        return data3;
    }

    public Map<String, Object> formula1(){
        HashMap<String, Object> result1 = new HashMap<>();
        result1.put("nombre",name);
        result1.put("type_formula","1");
        result1.put("txt1", uno);
        result1.put("txt2", dos);
        result1.put("val1", resul1);
        result1.put("val2", resul2);
        result1.put("val3", resul3);
        result1.put("uid", uid);
        return result1;
    }

    public Map<String, Object> formula3(){
        HashMap<String, Object> result2 = new HashMap<>();
        result2.put("nombre",name);
        result2.put("type_formula","2");
        result2.put("txt1",txt_uno);
        result2.put("txt2", txt_dos);
        result2.put("val1", s1);
        result2.put("val2", s2);
        result2.put("val3", s3);
        result2.put("val4", s4);
        result2.put("val5", s5);
        result2.put("uid", uid);
        return result2;
    }




}
