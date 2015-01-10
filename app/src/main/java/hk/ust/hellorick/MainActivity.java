package hk.ust.hellorick;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TimePicker;

import java.util.Calendar;


public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void showTimePickerDialog(View v) {
        DialogFragment timePickerFragment = new TimePickerFragment();
        FragmentManager fragmentManager = getFragmentManager();
        timePickerFragment.show(fragmentManager, "datePicker");
    }

    public void showNumPickerDialog(View view) {
        DialogFragment numberPickerFragment = new NumberPickerFragment();
        FragmentManager fragmentManager = getFragmentManager();
        numberPickerFragment.show(fragmentManager, "numberPicker");
    }

    public static class TimePickerFragment extends DialogFragment
            implements TimePickerDialog.OnTimeSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            Dialog dialog = new TimePickerDialog(getActivity(), this, hour, minute,
                    DateFormat.is24HourFormat(getActivity()));
            // remove focus of the dialog(because if the focus has been got, the input will be shown)
            dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM,
                    WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
            // Create a new instance of TimePickerDialog and return it
            return dialog;
        }

        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            // Do something with the time chosen by the user
        }
    }

    public static class NumberPickerFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Dialog dialog = new Dialog(getActivity());
            dialog.setTitle("NumberPicker");
            dialog.setContentView(R.layout.number_picker_dialog);
            Button b1 = (Button) dialog.findViewById(R.id.button1);
            Button b2 = (Button) dialog.findViewById(R.id.button2);

            final NumberPicker np = (NumberPicker) dialog.findViewById(R.id.numberPicker1);
            np.setMaxValue(20);
            np.setMinValue(9);
            np.setWrapSelectorWheel(true);
            np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

                }
            });

            final NumberPicker np2 = (NumberPicker) dialog.findViewById(R.id.numberPicker2);
            np2.setMaxValue(8);
            np2.setMinValue(3);
            np2.setWrapSelectorWheel(true);
            np2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                @Override
                public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

                }
            });

            b1.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            b2.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
            return dialog;
        }

    }

}
