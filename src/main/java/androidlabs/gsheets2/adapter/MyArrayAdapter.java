package androidlabs.gsheets2.adapter;

/**
 * Created by sanyam on 10/1/2018.
 *
 *
 *
 *
 __
 |  \
 _______   ______   _______   __    __   ______   ______ ____         __   __   __   ______    _______       | $$____    ______    ______    ______
 /       \ |      \ |       \ |  \  |  \ |      \ |      \    \       |  \ |  \ |  \ |      \  /       \      | $$    \  /      \  /      \  /      \
 |  $$$$$$$  \$$$$$$\| $$$$$$$\| $$  | $$  \$$$$$$\| $$$$$$\$$$$\      | $$ | $$ | $$  \$$$$$$\|  $$$$$$$      | $$$$$$$\|  $$$$$$\|  $$$$$$\|  $$$$$$\
 \$$    \  /      $$| $$  | $$| $$  | $$ /      $$| $$ | $$ | $$      | $$ | $$ | $$ /      $$ \$$    \       | $$  | $$| $$    $$| $$   \$$| $$    $$
 _\$$$$$$\|  $$$$$$$| $$  | $$| $$__/ $$|  $$$$$$$| $$ | $$ | $$      | $$_/ $$_/ $$|  $$$$$$$ _\$$$$$$\      | $$  | $$| $$$$$$$$| $$      | $$$$$$$$
 |       $$ \$$    $$| $$  | $$ \$$    $$ \$$    $$| $$ | $$ | $$       \$$   $$   $$ \$$    $$|       $$      | $$  | $$ \$$     \| $$       \$$     \
 \$$$$$$$   \$$$$$$$ \$$   \$$ _\$$$$$$$  \$$$$$$$ \$$  \$$  \$$        \$$$$$\$$$$   \$$$$$$$ \$$$$$$$        \$$   \$$  \$$$$$$$ \$$        \$$$$$$$
 |  \__| $$
 \$$    $$
 \$$$$$$
 *
 *
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidlabs.gsheets2.R;
import androidlabs.gsheets2.model.MyDataModel;


import java.util.List;

public class MyArrayAdapter extends ArrayAdapter<MyDataModel> {

    List<MyDataModel> modelList;
    Context context;
    private LayoutInflater mInflater;

    // Constructors
    public MyArrayAdapter(Context context, List<MyDataModel> objects) {
        super(context, 0, objects);
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        modelList = objects;
    }

    @Override
    public MyDataModel getItem(int position) {
        return modelList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        if (convertView == null) {
            View view = mInflater.inflate(R.layout.layout_row_view, parent, false);
            vh = ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        MyDataModel item = getItem(position);

//        vh.textViewName.setText(item.getName());
//        vh.textViewCountry.setText(item.getCountry());
        vh.tvformid.setText(item.getFormid());
        vh.tvname.setText(item.getName());
        vh.tvPcontact.setText(item.getContact());
        vh.tvPguardian.setText(item.getGuardian());
        vh.tvPaddress.setText(item.getAddress());
        vh.tvPdoj.setText(item.getDoj());
        vh.tvgender.setText(item.getGender());
        vh.tvage.setText(item.getAge());
        vh.tvtimestamp.setText(item.getTimestamp());
        vh.tvdr_attending.setText(item.getDr_attending());
        vh.tvbed_allot.setText(item.getBed_allot());
        vh.tvinsurance.setText(item.getInsurance());
        vh.tvot_status.setText(item.getOt_status());
        vh.tvemergency_contact.setText(item.getEmergency_contact());
        return vh.rootView;
    }



//
//
// .----------------.  .----------------.  .-----------------. .----------------.  .----------------.  .----------------.   .----------------.  .----------------.  .----------------.   .----------------.  .----------------.  .----------------.  .----------------.
//         | .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. | | .--------------. || .--------------. || .--------------. | | .--------------. || .--------------. || .--------------. || .--------------. |
//         | |    _______   | || |      __      | || | ____  _____  | || |  ____  ____  | || |      __      | || | ____    ____ | | | | _____  _____ | || |      __      | || |    _______   | | | |  ____  ____  | || |  _________   | || |  _______     | || |  _________   | |
//            | |   /  ___  |  | || |     /  \     | || ||_   \|_   _| | || | |_  _||_  _| | || |     /  \     | || ||_   \  /   _|| | | ||_   _||_   _|| || |     /  \     | || |   /  ___  |  | | | | |_   ||   _| | || | |_   ___  |  | || | |_   __ \    | || | |_   ___  |  | |
//            | |  |  (__ \_|  | || |    / /\ \    | || |  |   \ | |   | || |   \ \  / /   | || |    / /\ \    | || |  |   \/   |  | | | |  | | /\ | |  | || |    / /\ \    | || |  |  (__ \_|  | | | |   | |__| |   | || |   | |_  \_|  | || |   | |__) |   | || |   | |_  \_|  | |
//            | |   '.___`-.   | || |   / ____ \   | || |  | |\ \| |   | || |    \ \/ /    | || |   / ____ \   | || |  | |\  /| |  | | | |  | |/  \| |  | || |   / ____ \   | || |   '.___`-.   | | | |   |  __  |   | || |   |  _|  _   | || |   |  __ /    | || |   |  _|  _   | |
//            | |  |`\____) |  | || | _/ /    \ \_ | || | _| |_\   |_  | || |    _|  |_    | || | _/ /    \ \_ | || | _| |_\/_| |_ | | | |  |   /\   |  | || | _/ /    \ \_ | || |  |`\____) |  | | | |  _| |  | |_  | || |  _| |___/ |  | || |  _| |  \ \_  | || |  _| |___/ |  | |
//            | |  |_______.'  | || ||____|  |____|| || ||_____|\____| | || |   |______|   | || ||____|  |____|| || ||_____||_____|| | | |  |__/  \__|  | || ||____|  |____|| || |  |_______.'  | | | | |____||____| | || | |_________|  | || | |____| |___| | || | |_________|  | |
//            | |              | || |              | || |              | || |              | || |              | || |              | | | |              | || |              | || |              | | | |              | || |              | || |              | || |              | |
//            | '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' | | '--------------' || '--------------' || '--------------' | | '--------------' || '--------------' || '--------------' || '--------------' |
//            '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'   '----------------'  '----------------'  '----------------'   '----------------'  '----------------'  '----------------'  '----------------'
//
//






    private static class ViewHolder {
        public final RelativeLayout rootView;

//        public final TextView textViewName;
//        public final TextView textViewCountry;
        public final TextView tvformid;
        public final TextView tvname;
        public final TextView tvPcontact;
        public final TextView tvPguardian;
        public final TextView tvPaddress;
        public final TextView tvPdoj;
        public final TextView tvgender;
        public final TextView tvage;
        public final TextView tvtimestamp;
        public final TextView tvdr_attending;
        public final TextView tvbed_allot;
        public final TextView tvinsurance;
        public final TextView tvot_status;
        public final TextView tvemergency_contact;
        private ViewHolder(RelativeLayout rootView, TextView tvformid, TextView tvname,TextView tvPcontact,TextView tvPguardian,TextView tvPaddress,TextView tvPdoj,TextView tvgender,TextView tvage,TextView tvtimestamp,TextView tvdr_attending,TextView tvbed_allot,TextView tvinsurance,TextView tvot_status,TextView tvemergency_contact) {
            this.rootView = rootView;
//            this.textViewName = textViewName;
//            this.textViewCountry = textViewCountry;
            this.tvformid = tvformid;
            this.tvname = tvname;
            this.tvPcontact = tvPcontact;
            this.tvPguardian = tvPguardian;
            this.tvPaddress = tvPaddress;
            this.tvPdoj = tvPdoj;
            this.tvgender = tvgender;
            this.tvage = tvage;
            this.tvtimestamp = tvtimestamp;
            this.tvdr_attending = tvdr_attending;
            this.tvbed_allot = tvbed_allot;
            this.tvinsurance = tvinsurance;
            this.tvot_status = tvot_status;
            this.tvemergency_contact = tvemergency_contact;
        }

        public static ViewHolder create(RelativeLayout rootView) {
            TextView tvformid = (TextView) rootView.findViewById(R.id.tvformid);
            TextView tvname = (TextView) rootView.findViewById(R.id.tvname);
            TextView tvPcontact = (TextView) rootView.findViewById(R.id.tvPcontact);
            TextView tvPguardian = (TextView) rootView.findViewById(R.id.tvPguardian);
            TextView tvPaddress = (TextView) rootView.findViewById(R.id.tvPaddress);
            TextView tvPdoj = (TextView) rootView.findViewById(R.id.tvPdoj);
            TextView tvgender = (TextView) rootView.findViewById(R.id.tvgender);
            TextView tvage = (TextView) rootView.findViewById(R.id.tvage);
            TextView tvtimestamp = (TextView) rootView.findViewById(R.id.tvtimestamp);
            TextView tvdr_attending = (TextView) rootView.findViewById(R.id.tvdr_attending);
            TextView tvbed_allot = (TextView) rootView.findViewById(R.id.tvbed_allot);
            TextView tvinsurance = (TextView) rootView.findViewById(R.id.tvinsurance);
            TextView tvot_status = (TextView) rootView.findViewById(R.id.tvot_status);
            TextView tvemergency_contact = (TextView) rootView.findViewById(R.id.tvemergency_contact);
            return new ViewHolder(rootView, tvformid, tvname, tvPcontact, tvPguardian, tvPaddress, tvPdoj, tvgender, tvage, tvtimestamp,tvdr_attending,tvbed_allot,tvinsurance,tvot_status,tvemergency_contact);
        }
    }
}

//
//
//
//                                                                                                               __
//                                                                                                              |  \
//  _______   ______   _______   __    __   ______   ______ ____         __   __   __   ______    _______       | $$____    ______    ______    ______
// /       \ |      \ |       \ |  \  |  \ |      \ |      \    \       |  \ |  \ |  \ |      \  /       \      | $$    \  /      \  /      \  /      \
//|  $$$$$$$  \$$$$$$\| $$$$$$$\| $$  | $$  \$$$$$$\| $$$$$$\$$$$\      | $$ | $$ | $$  \$$$$$$\|  $$$$$$$      | $$$$$$$\|  $$$$$$\|  $$$$$$\|  $$$$$$\
// \$$    \  /      $$| $$  | $$| $$  | $$ /      $$| $$ | $$ | $$      | $$ | $$ | $$ /      $$ \$$    \       | $$  | $$| $$    $$| $$   \$$| $$    $$
// _\$$$$$$\|  $$$$$$$| $$  | $$| $$__/ $$|  $$$$$$$| $$ | $$ | $$      | $$_/ $$_/ $$|  $$$$$$$ _\$$$$$$\      | $$  | $$| $$$$$$$$| $$      | $$$$$$$$
//|       $$ \$$    $$| $$  | $$ \$$    $$ \$$    $$| $$ | $$ | $$       \$$   $$   $$ \$$    $$|       $$      | $$  | $$ \$$     \| $$       \$$     \
// \$$$$$$$   \$$$$$$$ \$$   \$$ _\$$$$$$$  \$$$$$$$ \$$  \$$  \$$        \$$$$$\$$$$   \$$$$$$$ \$$$$$$$        \$$   \$$  \$$$$$$$ \$$        \$$$$$$$
//                              |  \__| $$
//                               \$$    $$
//                                \$$$$$$

//
//
//
//
//
//
//
