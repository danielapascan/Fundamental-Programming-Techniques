package inter;

import operatii.Functii;
import model.Polinom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private View view;
    private Functii f= new Functii();
    public Controller(View v)
    {
        this.view=v;
    }

    public void faceAdunare()
    {
        String polinom1 = String.valueOf(view.getFirstPolinom().getText());
        String polinom2 = String.valueOf(view.getSecondPolinom().getText());
        Polinom p1 = new Polinom();
        Polinom p2 = new Polinom();
        Polinom rez= new Polinom();
        p1.facePolinom2(polinom1);
        p2.facePolinom2(polinom2);
        rez=f.adunaPolinoame(p1,p2);
        view.getRezultat().setText(f.afisarePolinom(rez));
    }

    public void faceScadere()
    {
        String polinom1=String.valueOf(view.getFirstPolinom().getText());
        String polinom2=String.valueOf(view.getSecondPolinom().getText());
        Polinom p1= new Polinom();
        Polinom p2= new Polinom();
        p1.facePolinom2(polinom1);
        p2.facePolinom2(polinom2);
        view.getRezultat().setText(f.afisarePolinom(f.scadePolinoame(p1,p2)));
    }

    public void faceInmultire()
    {
        String polinom1=String.valueOf(view.getFirstPolinom().getText());
        String polinom2=String.valueOf(view.getSecondPolinom().getText());
        Polinom p1= new Polinom();
        Polinom p2= new Polinom();
        p1.facePolinom2(polinom1);
        p2.facePolinom2(polinom2);
        if((p2.getPolinom().lastEntry().getKey()==0 && p2.getPolinom().lastEntry().getValue()==0.0) || (p1.getPolinom().lastEntry().getKey()==0 && p1.getPolinom().lastEntry().getValue()==0.0))
        {
            view.getRezultat().setText("0");
        }
        else {
            view.getRezultat().setText(f.afisarePolinom(f.inmultestePolinoame(p1, p2)));
        }
    }

    public void faceDerivare()
    {
        String polinom1=String.valueOf(view.getFirstPolinom().getText());
        Polinom p1= new Polinom();
        p1.facePolinom2(polinom1);
        if(p1.getPolinom().lastEntry().getKey()<1)
        {
            view.getRezultat().setText("0");
        }
        else {
            view.getRezultat().setText(f.afisarePolinom(f.derivarePolinom(p1)));
        }
    }

    public void faceIntegrare()
    {
        String polinom1=String.valueOf(view.getFirstPolinom().getText());
        Polinom p1= new Polinom();
        p1.facePolinom2(polinom1);
        view.getRezultat().setText(f.afisarePolinom(f.integrarePolinom(p1))+ "+c");
    }

    public void faceImpartire()
    {
        String polinom1=String.valueOf(view.getFirstPolinom().getText());
        String polinom2=String.valueOf(view.getSecondPolinom().getText());
        Polinom p1= new Polinom();
        Polinom p2= new Polinom();
        p1.facePolinom2(polinom1);
        p2.facePolinom2(polinom2);
        if (p1.getPolinom().lastEntry().getKey()<p2.getPolinom().lastEntry().getKey()) {
            view.getRezultat().setText("Polinomul 1 are gradul mai mic decat polinomul 2!");
        }
        else if(p2.getPolinom().lastEntry().getKey()==0 && p2.getPolinom().lastEntry().getValue()==0.0)
        {
            view.getRezultat().setText("Nu se poate face impartire la 0!");
        }
        else {
            view.getRezultat().setText(f.impartirePolinom(p1, p2));
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command= e.getActionCommand();
        if(command=="ADUNARE") {

            faceAdunare();
        }
        else if(command=="SCADERE")
        {
            faceScadere();
        }
        else if(command=="INMULTIRE")
        {
            faceInmultire();
        }
        else if(command=="DERIVARE")
        {
            faceDerivare();
        }
        else if(command=="INTEGRARE")
        {
            faceIntegrare();
        }
        else if(command=="IMPARTIRE")
        {
            faceImpartire();
        }
    }
}
