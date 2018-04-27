package com.coderbd.calljavaapi;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.coderbd.calljavaapi.entity.User;
import com.coderbd.calljavaapi.model.UserModel;

public class EditActivity extends AppCompatActivity {
    EditText fn, ln, e;
    Button btnedit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_edit);
            fn = (EditText) findViewById(R.id.edit_first_name);
            ln = (EditText) findViewById(R.id.edit_last_name);
            e = (EditText) findViewById(R.id.edit_email);
            btnedit = (Button) findViewById(R.id.btnEdit);

            Intent intent = getIntent();
            final User userx = (User) intent.getSerializableExtra("user");
            System.out.println("at Edit Area::: " + userx.getFirstName());
            fn.setText(userx.getFirstName());
            ln.setText(userx.getLastName());
            e.setText(userx.getEmail());
            btnedit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {


                        ///////for update======
                        User user = new User();
                        user.setId(userx.getId());
                        user.setFirstName(fn.getText().toString());
                        user.setLastName(ln.getText().toString());
                        user.setEmail(e.getText().toString());
                        boolean result = new HttpEditUser().execute(user).get();
                        if (result) {
                            Intent intentc = new Intent(EditActivity.this, MainActivity.class);
                            startActivity(intentc);
                        } else {
                            AlertDialog.Builder alBuilder = new AlertDialog.Builder(getApplicationContext());
                            alBuilder.setMessage("Update Failed!!!");
                            alBuilder.create().show();
                        }
                    } catch (Exception e) {
                        AlertDialog.Builder alBuilder = new AlertDialog.Builder(getApplicationContext());
                        alBuilder.setMessage(e.getMessage());
                        alBuilder.create().show();

                    }
                }
            });
        } catch (Exception ex)

        {
            AlertDialog.Builder alBuilder = new AlertDialog.Builder(getApplicationContext());
            alBuilder.setMessage(ex.getMessage());
            alBuilder.create().show();

        }
    }

    private class HttpEditUser extends AsyncTask<User, Void, Boolean> {
        @Override
        protected Boolean doInBackground(User... params) {
            UserModel userModel = new UserModel();
            return userModel.update(params[0]);
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
        }
    }
}
