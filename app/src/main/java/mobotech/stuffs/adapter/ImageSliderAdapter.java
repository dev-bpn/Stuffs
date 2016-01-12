package mobotech.stuffs.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.androidquery.AQuery;

import java.util.ArrayList;

import mobotech.stuffs.R;
import mobotech.stuffs.model.Banner;
import mobotech.stuffs.view.RecyclingPagerAdapter;

/**
 * Created by prashantwosti on 2/20/2015.
 */
public class ImageSliderAdapter extends RecyclingPagerAdapter {

    private Context context;
    private ArrayList<Banner> bannerArrayList;
    private int size;
    private boolean isInfiniteLoop;

    public ImageSliderAdapter(Context context, ArrayList<Banner> bannerArrayList) {
        this.context = context;
        this.bannerArrayList = bannerArrayList;
        this.size = bannerArrayList.size();
        isInfiniteLoop = false;
    }

    @Override
    public int getCount() {
        // Infinite loop
        return isInfiniteLoop ? Integer.MAX_VALUE : bannerArrayList.size();
    }

    /**
     * get really position
     *
     * @param position
     * @return
     */
    private int getPosition(int position) {
        return isInfiniteLoop ? position % size : position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup container) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = holder.imageView = new ImageView(context);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        new AQuery(view).id(holder.imageView).image(bannerArrayList.get(getPosition(position)).getBannerUrl());

        holder.imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(bannerArrayList.get(getPosition(position)).getBannerUrl()))
                    new MaterialDialog.Builder(context)
                            .title("Action required to open a link")
                            .content("Allow MyRate to open a link in a browser?")
                            .positiveText("Continue")
                            .negativeText("Cancel")
                            .autoDismiss(true)
                            .positiveColorRes(R.color.myPrimaryColor)
                            .negativeColorRes(R.color.myPrimaryColor)
                            .callback(new MaterialDialog.ButtonCallback() {

                                @Override
                                public void onPositive(MaterialDialog dialog) {
                                    super.onPositive(dialog);
                                    dialog.dismiss();
//                                    context.startActivity(new Intent(Intent.ACTION_VIEW,
//                                            Uri.parse(bannerArrayList.get(getPosition(position)).getBannerUrl())));
                                    try {
                                        context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + "riberasolutions.com.myanmarexchangerates")));
                                    } catch (android.content.ActivityNotFoundException anfe) {
                                        context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + "riberasolutions.com.myanmarexchangerates")));
                                    }
                                }

                                @Override
                                public void onNegative(MaterialDialog dialog) {
                                    super.onNegative(dialog);
                                    dialog.dismiss();
//                                    AppLog.showLog("DIALOG DISMISSED");
                                }
                            })
                            .build()
                            .show();

            }
        });
        return view;
    }

    /**
     * @return the isInfiniteLoop
     */
    public boolean isInfiniteLoop() {
        return isInfiniteLoop;
    }

    /**
     * @param isInfiniteLoop the isInfiniteLoop to set
     */
    public ImageSliderAdapter setInfiniteLoop(boolean isInfiniteLoop) {
        this.isInfiniteLoop = isInfiniteLoop;
        return this;
    }

    private static class ViewHolder {

        ImageView imageView;
    }
}
