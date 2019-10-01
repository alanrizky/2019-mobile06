package id.ac.polinema.idealbodyweight.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import id.ac.polinema.idealbodyweight.R;
import id.ac.polinema.idealbodyweight.util.BodyMassIndex;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BodyMassIndexFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class BodyMassIndexFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public BodyMassIndexFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_body_mass_index, container, false);
        final EditText heightText  = view.findViewById(R.id.input_height);
        final EditText massText  = view.findViewById(R.id.input_mass);

        Button calculateButton = view.findViewById(R.id.button_calculate);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    String heightString = heightText.getText().toString();
                    String massString = massText.getText().toString();
                    if (!TextUtils.isEmpty(heightString) && !TextUtils.isEmpty(massString)) {
                        int height = Integer.parseInt(heightString);
                        int mass = Integer.parseInt(massString);
                        BodyMassIndex bodyMassIndex = new BodyMassIndex(height, mass);
                        mListener.onCalculateBodyMassIndexClicked(bodyMassIndex.getIndex());
                    } else {
                        Toast.makeText(getActivity(), "Please input your height, and your mass", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onCalculateBodyMassIndexClicked(String index);
        void onFragmentInteraction(Uri uri);
    }
}
