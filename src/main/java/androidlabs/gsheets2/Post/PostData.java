package androidlabs.gsheets2.Post;

/**
 * Created by sanyam on 10/1/2018.
 */
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;

import androidlabs.gsheets2.R;

public class PostData extends AppCompatActivity {
    private ProgressDialog progress;


    TextView tvformid;
    TextView tvname;
    TextView tvPcontact;
    TextView tvPguardian;
    TextView tvPaddress;
    TextView tvPdoj;
    TextView tvgender;
    TextView tvage;
    TextView tvtimestamp;
    TextView tvdr_attending;
    TextView tvbed_allot;
    TextView tvinsurance;
    TextView tvot_status;
    TextView tvemergency_contact;

    Button button;


        String formid;
        String name;
        String Pcontact;
        String Pguardian;
        String Paddress;
        String Pdoj;
        String gender;
        String age;
        String timestamp;
        String dr_attending;
        String bed_allot;
        String insurance;
        String ot_status;
        String emergency_contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form);

        button=(Button)findViewById(R.id.btn_signup);
        tvformid=(EditText)findViewById(R.id.formid);
        tvname=(EditText)findViewById(R.id.name);
        tvPcontact=(EditText)findViewById(R.id.Pcontact);
        tvPguardian=(EditText)findViewById(R.id.Pguardian);
        tvPaddress=(EditText)findViewById(R.id.Paddress);
        tvPdoj=(EditText)findViewById(R.id.Pdoj);
        tvgender=(EditText)findViewById(R.id.gender);
        tvage=(EditText)findViewById(R.id.age);
        tvtimestamp=(EditText)findViewById(R.id.timestamp);
        tvdr_attending=(EditText)findViewById(R.id.dr_attending);
        tvbed_allot=(EditText)findViewById(R.id.bed_allot);
        tvinsurance=(EditText)findViewById(R.id.insurance);
        tvot_status=(EditText)findViewById(R.id.ot_status);
        tvemergency_contact=(EditText)findViewById(R.id.emergency_contact);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                formid=tvformid.getText().toString();
                name=tvage.getText().toString();
                Pcontact=tvPcontact.getText().toString();
                Pguardian=tvPguardian.getText().toString();
                Paddress=tvPaddress.getText().toString();
                Pdoj=tvPdoj.getText().toString();
                gender=tvgender.getText().toString();
                age=tvage.getText().toString();
                timestamp=tvtimestamp.getText().toString();
                dr_attending=tvdr_attending.getText().toString();
                bed_allot=tvbed_allot.getText().toString();
                insurance=tvinsurance.getText().toString();
                ot_status=tvot_status.getText().toString();
                emergency_contact=tvemergency_contact.getText().toString();

                new SendRequest().execute();
            }

        }   );

        }







    public class SendRequest extends AsyncTask<String, Void, String> {


        protected void onPreExecute(){}

        protected String doInBackground(String... arg0) {

            try{
                //Change your web app deployed URL or u can use this for attributes (name, country)
                URL url = new URL("https://script.google.com/macros/s/AKfycbwA1KVkYmRTNPvj4f9GrNuVtSX1OlHcTxA8UXHoLY4D7NDoKH0W/exec");
              
                JSONObject postDataParams = new JSONObject();

                //int i;
                //for(i=1;i<=70;i++)


                //    String usn = Integer.toString(i);

//                String id= "YOUR SPREAD SHEET ID";

                postDataParams.put("formid",name);
                postDataParams.put("name",name);
                postDataParams.put("Pcontact",Pcontact);
                postDataParams.put("Pgaurdian",Pguardian);
                postDataParams.put("Paddress",Paddress);
                postDataParams.put("Pdoj",Pdoj);
                postDataParams.put("gender",gender);
                postDataParams.put("age",age);
                postDataParams.put("timestamp",timestamp);
                postDataParams.put("dr_attending",dr_attending);
                postDataParams.put("bed_allot",bed_allot);
                postDataParams.put("insurance",insurance);
                postDataParams.put("ot_status",ot_status);
                postDataParams.put("emergency_contact",emergency_contact);
                Log.e("params",postDataParams.toString());

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(15000 /* milliseconds */);
                conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);

                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(getPostDataString(postDataParams));

                writer.flush();
                writer.close();
                os.close();

                int responseCode=conn.getResponseCode();

                if (responseCode == HttpsURLConnection.HTTP_OK) {

                    BufferedReader in=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuffer sb = new StringBuffer("");
                    String line="";

                    while((line = in.readLine()) != null) {

                        sb.append(line);
                        break;
                    }

                    in.close();
                    return sb.toString();

                }
                else {
                    return new String("false : "+responseCode);
                }
            }
            catch(Exception e){
                return new String("Exception: " + e.getMessage());
            }
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getApplicationContext(), result,
                    Toast.LENGTH_LONG).show();

        }
    }

    public String getPostDataString(JSONObject params) throws Exception {

        StringBuilder result = new StringBuilder();
        boolean first = true;

        Iterator<String> itr = params.keys();

        while(itr.hasNext()){

            String key= itr.next();
            Object value = params.get(key);

            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(key, "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(value.toString(), "UTF-8"));

        }
        return result.toString();
    }
}
