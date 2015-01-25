package com.talktodeaf.project.talktodeaf.app;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.cengalabs.flatui.FlatUI;
import com.talktodeaf.project.talktodeaf.R;
import com.talktodeaf.project.talktodeaf.model.Example;
import com.talktodeaf.project.talktodeaf.rest.ApiService;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class Catagory01 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private OnFragmentInteractionListener mListener;
    private static final String TAG = Catagory01.class.getSimpleName();
    String method ="getQueryMySQL";
    public static Catagory01 newInstance(int sectionNumber) {
        Catagory01 fragment = new Catagory01();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public Catagory01() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*new HttpAsyncTask().execute();*/
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://172.19.237.198:8080")
                .build();
        ApiService retrofit = restAdapter.create(ApiService.class);
        retrofit.getExampleByMethodWithCallback(method, new Callback<Example>() {
            @Override
            public void success(Example example, Response response) {
                Toast.makeText(getActivity(),
                        "Name : " + example.getNameVoc() + " URL : " + example.getDesVoc(),
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getActivity(),
                        "Connect Failure Please Try Again",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
    /*public class HttpAsyncTask extends AsyncTask<Void, Void, Example> {
        @Override
        protected Example doInBackground(Void... params) {

            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint("http://172.19.237.198:8080")
                    .build();

            ApiService retrofit = restAdapter.create(ApiService.class);
            Example example = retrofit.getExampleByMethodWithCallback();
            String result = example.getDesVoc();
            String result2 = example.getNameVoc();

            return example;
        }

        @Override
        protected void onPostExecute(Example example) {

            *//*Toast.makeText(getActivity(),
                    "Name : " + example.getDesVoc() + " URL : " + example.getNameVoc(),
                    Toast.LENGTH_LONG).show();*//*
            super.onPostExecute(example);
        }
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FlatUI.initDefaultValues(getActivity());
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_catagory01, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        /*try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
        super.onAttach(activity);
        ((MainActivity) activity).onSectionAttached(getArguments().getInt(
                ARG_SECTION_NUMBER));
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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }


}
