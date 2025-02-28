package operatii;

import model.Polinom;

import java.util.Map;

public class Functii {

    public static String afisarePolinom(Polinom poli)
    {
        StringBuilder builder = new StringBuilder();
        for(Map.Entry<Integer,Double> pol :poli.getPolinom().entrySet())
        {
            if(pol.getValue() != 0)
            {
                if(pol.getValue() >= 0)
                {
                    builder.append("+");
                }
                if(pol.getKey()>1) {
                    builder.append(pol.getValue());
                    builder.append("x^");
                    builder.append(pol.getKey());
                    builder.append(" ");
                }
                else if(pol.getKey()==1)
                {
                    builder.append(pol.getValue());
                    builder.append("x ");
                }
                else if(pol.getKey()==0)
                {
                    builder.append(pol.getValue());
                    builder.append(" ");
                }
            }
        }
        return builder.toString();
    }
    public Polinom adunaPolinoame(Polinom polinom1,Polinom polinom2)
    {
        Polinom rezultat= new Polinom();
        for (Map.Entry<Integer, Double> mon : polinom2.getPolinom().entrySet())
        {
            if (polinom1.getPolinom().containsKey(mon.getKey()))
            {
                    rezultat.getPolinom().put(mon.getKey(), polinom1.getPolinom().get(mon.getKey()) + mon.getValue());
            }
            else
            {
               rezultat.getPolinom().put(mon.getKey(), mon.getValue());
            }
        }
        for(Map.Entry<Integer, Double> mon : polinom1.getPolinom().entrySet())
        {
            if(!rezultat.getPolinom().containsKey(mon.getKey()))
            {
                rezultat.getPolinom().put(mon.getKey(),mon.getValue());
            }
        }
        return rezultat;
    }
    public Polinom scadePolinoame(Polinom polinom1,Polinom polinom2)
    {
        Polinom rezultat= new Polinom();
        for (Map.Entry<Integer, Double> mon : polinom2.getPolinom().entrySet())
        {
            if (polinom1.getPolinom().containsKey(mon.getKey()))
            {
                rezultat.getPolinom().put(mon.getKey(), polinom1.getPolinom().get(mon.getKey()) - mon.getValue());
            }
            else
            {
                rezultat.getPolinom().put(mon.getKey(), mon.getValue()*(-1));
            }
        }
        for(Map.Entry<Integer, Double> mon : polinom1.getPolinom().entrySet())
        {
            if(!rezultat.getPolinom().containsKey(mon.getKey()))
            {
                rezultat.getPolinom().put(mon.getKey(),mon.getValue());
            }
        }
        return rezultat;
    }
    public Polinom inmultestePolinoame(Polinom polinom1,Polinom polinom2)
    {
      Polinom pol=new Polinom();
      if((polinom1.getPolinom().lastEntry().getKey()==0 && polinom1.getPolinom().lastEntry().getValue()==0) ||
              (polinom2.getPolinom().lastEntry().getKey()==0 && polinom2.getPolinom().lastEntry().getValue()==0))
      {
          pol.adaugaMonom(0,0.0);
      }
      else {
          for (Map.Entry<Integer, Double> mon1 : polinom1.getPolinom().entrySet()) {
              Polinom rezultat = new Polinom();
              for (Map.Entry<Integer, Double> mon2 : polinom2.getPolinom().entrySet()) {
                  //in rezultat punem fiecare monom fara sa le grupam pe cele de grad egal
                  rezultat.getPolinom().put(mon1.getKey() + mon2.getKey(), mon1.getValue() * mon2.getValue());
              }
              //adunam polinoamele pentru a grupa monoamele de grad egal
              pol = adunaPolinoame(pol, rezultat);
          }
      }
        return pol;
    }

    public Polinom derivarePolinom(Polinom polinom)
    {
        Polinom rezultat= new Polinom();
        for (Map.Entry<Integer, Double> mon : polinom.getPolinom().entrySet())
        {
            if(mon.getKey()!=0)
            {
                rezultat.getPolinom().put(mon.getKey()-1,mon.getValue()*mon.getKey());
            }
        }
        return rezultat;
    }
    public Polinom integrarePolinom(Polinom polinom)
    {
        Polinom rezultat= new Polinom();
        for (Map.Entry<Integer, Double> mon : polinom.getPolinom().entrySet())
        {
                rezultat.getPolinom().put(mon.getKey()+1,mon.getValue()/(mon.getKey()+1));
        }
        return rezultat;
    }

    public Polinom reducePolinom(Polinom polinom)
    {
        Polinom result= new Polinom();
        for (Map.Entry<Integer, Double> mon : polinom.getPolinom().entrySet())
        {
            if (mon.getValue()!=0.0)
            {
                result.adaugaMonom(mon.getKey(),mon.getValue());
            }
        }
        return result;
    }

    public Polinom invPolinom(Polinom polinom)
    {
        for (Map.Entry<Integer, Double> mon : polinom.getPolinom().entrySet())
        {
            polinom.getPolinom().put(mon.getKey(),mon.getValue()*(-1));
        }
        return polinom;
    }

    public String impartirePolinom(Polinom polinom1, Polinom polinom2)
    {
        Integer grad1= polinom1.getPolinom().lastEntry().getKey();
        Integer grad2= polinom2.getPolinom().lastEntry().getKey();
        Polinom cat= new Polinom();
            while (grad1 >= grad2) {
                double coef1 = polinom1.getPolinom().lastEntry().getValue();
                double coef2 = polinom2.getPolinom().lastEntry().getValue();
                double coefrez = coef1 / coef2;
                Integer rangrez = grad1 - grad2;
                Polinom cataux = new Polinom();
                cataux.adaugaMonom(rangrez, coefrez);
                cat.adaugaMonom(rangrez, coefrez);
                Polinom inter = new Polinom();
                Polinom inter2 = new Polinom();
                inter = inmultestePolinoame(cataux, polinom2);
                inter = reducePolinom(inter);
                inter2 = invPolinom(inter);
                inter2 = reducePolinom(inter2);
                polinom1 = adunaPolinoame(polinom1, inter2);
                polinom1 = reducePolinom(polinom1);
                grad1 = polinom1.getPolinom().lastEntry().getKey();
            }
       String s= new String();
        s=impartireString(cat,polinom1);
        return s;
    }

    public String impartireString(Polinom cat, Polinom rest)
    {
        StringBuilder builder = new StringBuilder();
        builder.append("cat: ");
        String cats= new String();
        String catr= new String();
        cats=afisarePolinom(cat);
        builder.append(cats);
        builder.append(" rest: ");
        catr=afisarePolinom(rest);
        builder.append(catr);
        return builder.toString();
    }

}
