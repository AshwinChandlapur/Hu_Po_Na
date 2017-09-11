package nograj.poltician.humble.humble_poltician_nograj;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Nikith_Shetty on 10/09/2017.
 */

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {
    private List<FbFeed> feedList;

    public FeedAdapter (List<FbFeed> list) {
        feedList = list;

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView proPic;
        TextView name;
        TextView timeStamp;
        TextView statusMsg;
        TextView url;
        ImageView feedImg;

        public ViewHolder(View itemView) {
            super(itemView);
            proPic = (ImageView) itemView.findViewById(R.id.profilePic);
            name = (TextView) itemView.findViewById(R.id.name);
            timeStamp = (TextView) itemView.findViewById(R.id.timestamp);
            statusMsg = (TextView) itemView.findViewById(R.id.txtStatusMsg);
            url = (TextView) itemView.findViewById(R.id.txtUrl);
            feedImg = (ImageView) itemView.findViewById(R.id.feedImage1);
        }
    }

    @Override
    public FeedAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.feed_card, parent, false);
        return new FeedAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FeedAdapter.ViewHolder holder, int position) {
        Log.e(this.toString(), "onBindViewHolder: " + feedList.get(position).getFromName());
        holder.name.setText(feedList.get(position).getFromName());
        holder.proPic.setVisibility(View.GONE);
        holder.timeStamp.setVisibility(View.GONE);
        holder.statusMsg.setText(feedList.get(position).getDescription());
        if (feedList.get(position).getFull_picture() != null || feedList.get(position).getFull_picture() != ""){
            holder.feedImg.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return feedList.size();
    }
}
