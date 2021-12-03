package ro.ionescu.radu.tagscanner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>
{
	private final List<String> mData;
	private final LayoutInflater mInflater;

	MyRecyclerViewAdapter(Context context, List<String> data)
	{
		this.mInflater = LayoutInflater.from(context);
		this.mData     = data;
	}

	@NonNull
	@Override
	public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
	{
		View view = mInflater.inflate(R.layout.rv_row, parent, false);
		return new ViewHolder(view);
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position)
	{
		String animal = mData.get(position);
		holder.myTextView.setText(animal);
	}

	@Override
	public int getItemCount()
	{
		return mData.size();
	}

	public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
	{
		final TextView myTextView;

		ViewHolder(View itemView)
		{
			super(itemView);
			myTextView = itemView.findViewById(R.id.tvData);
			itemView.setOnClickListener(this);
		}

		@Override
		public void onClick(View view)
		{

		}
	}
}