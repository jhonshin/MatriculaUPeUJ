package com.example.matriculaap;

import java.util.ArrayList;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.list.ListAdapter;
import com.example.model.Model;


public class MainEnProceso extends MainBaseMenu {
	
	private ListView lvProcesos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_en_proceso);
		lvProcesos = (ListView) findViewById(R.id.lvProcesos);
		new procesoSearch().execute();
	}
	public void updateListView(ArrayList<Model> procesos) {
		lvProcesos
				.setAdapter(new ListAdapter(this, R.layout.row_list, procesos));
	}
	class procesoSearch extends AsyncTask<Object, Void, ArrayList<Model>> {

		
		ProgressDialog dialog;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();

			dialog = new ProgressDialog(MainEnProceso.this);
			dialog.setMessage(getResources().getString(
					R.string.label_tweet_search_loader));
			dialog.show();

		}
		
		@Override
		protected ArrayList<Model> doInBackground(Object... params) {
			ArrayList<Model> procesos= new ArrayList<Model>();
			try {
				//for (int i = 0; i < 11; i++) {
					Model proceso= new Model();
					proceso.setNombre("En Proceso Confirmado");
					proceso.setCantidad("26");
					proceso.setPorcentaje("%");
					procesos.add(proceso);
					
					proceso= new Model();
					proceso.setNombre("En Proceso Sin Confirmado");
					proceso.setCantidad("0");
					proceso.setPorcentaje("%");
					procesos.add(proceso);
					
					
				//}
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			// TODO Auto-generated method stub
			return procesos;
		}
		@Override
		protected void onPostExecute(ArrayList<Model> procesos) {
			// TODO Auto-generated method stub
			super.onPostExecute(procesos);
			dialog.dismiss();
			if(procesos.isEmpty()){
				Toast.makeText(
						MainEnProceso.this, 
						getResources().getString(
								R.string.label_tweets_not_found), 
						Toast.LENGTH_SHORT).show();
			}else {
				updateListView(procesos);
			}
		}
		
	}
}
