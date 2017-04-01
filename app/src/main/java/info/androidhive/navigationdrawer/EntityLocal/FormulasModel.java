package info.androidhive.navigationdrawer.EntityLocal;

import com.activeandroid.annotation.Table;



import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.query.Select;

import java.util.List;

import info.androidhive.navigationdrawer.activity.Formulas;

@Table(name="Formulas")
public class FormulasModel extends Model {

    public FormulasModel(){};

    @Column(name="name")
    public String name;

    @Column(name="txt_1")
    public String txt_1;

    @Column(name="txt_2")
    public String txt_2;

    @Column(name="value_3")
    public String value_3;

    @Column(name="value_4")
    public String value_4;

    @Column(name="value_5")
    public String value_5;

    @Column(name="value_6")
    public String value_6;

    @Column(name="value_7")
    public String value_7;


    public String getName() {
        FormulasModel formulasModel=new Select().from(FormulasModel.class).executeSingle();
        return formulasModel.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTxt_1() {
        return txt_1;
    }

    public void setTxt_1(String txt_1) {
        this.txt_1 = txt_1;
    }

    public String getTxt_2() {
        return txt_2;
    }

    public void setTxt_2(String txt_2) {
        this.txt_2 = txt_2;
    }

    public String getValue_3() {
        return value_3;
    }

    public void setValue_3(String value_3) {
        this.value_3 = value_3;
    }

    public String getValue_4() {
        return value_4;
    }

    public void setValue_4(String value_4) {
        this.value_4 = value_4;
    }

    public String getValue_5() {
        return value_5;
    }

    public void setValue_5(String value_5) {
        this.value_5 = value_5;
    }

    public String getValue_6() {
        return value_6;
    }

    public void setValue_6(String value_6) {
        this.value_6 = value_6;
    }

    public String getValue_7() {
        return value_7;
    }

    public void setValue_7(String value_7) {
        this.value_7 = value_7;
    }

    public void saveData(String name, String txtuno, String txtdos, String val1, String val2, String val3){
        this.name=name;
        this.txt_1 =txtuno;
        this.txt_2 =txtdos;
        this.value_3=val1;
        this.value_4=val2;
        this.value_5=val3;
        save();
    }

    public void saveDataDos(String name, String txtuno, String txtdos, String val1, String val2, String val3, String val4, String val5){
        this.name=name;
        this.txt_1 =txtuno;
        this.txt_2 =txtdos;
        this.value_3=val1;
        this.value_4=val2;
        this.value_5=val3;
        this.value_6=val4;
        this.value_7=val5;
        save();
    }

    public static List<FormulasModel> selectAll(){
        return new Select().from(FormulasModel.class).orderBy("name ASC").execute();
    }


}
