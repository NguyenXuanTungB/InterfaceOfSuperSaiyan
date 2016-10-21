package vulan.com.trackingstore.util.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import vulan.com.trackingstore.R;
import vulan.com.trackingstore.data.model.DrawerRightItem;
import vulan.com.trackingstore.data.model.Food;

/**
 * Created by VULAN on 10/21/2016.
 */

public class HomeDialog extends Dialog {

    private Context mContext;
    private View mView;
    private TextView mTextTitle, mTextName, mTextMeter, mTextContent;
    private ImageView mImage;
    private CardView mCardview;

    public HomeDialog(Context context, Food food, DrawerRightItem drawerRightItem) {
        super(context);
        mContext = context;
        mView = View.inflate(mContext, R.layout.layout_slide_up, null);
        findView(mView);
        init(food, drawerRightItem);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.setCanceledOnTouchOutside(true);
        setContentView(mView);
    }

    private void init(Food food, DrawerRightItem item) {
        mTextTitle.setText(item.getTitle());
        mTextMeter.setText(item.getMeter());
        mTextName.setText(food.getName());
        mTextContent.setText(food.getContent());
        mImage.setImageResource(food.getImageFood());
    }

    private void findView(View mView) {
        mTextTitle = (TextView) mView.findViewById(R.id.text_location);
        mTextName = (TextView) mView.findViewById(R.id.text_name);
        mTextMeter = (TextView) mView.findViewById(R.id.text_meter);
        mTextContent = (TextView) mView.findViewById(R.id.text_content);
        mImage = (ImageView) mView.findViewById(R.id.image_food);
        mCardview = (CardView) mView.findViewById(R.id.card_go_to_restaurant);
    }
}
