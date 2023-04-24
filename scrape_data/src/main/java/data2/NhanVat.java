package data2;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class NhanVat{
	private String link="https://nguoikesu.com";
	private String after="/nhanvat";
	private JSONArray list;
	private JSONArray flist;
	private JSONObject object;
	private int id=0;
	private String name;
	private String mota;
	private String url;
	private String sinh;
	private String mat;
	private String description;
	private String trieuDai;
	private String cha[];
	@SuppressWarnings("unchecked")
	public void open() {
		elements ele=new elements(link+after,"div.com-content-category-blog__items.blog-item");
		for(Element a:ele.getSec()) {
			name=a.select("div.page-header h2 a").text();
			cha[id]=name;
			url=link+after+a.select("div.page-header h2 a").attr("href");
			mota=a.select("p").first().text();
			moreInfo();
			image img=new image(name);
			object.put("id", id);
			object.put("ten", name);
			object.put("mota", mota);
			object.put("sinh", sinh);
			object.put("mat", mat);
			object.put("trieuDai", trieuDai);
			object.put("des",description);
			object.put("image", img.getImg());
			object.put("relate", elements.getRelate(url));
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
	public void moreInfo() {
		elements ele=new elements(url,"div.com-content-article__body");
		for(Element tr:ele.getSec().select("tr")) {
			if(tr.select("th").text()=="sinh") sinh=tr.select("td").text();
			if(tr.select("th").text()=="mất") mat=tr.select("td").text();
			if(tr.select("th").text()=="triều đại") trieuDai=tr.select("td").text();
		}
		for(Element p:ele.getSec().select("p")) {
			description=p.text();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	private void saveObject() {
		list.add(object);
		object=new JSONObject();
	}
	public void wFile() {
		try(FileWriter file=new FileWriter("nhanvat.json")){
			file.write(flist.toJSONString());
			file.flush();
		}catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}
