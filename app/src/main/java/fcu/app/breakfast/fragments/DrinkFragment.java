package fcu.app.breakfast.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import fcu.app.breakfast.CartActivity;
import fcu.app.breakfast.Product;
import fcu.app.breakfast.ProductAdapter;
import fcu.app.breakfast.ProductDetailsActivity;
import fcu.app.breakfast.R;
import fcu.app.breakfast.ShoppingCartActivity;
import fcu.app.breakfast.ShoppingCartHelper;
import fcu.app.breakfast.ViewMenu;


public class DrinkFragment extends Fragment implements View.OnClickListener {

    View view;
    private List<Product> mProductList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_drink, container, false);

        mProductList = ShoppingCartHelper.getDrinkCatalog(getResources());

        ListView drinkListViewCatalog = view.findViewById(R.id.ListViewDrinkCatalog);
        drinkListViewCatalog.setAdapter(new ProductAdapter(mProductList, getLayoutInflater(), false));

        drinkListViewCatalog.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent productDetailsIntent = new Intent(getActivity().getBaseContext(), ProductDetailsActivity.class);
                productDetailsIntent.putExtra(ShoppingCartHelper.PRODUCT_INDEX, position);
                startActivity(productDetailsIntent);
            }
        });


        Button viewShoppingCart = view.findViewById(R.id.ButtonViewCart);
        viewShoppingCart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent viewShoppingCartIntent = new Intent(getActivity().getBaseContext(), ShoppingCartActivity.class);
                startActivity(viewShoppingCartIntent);
            }
        });

        return view;
    }

    @Override
    public void onClick(View v) {

    }

//    @Override
//    public void onClick(View v) {
//        Intent intent = new Intent(v.getContext(), CartActivity.class);
//        startActivityForResult(intent,0);
//    }
}