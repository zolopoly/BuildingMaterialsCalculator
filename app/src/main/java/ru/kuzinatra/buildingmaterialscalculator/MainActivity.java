package ru.kuzinatra.buildingmaterialscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText input;
    private TextView output;
    private TextView change;
    private TextView outputTextView;
    private TextView shopList;
    private TextView cartList;
    private User user;
    private Store store;
    private String outputText;
    private double inputCoins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_buy = findViewById(R.id.button_buy);
        input = findViewById(R.id.input);

        shopList = findViewById(R.id.shop_list);
        cartList = findViewById(R.id.cart_list);
        output = findViewById(R.id.output);
        change = findViewById(R.id.change);
        outputTextView = findViewById(R.id.output_text);

        setShopList();

        button_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = input.getText().toString();
                if (TextUtils.isEmpty(value)) {
                    inputCoins = 0;
                } else {
                    inputCoins = Double.parseDouble(value);
                }
                user = new User(inputCoins);
                store = new Store(user);

                if (store.sell()) {
                    outputText = "Монет достаточно для покупок!\nКупили все необходимое:";
                } else {
                    outputText = "Монет недостаточно\nВот что удалось купить:";
                }

                outputTextView.setText(outputText);
                setCartList();

                output.setText("Осталось монет: ");
                change.setText(String.valueOf(Math.floor(user.getWallet())));
            }
        });
    }

    private void setShopList() {
        StringBuilder shopListString = new StringBuilder();
        for (Item item : Store.getItems()) {
            shopListString.append("- ")
                    .append(item.getName())
                    .append("\t\t\t")
                    .append(item.getPrice())
                    .append("\t\t\t")
                    .append(item.getDiscount())
                    .append("%\t\t\t")
                    .append(item.getDiscountPrice())
                    .append("\n");
        }
        shopList.setText(shopListString);
    }

    private void setCartList() {
        StringBuilder cartListString = new StringBuilder();
        for (Item item : user.getCart()) {
            cartListString.append("- ")
                    .append(item.getName())
                    .append("\t\t\t")
                    .append(item.getPrice())
                    .append("\t\t\t")
                    .append(item.getDiscount())
                    .append("%\t\t\t")
                    .append(item.getDiscountPrice())
                    .append("\n");
        }
        cartList.setBackgroundColor(Color.parseColor("#20880E4F"));
        cartList.setText(cartListString);
    }
}


