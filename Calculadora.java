import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Calculadora implements ActionListener {

    static JPanel painel1 = new JPanel();
    static JLabel numero1 = new JLabel("0");

    static String numeroatual = "";
    static int valor1 = 0;
    static int valor2 = 0;
    static int resultado = 0;
    static String operacao = "";

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton botao = (JButton) e.getSource();
        String num = botao.getText();

        if (num.equals("0") || num.equals("1") || num.equals("2") ||
            num.equals("3") || num.equals("4") || num.equals("5") ||
            num.equals("6") || num.equals("7") || num.equals("8") ||
            num.equals("9")) {

            numeroatual += num;
            numero1.setText(numeroatual);
            return;
        }

        if (num.equals("+") || num.equals("-") || num.equals("*") || num.equals("/")) {
            valor1 = Integer.parseInt(numeroatual);
            operacao = num;

            numero1.setText(num);
            numeroatual = "";
        }

        if (num.equals("=")) {
            valor2 = Integer.parseInt(numeroatual);

            switch (operacao) {
                case "+":
                    resultado = valor1 + valor2;
                    break;
                case "-":
                    resultado = valor1 - valor2;
                    break;
                case "*":
                    resultado = valor1 * valor2;
                    break;
                case "/":
                    if (valor2 != 0) {
                        resultado = valor1 / valor2;
                    } else {
                        System.out.println("Erro: Divisao por zero");
                        return;
                    }
                    break;
            }

            numeroatual = Integer.toString(resultado);
            numero1.setText(numeroatual);
        }
    }


    public static void main(String[] args) {

        Calculadora calculadora = new Calculadora();

        JFrame frame = new JFrame("Calculadora Simples");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new BorderLayout());

        JPanel painel2 = new JPanel();
        JPanel painel3 = new JPanel();

        painel1.add(numero1);
        frame.add(painel1, BorderLayout.NORTH);

        // Operacoes da calculadora

        JButton soma = new JButton("+");
        JButton subtracao = new JButton("-");
        JButton multiplicacao = new JButton("*");
        JButton divisao = new JButton("/");
        JButton igual = new JButton("=");

        // Painel 2 - Numeros da calculadora

        JButton zero = new JButton("0");
        JButton um = new JButton("1");
        JButton dois = new JButton("2");
        JButton tres = new JButton("3");
        JButton quatro = new JButton("4");
        JButton cinco = new JButton("5");
        JButton seis = new JButton("6");
        JButton sete = new JButton("7");
        JButton oito = new JButton("8");
        JButton nove = new JButton("9");
        
        painel2.add(sete);
        painel2.add(oito);
        painel2.add(nove);
        painel2.add(soma);
        painel2.add(quatro);
        painel2.add(cinco);
        painel2.add(seis);
        painel2.add(subtracao);
        painel2.add(um);
        painel2.add(dois);
        painel2.add(tres);
        painel2.add(multiplicacao);
        painel2.setLayout(new GridLayout(3, 4));
        painel2.setSize(300, 100);

        frame.add(painel2, BorderLayout.CENTER);

        // Painel 3 - Botao de soma

        painel3.add(divisao);
        painel3.add(zero);
        painel3.add(igual);
        painel3.setLayout(new GridLayout(1, 3));
        painel3.setSize(300, 50);

        frame.add(painel3, BorderLayout.SOUTH);

        // Contas

        zero.addActionListener(calculadora);
        um.addActionListener(calculadora);
        dois.addActionListener(calculadora);
        tres.addActionListener(calculadora);
        quatro.addActionListener(calculadora);
        cinco.addActionListener(calculadora);
        seis.addActionListener(calculadora);
        sete.addActionListener(calculadora);
        oito.addActionListener(calculadora);
        nove.addActionListener(calculadora);
        soma.addActionListener(calculadora);
        subtracao.addActionListener(calculadora);
        multiplicacao.addActionListener(calculadora);
        divisao.addActionListener(calculadora);
        igual.addActionListener(calculadora);

        frame.setVisible(true);

    }
}
