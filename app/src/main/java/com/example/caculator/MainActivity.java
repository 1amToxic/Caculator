package com.example.caculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt0,deL,aC,muL,diV,adD,suB,equaL;
    TextView textView;
    private BigDecimal number1,number2;
    private String one,two,newpt;
    private String pt;
    boolean check; //check xem truong hop cong lien tiep
    //    Main
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUp();
    }
    private  void setUp(){
        one = "";two = ""; pt = ""; check = false;
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
    }
    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.num0: {
                if(check)   {textView.setText(""); check = false;}
                textView.append("0");
                break;
            }
            case R.id.num1: {
                if(check)   {textView.setText(""); check = false;}
                if(textView.getText().toString().equals("0"))   textView.setText("");
                textView.append("1");
                break;
            }
            case R.id.num2: {
                if(check)   {textView.setText(""); check = false;}
                if(textView.getText().toString().equals("0"))   textView.setText("");
                textView.append("2");
                break;
            }
            case R.id.num3: {
                if(check)   {textView.setText(""); check = false;}
                if(textView.getText().toString().equals("0"))   textView.setText("");
                textView.append("3");
                break;
            }
            case R.id.num4: {
                if(check)   {textView.setText(""); check = false;}
                if(textView.getText().toString().equals("0"))   textView.setText("");
                textView.append("4");
                break;
            }
            case R.id.num5: {
                if(check)   {textView.setText(""); check = false;}
                if(textView.getText().toString().equals("0"))   textView.setText("");
                textView.append("5");
                break;
            }
            case R.id.num6: {
                if(check)   {textView.setText(""); check = false;}
                if(textView.getText().toString().equals("0"))   textView.setText("");
                textView.append("6");
                break;
            }
            case R.id.num7:{
                if(check)   {textView.setText(""); check = false;}
                if(textView.getText().toString().equals("0"))   textView.setText("");
                textView.append("7");
                break;
            }
            case R.id.num8:{
                if(check)   {textView.setText(""); check = false;}
                if(textView.getText().toString().equals("0"))   textView.setText("");
                textView.append("8");
                break;
            }
            case R.id.num9: {
                if(check)   {textView.setText(""); check = false;}
                if(textView.getText().toString().equals("0"))   textView.setText("");
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
            case R.id.add:{
                if(!pt.equals("")){  resultcomplete(pt,"add"); break;}
                one = textView.getText().toString();
                textView.setText("");
                pt="add";
                break;
            }
            case R.id.sub:{
                if(!pt.equals("")){  resultcomplete(pt,"sub"); break;}
                one = textView.getText().toString();
                textView.setText("");
                pt="sub";
                break;
            }
            case R.id.mul:{
                if(!pt.equals("")){  resultcomplete(pt,"mul"); break;}
                one = textView.getText().toString();
                textView.setText("");
                pt="mul";
                break;
            }
            case R.id.div:{
                if(!pt.equals("")){  resultcomplete(pt,"div"); break;}
                one = textView.getText().toString();
                textView.setText("");
                pt="div";
                break;
            }
            case R.id.equal:{
                if(pt.equals("")){
                    break;
                }
                resultcomplete(pt,"");
                break;
            }
            case R.id.del:{
                String tmp = textView.getText().toString();
                if(!tmp.equals("")) tmp = tmp.substring(0,tmp.length()-1);
                textView.setText(tmp);
                if(!two.equals("")) two = tmp;
                else one = tmp;
                break;
            }
            default: break;
        }
    }
    public void resultcomplete(String nowpt,String nextpt){
        two = textView.getText().toString();
        textView.setText("");
        try {
            Double.parseDouble(two);
        } catch (NumberFormatException e) {
            Toast.makeText(this,"Your number is not correct"+"\n"+"Please try again",Toast.LENGTH_SHORT).show();
            one = "";
            two = "";
            pt = "";
        }
        if(two.equals("")||one.equals("")){
            textView.setText(one);
            return;
        }
        number1 =  new BigDecimal(one);
        number2 =  new BigDecimal(two);
        //DecimalFormat form = new DecimalFormat("##.0000");
        switch (nowpt){
            case "add":{
                textView.setText(number1.add(number2).toString());
                break;
            }
            case "sub":{
                textView.setText(number1.subtract(number2).toString());
                break;
            }
            case "mul":{
                textView.setText(number1.multiply(number2).toString());
                break;
            }
            case "div":{
                if(two.equals("0")){
                    Toast.makeText(this,"Can not divide into 0",Toast.LENGTH_SHORT).show();
                    pt = "";
                    one = "";
                    two = "";
                }
                else{
                    BigDecimal big = number1.divide(number2,4, RoundingMode.HALF_UP);
                    textView.setText(big.toPlainString());
                }
                break;
            }
            default:{
                Toast.makeText(this,"Try again",Toast.LENGTH_SHORT).show();
                pt = "";
                one = "";
                two = "";
                break;
            }
        }

        one = textView.getText().toString();
        pt =nextpt;
        if(!pt.equals(""))  check = true;
    }
}