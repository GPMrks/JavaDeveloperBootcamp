package modularizacao.java.utils;

import modularizacao.java.utils.Internal.DivHelper;
import modularizacao.java.utils.Internal.MultHelper;
import modularizacao.java.utils.Internal.SubHelper;
import modularizacao.java.utils.Internal.SumHelper;

public class Calculadora {

    private DivHelper divhelper;
    private SumHelper sumhelper;
    private MultHelper multhelper;
    private SubHelper subhelper;

    public Calculadora(){
        divhelper = new DivHelper();
        sumhelper = new SumHelper();
        multhelper = new MultHelper();
        subhelper = new SubHelper();

    }

    public int sum(int a, int b){
        return sumhelper.execute(a,b);
    }

    public int sub(int a, int b){
        return subhelper.execute(a,b);
    }

    public int mult(int a, int b){
        return multhelper.execute(a,b);
    }

    public int div(int a, int b){
        return divhelper.execute(a,b);
    }

}
