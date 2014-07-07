package com.example.matriculaap;

import java.util.ArrayList;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.list.ListAdapter;
import com.example.model.Model;

public class MainPorFacultades extends MainBaseMenu  {

	private ListView lvFacultades;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_por_facultades);
		
		lvFacultades=(ListView) findViewById(R.id.lvFacultades);
		Button btnFaculEstadis = (Button) findViewById(R.id.btnFaculEstadis);
	   new facultadSearch().execute();
		btnFaculEstadis.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
		
			Intent i= new Intent(getApplicationContext(),
					MainPorFacultadesEstadis.class);	
			startActivity(i);
				
				// TODO Auto-generated method stub
				
			}
		});	
	}
public void updateListView(ArrayList<Model> facultades){
	lvFacultades
	.setAdapter(new ListAdapter(this, R.layout.row_list, facultades));
	
}
	
class facultadSearch extends AsyncTask<Object, Void, ArrayList<Model>> {

	ProgressDialog dialog;
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		dialog = new ProgressDialog(MainPorFacultades.this);
		dialog.setMessage(getResources().getString(R.string.label_tweet_search_loader));
		dialog.show();
	}
	
	@Override
	protected ArrayList<Model> doInBackground(Object... params) {
		ArrayList<Model> facultades= new ArrayList<Model>();
		try {
			//for (int i = 0; i < 4; i++) {
				Model facultad= new Model();
				facultad.setNombre("Ciencias de la Salud: ");
				facultad.setCantidad("500");
				facultad.setPorcentaje("%");
				facultades.add(facultad);
				
				facultad= new Model();
				facultad.setNombre("Ciencias Empresariales: ");
				facultad.setCantidad("937");
				facultad.setPorcentaje("%");
				facultades.add(facultad);
				
				facultad= new Model();
				facultad.setNombre("Ciencias Humanas y Educación: ");
				facultad.setCantidad("158");
				facultad.setPorcentaje("%");
				facultades.add(facultad);
				
				facultad= new Model();
				facultad.setNombre("Ingenieria y Arquitectura: ");
				facultad.setCantidad("896");
				facultad.setPorcentaje("%");
				facultades.add(facultad);
				
			//}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		// TODO Auto-generated method stub
		return facultades;
	}
	@Override
	protected void onPostExecute(ArrayList<Model> facultades) {
		// TODO Auto-generated method stub
		super.onPostExecute(facultades);
		dialog.dismiss();
		if (facultades.isEmpty()) {
			Toast.makeText(MainPorFacultades.this, 
					getResources().getString(R.string.label_tweets_not_found), 
					Toast.LENGTH_SHORT).show();
			
		}else{
			updateListView(facultades);
		}
	}
}

}
