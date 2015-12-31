package mobotech.stuffs;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.afollestad.materialdialogs.AlertDialogWrapper;
import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        basicDialog();

//        dismissingDialog();

//        dialogWithIcon();

//        alertDialog();

//        listDialog();

//        singleChoiceListDialog();

//        multiChoiceListDialog();

//        coloredDialogBox();

//        dialogCallbacks();

        dialogStuffsGravity();

    }

    private void dialogStuffsGravity() {

        new MaterialDialog.Builder(this)
                .title("My Title")
                .titleGravity(GravityEnum.CENTER)
                .content("The full Content......The full Content......The full Content......")
                .contentGravity(GravityEnum.CENTER)
                .positiveText("Yes")
                .btnStackedGravity(GravityEnum.START)
                .itemsGravity(GravityEnum.END)
                .buttonsGravity(GravityEnum.END)
                .show();

    }

    private void dialogCallbacks() {

        new MaterialDialog.Builder(this)
                .title("Use Google's Location Services?")
                .content("Let Google help apps determine location. This means sending anonymous location data to Google, even when no apps are running.")
                .positiveText("Agree")
                .showListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialog) {

                        Toast.makeText(getApplicationContext() , "Dialog onShow ..", Toast.LENGTH_SHORT).show();

                    }
                })
                .cancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {

                        Toast.makeText(getApplicationContext() , "Dialog onCancel ..", Toast.LENGTH_SHORT).show();

                    }
                })
                .dismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {

                        Toast.makeText(getApplicationContext() , "Dialog onDismiss ..", Toast.LENGTH_SHORT).show();

                    }
                })
                .show();

    }

    private void coloredDialogBox() {

        new MaterialDialog.Builder(this)
                .titleColorRes(R.color.material_blue_grey_800)
                .contentColor(Color.WHITE) // notice no 'res' postfix for literal color
                .dividerColorRes(R.color.material_blue_grey_900)
                .backgroundColorRes(R.color.material_blue_grey_800)
                .positiveColorRes(R.color.material_deep_teal_200)
                .neutralColorRes(R.color.material_blue_grey_950)
                .negativeColorRes(R.color.ripple_material_dark)
                .widgetColorRes(R.color.ripple_material_light)
                .title("My Title")
                .content("Content for coloured dialog box..")
                .positiveText("Yeah")
                .negativeText("No")
                .show();

    }


    private void multiChoiceListDialog() {

        new MaterialDialog.Builder(this)
                .title("Multi Choice List dialog")
                .items(R.array.listItems)
                .itemsCallbackMultiChoice(null, new MaterialDialog.ListCallbackMultiChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, Integer[] which, CharSequence[] text) {
                        /**
                         * If you use alwaysCallMultiChoiceCallback(), which is discussed below,
                         * returning false here won't allow the newly selected check box to actually be selected.
                         * See the limited multi choice dialog example in the sample project for details.
                         **/

                        Toast.makeText(getApplicationContext() , "Selected at.."+ which +" "+ text , Toast.LENGTH_SHORT).show();

                        return true;
                    }
                })
                .positiveText("Done")
                .show();

    }


    private void singleChoiceListDialog() {

        new MaterialDialog.Builder(this)
                .title("Single Choice List Dialog")
                .items(R.array.listItems)
                .itemsCallbackSingleChoice(-1, new MaterialDialog.ListCallbackSingleChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, View view, int position, CharSequence text) {
                        /**
                         * If you use alwaysCallSingleChoiceCallback(), which is discussed below,
                         * returning false here won't allow the newly selected radio button to actually be selected.
                         **/
                        Toast.makeText(getApplicationContext() , "Selected at.."+ position , Toast.LENGTH_SHORT).show();


                        return true;
                    }
                })
                .positiveText("Done")
                .show();

    }


    private void listDialog() {

        new MaterialDialog.Builder(this)
                .title("List Dialog")
                .items(R.array.listItems)
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View view, int position, CharSequence text) {

                        Toast.makeText(getApplicationContext() , "Clicked at.."+ position , Toast.LENGTH_SHORT).show();


                    }
                })
                .show();

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
