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

public class MainPorEscuelas extends MainBaseMenu {

	private ListView lvEscuelas;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_por_escuelas);
		
		lvEscuelas = (ListView) findViewById(R.id.lvEscuelas);
		new escuelaSearch().execute();
		Button btnEscuEstadis = (Button) findViewById(R.id.btnEscuEstadis);
		  
			btnEscuEstadis.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
			
				Intent i= new Intent(getApplicationContext(),
						MainPorEscuelasEstadis.class);	
				startActivity(i);
					
					// TODO Auto-generated method stub
					
				}
			});
	}
	public void updateListView(ArrayList<Model> escuelas){
		lvEscuelas
		.setAdapter(new ListAdapter(this, R.layout.row_list, escuelas));
	
	}
	class escuelaSearch extends AsyncTask<Object, Void, ArrayList<Model>> {

		ProgressDialog dialog;
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		dialog = new ProgressDialog(MainPorEscuelas.this);
		dialog.setMessage(getResources().getString(
				R.string.label_tweet_search_loader));
		dialog.show();
	}
		@Override
		protected ArrayList<Model> doInBackground(Object... params) {
			ArrayList<Model> escuelas= new ArrayList<Model>();
			
			try {
				//for (int i = 0; i < 21; i++) {
					Model escuela= new Model();
					escuela.setNombre("Administracion: ");
					escuela.setCantidad("338");
					escuela.setPorcentaje(" %");
					escuelas.add(escuela);
					
					escuela= new Model();
					escuela.setNombre("Asistencia Gerencial: ");
					escuela.setCantidad("41");
					escuela.setPorcentaje(" %");
					escuelas.add(escuela);
					
					escuela= new Model();
					escuela.setNombre("Contabilidad: ");
					escuela.setCantidad("558");
					escuela.setPorcentaje(" %");
					escuelas.add(escuela);
					
					escuela= new Model();
					escuela.setNombre("Educacion-LingüisticaIngles: ");
					escuela.setCantidad("43");
					escuela.setPorcentaje(" %");
					escuelas.add(escuela);
					
					escuela= new Model();
					escuela.setNombre("Educacion-Primaria: ");
					escuela.setCantidad("50");
					escuela.setPorcentaje(" %");
					escuelas.add(escuela);
					
					escuela= new Model();
					escuela.setNombre("Educacion-Inicial: ");
					escuela.setCantidad("65");
					escuela.setPorcentaje(" %");
					escuelas.add(escuela);
					
					escuela= new Model();
					escuela.setNombre("Enfermeria: ");
					escuela.setCantidad("168");
					escuela.setPorcentaje(" %");
					escuelas.add(escuela);
					
					escuela= new Model();
					escuela.setNombre("Psiclogia: ");
					escuela.setCantidad("330");
					escuela.setPorcentaje(" %");
					escuelas.add(escuela);
					
					escuela= new Model();
					escuela.setNombre("Ingenieria de Alimentos: ");
					escuela.setCantidad("68");
					escuela.setPorcentaje(" %");
					escuelas.add(escuela);
					
					escuela= new Model();
					escuela.setNombre("Ingenieria Ambiental: ");
					escuela.setCantidad("230");
					escuela.setPorcentaje(" %");
					escuelas.add(escuela);
					
					escuela= new Model();
					escuela.setNombre("Ingenieria de Sistemas: ");
					escuela.setCantidad("150");
					escuela.setPorcentaje(" %");
					escuelas.add(escuela);
					
					escuela= new Model();
					escuela.setNombre("Ingenieria Civil: ");
					escuela.setCantidad("450");
					escuela.setPorcentaje(" %");
					escuelas.add(escuela);
					
					
				//}
				
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			} 
			// TODO Auto-generated method stub
			return escuelas;
		}
		@Override
		protected void onPostExecute(ArrayList<Model> escuelas) {
			// TODO Auto-generated method stub
			super.onPostExecute(escuelas);
			
			dialog.dismiss();
			if(escuelas.isEmpty()){
				Toast.makeText(MainPorEscuelas.this, 
						getResources().getString(R.string.label_tweets_not_found), 
						Toast.LENGTH_SHORT).show();
				
				
			}else{
				updateListView(escuelas);
			}
		}
		
	}
	}
	

