package data2;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.nodes.Element;
import java.io.FileWriter;
import java.io.IOException;
public class ditich{
	private int id=0;
	private String name;
	private String mota;
	private JSONObject object;
	private JSONArray list;
	private String link="https://nguoikesu.com";
	private String after="/di-tich-lich-su?types[0]=1";
	@SuppressWarnings("unchecked")
	public void open() {
		elements ele=new elements(link+after,"ul.com-tags-tag__category.category.list-group");
		for(Element a:ele.getSec().select("li")) {
			id++;
			name=a.select("h3 a").text();
			mota=a.select("span.tag-body p").text();
			object.put("id", id);
			object.put("ten", name);
			object.put("mota", mota);
			saveObject();
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
		try(FileWriter file=new FileWriter("ditich.json")){
			file.write(list.toJSONString());
			file.flush();
		}catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
