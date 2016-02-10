package mobotech.stuffs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Dell on 1/7/2016.
 */
public class CustomListWithCheckboxAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<String> nameList;

    public CustomListWithCheckboxAdapter(Context context, List<String> nameList) {
        this.context = context;
        this.nameList = nameList;
    }

    @Override
    public int getCount() {
        return nameList.size();
    }

    @Override
    public Object getItem(int i) {
        return nameList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView == null)
            convertView = inflater.inflate(R.layout.single_row_accessories_view, null);

        TextView name = (TextView) convertView.findViewById(R.id.accessory_name);
        CheckBox checkbox = (CheckBox) convertView.findViewById(R.id.accessory_checkbox);

        String productName = nameList.get(position);
        name.setText(productName);

        return convertView;
    }
}
