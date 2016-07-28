package com.abc.app.hiapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class MemberListActivity extends Activity {
    ListView Iv_memberlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_list);
        ArrayList<MemberBean> list = this.getList();
        Iv_memberlist = (ListView) findViewById(R.id.Iv_memberlist);
        Iv_memberlist.setAdapter(new MemberAdapter(this, list));
        Iv_memberlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object o = Iv_memberlist.getItemAtPosition(position);
                MemberBean member = (MemberBean) o;
                Toast.makeText(MemberListActivity.this,"선택한 이름"+member.getId(),Toast.LENGTH_SHORT).show();

            }
        });

    }

    public ArrayList<MemberBean>getList(){
        ArrayList<MemberBean>list = new ArrayList<MemberBean>();
        String[] names={
                "cupcake",
                "donut",
                "eclair",
                "froyo",
                "gingerbread",
                "honeycomb",
                "icecream",
                "jellybean",
                "kitkat",
                "lollipop"
        };
        int i=0;
                while(i<names.length){
                    MemberBean member = new MemberBean();
                    member.setName(names[i]);
                    member.setPhone("010-9075-3070");
                    list.add(member);
                    i++;
                }
        return list;

        }



}
