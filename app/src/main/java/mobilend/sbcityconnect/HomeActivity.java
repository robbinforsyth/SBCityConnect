package mobilend.sbcityconnect;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    ImageButton menuButton;
    private String user = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        user = getIntent().getStringExtra("USERNAME");

        if(user.equals("Robert")) {
            setContentView(R.layout.activity_home_robert);
        }
        else{
            setContentView(R.layout.activity_home);
        }
        //Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //getSupportActionBar().setTitle(null);


        TextView tv1 = (TextView)findViewById(R.id.nameTitle);
        tv1.setText(user);

        menuButton=(ImageButton) findViewById(R.id.menuButton);
        menuButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //Add these seven lines inside OnClickListener for menuButton in each activity
                LayoutInflater inflater=(LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                final View menuView=inflater.inflate(R.layout.dropdown_menu,null);
                final DropdownMenu menuWindow=new DropdownMenu(menuView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                menuWindow.setUser(user);

                menuWindow.setOutsideTouchable(true);
                menuWindow.setFocusable(true);
                menuWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                menuWindow.update();
                menuWindow.showAsDropDown(menuButton,-50,0);
            }
        });

        if(user.equals("Janice")){
            TextView tv2 = (TextView)findViewById(R.id.submessage);
            tv2.setText("You Saved $365 this year");

            //ImageView w1 = (ImageView)findViewById(R.id.weatherImage);
            //w1.setImageResource(R.mipmap.thunderstorm);
        }
        else if(user.equals("Robert")){
            TextView tv3 = (TextView)findViewById(R.id.submessage);
            tv3.setText("You Saved $1,025 this year");

        }
        else if(user.equals("Joseph")){
            TextView tv4 = (TextView)findViewById(R.id.submessage);
            tv4.setText("You Saved $550 this year");
        }
    }

/*    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu, menu);
        return true;
    }*/

    public boolean onMenuItemClick(MenuItem item){
        switch(item.getItemId()){
            case R.id.life:
                //TODO - implement submenu
                return true;
            case R.id.calendar:
                Intent intent = new Intent(this, CalendarHomeActivity.class);
                intent.putExtra("USERNAME", user);
                startActivity(intent);
                return true;
            case R.id.cityAssistance:
                startActivity(new Intent(this, CityAssistanceActivity.class));
                return true;
            case R.id.payments:
                //go to payments
                Intent intent2 = new Intent(this, EPaymentActivity.class);
                intent2.putExtra("USERNAME", user);
                startActivity(intent2);
                return true;
            case R.id.moneyManagement:
                Intent intent3 = new Intent(this, MoneyManagementHomeActivity.class);
                intent3.putExtra("USERNAME", user);
                startActivity(intent3);
                return true;
            case R.id.work:
                return true;
            case R.id.business:
                return true;
            case R.id.government:
                return true;
            case R.id.settings:
                return true;
            case R.id.logout:
                startActivity(new Intent(this, MainActivity.class));
                return true;

        }
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.menuIcon:
                PopupMenu popup = new PopupMenu(HomeActivity.this, menuButton);
                popup.setOnMenuItemClickListener(HomeActivity.this);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
                popup.show();
                return true;
        }
        return false;
    }

    public void goToCalendar(View view){
        Intent intent = new Intent(this, CalendarHomeActivity.class);

        //Intent intent = new Intent(getBaseContext(), HomeActivity.class);
        intent.putExtra("USERNAME", user);
        startActivity(intent);
    }

    public void goToPayment(View view){
        Intent intent = new Intent(this, MakeAPayment1Activity.class);

        //Intent intent = new Intent(getBaseContext(), HomeActivity.class);
        intent.putExtra("USERNAME", user);
        startActivity(intent);
    }
}
