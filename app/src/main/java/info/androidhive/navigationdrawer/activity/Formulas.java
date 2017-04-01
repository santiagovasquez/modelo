package info.androidhive.navigationdrawer.activity;

/**
 * Created by santiagovasquez on 29/03/2017.
 */
public class Formulas {
    private Float dato1;
    private Float dato2;
    private Float dato3;
    private Float dato4;
    private Float dato5;

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




}
