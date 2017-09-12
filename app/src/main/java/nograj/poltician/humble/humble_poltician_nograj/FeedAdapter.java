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

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedViewHolder> {
    private String TAG = "FeedAdapter";
    private List<FbFeed> feedList;

    public FeedAdapter (List<FbFeed> list) {
        feedList = list;
        Log.e(TAG, "FeedAdapter: " + feedList.size());
    }

    public class FeedViewHolder extends RecyclerView.ViewHolder {
        ImageView proPic;
        TextView name;
        TextView timeStamp;
        TextView statusMsg;
        TextView url;
        ImageView feedImg;

        public FeedViewHolder(View itemView) {
            super(itemView);
            proPic = (ImageView) itemView.findViewById(R.id.profilePic);
            name = (TextView) itemView.findViewById(R.id.name);
            timeStamp = (TextView) itemView.findViewById(R.id.timestamp);
            statusMsg = (TextView) itemView.findViewById(R.id.txtStatusMsg);
            url = (TextView) itemView.findViewById(R.id.txtUrl);
            feedImg = (ImageView) itemView.findViewById(R.id.feedImage1);
            //set default values
            name.setText("Name");
            timeStamp.setText("timeStamp-12:78-20/1/2013");
            statusMsg.setText("statusMsg goes here");
            url.setText("url if any");
        }
    }

    @Override
    public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.feed_card, parent, false);
        return new FeedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FeedViewHolder holder, int position) {
        FbFeed feed = feedList.get(position);
        try {
            Log.e(TAG, "onBindViewHolder: " + feed.toString());
            holder.name.setText(feed.getFromName());
            holder.timeStamp.setVisibility(View.GONE);
            holder.statusMsg.setText(feed.getDescription());
            if (feed.getFull_picture() != null || feed.getFull_picture() != ""){
                holder.feedImg.setVisibility(View.GONE);
            }
        } catch (Exception e) {
            Log.e(TAG, "onBindViewHolder: " + e.toString());
        }
    }

    @Override
    public int getItemCount() {
        return feedList.size();
    }
}
