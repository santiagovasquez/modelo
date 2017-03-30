package info.androidhive.navigationdrawer.EntityLocal;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name="formulas")
public class ResultsFormula extends Model {

    public ResultsFormula(){};

    @Column(name="name")
    public String name;

    @Column(name="txt_value1")
    public int txt_value1;

    @Column(name="txt_value2")
    public int txt_value2;

    @Column(name="value1")
    public int value1;

    @Column(name="value2")
    public int value2;

    @Column(name="value3")
    public int value3;

    @Column(name="value4")
    public int value4;

    @Column(name="value5")
    public int value5;

    @Column(name="value6")
    public int value6;

    @Column(name="value7")
    public int value7;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTxt_value1() {
        return txt_value1;
    }

    public void setTxt_value1(int txt_value1) {
        this.txt_value1 = txt_value1;
    }

    public int getTxt_value2() {
        return txt_value2;
    }

    public void setTxt_value2(int txt_value2) {
        this.txt_value2 = txt_value2;
    }

    public int getValue1() {
        return value1;
    }

    public void setValue1(int value1) {
        this.value1 = value1;
    }

    public int getValue2() {
        return value2;
    }

    public void setValue2(int value2) {
        this.value2 = value2;
    }

    public int getValue3() {
        return value3;
    }

    public void setValue3(int value3) {
        this.value3 = value3;
    }

    public int getValue4() {
        return value4;
    }

    public void setValue4(int value4) {
        this.value4 = value4;
    }

    public int getValue5() {
        return value5;
    }

    public void setValue5(int value5) {
        this.value5 = value5;
    }

    public int getValue6() {
        return value6;
    }

    public void setValue6(int value6) {
        this.value6 = value6;
    }

    public int getValue7() {
        return value7;
    }

    public void setValue7(int value7) {
        this.value7 = value7;
    }



}
