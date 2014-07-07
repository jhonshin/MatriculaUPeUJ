package com.example.matriculaap;




import java.util.ArrayList;

import uk.co.senab.actionbarpulltorefresh.library.ActionBarPullToRefresh;
import uk.co.senab.actionbarpulltorefresh.library.PullToRefreshLayout;
import uk.co.senab.actionbarpulltorefresh.library.listeners.OnRefreshListener;

import android.app.ProgressDialog;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.list.ListAdapter;
import com.example.model.Model;



//Jhon Ccaypani Vasquez !!

public class MainActivity extends MainBaseMenu {

	private ListView lvPrincipal;
	private PullToRefreshLayout pull_to_refresh_layout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Typeface miFuente= Typeface.createFromAsset(getAssets(),"fonts/acmesab.TTF");
		TextView txt= (TextView) findViewById(R.id.tituloMain);
		txt.setTypeface(miFuente);
		
		lvPrincipal= (ListView) findViewById(R.id.lvPrincipal);
		new principalSearch().execute();
		pull_to_refresh_layout = (PullToRefreshLayout) findViewById(R.id.ptr_layout);
		ActionBarPullToRefresh.from(this).allChildrenArePullable()
										.listener(new OnRefreshListener() {
											
											@Override
											public void onRefreshStarted(View view) {
												// TODO Auto-generated method stub
												new principalSearch().execute();
											}
										}).setup(pull_to_refresh_layout);
		
	}	
	public void updateListView(ArrayList<Model> principal){
		lvPrincipal.setAdapter(new ListAdapter(this, R.layout.row_list, principal));
		
	} 
	class principalSearch  extends AsyncTask<Object, Void, ArrayList<Model>>{

		ProgressDialog dialog;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();

			dialog = new ProgressDialog(MainActivity.this);
			dialog.setMessage(getResources().getString(
					R.string.label_tweet_search_loader));
			dialog.show();

		}
		@Override
		protected ArrayList<Model> doInBackground(Object... params) {
			ArrayList<Model> principal= new ArrayList<Model>();
			try {
			//	for (int i = 0; i < 4; i++) {
					Model princ= new Model();
					princ.setNombre("Total Matriculados:");
					princ.setCantidad("2517");
					princ.setPorcentaje("%");
					principal.add(princ);
					
					princ= new Model();
					princ.setNombre("Matriculados Virtualmente:");
					princ.setCantidad("1565");
					princ.setPorcentaje("%");
					principal.add(princ);
					
					princ= new Model();
					princ.setNombre("Matriculados Presencialmente:");
					princ.setCantidad("926");
					princ.setPorcentaje("%");
					principal.add(princ);
					
					princ= new Model();
					princ.setNombre("Matriculados por primera vez:");
					princ.setCantidad("605");
					princ.setPorcentaje("%");
					principal.add(princ);
			//	}
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
			
			// TODO Auto-generated method stub
			return principal;
		}
		@Override
		protected void onPostExecute(ArrayList<Model> principal) {
		
			// TODO Auto-generated method stub
			super.onPostExecute(principal);
		dialog.dismiss();
		if(principal.isEmpty()){
			Toast.makeText(MainActivity.this, getResources().getString(R.string.label_tweets_not_found), Toast.LENGTH_SHORT).show();
		} else{
			updateListView(principal);
		}
		pull_to_refresh_layout.setRefreshComplete();
		}
		
		
	}

}
