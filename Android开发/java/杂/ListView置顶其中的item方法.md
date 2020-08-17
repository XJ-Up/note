# ListView置顶其中的item方法

```java
public class MainActivity extends AppCompatActivity {
        List <String> strings=new ArrayList<>();
        int  bian;//记录置顶的下标
        String  bian1;//记录置顶的内容
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView=findViewById(R.id.list);
        for (int i = 0; i <20 ; i++) {
            strings.add(i+"");
        }
        final Ada ada=new Ada(getApplicationContext(),strings);
        listView.setAdapter(ada);
        ada.Get(new Ada.Oc() {
            @Override
            public void xuexi(View view) {
                //获取点击的 item下标
                int i= (int) view.getTag();
                //如果是第一个item ，判断它是置顶上去的还是
                if (i==0){
                    if (bian1!=null){
                        strings.remove(0);
                        strings.add(bian,bian1);
                        bian1=null;
                        ada.notifyDataSetChanged();
                    }
                }else {
                    String s = strings.get(i);
                    strings.remove(i);
                    bian=i;
                    bian1=s;
                    strings.add(0,s);
                    ada.notifyDataSetChanged();
                }

            }
        });
    }
}
```

