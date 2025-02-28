package model;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Polinom {
    private TreeMap<Integer,Double> polinom= new TreeMap<Integer, Double>();
    public Polinom (TreeMap<Integer, Double> poli )
    {
        this.polinom = poli;
    }
    public Polinom()
    {
        polinom.put(0, 0.0);
    }

    public Polinom adaugaMonom (int gradPolinom, double coeficientPolinom)
    {
        if(polinom.containsKey(gradPolinom))
        {
            polinom.put(gradPolinom,polinom.get(gradPolinom)+coeficientPolinom);
        }
        else {
            polinom.put(gradPolinom, coeficientPolinom);
        }
        return null;
    }

    public int facePolinom2(String s)
    {
        Pattern pattern = Pattern.compile("([+-?]?[^-+]+)");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            double coeficient = 0;
            Integer rang = 0;
            String s1 = matcher.group(1);
            Pattern pattern2 = Pattern.compile("^[-+]?([0-9]*\\.?[0-9]+)");
            Matcher matcher2 = pattern2.matcher(s1);
            while (matcher2.find()) {
                coeficient = Double.parseDouble(matcher2.group());
            }
            Pattern pattern3 = Pattern.compile("([0-9]$)");
            Matcher matcher3 = pattern3.matcher(s1);
            if(matcher3.find())
            {
                String aux= matcher.group();
                Pattern verif=Pattern.compile("[+-]?[\\dx^\\d]{4,5}");
                Matcher m=verif.matcher(aux);
                if(m.matches()) {
                    rang=Integer.parseInt(matcher3.group());
                }
                else rang=0;
            }
            else {
                rang=1;}
            this.adaugaMonom(rang, coeficient);
        }
        return 0;
    }
    public TreeMap<Integer, Double> getPolinom()
    {
        return polinom;
    }


}
