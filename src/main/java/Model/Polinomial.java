package Model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class Polinomial {

    private List<Monomial> polinom = new ArrayList<Monomial>();
    public List<Monomial> getPolinom() {
        return polinom;
    }
    public void setPolinom(List<Monomial> polinom) {
        this.polinom = polinom;
    }

    public Polinomial addPolinoame(Polinomial p1, Polinomial p2) {
        Polinomial p=new Polinomial();
        List<Monomial> rezultat = new ArrayList<Monomial>();
        p1.polinom.forEach(pol1->{
            AtomicBoolean ok= new AtomicBoolean(false);
            Monomial m=new Monomial();
            p2.polinom.forEach(pol2->{
                if (pol1.getGrad()==pol2.getGrad()){
                    ok.set(true);
                    m.setGrad(pol1.getGrad());
                    m.setCoeficient(pol1.getCoeficient()+pol2.getCoeficient());
                }
            });
            if(ok.get()==false){
                m.setGrad(pol1.getGrad());
                m.setCoeficient(pol1.getCoeficient());
            }
            rezultat.add(m);
        });
        p2.polinom.forEach(pol2->{
            AtomicBoolean ok= new AtomicBoolean(true);
            Monomial m=new Monomial();
            rezultat.forEach(rez->{
                if (rez.getGrad()==pol2.getGrad())
                    ok.set(false);
            });
            if(ok.get()==true){
                m.setGrad(pol2.getGrad());
                m.setCoeficient(pol2.getCoeficient());
            }
            rezultat.add(m);
        });
        Collections.sort(rezultat);
        p.setPolinom(rezultat);
        return p;
    }
    public Polinomial substractPolinoame(Polinomial p1, Polinomial p2) {
        Polinomial p=new Polinomial();
        List<Monomial> rezultat = new ArrayList<Monomial>();
        p1.polinom.forEach(pol1->{
            AtomicBoolean ok= new AtomicBoolean(false);
            Monomial m=new Monomial();
            p2.polinom.forEach(pol2->{
                if (pol1.getGrad()==pol2.getGrad()){
                    ok.set(true);
                    m.setGrad(pol1.getGrad());
                    m.setCoeficient(pol1.getCoeficient()-pol2.getCoeficient());
                }
            });
            if(ok.get()==false){
                m.setGrad(pol1.getGrad());
                m.setCoeficient(pol1.getCoeficient());
            }
            rezultat.add(m);
        });
        p2.polinom.forEach(pol2->{
            AtomicBoolean ok= new AtomicBoolean(true);
            Monomial m=new Monomial();
            rezultat.forEach(rez->{
                if (rez.getGrad()==pol2.getGrad())
                    ok.set(false);
            });
            if(ok.get()==true){
                m.setGrad(pol2.getGrad());
                m.setCoeficient((-1)*pol2.getCoeficient());
            }
            rezultat.add(m);
        });
        Collections.sort(rezultat);
        p.setPolinom(rezultat);
        return p;
    }
    public Polinomial multiplyPolinoame(Polinomial p1, Polinomial p2) {
        Polinomial p=new Polinomial();
        List<Monomial> rezultat = new ArrayList<Monomial>();
        p1.polinom.forEach(pol1->{
            p2.polinom.forEach(pol2->{
                AtomicBoolean ok= new AtomicBoolean(true);
                Monomial m=new Monomial();
                m.setGrad(pol1.getGrad()+pol2.getGrad());
                m.setCoeficient(pol1.getCoeficient()*pol2.getCoeficient());
                rezultat.forEach(rez-> {
                    if(rez.getGrad()==m.getGrad()){
                        ok.set(false);
                        rez.setCoeficient(m.getCoeficient()+rez.getCoeficient());
                    }
                });
                if(ok.get()==true)
                    rezultat.add(m);
            });});
        Collections.sort(rezultat);
        p.setPolinom(rezultat);
        return p;
    }
    public Polinomial[] dividePolinoame(Polinomial p1, Polinomial p2) {
        List<Monomial> rez = new ArrayList<Monomial>();
        Monomial m=new Monomial();
        m.setGrad(0);
        m.setCoeficient(0);
        rez.add(m);
        Polinomial pol=new Polinomial();
        pol.setPolinom(rez);
        Polinomial[] rezultate= {pol, pol};///rezultate[0]-catul      rezultate[1]-restul
        Collections.sort(p1.polinom);
        Collections.sort(p2.polinom);
        if(p1.polinom.get(0).getGrad()<p2.polinom.get(0).getGrad()||(p2.polinom.get(0).getGrad()==0&&p2.polinom.get(0).getCoeficient()==0))
            return null;
        Monomial curent=new Monomial();
        curent.setCoeficient(p1.polinom.get(0).getCoeficient()/p2.polinom.get(0).getCoeficient());
        curent.setGrad(p1.polinom.get(0).getGrad()-p2.polinom.get(0).getGrad());
        rezultate[0].polinom.add(curent);
        rezultate[0].polinom.remove(0);
        Polinomial inmultire =  multiplyPolinoame(rezultate[0], p2);
        rezultate[1] = substractPolinoame(p1, inmultire);
        rezultate[1].polinom.remove(0);
        while((rezultate[1].polinom.get(0).getGrad()>=p2.polinom.get(0).getGrad())&&p2.polinom.get(0).getGrad()!=0) {
            List<Monomial> termenCurent = new ArrayList<Monomial>();
            Monomial curent2 = new Monomial();
            curent2.setCoeficient(rezultate[1].polinom.get(0).getCoeficient() / p2.polinom.get(0).getCoeficient());
            curent2.setGrad(rezultate[1].polinom.get(0).getGrad() - p2.polinom.get(0).getGrad());
            termenCurent.add(curent2);
            Polinomial polinomInmultire = new Polinomial();
            polinomInmultire.setPolinom(termenCurent);
            rezultate[0].polinom.add(curent2);
            inmultire = multiplyPolinoame(polinomInmultire, p2);
            rezultate[1] = substractPolinoame(rezultate[1], inmultire);
            rezultate[1].polinom.remove(0);
        }
        return rezultate;
    }
    public Polinomial deriveazaPolinom(Polinomial p1) {
        Polinomial p=new Polinomial();
        List<Monomial> rezultat = new ArrayList<Monomial>();
        p1.polinom.forEach(pol1->{
            Monomial m=new Monomial();
            if(pol1.getGrad()==0)
                m.setCoeficient(0);
            else{
                m.setGrad(pol1.getGrad()-1);
                m.setCoeficient(pol1.getCoeficient()*pol1.getGrad());
            }
            rezultat.add(m);});
        Collections.sort(rezultat);
        p.setPolinom(rezultat);
        return p;
    }
    public Polinomial integreazaPolinom(Polinomial p1) {
        Polinomial p=new Polinomial();
        List<Monomial> rezultat = new ArrayList<Monomial>();
        p1.polinom.forEach(pol1->{
            Monomial m=new Monomial();
            m.setGrad(pol1.getGrad()+1);
            m.setCoeficient(pol1.getCoeficient()/(double)m.getGrad());
            rezultat.add(m);
        });
        Collections.sort(rezultat);
        p.setPolinom(rezultat);
        return p;
    }
   public Polinomial convertInput(String inputString) throws InputNecorespunzator {
        Polinomial p = new Polinomial();
        List<Monomial> pol=new ArrayList<Monomial>();
        String regex = "([-]?([1-9]+)?(X(\\^[1-9]+)?)?)";//pattern pentru monom
        Boolean ok = true;
        if(inputString.length()==0)///daca nu s-a introdus nimic
            ok=false;
        if(ok) {
            int poz = inputString.indexOf('-');
            String s = inputString;
            while (poz != -1) { ///oriunde exista - se adauga +
                inputString = inputString.substring(0, poz) + '+' + inputString.substring(poz);
                s = s.substring(0, poz) + "r+" + s.substring(poz + 1);
                poz = s.indexOf('-');
            }
            if (inputString.charAt(0) == '+') ///se elimina primul + daca e primul caracter
                inputString = inputString.substring(1);
            String[] sol = inputString.split("\\+");///split dupa +, impartire in monoame
            for (String a : sol) {
                if (a.matches(regex) == false) ///verific daca patternul stabilit e respectat
                    ok = false;
                if (ok == true) {
                    Monomial m = new Monomial();
                    if (a.indexOf('^') == -1) {
                        if (a.matches("^[-]?[0-9]+$") == true) { ///grad=0
                            m.setCoeficient(Integer.parseInt(a));
                            m.setGrad(0);
                        } else { ///cazul nX, grad=1
                            if (a.equals("X")) {  ///cazul n=1
                                m.setCoeficient(1);
                                m.setGrad(1);
                            } else {
                                String[] sol2 = a.split("X");
                                for (String a2 : sol2) {
                                    System.out.println(a2);
                                    if (a2.equals("-"))
                                        m.setCoeficient(-1);
                                    else m.setCoeficient(Integer.parseInt(a2));
                                }
                                m.setGrad(1);
                            }
                        }
                    } else { ///cazul nx^m
                        String[] sol2 = a.split("X\\^");
                        int coef = 0;
                        for (String a2 : sol2) {
                            if (coef == 1)
                                m.setGrad(Integer.parseInt(a2));
                            else {
                                if (a2.matches("^[-]?[0-9]+$") == false) {
                                    if (a2.equals("-"))
                                        m.setCoeficient(-1);
                                    else
                                        m.setCoeficient(1);
                                    coef++;
                                } else { m.setCoeficient(Integer.parseInt(a2));
                                    coef++;
                                }
                            }
                        }
                    }
                    pol.add(m);
                }
            }
        }
        if (ok == true){
            p.setPolinom(pol);
            return p;
        }
        else   throw new InputNecorespunzator();
    }
    @Override
    public String toString() {
        String s = "";
        for (Monomial m : polinom) {
            String format;
            if(m.getCoeficient() == (long) m.getCoeficient())
                format="%.00f";
            else format="%.02f";
            if(m.getCoeficient()!=0){
            if (m.getCoeficient() == 1) {
                if (m.getGrad()==1)  s = s + "+X";
                else {
                    if (m.getGrad()==0)
                         s = s + "+" + String.format(format,m.getCoeficient());
                     else s = s + "+X^" + m.getGrad();
                }
            } else {
                if (m.getCoeficient() == -1) {
                    if (m.getGrad()==1)  s = s + "-X";
                    else {
                        if (m.getGrad()==0)
                            s = s + "-1";
                        else s = s + "-X^" + m.getGrad();
                    }
                } else {
                    if (m.getGrad() == 0) {
                        if (m.getCoeficient() < 0)
                            s = s + String.format(format,m.getCoeficient());
                        else s = s + "+" + String.format(format,m.getCoeficient()) ;
                    } else {
                        if(m.getGrad()==1){
                            if (m.getCoeficient() < 0)
                                s = s + String.format(format, m.getCoeficient()) + "X";
                            else s = s + "+" + String.format(format,m.getCoeficient()) + "X";
                        }
                        else {
                            if (m.getCoeficient() < 0)
                                s = s + String.format(format,m.getCoeficient()) + "X^" + m.getGrad();
                            else s = s + "+" + String.format(format,m.getCoeficient()) + "X^" + m.getGrad();
                        }
                    }
                }
            }
        }}
        if(s.length()!=0&&s.charAt(0)=='+')
            s=s.substring(1);
        return s;
    }
}

