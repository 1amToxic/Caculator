package com.example.caculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt0, deL, aC, muL, diV, adD, suB, equaL,closee,openn;
    TextView textView;
    private BigDecimal number1, number2;
    private String one, two, newpt;
    private String pt;
    boolean check; //check xem truong hop cong lien tiep
    In inp = new In();
    //    Main
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUp();

    }

    private void setUp() {
        one = "";
        two = "";
        pt = "";
        check = false;

        bt1 = findViewById(R.id.num1);
        bt2 = findViewById(R.id.num2);
        bt3 = findViewById(R.id.num3);
        bt4 = findViewById(R.id.num4);
        bt5 = findViewById(R.id.num5);
        bt6 = findViewById(R.id.num6);
        bt7 = findViewById(R.id.num7);
        bt8 = findViewById(R.id.num8);
        bt9 = findViewById(R.id.num9);
        bt0 = findViewById(R.id.num0);
        deL = findViewById(R.id.del);
        aC = findViewById(R.id.ac);
        muL = findViewById(R.id.mul);
        diV = findViewById(R.id.div);
        adD = findViewById(R.id.add);
        suB = findViewById(R.id.sub);
        equaL = findViewById(R.id.equal);
        textView = findViewById(R.id.text);
        closee = findViewById(R.id.close);
        openn =findViewById(R.id.open);
        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
        bt8.setOnClickListener(this);
        bt9.setOnClickListener(this);
        bt0.setOnClickListener(this);
        deL.setOnClickListener(this);
        aC.setOnClickListener(this);
        muL.setOnClickListener(this);
        diV.setOnClickListener(this);
        adD.setOnClickListener(this);
        suB.setOnClickListener(this);
        equaL.setOnClickListener(this);
        openn.setOnClickListener(this);
        closee.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.num0: {
                textView.append("0");
                break;
            }
            case R.id.num1: {
                if (textView.getText().toString().equals("0")) textView.setText("");
                textView.append("1");
                break;
            }
            case R.id.num2: {
                if (textView.getText().toString().equals("0")) textView.setText("");
                textView.append("2");
                break;
            }
            case R.id.num3: {
                if (textView.getText().toString().equals("0")) textView.setText("");
                textView.append("3");
                break;
            }
            case R.id.num4: {
                if (textView.getText().toString().equals("0")) textView.setText("");
                textView.append("4");
                break;
            }
            case R.id.num5: {
                if (textView.getText().toString().equals("0")) textView.setText("");
                textView.append("5");
                break;
            }
            case R.id.num6: {
                if (textView.getText().toString().equals("0")) textView.setText("");
                textView.append("6");
                break;
            }
            case R.id.num7: {
                if (textView.getText().toString().equals("0")) textView.setText("");
                textView.append("7");
                break;
            }
            case R.id.num8: {
                if (textView.getText().toString().equals("0")) textView.setText("");
                textView.append("8");
                break;
            }
            case R.id.num9: {
                if (textView.getText().toString().equals("0")) textView.setText("");
                textView.append("9");
                break;
            }
            case R.id.ac: {
                one = "";
                two = "";
                pt = "";
                textView.setText("");
                break;
            }
            case R.id.add: {
                textView.append("+");
                break;
            }
            case R.id.sub: {
                textView.append("-");
                break;
            }
            case R.id.mul: {
                textView.append("*");
                break;
            }
            case R.id.div: {
                textView.append(":");
                break;
            }
            case R.id.equal: {
                resultcomplete();
                break;
            }
            case R.id.del: {
                String tmp = textView.getText().toString();
                if (!tmp.equals("")) tmp = tmp.substring(0, tmp.length() - 1);
                textView.setText(tmp);
                if (!two.equals("")) two = tmp;
                else one = tmp;
                break;
            }
            case R.id.open:{
                textView.append("(");
                break;
            }
            case R.id.close:{
                textView.append(")");
                break;
            }
            default:
                break;
        }
    }

    public void resultcomplete() {
        String resultinfix = textView.getText().toString();
        inp.setString(resultinfix);
        resultinfix = inp.getString();
        textView.setText(resultinfix.toString());
    }
    public void process(String s) {

    }
}

class In{
    private  String exp;
    BigInteger big1,big2;
    public void setString(String news){
        this.exp= news;
    }
    public String getString(){
        return this.SolveInfix();
    }
    int Prec(char ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case ':':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    // The main method that converts given infix expression
    // to postfix expression.
    String help(char oper, BigInteger big1, BigInteger big2){
        String res = new String("");
        switch (oper){
            case '+':{
                res = big1.add(big2).toString();
                break;
            }
            case '-':{
                res = big1.subtract(big2).toString();
                break;
            }
            case '*':{
                res = big1.multiply(big2).toString();
                break;
            }
            case ':':{
                res = big1.divide(big2).toString();
                break;
            }
        }
        return  res;
    }
    String SolveInfix()
    {

        String exp = this.exp;
        // initializing empty String for result
        String result = new String("");
        // initializing empty stack
        Stack<String> operandstack = new Stack<>();
        Stack <Character> operatorStack = new Stack<>();
        String temp = new String("");
        for (int i = 0; i<exp.length(); i++)
        {
            temp = "";
            char c = exp.charAt(i);

            // If the scanned character is an operand, add it to output.
            if (Character.isLetterOrDigit(c)){
                while(i<exp.length()&&Character.isLetterOrDigit(c)){
                    temp += c;
                    i++;
                    if(i==exp.length()) break;
                    c = exp.charAt(i);
                }
                operandstack.push(temp);
                i--;
            }
                // If the scanned character is an '(', push it to the stack.
            else if (c == '(')
                operatorStack.push(c);
                //  If the scanned character is an ')', pop and output from the stack
                // until an '(' is encountered.
            else if (c == ')')
            {
                while(!operatorStack.empty()&&operatorStack.peek()!='('){
                    String op2 = operandstack.pop();
                    String op1 = operandstack.pop();
                    char oper = operatorStack.pop();
                    big1 = new BigInteger(op1);
                    big2 = new BigInteger(op2);
                    String res = help(oper,big1,big2);
                    operandstack.push(res);
                }
                operatorStack.pop();
            }
            else // an operator is encountered
            {
                char charac = exp.charAt(i);
                if(!operatorStack.empty()&&Prec(charac)>Prec(operatorStack.peek())){
                    operatorStack.push(charac);
                }
                else if(!operatorStack.empty()&&Prec(charac)<=Prec(operatorStack.peek())){
                    String op2 = operandstack.pop();
                    String op1 = operandstack.pop();
                    big1 = new BigInteger(op1);
                    big2 = new BigInteger(op2);
                    char oper = operatorStack.pop();
                    String res=  help(oper, big1,big2);
                    operandstack.push(res);
                    operatorStack.push(charac);
                }
                else{
                    operatorStack.push(charac);
                }
            }

        }

        // pop all the operators from the stack
        while (!operatorStack.isEmpty()){
            String op2 = operandstack.peek();
            operandstack.pop();
            String op1 = operandstack.peek();
            operandstack.pop();
            big1 = new BigInteger(op1);
            big2 = new BigInteger(op2);
            char oper = operatorStack.pop();
            String res= help(oper,big1,big2);
            operandstack.push(res);
        }
        result = operandstack.peek();
        return result;
    }

    // Driver method
    public static void main(String[] args)
    {

    }
}


