package data2;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.nodes.Element;
import java.io.FileWriter;
import java.io.IOException;
public class DiaDanh{
	private String link="https://nguoikesu.com";
	private String after="/dia-danh";
	private JSONArray list;
	private JSONObject object;
	private int id=0;
	private String name;
	private String mota;
	@SuppressWarnings("unchecked")
	public void open() {
		elements ele=new elements(link+after,"div.com-content-category-blog__items.blog-item");
		for(Element a:ele.getSec()) {
			name=a.select("div.page-header h2 a").text();
			mota=a.select("p").first().text();
			object.put("id", id);
			object.put("ten", name);
			object.put("mota", mota);
			saveObject();
			id++;
		}
		elements tmp=new elements(link+after,"div.com-content-category-blog__pagination");
		for(Element li:tmp.getSec().select("a.page-link")) {
			if(li.attr("aria-label")=="Đi tới tiếp tục trang") {
				after=li.attr("href");
				open();
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private void saveObject() {
		list.add(object);
		object=new JSONObject();
	}
	public void wFile() {
		try(FileWriter file=new FileWriter("diadanh.json")){
			file.write(list.toJSONString());
			file.flush();
		}catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
