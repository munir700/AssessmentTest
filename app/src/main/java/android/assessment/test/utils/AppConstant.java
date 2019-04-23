package android.assessment.test.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

public class AppConstant {
    @BindingAdapter({"android:src"})
    public static void setImageViewResource(ImageView imageView, int resource) {
        imageView.setImageResource(resource);
    }
}
