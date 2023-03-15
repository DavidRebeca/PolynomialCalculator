package Controller;

import Model.InputNecorespunzator;
import Model.Polinomial;
import View.CalcView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcController {

    private CalcView calcView;
    private Polinomial calcModel;

    public CalcController(CalcView calcView, Polinomial calcModel) {
        this.calcView = calcView;
        this.calcModel = calcModel;
        calcView.addCalculeazaListener(new CalculeazaListener());
    }
    class CalculeazaListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    Polinomial p1=calcModel.convertInput(calcView.getPolinom1());
                    Polinomial p2=calcModel.convertInput(calcView.getPolinom2());
                    if(calcView.getOperatie()=="ADUNARE"){
                        Polinomial rez=calcModel.addPolinoame(p1,p2);
                        calcView.showRezultat(rez.toString());
                    }
                    if(calcView.getOperatie()=="SCADERE"){
                        Polinomial rez=calcModel.substractPolinoame(p1,p2);
                        calcView.showRezultat(rez.toString());
                    }
                    if(calcView.getOperatie()=="INMULTIRE"){
                        Polinomial rez=calcModel.multiplyPolinoame(p1,p2);
                        calcView.showRezultat(rez.toString());
                    }
                    if(calcView.getOperatie()=="IMPARTIRE"){
                        Polinomial[] rezultate=new Polinomial[2];
                        rezultate=calcModel.dividePolinoame(p1,p2);
                        if(rezultate==null)
                            calcView.showRezultat("Polinoamele nu se pot imparti");
                        else
                            calcView.showRezultat("Cat= "+rezultate[0].toString()+"   Rest="+rezultate[1].toString());
                    }
                    if(calcView.getOperatie()=="DERIVARE"){
                        Polinomial rez=new Polinomial();
                        if(calcView.getPolinomSelectat()=="Polinom 1")
                                rez=calcModel.deriveazaPolinom(p1);
                        else
                                rez=calcModel.deriveazaPolinom(p2);
                        calcView.showRezultat(rez.toString());
                    }
                    if(calcView.getOperatie()=="INTEGRARE"){
                        Polinomial rez=new Polinomial();
                        if(calcView.getPolinomSelectat()=="Polinom 1")
                            rez=calcModel.integreazaPolinom(p1);
                        else
                            rez=calcModel.integreazaPolinom(p2);
                        calcView.showRezultat(rez.toString());
                    }

                } catch (InputNecorespunzator ex) {
                   calcView.showRezultat("Input necorespunzator. Reintroduceti polinoame!");
                }


            }
        }


}


