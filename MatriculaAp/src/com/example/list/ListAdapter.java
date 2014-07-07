package com.example.list;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.matriculaap.R;
import com.example.model.Model;

public class ListAdapter extends ArrayAdapter<Model>{
	public Integer tot=2517;
	private Context context;
	private ArrayList<Model> listas;
	

	public ListAdapter(Context context, int viewResourceId, 
			ArrayList<Model> listas) {
		super(context, viewResourceId, listas);
		
		this.context= context;
		this.listas= listas;
		// TODO Auto-generated constructor stub
	}
	static class ViewHolder{
		
		public TextView nombre;
		public TextView cantidad;
		public TextView porcentaje;
	}
@Override
public View getView(int position, View convertView, ViewGroup parent) {
	
	if (convertView == null) {

		convertView = LayoutInflater.from(context).inflate(R
				.layout.row_list, parent, false);
		ViewHolder ViewHolder = new ViewHolder();
		ViewHolder.nombre= (TextView) convertView.findViewById(R.id.txtNombre);
		ViewHolder.cantidad= (TextView) convertView.findViewById(R.id.txtCantidad);
		ViewHolder.porcentaje= (TextView) convertView.findViewById(R.id.txtPorcentaje);
		convertView.setTag(ViewHolder);	
	}
	ViewHolder Holder =(ViewHolder) convertView.getTag();
	 Holder.nombre.setText(listas.get(position).getNombre());
	 Holder.cantidad.setText(listas.get(position).getCantidad());
	 Holder.porcentaje.setText(Integer.parseInt(listas.get(position).getCantidad())*100/tot+"%");
	 
	
	return convertView;
}

}
