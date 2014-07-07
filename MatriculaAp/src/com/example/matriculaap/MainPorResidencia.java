package com.example.matriculaap;


import java.util.ArrayList;

import com.example.list.ListAdapter;
import com.example.model.Model;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainPorResidencia extends MainBaseMenu  {

	private ListView lvResidencia;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_por_residencia);
		lvResidencia = (ListView) findViewById(R.id.lvResidencia);
		new residenciaSearch().execute();
		Button btnResidEstadis = (Button) findViewById(R.id.btnResidEstadis);
		 btnResidEstadis.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
			
				Intent i= new Intent(getApplicationContext(),
						MainPorResidenciaEstadis.class);	
				startActivity(i);
					
					// TODO Auto-generated method stub
					
				}
			});
		
	}
	public void updateListView(ArrayList<Model> residencia) {
		lvResidencia
				.setAdapter(new ListAdapter(this, R.layout.row_list, residencia));
	}
	class residenciaSearch extends AsyncTask<Object, Void, ArrayList<Model>> {

		
		ProgressDialog dialog;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();

			dialog = new ProgressDialog(MainPorResidencia.this);
			dialog.setMessage(getResources().getString(
					R.string.label_tweet_search_loader));
			dialog.show();

		}
		
		@Override
		protected ArrayList<Model> doInBackground(Object... params) {
			ArrayList<Model> residencia= new ArrayList<Model>();
			try {
				//for (int i = 0; i < 11; i++) {
					Model residen= new Model();
					residen.setNombre("Vivienda Interno");
					residen.setCantidad("273");
					residen.setPorcentaje("%");
					residencia.add(residen);
					
					residen= new Model();
					residen.setNombre("Vivienda Externo");
					residen.setCantidad("2218");
					residen.setPorcentaje("%");
					residencia.add(residen);
										
				//}
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			// TODO Auto-generated method stub
			return residencia;
		}
		@Override
		protected void onPostExecute(ArrayList<Model> residencia) {
			// TODO Auto-generated method stub
			super.onPostExecute(residencia);
			dialog.dismiss();
			if(residencia.isEmpty()){
				Toast.makeText(
						MainPorResidencia.this, 
						getResources().getString(
								R.string.label_tweets_not_found), 
						Toast.LENGTH_SHORT).show();
			}else {
				updateListView(residencia);
			}
		}
		
	}
	
	
	
	
	
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_main_por_residencia);
//		Button btnResidEstadis= (Button) findViewById(R.id.btnResidEstadis);
//		
//		btnResidEstadis.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {	
//				Intent i= new Intent(
//						getApplicationContext(),MainPorResidenciaEstadis.class);
//				startActivity(i);
//				// TODO Auto-generated method stub
//				
//			}
//		});
//	}
}
