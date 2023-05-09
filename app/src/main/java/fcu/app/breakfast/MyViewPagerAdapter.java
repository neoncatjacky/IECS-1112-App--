package fcu.app.breakfast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import fcu.app.breakfast.fragments.DessertFragment;
import fcu.app.breakfast.fragments.DrinkFragment;
import fcu.app.breakfast.fragments.MainDish;

public class MyViewPagerAdapter extends FragmentStateAdapter {
    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new MainDish();
            case 1:
                return new DrinkFragment();
            case 2:
                return new DessertFragment();
            default:
                    return new MainDish();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
