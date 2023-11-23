package ru.kuzinatra.buildingmaterialscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private Button button_buy;
    private EditText input;
    private TextView output;
    private TextView shopList;
    private TextView cartList;
    private User user;
    private Store store;
    private double change;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button_buy = findViewById(R.id.button_buy);
        input = findViewById(R.id.input);

        shopList = findViewById(R.id.shop_list);
        cartList = findViewById(R.id.cart_list);
        output = findViewById(R.id.output);

        button_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double inputCoins = Double.parseDouble(input.getText().toString());
                user = new User(inputCoins);
                store = new Store(user);
                change = store.sell();
                output.setText(String.valueOf(Math.floor(change)));

                StringBuilder shopListString = new StringBuilder();
                for (Item item : Store.getItems()) {
                    shopListString.append("- ")
                            .append(item.getName())
                            .append("\t\t\t")
                            .append(item.getPrice())
                            .append("\t\t\t")
                            .append(item.getDiscount())
                            .append("\t\t\t")
                            .append(item.getDiscountPrice())
                            .append("\n");
                }
                shopList.setText(shopListString.toString());


                for (Item item : user.getCart()) {
                    cartList.append("- " + item.getName() + "\t\t\t" + item.getPrice() + "\t\t\t" + item.getDiscount() + "\t\t\t" + item.getDiscountPrice() + "\n");
                }


//                String outputText = language.get(inputText);
//                if (outputText != null) {
//                    output.setText(outputText.toLowerCase(Locale.ROOT));
//                } else {
//                    output.setText(R.string.hint_has_no_translation);
//                }
            }
        });

    }
}


