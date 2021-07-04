package question3;

import question3.tp3.PileI;
import question3.tp3.PilePleineException;
import question3.tp3.PileVideException;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Décrivez votre classe Controleur ici.
 * 
 * @author Maria Bou Aoun
 * @version 2.0
 */
public class Controleur extends JPanel {

    private JButton push, add, sub, mul, div, clear;
    private PileModele<Integer> pile;
    private JTextField donnee;

    public Controleur(PileModele<Integer> pile) {
        super();
        this.pile = pile;
        this.donnee = new JTextField(8);

        this.push = new JButton("push");
        this.add = new JButton("+");
        this.sub = new JButton("-");
        this.mul = new JButton("*");
        this.div = new JButton("/");
        this.clear = new JButton("[]");

        setLayout(new GridLayout(2, 1));
        add(donnee);
        donnee.addActionListener(null /* null est à remplacer */);
        JPanel boutons = new JPanel();
        boutons.setLayout(new FlowLayout());
        boutons.add(push);  push.addActionListener(new pushOp());
        boutons.add(add);   add.addActionListener(new addOp());
        boutons.add(sub);   sub.addActionListener(new subOp());
        boutons.add(mul);   mul.addActionListener(new mulOp());
        boutons.add(div);   div.addActionListener(new divOp());
        boutons.add(clear); clear.addActionListener(new clearOp());
        add(boutons);
        boutons.setBackground(Color.red);
        actualiserInterface();
    }

    public void actualiserInterface() {
         if (pile.estPleine())
            push.setEnabled(false);
        else if (pile.estVide()){
            push.setEnabled(true);
            clear.setEnabled(false);
            add.setEnabled(false);
            sub.setEnabled(false);
            mul.setEnabled(false);
            div.setEnabled(false);
        } else if (pile.taille() == 1){
            push.setEnabled(true);
            clear.setEnabled(true);
            add.setEnabled(false);
            sub.setEnabled(false);
            mul.setEnabled(false);
            div.setEnabled(false);
        } else {
            push.setEnabled(true);
            clear.setEnabled(true);
            add.setEnabled(true);
            sub.setEnabled(true);
            mul.setEnabled(true);
            div.setEnabled(true);
        }
    }

    private Integer operande() throws NumberFormatException {
        return Integer.parseInt(donnee.getText());
    }

    private class pushOp implements ActionListener {
        public void actionPerformed (ActionEvent ae){
            try {
                pile.empiler(operande());
            }
            catch (NumberFormatException nfe){}
            catch (PilePleineException pve){}

    
            actualiserInterface();
        }
    }

    private class addOp implements ActionListener {
        public void actionPerformed (ActionEvent ae){
            int op1 = 0, op2 = 0, valeur = 0;

            try {
              
                op1 = pile.depiler();
                op2 = pile.depiler();


                valeur = op2 + op1;
                pile.empiler(valeur);
            }
            catch (PileVideException pve){}
            catch (PilePleineException ppe){}

            actualiserInterface();
        }
    }

    private class subOp  implements ActionListener {
        public void actionPerformed (ActionEvent ae){
            int op1 = 0, op2 = 0, valeur = 0;

            try {
             
                op1 = pile.depiler();
                op2 = pile.depiler();

               
                valeur = op2 - op1;
                pile.empiler(valeur);
            }
            catch (PileVideException pve){}
            catch (PilePleineException ppe){}

            actualiserInterface();
        }
    }

    private class mulOp  implements ActionListener {
        public void actionPerformed (ActionEvent ae){
            int op1 = 0, op2 = 0, valeur = 0;

            try {
              
                op1 = pile.depiler();
                op2 = pile.depiler();

                
                valeur = op2 * op1;
                pile.empiler(valeur);
            }
            catch (PileVideException pve){}
            catch (PilePleineException ppe){}

            actualiserInterface();
        }
    }

    private class divOp  implements ActionListener {
        public void actionPerformed (ActionEvent ae){
            int op1 = 0, op2 = 0, valeur = 0;

            try {
                
                op1 = pile.depiler();
                op2 = pile.depiler();

             
                if (op1 == 0 ) {
                    pile.empiler(op2);
                    pile.empiler(op1);
                }
                else {
                    valeur = op2 / op1;
                    pile.empiler(valeur);
                }
            }
            catch (PileVideException pve){}
            catch (PilePleineException ppe){}

           
            actualiserInterface();
        }
    }

    private class clearOp  implements ActionListener {
        public void actionPerformed (ActionEvent ae){
            while (!pile.estVide()){
                try {
                    pile.depiler();
                }
                catch (PileVideException pve){}
            }

           
            actualiserInterface();
        }
    })

}
