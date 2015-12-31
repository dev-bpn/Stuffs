package mobotech.stuffs;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.afollestad.materialdialogs.AlertDialogWrapper;
import com.afollestad.materialdialogs.MaterialDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        basicDialog();

//        dismissingDialog();

//        dialogWithIcon();

        alertDialog();
    }

    private void alertDialog() {

        new AlertDialogWrapper.Builder(this)
                .setTitle("Dialog Title")
                .setMessage("Do you want to cancel Alert Dialog ?")
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Toast.makeText(getApplicationContext() , "No.." , Toast.LENGTH_SHORT).show();
                    }
                }).setPositiveButton("Yeah" , new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
//                dialogInterface.dismiss();
                Toast.makeText(getApplicationContext() , "Yeah.." , Toast.LENGTH_SHORT).show();
            }
        }).show();

    }

//    private void dialogWithIcon() {
//
//        new MaterialDialog.Builder(this)
//                .title("Title")
//                .content("Here the content stuffs...")
//                .positiveText("OK")
//                .icon(R.drawable.launcher)
//                .maxIconSize(100)
//                .show();
//
//    }

    private void dismissingDialog() {

        MaterialDialog.Builder builder = new MaterialDialog.Builder(this)
                .title("Title")
                .content("Here goes the content stuffs...")
                .positiveText("Ok");

        MaterialDialog dialog = builder.build();
        dialog.show();
        dialog.dismiss();

    }

    public void basicDialog(){

        new MaterialDialog.Builder(this)
                .title("Title")
                .content("Here goes the content stuffs...")
                .positiveText("Yes")
                .negativeText("No")
                .show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
