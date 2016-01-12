package mobotech.stuffs.view;

/**
 * Created by niraj on 8/6/15.
 */
import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class NonSwipeableViewPager extends ViewPager {

    public NonSwipeableViewPager(Context context) {
        super(context);
    }

    public NonSwipeableViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        // TODO
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // TODO
        return false;
    }

}