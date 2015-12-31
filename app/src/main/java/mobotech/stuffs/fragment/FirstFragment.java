package mobotech.stuffs.fragment;


import android.app.Fragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

import mobotech.stuffs.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends android.support.v4.app.Fragment {
    // Store instance variables
    private String title , description , imageLink;
    private int page;

    // newInstance constructor for creating fragment with arguments
    public static FirstFragment newInstance(int page, String title , String description , String imageLink) {
        FirstFragment fragmentFirst = new FirstFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        args.putString("description", description);
        args.putString("imageLink" , imageLink);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
        description = getArguments().getString("description");
        imageLink = getArguments().getString("imageLink");

    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        TextView textViewTitle= (TextView) view.findViewById(R.id.textViewTitle);
        textViewTitle.setText(page + " -- " + title );

        TextView textViewDesc= (TextView) view.findViewById(R.id.textViewDescription);
        textViewDesc.setText(page + "---"+ description);

        TextView textViewImageLink= (TextView) view.findViewById(R.id.textViewImageLink);
        textViewImageLink.setText(page + "---" + imageLink);

        imageViewJob(view);

        return view;
    }

    private void imageViewJob(View view){

        final ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        ImageRequest imageRequest = new ImageRequest(imageLink, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                imageView.setImageBitmap(response);
            }
        }, 200, 100, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                imageView.setImageResource(R.drawable.error);
            }
        });
        requestQueue.add(imageRequest);
    }
}